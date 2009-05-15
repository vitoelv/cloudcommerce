/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Plugins;

public interface PluginsDAO extends DAO {
    public List<Plugins> getPluginsList();

    public Plugins getPlugins(int id);

    public void savePlugins(Plugins obj);

    public void removePlugins(int id);
}
