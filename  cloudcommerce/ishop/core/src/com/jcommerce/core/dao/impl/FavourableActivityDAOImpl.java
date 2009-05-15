/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.FavourableActivityDAO;
import com.jcommerce.core.model.FavourableActivity;

public class FavourableActivityDAOImpl extends DAOImpl implements FavourableActivityDAO {
    public FavourableActivityDAOImpl() {
        modelClass = FavourableActivity.class;
    }

    public List<FavourableActivity> getFavourableActivityList() {
        return getList();
    }

    public FavourableActivity getFavourableActivity(int id) {
        return (FavourableActivity)getById(id);
    }

    public void saveFavourableActivity(FavourableActivity obj) {
        save(obj);
    }

    public void removeFavourableActivity(int id) {
        deleteById(id);
    }
}
