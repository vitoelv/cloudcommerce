/**
 * Author: Bob Chen
 */

package com.jcommerce.core.model;

public class AdminAction extends ModelObject {
	
	private int id;
	private AdminAction parent;
	private String code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AdminAction getParent() {
		return parent;
	}

	public void setParent(AdminAction parent) {
		this.parent = parent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
