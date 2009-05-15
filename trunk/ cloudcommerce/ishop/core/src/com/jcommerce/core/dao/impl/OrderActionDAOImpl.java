/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.OrderActionDAO;
import com.jcommerce.core.model.OrderAction;

public class OrderActionDAOImpl extends DAOImpl implements OrderActionDAO {
    public OrderActionDAOImpl() {
        modelClass = OrderAction.class;
    }

    public List<OrderAction> getOrderActionList() {
        return getList();
    }

    public OrderAction getOrderAction(int id) {
        return (OrderAction)getById(id);
    }

    public void saveOrderAction(OrderAction obj) {
        save(obj);
    }

    public void removeOrderAction(int id) {
        deleteById(id);
    }
}
