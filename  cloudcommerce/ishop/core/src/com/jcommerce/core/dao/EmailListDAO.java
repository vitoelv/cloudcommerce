/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.EmailList;

public interface EmailListDAO extends DAO {
    public List<EmailList> getEmailListList();

    public EmailList getEmailList(int id);

    public void saveEmailList(EmailList obj);

    public void removeEmailList(int id);
}
