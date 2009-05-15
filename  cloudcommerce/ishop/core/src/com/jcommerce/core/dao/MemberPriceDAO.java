/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.MemberPrice;

public interface MemberPriceDAO extends DAO {
    public List<MemberPrice> getMemberPriceList();

    public MemberPrice getMemberPrice(int id);

    public void saveMemberPrice(MemberPrice obj);

    public void removeMemberPrice(int id);
}
