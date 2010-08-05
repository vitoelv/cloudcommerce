/**
 * 
 */
package com.jcommerce.core.persistence;

import com.jcommerce.core.persistence.mongodb.MongoQueryTranslator;

/**
 * @author rioliu
 *
 */
public class QueryTranslatorFatory {

    public static IQueryTranslator getTranslator() {
        
        if(DBType.isMongo())   return new MongoQueryTranslator();
        if(DBType.isHibernate()) return null;
        
        throw new IllegalStateException("cannot find the corresponding query translator for db type : [" + DBType.getType().toUpperCase() + "]");
    }
}
