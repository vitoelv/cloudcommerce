/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.ShopConfigDAO;
import com.jcommerce.core.model.ShopConfig;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.ShopConfigManager;

public class ShopConfigManagerImpl extends ManagerImpl implements ShopConfigManager {
    private static Log log = LogFactory.getLog(ShopConfigManagerImpl.class);
    private ShopConfigDAO dao;

    public void setShopConfigDAO(ShopConfigDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public ShopConfig initialize(ShopConfig obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getShopConfig(obj.getId());
        }
        return obj;
    }

    public List<ShopConfig> getShopConfigList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<ShopConfig>)list;
    }

    public int getShopConfigCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<ShopConfig> getShopConfigList(Criteria criteria) {
        List list = getList(criteria);
        return (List<ShopConfig>)list;
    }

    public List<ShopConfig> getShopConfigList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<ShopConfig>)list;
    }

    public List<ShopConfig> getShopConfigList() {
        return dao.getShopConfigList();
    }

    public ShopConfig getShopConfig(String id) {
        ShopConfig obj = dao.getShopConfig(Integer.parseInt(id));
        return obj;
    }

    public void saveShopConfig(ShopConfig obj) {
        dao.saveShopConfig(obj);
    }

    public void removeShopConfig(String id) {
        dao.removeShopConfig(Integer.parseInt(id));
    }
}
