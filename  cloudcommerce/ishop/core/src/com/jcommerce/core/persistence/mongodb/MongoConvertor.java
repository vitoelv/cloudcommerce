/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcommerce.core.persistence.MiscUtils;
import com.jcommerce.core.persistence.IDBObjectConvertor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

/**
 * @author rioliu
 *
 */
public class MongoConvertor implements IDBObjectConvertor {
    
    private static Logger mTrace = LoggerFactory.getLogger(MongoConvertor.class); 
    
    public Object toObject(Object obj) {
        return toObject(obj, null, null);
    }
    
    public Object toObject(Object obj, Class<?> refClass, Object dbRef) {
        
        DBObject dbObject = new BasicDBObject();
        ObjectId objId = new ObjectId();
        
        Map<String, Object> refMap = new HashMap<String, Object>();
        
        try {
            dbObject.put("_id", objId);
            for(Field f : obj.getClass().getDeclaredFields()) {
                
                if(Modifier.isPrivate(f.getModifiers()) == false) continue;
                
                String key = f.getName();
                String methodName = "get" + key.substring(0,1).toUpperCase() + key.substring(1);
                
                Method method = null;
                try {
                    method = obj.getClass().getMethod(methodName, null);
                } catch (Exception e) {
                    mTrace.debug("get method exception: " + e.getMessage());
                    continue;
                }
                
                Object val = method.invoke(obj, null);
                if(val == null) continue;
                
                if(val != null && method.getReturnType().isPrimitive() == false && 
                                  method.getReturnType().getSimpleName().equals("String") == false &&
                                  method.getReturnType().getCanonicalName().contains("java.sql") == false) {
                    if(refClass != null && refClass.getName().equals(method.getReturnType().getName())) {
                        dbObject.put(key, dbRef);
                    } else {
                        refMap.put(f.getName(), val);
                    }
                } else {
                    dbObject.put(key, val);
                }
                
                if(refMap.size() > 0) 
                    dbObject.put("$refMap$", refMap);
            }
        } catch (Exception e) {
            mTrace.error("convert bean to mongo dbObject error: " + e.getMessage());
            mTrace.debug("convert bean to mongo dbObject error", e);
        }
        
        return dbObject;
    }

    public <T> T fromObject(Object obj, Class<T> clazz) {
        return fromObject(obj, clazz, false);
    }
    
    public <T> T fromObject(Object obj, Class<T> clazz, boolean hasLoop) {
        
        T bean = null;
        try {
           bean = clazz.newInstance();
            if(obj instanceof DBObject) {
                DBObject entry = (DBObject) obj;
                for(Method method : clazz.getDeclaredMethods()) {
                    if(method.getName().startsWith("set") && method.getReturnType().equals(void.class)) {
                        String field = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                        Object value = entry.get(field);
                        if(value != null && value instanceof DBRef && hasLoop == false) {
                            DBObject refObj = ((DBRef)value).fetch();
                            Method getter = clazz.getMethod(MiscUtils.getGetterName(field), null);
                            Class<?> getterClass = getter.getReturnType();
                            boolean loop = false;
                            for(Method m : getterClass.getDeclaredMethods()) {
                                if(m.getName().startsWith("get") && clazz.getCanonicalName().equals(m.getReturnType().getCanonicalName())) {
                                    loop = true;
                                    break;
                                }
                            }
                            value = fromObject(refObj, getter.getReturnType(), loop);
                            Method reverse = null;
                            try {
                                reverse = value.getClass().getMethod(MiscUtils.getSetterName(clazz.getSimpleName()), clazz);
                            } catch (NoSuchMethodException e) {
                                reverse = null;
                            }
                            if(reverse != null)
                                reverse.invoke(value, new Object[]{bean});
                        }
                        if(value instanceof DBRef) value = null;
                        if(value != null)
                            method.invoke(bean, new Object[]{value});
                    }
                }
            }
        } catch (InvocationTargetException ite) {
            ite.getTargetException().printStackTrace();
        } catch (Exception e) {
           mTrace.error("convert mongo dbObject to bean error: " + e.getMessage());
           mTrace.debug("convert mongo dbObject to bean error: ", e);
           System.out.println(e);
        } 
        
        
        return bean;
    }

    

}
