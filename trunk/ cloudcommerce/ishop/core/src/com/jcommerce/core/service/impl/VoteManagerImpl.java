/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.VoteDAO;
import com.jcommerce.core.model.Vote;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.VoteManager;

public class VoteManagerImpl extends ManagerImpl implements VoteManager {
    private static Log log = LogFactory.getLog(VoteManagerImpl.class);
    private VoteDAO dao;

    public void setVoteDAO(VoteDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Vote initialize(Vote obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getVote(obj.getId());
        }
        return obj;
    }

    public List<Vote> getVoteList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Vote>)list;
    }

    public int getVoteCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Vote> getVoteList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Vote>)list;
    }

    public List<Vote> getVoteList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Vote>)list;
    }

    public List<Vote> getVoteList() {
        return dao.getVoteList();
    }

    public Vote getVote(String id) {
        Vote obj = dao.getVote(Integer.parseInt(id));
        return obj;
    }

    public void saveVote(Vote obj) {
        dao.saveVote(obj);
    }

    public void removeVote(String id) {
        dao.removeVote(Integer.parseInt(id));
    }
}
