/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.AdsenseDAO;
import com.jcommerce.core.model.Adsense;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.AdsenseManager;

public class AdsenseManagerImpl extends ManagerImpl implements AdsenseManager {
    private static Log log = LogFactory.getLog(AdsenseManagerImpl.class);
    private AdsenseDAO dao;

    public void setAdsenseDAO(AdsenseDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Adsense initialize(Adsense obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getAdsense(obj.getId());
        }
        return obj;
    }

    public List<Adsense> getAdsenseList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Adsense>)list;
    }

    public int getAdsenseCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Adsense> getAdsenseList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Adsense>)list;
    }

    public List<Adsense> getAdsenseList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Adsense>)list;
    }

    public List<Adsense> getAdsenseList() {
        return dao.getAdsenseList();
    }

    public Adsense getAdsense(String id) {
        Adsense obj = dao.getAdsense(Integer.parseInt(id));
        return obj;
    }

    public void saveAdsense(Adsense obj) {
        dao.saveAdsense(obj);
    }

    public void removeAdsense(String id) {
        dao.removeAdsense(Integer.parseInt(id));
    }
}
