/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.VoteData;

public interface VoteDataDAO extends DAO {
    public List<VoteData> getVoteDataList();

    public VoteData getVoteData(int id);

    public void saveVoteData(VoteData obj);

    public void removeVoteData(int id);
}
