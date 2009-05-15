/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.OrderGoods;

public interface OrderGoodsDAO extends DAO {
    public List<OrderGoods> getOrderGoodsList();

    public OrderGoods getOrderGoods(int id);

    public void saveOrderGoods(OrderGoods obj);

    public void removeOrderGoods(int id);
}
