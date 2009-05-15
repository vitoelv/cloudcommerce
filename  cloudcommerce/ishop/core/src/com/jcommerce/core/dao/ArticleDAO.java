/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Article;

public interface ArticleDAO extends DAO {
    public List<Article> getArticleList();

    public Article getArticle(int id);

    public void saveArticle(Article obj);

    public void removeArticle(int id);
}
