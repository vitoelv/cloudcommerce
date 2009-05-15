/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.VoteDataDAO;
import com.jcommerce.core.model.VoteData;

public class VoteDataDAOImpl extends DAOImpl implements VoteDataDAO {
    public VoteDataDAOImpl() {
        modelClass = VoteData.class;
    }

    public List<VoteData> getVoteDataList() {
        return getList();
    }

    public VoteData getVoteData(int id) {
        return (VoteData)getById(id);
    }

    public void saveVoteData(VoteData obj) {
        save(obj);
    }

    public void removeVoteData(int id) {
        deleteById(id);
    }
}
