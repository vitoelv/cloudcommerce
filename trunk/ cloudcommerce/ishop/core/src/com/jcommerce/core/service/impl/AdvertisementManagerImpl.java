/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.AdvertisementDAO;
import com.jcommerce.core.model.Advertisement;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.AdvertisementManager;

public class AdvertisementManagerImpl extends ManagerImpl implements AdvertisementManager {
    private static Log log = LogFactory.getLog(AdvertisementManagerImpl.class);
    private AdvertisementDAO dao;

    public void setAdvertisementDAO(AdvertisementDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public Advertisement initialize(Advertisement obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getAdvertisement(obj.getId());
        }
        return obj;
    }

    public List<Advertisement> getAdvertisementList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<Advertisement>)list;
    }

    public int getAdvertisementCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<Advertisement> getAdvertisementList(Criteria criteria) {
        List list = getList(criteria);
        return (List<Advertisement>)list;
    }

    public List<Advertisement> getAdvertisementList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<Advertisement>)list;
    }

    public List<Advertisement> getAdvertisementList() {
        return dao.getAdvertisementList();
    }

    public Advertisement getAdvertisement(String id) {
        Advertisement obj = dao.getAdvertisement(Integer.parseInt(id));
        return obj;
    }

    public void saveAdvertisement(Advertisement obj) {
        dao.saveAdvertisement(obj);
    }

    public void removeAdvertisement(String id) {
        dao.removeAdvertisement(Integer.parseInt(id));
    }
}
