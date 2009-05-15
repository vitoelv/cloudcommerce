/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.PaymentDAO;
import com.jcommerce.core.model.Payment;

public class PaymentDAOImpl extends DAOImpl implements PaymentDAO {
    public PaymentDAOImpl() {
        modelClass = Payment.class;
    }

    public List<Payment> getPaymentList() {
        return getList();
    }

    public Payment getPayment(int id) {
        return (Payment)getById(id);
    }

    public void savePayment(Payment obj) {
        save(obj);
    }

    public void removePayment(int id) {
        deleteById(id);
    }
}
