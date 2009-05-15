/**
* Author: Bob Chen
*/

package com.jcommerce.core.service;

import java.util.List;

import com.jcommerce.core.model.OrderAction;
import com.jcommerce.core.service.Criteria;
public interface OrderActionManager extends Manager {
    public OrderAction initialize(OrderAction obj);

    public List<OrderAction> getOrderActionList(int firstRow, int maxRow);

    public int getOrderActionCount(Criteria criteria);

    public List<OrderAction> getOrderActionList(Criteria criteria);

    public List<OrderAction> getOrderActionList(int firstRow, int maxRow, Criteria criteria);

    public List<OrderAction> getOrderActionList();

    public OrderAction getOrderAction(String id);

    public void saveOrderAction(OrderAction obj);

    public void removeOrderAction(String id);
}
