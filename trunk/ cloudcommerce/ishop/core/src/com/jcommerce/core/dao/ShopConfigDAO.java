/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.ShopConfig;

public interface ShopConfigDAO extends DAO {
    public List<ShopConfig> getShopConfigList();

    public ShopConfig getShopConfig(int id);

    public void saveShopConfig(ShopConfig obj);

    public void removeShopConfig(int id);
}
