package com.jcommerce.core.model;

import java.util.HashSet;
import java.util.Set;

public class GroupGoods extends ModelObject {

	private int id;
	private GroupGoods parent;
	private Set<GroupGoods> children = new HashSet<GroupGoods>();
	private Goods goods;
	private double goodsPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GroupGoods getParent() {
		return parent;
	}

	public void setParent(GroupGoods parent) {
		if (getParent() != null) {
			getParent().removeChild(this);
		}
		this.parent = parent;
		if (this.parent != null) {
			this.parent.addChild(this);
		}
	}

	public Set<GroupGoods> getChildren() {
		return children;
	}

	public void setChildren(Set<GroupGoods> children) {
		if (children == null) {
			this.children.clear();
		} else {
			this.children = children;
		}
	}

	public void addChild(GroupGoods child) {
		children.add(child);
		child.parent = this;
	}

	public void removeChild(GroupGoods child) {
		children.remove(child);
		child.parent = null;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}
