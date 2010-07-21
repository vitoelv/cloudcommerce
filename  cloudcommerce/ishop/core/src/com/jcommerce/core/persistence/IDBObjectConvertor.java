/**
 * 
 */
package com.jcommerce.core.persistence;

/**
 * @author rioliu
 *
 */
public interface IDBObjectConvertor {
    
    public Object toObject(Object obj);

    public Object toObject(Object obj, Class<?> ownerClass, Object dbRef);
    
    public <T> T fromObject(Object obj, Class<T> clazz);
        
}
