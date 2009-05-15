/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.AttributeDAO;
import com.jcommerce.core.model.Attribute;

public class AttributeDAOImpl extends DAOImpl implements AttributeDAO {
    public AttributeDAOImpl() {
        modelClass = Attribute.class;
    }

    public List<Attribute> getAttributeList() {
        return getList();
    }

    public Attribute getAttribute(int id) {
        return (Attribute)getById(id);
    }

    public void saveAttribute(Attribute obj) {
        save(obj);
    }

    public void removeAttribute(int id) {
        deleteById(id);
    }
}
