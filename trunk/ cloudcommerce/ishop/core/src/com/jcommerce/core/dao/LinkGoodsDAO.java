/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.LinkGoods;

public interface LinkGoodsDAO extends DAO {
    public List<LinkGoods> getLinkGoodsList();

    public LinkGoods getLinkGoods(int id);

    public void saveLinkGoods(LinkGoods obj);

    public void removeLinkGoods(int id);
}
