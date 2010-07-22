/**
 * Author: Bob Chen
 */

package com.jcommerce.core.model;

import java.sql.Timestamp;
import java.util.Date;

public class User extends ModelObject {
    public static final int SEX_UNKNOWN = 0; 
    public static final int SEX_MALE = 1; 
    public static final int SEX_FEMALE = 2; 
    
    private int id;
    private String name;
    private String password;
    private String email;
    private String question;
    private String answer;
    private int sex;
    private Date birthday;
    private double money;
    private double frozenMoney;
    private int payPoints;
    private int rankPoints;
    private UserAddress address;
    private Timestamp registerTime;
    private Timestamp lastLogin;
    private Timestamp lastTime;
    private String lastIP;
    private int visitCount;
    private int rank;   // rank in UserRank table
    /**
     * ç‰¹æ®Šä¼šå‘˜
     */
    private boolean special;
    /**
     * åŠ å¯†ä¸²
     */
    private String salt;
    /**
     * æŽ¨è��äºº
     */
    private User parent;
    private int flag;
    private String alias;
    private String MSN;
    private String QQ;
    private String officePhone;
    private String homePhone;
    private String mobilePhone;
    private boolean validated;
    /**
     * ä¿¡ç”¨é¢�åº¦
     */
    private double creditLine;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(double frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public int getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(int payPoints) {
        this.payPoints = payPoints;
    }

    public int getRankPoints() {
        return rankPoints;
    }

    public void setRankPoints(int rankPoints) {
        this.rankPoints = rankPoints;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getLastTime() {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIP() {
        return lastIP;
    }

    public void setLastIP(String lastIP) {
        this.lastIP = lastIP;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMSN() {
        return MSN;
    }

    public void setMSN(String msn) {
        MSN = msn;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String qq) {
        QQ = qq;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }
}
