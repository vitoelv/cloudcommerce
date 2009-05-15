/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Keywords;

public interface KeywordsDAO extends DAO {
    public List<Keywords> getKeywordsList();

    public Keywords getKeywords(int id);

    public void saveKeywords(Keywords obj);

    public void removeKeywords(int id);
}
