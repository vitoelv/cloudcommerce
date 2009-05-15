/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.NavigationDAO;
import com.jcommerce.core.model.Navigation;

public class NavigationDAOImpl extends DAOImpl implements NavigationDAO {
    public NavigationDAOImpl() {
        modelClass = Navigation.class;
    }

    public List<Navigation> getNavigationList() {
        return getList();
    }

    public Navigation getNavigation(int id) {
        return (Navigation)getById(id);
    }

    public void saveNavigation(Navigation obj) {
        save(obj);
    }

    public void removeNavigation(int id) {
        deleteById(id);
    }
}
