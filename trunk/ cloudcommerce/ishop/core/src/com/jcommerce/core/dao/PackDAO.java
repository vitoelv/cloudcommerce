/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Pack;

public interface PackDAO extends DAO {
    public List<Pack> getPackList();

    public Pack getPack(int id);

    public void savePack(Pack obj);

    public void removePack(int id);
}
