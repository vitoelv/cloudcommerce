/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Shipping;

public interface ShippingDAO extends DAO {
    public List<Shipping> getShippingList();

    public Shipping getShipping(int id);

    public void saveShipping(Shipping obj);

    public void removeShipping(int id);
}
