/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.util.Collection;
import java.util.List;

import com.jcommerce.core.persistence.BaseDAO;
import com.jcommerce.core.persistence.IDAO;
import com.jcommerce.core.persistence.PersistenceException;
import com.jcommerce.core.persistence.ReflectionUtils;
import com.jcommerce.core.service.Criteria;
import com.mongodb.DBObject;

/**
 * @author xliu
 *
 */
public class MongoDAO extends BaseDAO implements IDAO {
    
    
    private MongoTemplate mTemplate;

    public MongoDAO() {
        super();
    }

    public MongoDAO(Class<?> clazz) {
        super(clazz);
    }

    public List<?> getList(Criteria criteria, int skipNum, int limitNum) {
        
        DBObject query = (DBObject) mTranslator.translate(criteria);
        return mTemplate.find(ReflectionUtils.getCollectionNameByClass(getModelClass()), query, getModelClass(), criteria.getOrders(), skipNum, limitNum);
        
    }

    public List<?> getList(int skipNum, int limitNum) {
        
        return mTemplate.find(ReflectionUtils.getCollectionNameByClass(getModelClass()), null, getModelClass(), null, skipNum, limitNum);
    }
    
    public List<?> getList() {
        
        return mTemplate.find(ReflectionUtils.getCollectionNameByClass(getModelClass()), null, getModelClass(), null, 0, 0);
    }

    public int getCount(Criteria criteria) {
        
        return mTemplate.getCount(ReflectionUtils.getCollectionNameByClass(getModelClass()));
    }

    public void deleteAll(Collection<Object> objs) throws PersistenceException {
        if(objs != null && objs.size() > 0) {
            for(Object obj : objs) {
                delete(obj);
            }
        }
    }

    public Class<?> getModelClass() {
        return modelClass;
    }
    
    public void setTemplate(MongoTemplate template) {
        mTemplate = template;
    }

    public void save(Object obj) throws PersistenceException {
        
        mTemplate.save(obj);
    }

    public void delete(Object obj) throws PersistenceException {
        
        mTemplate.remove(obj);
        
    }

    public void update(Object obj) throws PersistenceException {
        
        //TODO mogo impl
    }
    

    
    

    
    
}
