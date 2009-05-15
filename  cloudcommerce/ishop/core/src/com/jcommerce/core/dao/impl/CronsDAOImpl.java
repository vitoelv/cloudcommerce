/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.CronsDAO;
import com.jcommerce.core.model.Crons;

public class CronsDAOImpl extends DAOImpl implements CronsDAO {
    public CronsDAOImpl() {
        modelClass = Crons.class;
    }

    public List<Crons> getCronsList() {
        return getList();
    }

    public Crons getCrons(int id) {
        return (Crons)getById(id);
    }

    public void saveCrons(Crons obj) {
        save(obj);
    }

    public void removeCrons(int id) {
        deleteById(id);
    }
}
