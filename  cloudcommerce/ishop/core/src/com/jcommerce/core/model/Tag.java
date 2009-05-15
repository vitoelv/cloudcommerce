/**
 * @author KingZhao
 */
package com.jcommerce.core.model;

public class Tag extends ModelObject {

	private int id;
	private User user;
	private Goods goods;
	private String tagWords;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getTagWords() {
		return tagWords;
	}

	public void setTagWords(String tagWords) {
		this.tagWords = tagWords;
	}

}
