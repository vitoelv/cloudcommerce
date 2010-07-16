/**
 * 
 */
package com.jcommerce.core.persistence;

/**
 * @author rioliu
 *
 */
public interface IDBObjectConvertor {

    public Object convertPojo2DBObject(Object obj);
    
    public Object convertDBObject2Pojo(Object obj);
        
}
