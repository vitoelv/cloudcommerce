/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.UserAccountDAO;
import com.jcommerce.core.model.UserAccount;

public class UserAccountDAOImpl extends DAOImpl implements UserAccountDAO {
    public UserAccountDAOImpl() {
        modelClass = UserAccount.class;
    }

    public List<UserAccount> getUserAccountList() {
        return getList();
    }

    public UserAccount getUserAccount(int id) {
        return (UserAccount)getById(id);
    }

    public void saveUserAccount(UserAccount obj) {
        save(obj);
    }

    public void removeUserAccount(int id) {
        deleteById(id);
    }
}
