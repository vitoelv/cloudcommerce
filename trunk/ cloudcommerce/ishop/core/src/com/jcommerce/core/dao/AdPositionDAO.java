/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.AdPosition;

public interface AdPositionDAO extends DAO {
    public List<AdPosition> getAdPositionList();

    public AdPosition getAdPosition(int id);

    public void saveAdPosition(AdPosition obj);

    public void removeAdPosition(int id);
}
