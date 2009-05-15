/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao.impl;

import java.util.List;

import com.jcommerce.core.dao.CategoryDAO;
import com.jcommerce.core.model.Category;

public class CategoryDAOImpl extends DAOImpl implements CategoryDAO {
    public CategoryDAOImpl() {
        modelClass = Category.class;
    }

    public List<Category> getCategoryList() {
        return getList();
    }

    public Category getCategory(int id) {
        return (Category)getById(id);
    }

    public void saveCategory(Category obj) {
        save(obj);
    }

    public void removeCategory(int id) {
        deleteById(id);
    }
}
