/**
 * @author KingZhao
 */
package com.jcommerce.core.model;

public class MemberPrice extends ModelObject {

	private int id;
	private Goods goods;
	private UserRank userRank;
	private double userPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public UserRank getUserRank() {
		return userRank;
	}

	public void setUserRank(UserRank userRank) {
		this.userRank = userRank;
	}

	public double getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(double userPrice) {
		this.userPrice = userPrice;
	}

}
