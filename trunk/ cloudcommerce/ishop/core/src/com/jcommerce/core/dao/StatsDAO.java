/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Stats;

public interface StatsDAO extends DAO {
    public List<Stats> getStatsList();

    public Stats getStats(int id);

    public void saveStats(Stats obj);

    public void removeStats(int id);
}
