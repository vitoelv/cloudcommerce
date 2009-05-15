/**
 * Author: Bob Chen
 */

package com.jcommerce.core.model;

public class Shipping extends ModelObject {
    
	private int id;
	private String name;
	private String code;
	private String description;
	private String insure;
	private boolean supportCod;
	private boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInsure() {
        return insure;
    }

    public void setInsure(String insure) {
        this.insure = insure;
    }

    public boolean isSupportCod() {
        return supportCod;
    }

    public void setSupportCod(boolean supportCod) {
        this.supportCod = supportCod;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
