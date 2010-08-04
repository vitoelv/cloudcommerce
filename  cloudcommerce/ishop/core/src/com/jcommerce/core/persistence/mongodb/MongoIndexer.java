/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcommerce.core.persistence.PersistenceException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;

/**
 * @author rioliu
 *
 */
public class MongoIndexer {

    private static Logger mTrace = LoggerFactory.getLogger(MongoIndexer.class);
    private static boolean sInit = false;
    private static Properties sIndexes = null;
    
    private MongoIndexer() {}

    static {
        initialize();
    }
    
    private static void initialize() {
        
        sIndexes = new Properties();
        try {
            sIndexes.load(MongoIndexer.class.getResourceAsStream("/com/jcommerce/core/persistence/mongodb/indexes.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(sIndexes.size() > 0) sInit = true;
    }
    
    public static void ensureIndex(DBCollection collection) throws PersistenceException {
        
        if(sInit == false) throw new PersistenceException("can not create index, because index properties initialization failed");
        
        String collectionName = collection.getName();
        String indexConfig = sIndexes.getProperty(collectionName);
        if(StringUtils.isNotBlank(indexConfig)) {
            String[] indexes = indexConfig.split(";");
            if (indexes.length > 0) {
                for (String config : indexes) {
                    if (StringUtils.isNotBlank(config))
                        createIndex(collection, config);
                }
            }
        }
        
    }
    
    protected static void createIndex(DBCollection collection, String indexStr) throws PersistenceException {
        
        String[] fields = indexStr.split("|");
        if(fields.length == 0) fields = new String[] {indexStr};
        BasicDBObject index = new BasicDBObject();
        for(String field : fields) {
            String[] pairs = field.split(":");
            if(pairs.length >= 2) {
                if(StringUtils.isNotBlank(pairs[0])) {
                    index.append(checkField(pairs[0]), checkOrder(pairs[1]));
                }
            } else {
                mTrace.debug("index config format error, length is less than 2");
            }
        }
        
        String[] uniqueArray = indexStr.split(",");
        boolean isUnique = uniqueArray != null && uniqueArray.length > 0 && "unique".equalsIgnoreCase(uniqueArray[1]);
        
        try {
            if(index.size() > 0)
                collection.ensureIndex(isUnique ? index.append("unique", true) : index);
        } catch (MongoException e) {
            String errorMsg = "create index on collection [" + collection.getName() + "] failed : " + e.getMessage();
            mTrace.error(errorMsg);
            throw new PersistenceException(errorMsg);
        }
        
        
    }
    
    protected static String checkField(String field) {
        return StringUtils.isNotBlank(field) ? field : null;
    }
    
    protected static int checkOrder(String order) {
        
        if(StringUtils.isNotBlank(order)) {
            if("asc".equalsIgnoreCase(order)) return 1;
            if("desc".equalsIgnoreCase(order)) return -1;
        } 
        
        return 1; // default value is asc
    }
    
    protected static boolean checkUnique(String unique) {
        
        if(StringUtils.isNotBlank(unique)) {
            if("unique".equalsIgnoreCase(unique)) return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        MongoIndexer.checkField("field");
    }
    
}
