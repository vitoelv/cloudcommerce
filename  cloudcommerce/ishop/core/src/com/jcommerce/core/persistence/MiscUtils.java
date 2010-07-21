/**
 * 
 */
package com.jcommerce.core.persistence;

import org.bson.types.ObjectId;

import com.mongodb.DBObject;

/**
 * @author rioLiu
 *
 */
public class MiscUtils {
    
    public static String getCollectionNameByObject(Object obj) {
        return obj.getClass().getSimpleName().toLowerCase();
    }
    
    public static String getCollectionNameByClass(Class<?> clazz) {
        return clazz.getSimpleName().toLowerCase();
    }
    
    public static ObjectId getObjectId(DBObject obj) {
        return (ObjectId) obj.get("_id");
    }
    
    public static String getSetterName(String name) {
        return "set" + name.substring(0,1).toUpperCase() + name.substring(1);
    }
    
    public static String getGetterName(String name) {
        return "get" + name.substring(0,1).toUpperCase() + name.substring(1);
    }
    
    
    

}
