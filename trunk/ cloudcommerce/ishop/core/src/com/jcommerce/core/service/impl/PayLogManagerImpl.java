/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.PayLogDAO;
import com.jcommerce.core.model.PayLog;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.PayLogManager;

public class PayLogManagerImpl extends ManagerImpl implements PayLogManager {
    private static Log log = LogFactory.getLog(PayLogManagerImpl.class);
    private PayLogDAO dao;

    public void setPayLogDAO(PayLogDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public PayLog initialize(PayLog obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getPayLog(obj.getId());
        }
        return obj;
    }

    public List<PayLog> getPayLogList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<PayLog>)list;
    }

    public int getPayLogCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<PayLog> getPayLogList(Criteria criteria) {
        List list = getList(criteria);
        return (List<PayLog>)list;
    }

    public List<PayLog> getPayLogList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<PayLog>)list;
    }

    public List<PayLog> getPayLogList() {
        return dao.getPayLogList();
    }

    public PayLog getPayLog(String id) {
        PayLog obj = dao.getPayLog(Integer.parseInt(id));
        return obj;
    }

    public void savePayLog(PayLog obj) {
        dao.savePayLog(obj);
    }

    public void removePayLog(String id) {
        dao.removePayLog(Integer.parseInt(id));
    }
}
