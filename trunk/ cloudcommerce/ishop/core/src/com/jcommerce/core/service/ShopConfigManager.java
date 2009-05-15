/**
* @Author: KingZhao
*/

package com.jcommerce.core.service;

import java.util.List;

import com.jcommerce.core.model.ShopConfig;
import com.jcommerce.core.service.Criteria;
public interface ShopConfigManager extends Manager {
    public ShopConfig initialize(ShopConfig obj);

    public List<ShopConfig> getShopConfigList(int firstRow, int maxRow);

    public int getShopConfigCount(Criteria criteria);

    public List<ShopConfig> getShopConfigList(Criteria criteria);

    public List<ShopConfig> getShopConfigList(int firstRow, int maxRow, Criteria criteria);

    public List<ShopConfig> getShopConfigList();

    public ShopConfig getShopConfig(String id);

    public void saveShopConfig(ShopConfig obj);

    public void removeShopConfig(String id);
}
