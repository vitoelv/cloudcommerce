/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.CollectGoodsDAO;
import com.jcommerce.core.model.CollectGoods;

public class CollectGoodsDAOImpl extends DAOImpl implements CollectGoodsDAO {
    public CollectGoodsDAOImpl() {
        modelClass = CollectGoods.class;
    }

    public List<CollectGoods> getCollectGoodsList() {
        return getList();
    }

    public CollectGoods getCollectGoods(int id) {
        return (CollectGoods)getById(id);
    }

    public void saveCollectGoods(CollectGoods obj) {
        save(obj);
    }

    public void removeCollectGoods(int id) {
        deleteById(id);
    }
}
