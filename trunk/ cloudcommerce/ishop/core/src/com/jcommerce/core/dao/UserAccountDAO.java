/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.UserAccount;

public interface UserAccountDAO extends DAO {
    public List<UserAccount> getUserAccountList();

    public UserAccount getUserAccount(int id);

    public void saveUserAccount(UserAccount obj);

    public void removeUserAccount(int id);
}
