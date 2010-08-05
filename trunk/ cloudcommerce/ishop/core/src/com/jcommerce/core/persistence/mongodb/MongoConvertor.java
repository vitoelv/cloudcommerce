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

import com.jcommerce.core.persistence.ReflectionUtils;
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
            for(Field field : obj.getClass().getDeclaredFields()) {
                if(Modifier.isPrivate(field.getModifiers()) == false) continue;
                
                String key = field.getName();
                Method method = null;
                try {
                    method = obj.getClass().getMethod(ReflectionUtils.getGetterName(key), (Class[])null);
                } catch (Exception e) {
                    mTrace.debug("get method exception: " + e.getMessage());
                    continue;
                }
                
                Object value = method.invoke(obj, (Object[])null);
                if(value == null) continue;
                
                if(value != null && ReflectionUtils.isPrimitive(method.getReturnType()) == false) {
                    if(refClass != null && refClass.getName().equals(method.getReturnType().getName())) {
                        dbObject.put(key, dbRef);
                    } else {
                        refMap.put(field.getName(), value);
                    }
                } else {
                    dbObject.put(key, value);
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
        return fromObject(obj, clazz, null);
    }
    
    public <T> T fromObject(Object obj, Class<T> clazz, Map<String, Object> loopMap) {
        
        T bean = null;
        try {
           bean = clazz.newInstance();
            if(obj instanceof DBObject) {
                DBObject entry = (DBObject) obj;
                for(Method method : clazz.getDeclaredMethods()) {
                    if(ReflectionUtils.isSetterMethod(method)) {
                        String field = ReflectionUtils.getFieldNameByMethodName(method);
                        Object value = entry.get(field);
                        boolean hasLoop = loopMap != null && loopMap.containsKey(method.getParameterTypes()[0].getCanonicalName());
                        if(value != null && value instanceof DBRef && hasLoop == false) {
                            DBObject refObj = ((DBRef)value).fetch();
                            Method getter = clazz.getMethod(ReflectionUtils.getGetterName(field), (Class[])null);
                            Class<?> getterClass = getter.getReturnType();
                            Map<String, Object> loop = new HashMap<String, Object>();
                            for(Method m : getterClass.getDeclaredMethods()) {
                                if(ReflectionUtils.isWantedGetterMethod(m, clazz)) {
                                    loop.put(clazz.getCanonicalName(), null);
                                    break;
                                }
                            }
                            value = fromObject(refObj, getter.getReturnType(), loop);
                            Method reverse = null;
                                reverse = ReflectionUtils.getSetterMethod(value.getClass(), clazz);
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
            mTrace.error("invocation target exception: " + ite.getTargetException().getMessage());
        } catch (Exception e) {
           mTrace.error("convert mongo dbObject to bean error: " + e.getMessage());
           mTrace.debug("convert mongo dbObject to bean error: ", e);
           System.out.println(e);
        } 
        
        
        return bean;
    }

    

}
