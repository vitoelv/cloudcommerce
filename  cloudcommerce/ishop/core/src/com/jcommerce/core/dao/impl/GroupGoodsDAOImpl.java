/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.GroupGoodsDAO;
import com.jcommerce.core.model.GroupGoods;

public class GroupGoodsDAOImpl extends DAOImpl implements GroupGoodsDAO {
    public GroupGoodsDAOImpl() {
        modelClass = GroupGoods.class;
    }

    public List<GroupGoods> getGroupGoodsList() {
        return getList();
    }

    public GroupGoods getGroupGoods(int id) {
        return (GroupGoods)getById(id);
    }

    public void saveGroupGoods(GroupGoods obj) {
        save(obj);
    }

    public void removeGroupGoods(int id) {
        deleteById(id);
    }
}
