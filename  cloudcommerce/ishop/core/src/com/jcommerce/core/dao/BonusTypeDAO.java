/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.BonusType;

public interface BonusTypeDAO extends DAO {
    public List<BonusType> getBonusTypeList();

    public BonusType getBonusType(int id);

    public void saveBonusType(BonusType obj);

    public void removeBonusType(int id);
}
