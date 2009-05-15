package com.jcommerce.core.model;

public class LinkGoods extends ModelObject {

	private int id;
	private Goods goods;
	private Goods linkGoods;//相关货物
	private boolean bidirectional;//是否是双向的

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

	public Goods getLinkGoods() {
		return linkGoods;
	}

	public void setLinkGoods(Goods linkGoods) {
		this.linkGoods = linkGoods;
	}

    public boolean isBidirectional() {
        return bidirectional;
    }

    public void setBidirectional(boolean bidirectional) {
        this.bidirectional = bidirectional;
    }
}
