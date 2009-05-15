/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.GoodsDAO;
import com.jcommerce.core.model.Goods;

public class GoodsDAOImpl extends DAOImpl implements GoodsDAO {
    public GoodsDAOImpl() {
        modelClass = Goods.class;
    }

    public List<Goods> getGoodsList() {
        return getList();
    }

    public Goods getGoods(int id) {
        return (Goods)getById(id);
    }

    public void saveGoods(Goods obj) {
        save(obj);
    }

    public void removeGoods(int id) {
        deleteById(id);
    }
}
