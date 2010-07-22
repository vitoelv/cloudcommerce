/**
 * 
 */
package com.jcommerce.core.persistence;

import java.lang.reflect.Method;

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
    
    public static String getFieldNameByMethodName(Method method) {
        return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
    }
    
    public static Method getSetterMethod(Class<?> clazz, Class<?> wantedType) {
        
        Method setter = null;
        
        for(Method m : clazz.getDeclaredMethods()) {
            if(isSetterMethod(m) && isWantedParameterType(m.getParameterTypes(), wantedType)) {
                setter = m;
                break;
            }
        }
        
        return setter;
    }
    
    public static boolean isSetterMethod(Method m) {
        return m.getName().startsWith("set") && m.getReturnType().equals(void.class);
    }
    
    public static boolean isGetterMethod(Method m) {
        return m.getName().startsWith("get") && m.getReturnType().equals(void.class) == false;
    }
    
    public static boolean isWantedGetterMethod(Method m, Class<?> returnType) {
        return isGetterMethod(m) && m.getReturnType().equals(returnType);
    }
    
    public static boolean isWantedParameterType(Class<?>[] parameterTypes, Class<?> wantedType) {
        for(Class<?> clazz : parameterTypes) {
            if(clazz.equals(wantedType))
                return true;
        }
        
        return false;
    }
    
    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || clazz.equals(String.class) || clazz.getCanonicalName().contains("java.sql.");
    }
    
    
    

}
