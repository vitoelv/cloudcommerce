/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.PluginsDAO;
import com.jcommerce.core.model.Plugins;

public class PluginsDAOImpl extends DAOImpl implements PluginsDAO {
    public PluginsDAOImpl() {
        modelClass = Plugins.class;
    }

    public List<Plugins> getPluginsList() {
        return getList();
    }

    public Plugins getPlugins(int id) {
        return (Plugins)getById(id);
    }

    public void savePlugins(Plugins obj) {
        save(obj);
    }

    public void removePlugins(int id) {
        deleteById(id);
    }
}
