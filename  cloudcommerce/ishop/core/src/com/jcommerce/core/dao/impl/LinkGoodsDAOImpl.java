/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.LinkGoodsDAO;
import com.jcommerce.core.model.LinkGoods;

public class LinkGoodsDAOImpl extends DAOImpl implements LinkGoodsDAO {
    public LinkGoodsDAOImpl() {
        modelClass = LinkGoods.class;
    }

    public List<LinkGoods> getLinkGoodsList() {
        return getList();
    }

    public LinkGoods getLinkGoods(int id) {
        return (LinkGoods)getById(id);
    }

    public void saveLinkGoods(LinkGoods obj) {
        save(obj);
    }

    public void removeLinkGoods(int id) {
        deleteById(id);
    }
}
