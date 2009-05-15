/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Card;

public interface CardDAO extends DAO {
    public List<Card> getCardList();

    public Card getCard(int id);

    public void saveCard(Card obj);

    public void removeCard(int id);
}
