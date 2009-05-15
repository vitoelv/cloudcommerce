/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.GoodsDAO;
import com.jcommerce.core.model.Goods;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.GoodsManager;

public class GoodsManagerImpl extends ManagerImpl implements GoodsManager {
    private static Log log = LogFactory.getLog(GoodsManagerImpl.class);
    private GoodsDAO dao;

    public void setGoodsDAO(GoodsDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Goods initialize(Goods obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getGoods(obj.getId());
        }
        return obj;
    }

    public List<Goods> getGoodsList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Goods>)list;
    }
    

    public List<Goods> getGoodsList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Goods>)list;
    }
    
    public List<Goods> getGoodsList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Goods>)list;
    }

    public int getGoodsCount(Criteria criteria) {
        return getCount(criteria);
    }
    
    public List<Goods> getGoodsList() {
        return dao.getGoodsList();
    }

    public Goods getGoods(String id) {
        Goods obj = dao.getGoods(Integer.parseInt(id));
        return obj;
    }

    public void saveGoods(Goods obj) {
        dao.saveGoods(obj);
    }

    public void removeGoods(String id) {
        dao.removeGoods(Integer.parseInt(id));
    }

    public List<Goods> getBestSoldGoodsList() {
        String hql = "from "+getModelName()+" where bestSold=true";
        List list = dao.getList(hql);
        return (List<Goods>)list;
    }

    public List<Goods> getHotSoldGoodsList() {
        String hql = "from "+getModelName()+" where hotSold=true";
        List list = dao.getList(hql);
        return (List<Goods>)list;
    }

    public List<Goods> getNewGoodsList() {
        String hql = "from "+getModelName()+" where newAdded=true";
        List list = dao.getList(hql);
        return (List<Goods>)list;
    }   
}
