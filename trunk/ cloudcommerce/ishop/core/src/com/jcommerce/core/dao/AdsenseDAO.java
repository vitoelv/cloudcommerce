/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Adsense;

public interface AdsenseDAO extends DAO {
    public List<Adsense> getAdsenseList();

    public Adsense getAdsense(int id);

    public void saveAdsense(Adsense obj);

    public void removeAdsense(int id);
}
