/**
 * 
 */
package com.jcommerce.core.persistence;

import com.jcommerce.core.persistence.mongodb.MongoConvertor;

/**
 * @author rioliu
 *
 */
public class DBObjectConvertorFactory {

    public static IDBObjectConvertor getObjectConvertor() {
        
        if(DBType.isMongo()) return new MongoConvertor();
        if(DBType.isHibernate()) return null;
        
        throw new IllegalStateException("cannot find correspoding db object convertor");
    }
}
