/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.PaymentDAO;
import com.jcommerce.core.model.Payment;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.PaymentManager;

public class PaymentManagerImpl extends ManagerImpl implements PaymentManager {
    private static Log log = LogFactory.getLog(PaymentManagerImpl.class);
    private PaymentDAO dao;

    public void setPaymentDAO(PaymentDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Payment initialize(Payment obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getPayment(obj.getId());
        }
        return obj;
    }

    public List<Payment> getPaymentList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Payment>)list;
    }

    public int getPaymentCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Payment> getPaymentList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Payment>)list;
    }

    public List<Payment> getPaymentList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Payment>)list;
    }

    public List<Payment> getPaymentList() {
        return dao.getPaymentList();
    }

    public Payment getPayment(String id) {
        Payment obj = dao.getPayment(Integer.parseInt(id));
        return obj;
    }

    public void savePayment(Payment obj) {
        dao.savePayment(obj);
    }

    public void removePayment(String id) {
        dao.removePayment(Integer.parseInt(id));
    }
}
