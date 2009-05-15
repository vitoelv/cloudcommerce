/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.MailTemplate;

public interface MailTemplateDAO extends DAO {
    public List<MailTemplate> getMailTemplateList();

    public MailTemplate getMailTemplate(int id);

    public void saveMailTemplate(MailTemplate obj);

    public void removeMailTemplate(int id);
}
