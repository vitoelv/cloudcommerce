/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.UserBonus;

public interface UserBonusDAO extends DAO {
    public List<UserBonus> getUserBonusList();

    public UserBonus getUserBonus(int id);

    public void saveUserBonus(UserBonus obj);

    public void removeUserBonus(int id);
}
