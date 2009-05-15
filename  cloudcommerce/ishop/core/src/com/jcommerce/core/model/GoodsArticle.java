/**
 * @author KingZhao
 */
package com.jcommerce.core.model;

public class GoodsArticle extends ModelObject {
	
	private int id;
	private Article article;
	private Goods goods;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
