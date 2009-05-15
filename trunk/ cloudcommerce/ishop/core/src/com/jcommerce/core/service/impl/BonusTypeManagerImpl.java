/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.BonusTypeDAO;
import com.jcommerce.core.model.BonusType;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.BonusTypeManager;

public class BonusTypeManagerImpl extends ManagerImpl implements BonusTypeManager {
    private static Log log = LogFactory.getLog(BonusTypeManagerImpl.class);
    private BonusTypeDAO dao;

    public void setBonusTypeDAO(BonusTypeDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public BonusType initialize(BonusType obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getBonusType(obj.getId());
        }
        return obj;
    }

    public List<BonusType> getBonusTypeList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<BonusType>)list;
    }

    public int getBonusTypeCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<BonusType> getBonusTypeList(Criteria criteria) {
        List list = getList(criteria);
        return (List<BonusType>)list;
    }

    public List<BonusType> getBonusTypeList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<BonusType>)list;
    }

    public List<BonusType> getBonusTypeList() {
        return dao.getBonusTypeList();
    }

    public BonusType getBonusType(String id) {
        BonusType obj = dao.getBonusType(Integer.parseInt(id));
        return obj;
    }

    public void saveBonusType(BonusType obj) {
        dao.saveBonusType(obj);
    }

    public void removeBonusType(String id) {
        dao.removeBonusType(Integer.parseInt(id));
    }
}
