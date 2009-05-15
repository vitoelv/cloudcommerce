/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Vote;

public interface VoteDAO extends DAO {
    public List<Vote> getVoteList();

    public Vote getVote(int id);

    public void saveVote(Vote obj);

    public void removeVote(int id);
}
