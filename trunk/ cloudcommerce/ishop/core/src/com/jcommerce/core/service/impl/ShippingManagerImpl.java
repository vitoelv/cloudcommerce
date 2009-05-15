/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.ShippingDAO;
import com.jcommerce.core.model.Shipping;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.ShippingManager;

public class ShippingManagerImpl extends ManagerImpl implements ShippingManager {
    private static Log log = LogFactory.getLog(ShippingManagerImpl.class);
    private ShippingDAO dao;

    public void setShippingDAO(ShippingDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Shipping initialize(Shipping obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getShipping(obj.getId());
        }
        return obj;
    }

    public List<Shipping> getShippingList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Shipping>)list;
    }

    public int getShippingCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Shipping> getShippingList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Shipping>)list;
    }

    public List<Shipping> getShippingList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Shipping>)list;
    }

    public List<Shipping> getShippingList() {
        return dao.getShippingList();
    }

    public Shipping getShipping(String id) {
        Shipping obj = dao.getShipping(Integer.parseInt(id));
        return obj;
    }

    public void saveShipping(Shipping obj) {
        dao.saveShipping(obj);
    }

    public void removeShipping(String id) {
        dao.removeShipping(Integer.parseInt(id));
    }
}
