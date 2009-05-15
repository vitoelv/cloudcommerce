/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.BookingGoods;

public interface BookingGoodsDAO extends DAO {
    public List<BookingGoods> getBookingGoodsList();

    public BookingGoods getBookingGoods(int id);

    public void saveBookingGoods(BookingGoods obj);

    public void removeBookingGoods(int id);
}
