/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.PluginsDAO;
import com.jcommerce.core.model.Plugins;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.PluginsManager;

public class PluginsManagerImpl extends ManagerImpl implements PluginsManager {
    private static Log log = LogFactory.getLog(PluginsManagerImpl.class);
    private PluginsDAO dao;

    public void setPluginsDAO(PluginsDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Plugins initialize(Plugins obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getPlugins(obj.getId());
        }
        return obj;
    }

    public List<Plugins> getPluginsList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Plugins>)list;
    }

    public int getPluginsCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Plugins> getPluginsList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Plugins>)list;
    }

    public List<Plugins> getPluginsList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Plugins>)list;
    }

    public List<Plugins> getPluginsList() {
        return dao.getPluginsList();
    }

    public Plugins getPlugins(String id) {
        Plugins obj = dao.getPlugins(Integer.parseInt(id));
        return obj;
    }

    public void savePlugins(Plugins obj) {
        dao.savePlugins(obj);
    }

    public void removePlugins(String id) {
        dao.removePlugins(Integer.parseInt(id));
    }
}
