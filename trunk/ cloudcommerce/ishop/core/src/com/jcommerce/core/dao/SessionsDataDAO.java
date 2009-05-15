/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.SessionsData;

public interface SessionsDataDAO extends DAO {
    public List<SessionsData> getSessionsDataList();

    public SessionsData getSessionsData(int id);

    public void saveSessionsData(SessionsData obj);

    public void removeSessionsData(int id);
}
