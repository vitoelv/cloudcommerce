/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Cart;

public interface CartDAO extends DAO {
    public List<Cart> getCartList();

    public Cart getCart(int id);

    public void saveCart(Cart obj);

    public void removeCart(int id);
}
