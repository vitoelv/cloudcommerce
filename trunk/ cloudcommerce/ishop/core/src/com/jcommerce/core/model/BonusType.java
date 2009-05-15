/**
* Author: Bob Chen
*/

package com.jcommerce.core.model;

import java.sql.Timestamp;

public class BonusType extends ModelObject {
    
	private int id;
    private String name;
    private double money;
    private double minAmount;
    private double maxAmount;
    private int sendType;
    private double minGoodsAmount;
    private Timestamp sendStart;
    private Timestamp sendEnd;
    private Timestamp useStart;
    private Timestamp useEnd;
    
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
    
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double money) {
        this.money = money;
    }
    
    public double getMinAmount() {
        return minAmount;
    }
    
    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public double getMinGoodsAmount() {
        return minGoodsAmount;
    }

    public void setMinGoodsAmount(double minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
    }

    public Timestamp getSendStart() {
        return sendStart;
    }

    public void setSendStart(Timestamp sendStart) {
        this.sendStart = sendStart;
    }

    public Timestamp getSendEnd() {
        return sendEnd;
    }

    public void setSendEnd(Timestamp sendEnd) {
        this.sendEnd = sendEnd;
    }

    public Timestamp getUseStart() {
        return useStart;
    }

    public void setUseStart(Timestamp useStart) {
        this.useStart = useStart;
    }

    public Timestamp getUseEnd() {
        return useEnd;
    }

    public void setUseEnd(Timestamp useEnd) {
        this.useEnd = useEnd;
    }
}
