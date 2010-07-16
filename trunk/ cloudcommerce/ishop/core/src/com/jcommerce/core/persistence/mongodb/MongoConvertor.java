/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcommerce.core.persistence.IDBObjectConvertor;
import com.mongodb.BasicDBObjectBuilder;

/**
 * @author rioliu
 *
 */
public class MongoConvertor implements IDBObjectConvertor {
    
    private static Logger mTrace = LoggerFactory.getLogger(MongoConvertor.class); 

    /* (non-Javadoc)
     * @see com.jcommerce.core.database.fw.IDBObjectConvertor#convert(java.lang.Object)
     */
    public Object convert(Object obj) {
        
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        
        try {
            for(Field f : obj.getClass().getDeclaredFields()) {
                String key = f.getName();
                Object val = BeanUtils.getProperty(obj, key);
                
                if(val.getClass().isPrimitive() == false && (val instanceof Timestamp == false)) 
                    builder.add(key, convert(val));
                else
                    builder.add(key, val);
            }
        } catch (Exception e) {
            mTrace.error("convert bean to mongo dbObject error: " + e.getMessage());
        }
        
        return builder.get();
    }

}
