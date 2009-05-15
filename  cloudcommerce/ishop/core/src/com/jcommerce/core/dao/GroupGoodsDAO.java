/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.GroupGoods;

public interface GroupGoodsDAO extends DAO {
    public List<GroupGoods> getGroupGoodsList();

    public GroupGoods getGroupGoods(int id);

    public void saveGroupGoods(GroupGoods obj);

    public void removeGroupGoods(int id);
}
