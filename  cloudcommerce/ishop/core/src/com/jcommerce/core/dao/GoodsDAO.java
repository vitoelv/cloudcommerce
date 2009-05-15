/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Goods;

public interface GoodsDAO extends DAO {
    public List<Goods> getGoodsList();

    public Goods getGoods(int id);

    public void saveGoods(Goods obj);

    public void removeGoods(int id);
}
