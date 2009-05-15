/**
* @Author: KingZhao
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Feedback;

public interface FeedbackDAO extends DAO {
    public List<Feedback> getFeedbackList();

    public Feedback getFeedback(int id);

    public void saveFeedback(Feedback obj);

    public void removeFeedback(int id);
}
