/**
 * 
 */
package com.jcommerce.core.persistence;

/**
 * @author rioliu
 *
 */
public class DBType {

    public static final String TYPE_MONGO = "mongo";
    public static final String TYPE_HIBERNATE = "hibernate";
    
    private static String type;
    
    public static String getType() {
        return type;
    }
    
    public static void setType(String dbType) {
        type = dbType;
    }
    
    public static boolean isMongo() {
        return TYPE_MONGO.equalsIgnoreCase(type);
    }
    
    public static boolean isHibernate() {
        return TYPE_HIBERNATE.equalsIgnoreCase(type);
    }
}
