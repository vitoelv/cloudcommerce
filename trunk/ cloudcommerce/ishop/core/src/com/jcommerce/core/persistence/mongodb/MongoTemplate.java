/**
 * glue code for mongodb in spring
 */
package com.jcommerce.core.persistence.mongodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcommerce.core.model.User;
import com.jcommerce.core.model.UserAddress;
import com.jcommerce.core.persistence.MiscUtils;
import com.jcommerce.core.persistence.IDBObjectConvertor;
import com.jcommerce.core.service.Order;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * @author rioliu
 * 
 */
public class MongoTemplate {

    private static Logger mTrace = LoggerFactory.getLogger(MongoTemplate.class);
    private DB mDataBase;
    private IDBObjectConvertor mObjectConvertor = new MongoConvertor();
    private ReentrantLock mLock = new ReentrantLock();

    public MongoTemplate(String host, int port, String dataBaseName, String userName, String passWord) {
        initialize(host, port, dataBaseName, userName, passWord);
    }

    private void initialize(String host, int port, String dataBaseName, String userName, String passWord) {

        if (StringUtils.isBlank(host))
            throw new IllegalArgumentException("argument [host] is not configured ");

        if (StringUtils.isBlank(dataBaseName))
            throw new IllegalArgumentException("argument [database name] is not configured");

        if (port <= 0) {
            mTrace.warn("invalid port configuration, runtime will use default port [27017] to create connection");
            port = 27017;
        }

        Mongo mongo = null;
        try {
            mongo = new Mongo(host, port);
        } catch (Exception e) {
            mTrace.error("create mongo database instance error: " + e.getMessage());
            mTrace.error("database instance initialization failed");
            return;
        }

        mDataBase = mongo.getDB(dataBaseName);

        if (mDataBase != null) { // do usr/pwd authentication
            if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(passWord)) {
                boolean result = mDataBase.authenticate(userName, passWord.toCharArray());
                if (result == false)
                    mTrace.error("database authentication failed, user:[" + userName + "]/pwd:[" + passWord + "]");
            }
        }

        // TODO: error handling for invalid connection
    }

    public int getCount(String collectionName) {

        return getCount(collectionName, null);
    }

    public int getCount(String collectionName, DBObject query) {

        DBCollection collection = getCollection(collectionName);
        if (collection != null) {
            if (query != null)
                return Long.valueOf(collection.getCount(query)).intValue();
            else
                return Long.valueOf(collection.getCount()).intValue();
        } else {
            mTrace.debug("collection " + collectionName + " not found");
        }

        return 0;
    }

    public <T> List<T> find(String collectionName, DBObject query, Class<T> clazz, boolean sort, List<Order> orders, int skipNum, int limitNum) {

        List<T> result = null;

        DBCollection collection = getCollection(collectionName);
        if (collection != null) {
            DBCursor cursor = collection.find(query);

            if (skipNum > 0)
                cursor = cursor.skip(skipNum);
            if (limitNum > 0)
                cursor = cursor.limit(limitNum);

            if (cursor.hasNext() && sort && orders != null && orders.size() > 0) {
                BasicDBObject orderBy = new BasicDBObject();
                for (Order order : orders) {
                    orderBy.append(order.getField(), order.isAscend() ? 1 : -1);
                }
                cursor = cursor.sort(orderBy);
            }

            while (cursor.hasNext()) {
                if (result == null)
                    result = new ArrayList<T>();
                result.add(mObjectConvertor.fromObject(cursor.next(), clazz));
            }
        }

        return result;

    }
    
    public void save(Object obj) {
        save(obj, null, null);
    }

    public ObjectId save(Object obj, Class<?> ownerClass, DBRef dbRef) {

        DBObject dbObject = (DBObject) mObjectConvertor.toObject(obj, ownerClass, dbRef);
        DBCollection collection = getCollection(MiscUtils.getCollectionNameByObject(obj));

        Map<String, Object> refMap = (Map<String, Object>) dbObject.get("$refMap$");
        Map<String, Object> copyMap = new HashMap<String, Object>();
        if (refMap != null && refMap.size() > 0) {
            for (String key : refMap.keySet()) {
                copyMap.put(key, refMap.get(key));
            }
        }
        dbObject.removeField("$refMap$");

        mLock.lock(); // this should be thread safe
        try {

            mDataBase.requestStart();

            if (collection != null)
                collection.save(dbObject);

            Map<String, ObjectId> idMap = new HashMap<String, ObjectId>();
            if (copyMap != null && copyMap.size() > 0) {
                for (String key : copyMap.keySet()) {
                    ObjectId id = save(copyMap.get(key), obj.getClass(), new DBRef(mDataBase, MiscUtils.getCollectionNameByObject(obj), dbObject.get("_id")));
                    if (id != null)
                        idMap.put(key, id);
                }

                for (String key : copyMap.keySet()) {
                    ObjectId id = idMap.get(key);
                    if (id != null) {
                        DBObject updateObj = collection.findOne(MiscUtils.getObjectId(dbObject));
                        if (updateObj != null) {
                            updateObj.put(key, new DBRef(mDataBase, MiscUtils.getCollectionNameByObject(copyMap.get(key)), id));
                            collection.update(new BasicDBObject("_id", MiscUtils.getObjectId(updateObj)), updateObj, false, false);
                        }
                    }
                }
            }

            mDataBase.requestDone();

        } catch (MongoException e) {
            mTrace.error("save object error: " + e.getMessage());
        } finally {
            mLock.unlock();
        }

        return (ObjectId) dbObject.get("_id");

    }

    public void remove(Object obj) {

        DBObject dbObject = (DBObject) mObjectConvertor.toObject(obj);
        DBCollection collection = getCollection(MiscUtils.getCollectionNameByObject(obj));

        mLock.lock();
        try {
            if (collection != null)
                collection.remove(dbObject);
        } finally {
            mLock.unlock();
        }

    }

    public void update(Object obj, DBObject criteria, boolean upsert, boolean multiupdate) {

        DBObject dbObject = (DBObject) mObjectConvertor.toObject(obj);
        DBCollection collection = getCollection(MiscUtils.getCollectionNameByObject(obj));

        mLock.lock();
        try {
            if (collection != null)
                collection.update(criteria, dbObject, upsert, multiupdate);
        } finally {
            mLock.unlock();
        }

    }

    private DBCollection getCollection(String collectionName) {
        return mDataBase.getCollection(collectionName);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MongoTemplate mt = new MongoTemplate("localhost", 0, "test", null, null);
        
        User user = new User();
        user.setName("rioliu");
        user.setId(123);
        UserAddress ua = new UserAddress();
        ua.setAddress("Beijing");
        ua.setName("Beijing");
        ua.setUser(user);
        user.setUserAddress(ua);
        mt.save(user);

        List<User> users = mt.find(MiscUtils.getCollectionNameByClass(User.class), new BasicDBObject().append("name", "rioliu"), User.class, false, null, 0, 0);
        if(users != null && users.size() > 0) {
            for(User u : users) {
                System.out.println(u.getId());
                System.out.println(u.getName());
                System.out.println(u.getUserAddress().getAddress());
                System.out.println(u.getUserAddress().getUser().getName());
            }
        }
        
    }

}
