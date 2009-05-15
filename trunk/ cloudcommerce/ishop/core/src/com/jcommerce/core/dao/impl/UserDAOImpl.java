/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.UserDAO;
import com.jcommerce.core.model.User;

public class UserDAOImpl extends DAOImpl implements UserDAO {
    public UserDAOImpl() {
        modelClass = User.class;
    }

    public List<User> getUserList() {
        return getList();
    }

    public User getUser(int id) {
        return (User)getById(id);
    }

    public void saveUser(User obj) {
        save(obj);
    }

    public void removeUser(int id) {
        deleteById(id);
    }
}
