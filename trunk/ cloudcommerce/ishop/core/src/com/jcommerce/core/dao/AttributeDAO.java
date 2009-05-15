/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Attribute;

public interface AttributeDAO extends DAO {
    public List<Attribute> getAttributeList();

    public Attribute getAttribute(int id);

    public void saveAttribute(Attribute obj);

    public void removeAttribute(int id);
}
