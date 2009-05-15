/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.EmailSendList;

public interface EmailSendListDAO extends DAO {
    public List<EmailSendList> getEmailSendListList();

    public EmailSendList getEmailSendList(int id);

    public void saveEmailSendList(EmailSendList obj);

    public void removeEmailSendList(int id);
}
