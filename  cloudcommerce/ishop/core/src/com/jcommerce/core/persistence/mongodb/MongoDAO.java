/**
 * 
 */
package com.jcommerce.core.persistence.mongodb;

import java.util.Collection;
import java.util.List;

import com.jcommerce.core.dao.DAO;
import com.jcommerce.core.model.ModelObject;

/**
 * @author xliu
 *
 */
public class MongoDAO implements DAO {

    public List getList(String hql, int firstRow, int maxRow) {
        return null;
    }

    public List getList(int firstRow, int maxRow) {
        return null;
    }

    public int getCount(String hql) {
        return 0;
    }

    public List<DAO> getList(String hql) {
        return null;
    }

    public void deleteAll(Collection<ModelObject> objs) {

    }

    public Class getModelClass() {
        return null;
    }

}
