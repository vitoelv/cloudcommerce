/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jcommerce.core.dao.DAO;
import com.jcommerce.core.model.ModelObject;

public class DAOImpl extends HibernateDaoSupport implements DAO {
    protected Log log = LogFactory.getLog(getClass());

    protected Class modelClass = null;
    
    public List getList(int firstRow, int maxRow) {
        return getList("from " + modelClass.getSimpleName(), firstRow, maxRow);
    }
    
    public List getList(final String hsql, final int firstRow, final int maxRow) {
        if (firstRow < 0 || maxRow <=0) {
            throw new IllegalArgumentException("firstRow="+firstRow+" maxRow="+maxRow);
        }
        
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session s) throws HibernateException,
                    SQLException {
                Query query = s.createQuery(hsql);
                query.setFirstResult(firstRow);
                query.setMaxResults(maxRow);
                List list = query.list();
                return list;
            }
        });
    }   
    
    public int getCount(String hql){  
        Number count = (Number)getHibernateTemplate().find("select count(*) "+hql).listIterator().next();
        return count.intValue();
    }
    
    public List getList(String hql){          
        return getHibernateTemplate().find(hql);
    }
    
    public List getList(){        
        return getHibernateTemplate().find("from " + modelClass.getSimpleName());
    }
    
    public ModelObject getById(int id){        
        return getById(new Integer(id));
    }
    
    public ModelObject getById(Serializable id){
        return (ModelObject)getHibernateTemplate().get(modelClass, id);
    }
    
    public void save(ModelObject obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj = null");
        }
        
//        if (getById(getId(obj)) == null) {
//            Serializable id = getHibernateTemplate().save(obj);
//            setId(obj, id);
//        } else {
//            getHibernateTemplate().update(obj);
//        }
        ModelObject _obj = (ModelObject)getHibernateTemplate().merge(obj);
        setId(obj, getId(_obj));
    }    

    public boolean deleteById(int id) {
        return deleteById(new Integer(id));
    }
    
    public boolean deleteById(Serializable id) {
        ModelObject obj = getById(id);
        if (obj == null) {
//            throw new RuntimeException("Object not found for ID: "+id);
            return false;
        }
        
        getHibernateTemplate().delete(obj);
        return true;
    }    
    
    public boolean delete(ModelObject obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj = null");
        }
        
        getHibernateTemplate().delete(obj);
        return true;
    }    
    
    public void deleteAll(Collection<ModelObject> objs) {
        if (objs == null) {
            throw new IllegalArgumentException("objs = null");
        }
        
        getHibernateTemplate().deleteAll(objs);
    }    
    
    public Class getModelClass() {
        if (modelClass == null) {
            throw new RuntimeException("modelClass = null: "+getClass().getName());
        }
        
        return modelClass;
    }
    
    /**
     * Require all ModelObject have a getId() or getID() method
     */
    private Serializable getId(ModelObject obj) {
        try {
            Method m = obj.getClass().getMethod("getId", new Class[0]);
            if (m == null) {
                m = obj.getClass().getMethod("getID", new Class[0]);
            }
            if (m == null) {
                throw new RuntimeException("Method getId() not found: "+obj.getClass().getName());
            }
            
            Object id = m.invoke(obj, new Object[0]);
            if (id instanceof Serializable) {
                return (Serializable)id;
            } else {
                throw new RuntimeException("ID should be a Serializable object"+id+"obj is:"+obj);
            }
        } catch (SecurityException e) {
            log.error("Failed to invoke method getId()", e);
            throw new RuntimeException(e.toString());
        } catch (IllegalArgumentException e) {
            log.error("Failed to invoke method getId()", e);
            throw new RuntimeException(e.toString());
        } catch (NoSuchMethodException e) {
            log.error("Failed to invoke method getId()", e);
            throw new RuntimeException(e.toString());
        } catch (IllegalAccessException e) {
            log.error("Failed to invoke method getId()", e);
            throw new RuntimeException(e.toString());
        } catch (InvocationTargetException e) {
            log.error("Failed to invoke method getId()", e);
            throw new RuntimeException(e.toString());
        }
    }
    
    private void setId(ModelObject obj, Serializable id) {
        try {
            BeanUtils.setProperty(obj, "id", id);
        } catch (Exception e) {
            try {
                BeanUtils.setProperty(obj, "ID", id);
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }
        }
    }
}
