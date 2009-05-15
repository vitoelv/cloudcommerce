/**
 * Author: Bob Chen
 */

package com.jcommerce.core.model;

import java.sql.Timestamp;

public class UserBonus extends ModelObject {
    
	private int id;
	private BonusType type;
	private String bonusSN;
	private User user;
	private Timestamp usedTime;
	private Order order;
	private boolean emailed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BonusType getType() {
        return type;
    }

    public void setType(BonusType type) {
        this.type = type;
    }

    public String getBonusSN() {
        return bonusSN;
    }

    public void setBonusSN(String bonusSN) {
        this.bonusSN = bonusSN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Timestamp usedTime) {
        this.usedTime = usedTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isEmailed() {
        return emailed;
    }

    public void setEmailed(boolean emailed) {
        this.emailed = emailed;
    }

}
