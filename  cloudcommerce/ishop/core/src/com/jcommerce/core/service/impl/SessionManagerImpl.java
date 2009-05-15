/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.SessionDAO;
import com.jcommerce.core.model.Session;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.SessionManager;

public class SessionManagerImpl extends ManagerImpl implements SessionManager {
    private static Log log = LogFactory.getLog(SessionManagerImpl.class);
    private SessionDAO dao;

    public void setSessionDAO(SessionDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Session initialize(Session obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getSession(obj.getId());
        }
        return obj;
    }

    public List<Session> getSessionList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Session>)list;
    }

    public int getSessionCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Session> getSessionList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Session>)list;
    }

    public List<Session> getSessionList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Session>)list;
    }

    public List<Session> getSessionList() {
        return dao.getSessionList();
    }

    public Session getSession(String id) {
        Session obj = dao.getSession(id);
        return obj;
    }

    public void saveSession(Session obj) {
        dao.saveSession(obj);
    }

    public void removeSession(String id) {
        dao.removeSession(id);
    }
}
