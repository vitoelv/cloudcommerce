/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.AttributeDAO;
import com.jcommerce.core.model.Attribute;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.AttributeManager;

public class AttributeManagerImpl extends ManagerImpl implements AttributeManager {
    private static Log log = LogFactory.getLog(AttributeManagerImpl.class);
    private AttributeDAO dao;

    public void setAttributeDAO(AttributeDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Attribute initialize(Attribute obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getAttribute(obj.getId());
        }
        return obj;
    }

    public List<Attribute> getAttributeList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Attribute>)list;
    }

    public int getAttributeCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Attribute> getAttributeList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Attribute>)list;
    }

    public List<Attribute> getAttributeList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Attribute>)list;
    }

    public List<Attribute> getAttributeList() {
        return dao.getAttributeList();
    }

    public Attribute getAttribute(String id) {
        Attribute obj = dao.getAttribute(Integer.parseInt(id));
        return obj;
    }

    public void saveAttribute(Attribute obj) {
        dao.saveAttribute(obj);
    }

    public void removeAttribute(String id) {
        dao.removeAttribute(Integer.parseInt(id));
    }
}
