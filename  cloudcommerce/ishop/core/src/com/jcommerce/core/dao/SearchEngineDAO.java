/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.SearchEngine;

public interface SearchEngineDAO extends DAO {
    public List<SearchEngine> getSearchEngineList();

    public SearchEngine getSearchEngine(int id);

    public void saveSearchEngine(SearchEngine obj);

    public void removeSearchEngine(int id);
}
