/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.util.Collection;
import java.util.List;

import com.jcommerce.core.dao.DAO;
import com.jcommerce.core.model.ModelObject;
import com.jcommerce.core.persistence.IQueryTranslator;
import com.jcommerce.core.persistence.PersistenceException;
import com.jcommerce.core.service.Criteria;
import com.mongodb.DBObject;

import freemarker.ext.util.ModelCache;

/**
 * @author xliu
 *
 */
public class MongoDAO implements DAO {
    
    private MongoTemplate mTemplate = null;
    private IQueryTranslator mQueryTranslator = new MongoQueryTranslator();
    private Class<?> modelClass = null; // this variable should be instantiate in impl's constructor
    
    public MongoDAO (MongoTemplate template) {
        mTemplate = template;
    }

    public List getList(String hql, int firstRow, int maxRow) {
        return null;
    }
    
    public List getList(int firstRow, int maxRow) {
        return null;
    }

    public int getCount(String hql) {
        return mTemplate.getCount(hql);
    }

    public List<DAO> getList(String hql) {
        return null;
    }

    public void deleteAll(Collection<ModelObject> objs) {
        if(objs != null && objs.size() > 0) {
            for(ModelObject mo : objs) {
                try {
                    mTemplate.remove(mo);
                } catch (PersistenceException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public Class getModelClass() {
        return modelClass;
    }

    public List getList(Criteria criteria, int firstRow, int maxRow) {
        
        DBObject query = (DBObject)mQueryTranslator.translate(criteria);
        return mTemplate.find(getCollectionName(), query, modelClass, criteria.getOrders(), firstRow, maxRow);
    }

    private String getCollectionName() {
        
        if(modelClass != null)
            return modelClass.getSimpleName().toLowerCase();
        
        return null;
    }

}
