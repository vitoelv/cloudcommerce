/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.AdPositionDAO;
import com.jcommerce.core.model.AdPosition;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.AdPositionManager;

public class AdPositionManagerImpl extends ManagerImpl implements AdPositionManager {
    private static Log log = LogFactory.getLog(AdPositionManagerImpl.class);
    private AdPositionDAO dao;

    public void setAdPositionDAO(AdPositionDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public AdPosition initialize(AdPosition obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getAdPosition(obj.getId());
        }
        return obj;
    }

    public List<AdPosition> getAdPositionList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<AdPosition>)list;
    }

    public int getAdPositionCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<AdPosition> getAdPositionList(Criteria criteria) {
        List list = getList(criteria);
        return (List<AdPosition>)list;
    }

    public List<AdPosition> getAdPositionList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<AdPosition>)list;
    }

    public List<AdPosition> getAdPositionList() {
        return dao.getAdPositionList();
    }

    public AdPosition getAdPosition(String id) {
        AdPosition obj = dao.getAdPosition(Integer.parseInt(id));
        return obj;
    }

    public void saveAdPosition(AdPosition obj) {
        dao.saveAdPosition(obj);
    }

    public void removeAdPosition(String id) {
        dao.removeAdPosition(Integer.parseInt(id));
    }
}
