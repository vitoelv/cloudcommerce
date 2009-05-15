/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.AdminMessage;

public interface AdminMessageDAO extends DAO {
    public List<AdminMessage> getAdminMessageList();

    public AdminMessage getAdminMessage(int id);

    public void saveAdminMessage(AdminMessage obj);

    public void removeAdminMessage(int id);
}
