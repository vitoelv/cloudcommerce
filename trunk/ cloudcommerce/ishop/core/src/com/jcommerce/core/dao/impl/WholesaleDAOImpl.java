/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.WholesaleDAO;
import com.jcommerce.core.model.Wholesale;

public class WholesaleDAOImpl extends DAOImpl implements WholesaleDAO {
    public WholesaleDAOImpl() {
        modelClass = Wholesale.class;
    }

    public List<Wholesale> getWholesaleList() {
        return getList();
    }

    public Wholesale getWholesale(int id) {
        return (Wholesale)getById(id);
    }

    public void saveWholesale(Wholesale obj) {
        save(obj);
    }

    public void removeWholesale(int id) {
        deleteById(id);
    }
}
