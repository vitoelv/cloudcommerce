/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.PayLogDAO;
import com.jcommerce.core.model.PayLog;

public class PayLogDAOImpl extends DAOImpl implements PayLogDAO {
    public PayLogDAOImpl() {
        modelClass = PayLog.class;
    }

    public List<PayLog> getPayLogList() {
        return getList();
    }

    public PayLog getPayLog(int id) {
        return (PayLog)getById(id);
    }

    public void savePayLog(PayLog obj) {
        save(obj);
    }

    public void removePayLog(int id) {
        deleteById(id);
    }
}
