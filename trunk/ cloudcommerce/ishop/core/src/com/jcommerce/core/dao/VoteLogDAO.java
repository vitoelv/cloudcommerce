/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.VoteLog;

public interface VoteLogDAO extends DAO {
    public List<VoteLog> getVoteLogList();

    public VoteLog getVoteLog(int id);

    public void saveVoteLog(VoteLog obj);

    public void removeVoteLog(int id);
}
