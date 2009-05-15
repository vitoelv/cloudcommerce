/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.UserAccountDAO;
import com.jcommerce.core.model.UserAccount;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.UserAccountManager;

public class UserAccountManagerImpl extends ManagerImpl implements UserAccountManager {
    private static Log log = LogFactory.getLog(UserAccountManagerImpl.class);
    private UserAccountDAO dao;

    public void setUserAccountDAO(UserAccountDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public UserAccount initialize(UserAccount obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getUserAccount(obj.getId());
        }
        return obj;
    }

    public List<UserAccount> getUserAccountList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<UserAccount>)list;
    }

    public int getUserAccountCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<UserAccount> getUserAccountList(Criteria criteria) {
        List list = getList(criteria);
        return (List<UserAccount>)list;
    }

    public List<UserAccount> getUserAccountList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<UserAccount>)list;
    }

    public List<UserAccount> getUserAccountList() {
        return dao.getUserAccountList();
    }

    public UserAccount getUserAccount(String id) {
        UserAccount obj = dao.getUserAccount(Integer.parseInt(id));
        return obj;
    }

    public void saveUserAccount(UserAccount obj) {
        dao.saveUserAccount(obj);
    }

    public void removeUserAccount(String id) {
        dao.removeUserAccount(Integer.parseInt(id));
    }
}
