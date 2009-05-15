/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.MemberPriceDAO;
import com.jcommerce.core.model.MemberPrice;

public class MemberPriceDAOImpl extends DAOImpl implements MemberPriceDAO {
    public MemberPriceDAOImpl() {
        modelClass = MemberPrice.class;
    }

    public List<MemberPrice> getMemberPriceList() {
        return getList();
    }

    public MemberPrice getMemberPrice(int id) {
        return (MemberPrice)getById(id);
    }

    public void saveMemberPrice(MemberPrice obj) {
        save(obj);
    }

    public void removeMemberPrice(int id) {
        deleteById(id);
    }
}
