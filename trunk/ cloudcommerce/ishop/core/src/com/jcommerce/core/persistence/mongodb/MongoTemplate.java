/**
 * glue code for mongodb in spring
 */
package com.jcommerce.core.persistence.mongodb;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author rioliu
 *
 */
public class MongoTemplate {
    
    private static Logger mTrace = LoggerFactory.getLogger(MongoTemplate.class);
    private static DB mDataBase;
    
    public MongoTemplate(String host, int port, String dataBaseName, String userName, String passWord) {
        initialize(host, port, dataBaseName, userName, passWord);
    }

    private void initialize(String host, int port, String dataBaseName, String userName, String passWord) {
        
        if(StringUtils.isBlank(host))
            throw new IllegalArgumentException("argument [host] is not configured ");
        
        if(StringUtils.isBlank(dataBaseName))
            throw new IllegalArgumentException("argument [database name] is not configured");
        
        if(port <= 0)
            mTrace.warn("invalid port configuration, runtime will use default port [27017] to create connection");
        
        Mongo mongo = null;
        try {
            mongo = new Mongo(host, port);
        } catch (Exception e) {
            mTrace.error("create mongo database instance error: " + e.getMessage());
            mTrace.error("database instance initialization failed");
            return;
        } 
        
        mDataBase = mongo.getDB(dataBaseName);
        
        if(mDataBase != null) { // do usr/pwd authentication
            boolean result = mDataBase.authenticate(userName, passWord.toCharArray());
            if(result == false)
                mTrace.error("database authentication failed, user:["+ userName +"]/pwd:["+ passWord +"]");
        }
        
        //TODO: error handling for invalid connection
    }

    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
