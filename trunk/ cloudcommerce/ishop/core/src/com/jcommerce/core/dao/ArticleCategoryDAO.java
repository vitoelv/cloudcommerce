/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.ArticleCategory;

public interface ArticleCategoryDAO extends DAO {
    public List<ArticleCategory> getArticleCategoryList();

    public ArticleCategory getArticleCategory(int id);

    public void saveArticleCategory(ArticleCategory obj);

    public void removeArticleCategory(int id);
}
