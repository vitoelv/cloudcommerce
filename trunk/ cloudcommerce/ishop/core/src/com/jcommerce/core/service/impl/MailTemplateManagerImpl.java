/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.MailTemplateDAO;
import com.jcommerce.core.model.MailTemplate;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.MailTemplateManager;

public class MailTemplateManagerImpl extends ManagerImpl implements MailTemplateManager {
    private static Log log = LogFactory.getLog(MailTemplateManagerImpl.class);
    private MailTemplateDAO dao;

    public void setMailTemplateDAO(MailTemplateDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public MailTemplate initialize(MailTemplate obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getMailTemplate(obj.getId());
        }
        return obj;
    }

    public List<MailTemplate> getMailTemplateList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<MailTemplate>)list;
    }

    public int getMailTemplateCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<MailTemplate> getMailTemplateList(Criteria criteria) {
        List list = getList(criteria);
        return (List<MailTemplate>)list;
    }

    public List<MailTemplate> getMailTemplateList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<MailTemplate>)list;
    }

    public List<MailTemplate> getMailTemplateList() {
        return dao.getMailTemplateList();
    }

    public MailTemplate getMailTemplate(String id) {
        MailTemplate obj = dao.getMailTemplate(Integer.parseInt(id));
        return obj;
    }

    public void saveMailTemplate(MailTemplate obj) {
        dao.saveMailTemplate(obj);
    }

    public void removeMailTemplate(String id) {
        dao.removeMailTemplate(Integer.parseInt(id));
    }
}
