/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Order;

public interface OrderDAO extends DAO {
    public List<Order> getOrderList();

    public Order getOrder(int id);

    public void saveOrder(Order obj);
    
    public void removeOrder(int id);
}
