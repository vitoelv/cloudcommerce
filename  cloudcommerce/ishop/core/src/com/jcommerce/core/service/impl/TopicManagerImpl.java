/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.TopicDAO;
import com.jcommerce.core.model.Topic;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.TopicManager;

public class TopicManagerImpl extends ManagerImpl implements TopicManager {
    private static Log log = LogFactory.getLog(TopicManagerImpl.class);
    private TopicDAO dao;

    public void setTopicDAO(TopicDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Topic initialize(Topic obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getTopic(obj.getId());
        }
        return obj;
    }

    public List<Topic> getTopicList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Topic>)list;
    }

    public int getTopicCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Topic> getTopicList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Topic>)list;
    }

    public List<Topic> getTopicList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Topic>)list;
    }

    public List<Topic> getTopicList() {
        return dao.getTopicList();
    }

    public Topic getTopic(String id) {
        Topic obj = dao.getTopic(Integer.parseInt(id));
        return obj;
    }

    public void saveTopic(Topic obj) {
        dao.saveTopic(obj);
    }

    public void removeTopic(String id) {
        dao.removeTopic(Integer.parseInt(id));
    }
}
