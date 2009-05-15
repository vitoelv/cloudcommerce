/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.AccountLog;

public interface AccountLogDAO extends DAO {
    public List<AccountLog> getAccountLogList();

    public AccountLog getAccountLog(int id);

    public void saveAccountLog(AccountLog obj);

    public void removeAccountLog(int id);
}
