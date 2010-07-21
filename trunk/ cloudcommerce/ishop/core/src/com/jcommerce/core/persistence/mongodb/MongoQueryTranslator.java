/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.util.regex.Pattern;

import com.jcommerce.core.persistence.IQueryTranslator;
import com.jcommerce.core.service.Condition;
import com.jcommerce.core.service.Criteria;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;

/**
 * @author rioliu
 *
 */
public class MongoQueryTranslator implements IQueryTranslator {

    @Override
    public Object translate(Criteria c) {
        
        BasicDBObjectBuilder query = BasicDBObjectBuilder.start();
        
        for(Condition condition : c.getConditions()) {
            String field = condition.getField();
            int operator = condition.getOperator();
            String value = condition.getValue();
            
            query.append(field, getMongoCondition(operator, value));
        }
        
        return query.get();
    }
    
    private Object getMongoCondition(int operator, String value) {
        
        if(operator == Condition.EQUALS)
            return value;
        else if(operator == Condition.LIKE) {
            return Pattern.compile(".*" + value.toString() + ".*");
        }
        
        String op = null;
        if(operator == Condition.GREATERTHAN) {
            op = "$gt";
        } else if(operator == Condition.LESSTHAN) {
            op = "$lt";
        } else if(operator == Condition.GREATERTHAN_OR_EQUALS) {
            op = "$gte";
        } else if(operator == Condition.LESSTHAN_OR_EQUALS) {
            op = "$lte";
        } else if(operator == Condition.NOT_EQUALS) {
            op = "$ne";
        } 
        
        return new BasicDBObject(op, value);
    }

}
