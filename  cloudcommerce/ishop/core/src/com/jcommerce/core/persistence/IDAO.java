/**
 * 
 */
package com.jcommerce.core.persistence;

import java.util.Collection;
import java.util.List;

import com.jcommerce.core.service.Criteria;

/**
 * @author xliu
 *
 */
public interface IDAO {

    public List<?> getList(Criteria criteria, int skipNum, int limitNum);

    public List<?> getList(int skipNum, int limitNum);
    
    public List<?> getList();
    
    public int getCount(Criteria criteria);
    
    public void deleteAll(Collection<Object> objs) throws PersistenceException;
    
    public Class<?> getModelClass();
    
    public void save(Object obj) throws PersistenceException;
    
    public void delete(Object obj) throws PersistenceException;
    
    public void update(Object obj) throws PersistenceException;
    
    
}
