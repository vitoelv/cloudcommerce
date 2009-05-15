/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Crons;

public interface CronsDAO extends DAO {
    public List<Crons> getCronsList();

    public Crons getCrons(int id);

    public void saveCrons(Crons obj);

    public void removeCrons(int id);
}
