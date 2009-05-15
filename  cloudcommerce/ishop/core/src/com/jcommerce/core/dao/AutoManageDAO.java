/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.AutoManage;

public interface AutoManageDAO extends DAO {
    public List<AutoManage> getAutoManageList();

    public AutoManage getAutoManage(int id);

    public void saveAutoManage(AutoManage obj);

    public void removeAutoManage(int id);
}
