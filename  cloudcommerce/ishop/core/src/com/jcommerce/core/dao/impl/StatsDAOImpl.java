/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.StatsDAO;
import com.jcommerce.core.model.Stats;

public class StatsDAOImpl extends DAOImpl implements StatsDAO {
    public StatsDAOImpl() {
        modelClass = Stats.class;
    }

    public List<Stats> getStatsList() {
        return getList();
    }

    public Stats getStats(int id) {
        return (Stats)getById(id);
    }

    public void saveStats(Stats obj) {
        save(obj);
    }

    public void removeStats(int id) {
        deleteById(id);
    }
}
