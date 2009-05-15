/**
* @Author: KingZhao
*/

package com.jcommerce.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.jcommerce.core.dao.VirtualCardDAO;
import com.jcommerce.core.model.VirtualCard;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.VirtualCardManager;

public class VirtualCardManagerImpl extends ManagerImpl implements VirtualCardManager {
    private static Log log = LogFactory.getLog(VirtualCardManagerImpl.class);
    private VirtualCardDAO dao;

    public void setVirtualCardDAO(VirtualCardDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }

    public VirtualCard initialize(VirtualCard obj) {
        if (obj != null && !Hibernate.isInitialized(obj)) {
            obj = dao.getVirtualCard(obj.getId());
        }
        return obj;
    }

    public List<VirtualCard> getVirtualCardList(int firstRow, int maxRow) {
        List list = getList(firstRow, maxRow);
        return (List<VirtualCard>)list;
    }

    public int getVirtualCardCount(Criteria criteria) {
        return getCount(criteria);
    }

    public List<VirtualCard> getVirtualCardList(Criteria criteria) {
        List list = getList(criteria);
        return (List<VirtualCard>)list;
    }

    public List<VirtualCard> getVirtualCardList(int firstRow, int maxRow, Criteria criteria) {
        List list = getList(firstRow, maxRow, criteria);
        return (List<VirtualCard>)list;
    }

    public List<VirtualCard> getVirtualCardList() {
        return dao.getVirtualCardList();
    }

    public VirtualCard getVirtualCard(String id) {
        VirtualCard obj = dao.getVirtualCard(Integer.parseInt(id));
        return obj;
    }

    public void saveVirtualCard(VirtualCard obj) {
        dao.saveVirtualCard(obj);
    }

    public void removeVirtualCard(String id) {
        dao.removeVirtualCard(Integer.parseInt(id));
    }
}
