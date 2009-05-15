/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.UserAddress;

public interface UserAddressDAO extends DAO {
    public List<UserAddress> getUserAddressList();

    public UserAddress getUserAddress(int id);

    public void saveUserAddress(UserAddress obj);

    public void removeUserAddress(int id);
}
