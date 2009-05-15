/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.VoteDAO;
import com.jcommerce.core.model.Vote;

public class VoteDAOImpl extends DAOImpl implements VoteDAO {
    public VoteDAOImpl() {
        modelClass = Vote.class;
    }

    public List<Vote> getVoteList() {
        return getList();
    }

    public Vote getVote(int id) {
        return (Vote)getById(id);
    }

    public void saveVote(Vote obj) {
        save(obj);
    }

    public void removeVote(int id) {
        deleteById(id);
    }
}
