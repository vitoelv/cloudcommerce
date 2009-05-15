/**
 * in this file ,almost all code is auto generated.
 * note: methods be changed base on the method auto generated are below:
 * Goods, GoodsType, Category
 *       
 */

package com.jcommerce.ws.agent.impl;

import java.util.*;
import java.sql.Timestamp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.jcommerce.core.model.*;
import com.jcommerce.ws.agent.Adapter;
import com.jcommerce.ws.server.ObjIdList;

public class AdapterImpl implements Adapter {

	private DBAccessImpl dbAccessImpl;

	public AdapterImpl(DBAccessImpl dbAccessImpl) {
		super();
		this.dbAccessImpl = dbAccessImpl;
	}

	/**
	 * private String getImageStr(String file) { // transfer image file to byte
	 * array, then do base64 encoding on this array InputStream in = null;
	 * byte[] data = null; // read byte array of img try { in = new
	 * FileInputStream(file); data = new byte[in.available()]; in.read(data);
	 * in.close(); } catch (IOException e) { e.printStackTrace(); } // do base64
	 * encode to byte array BASE64Encoder encoder = new BASE64Encoder(); //
	 * return string of byte array encoded using base64 return
	 * encoder.encode(data); }
	 * 
	 * 
	 * private boolean generateImage(String imgStr, String file) { // decode
	 * byte array string and create img file if (imgStr == null) return false;
	 * BASE64Decoder decoder = new BASE64Decoder(); try { // do Base64 decoding
	 * byte[] b = decoder.decodeBuffer(imgStr); for (int i = 0; i < b.length;
	 * ++i) { if (b[i] < 0) { // adjust abnormal data b[i] += 256; } }
	 * 
	 * String imgFilePath = file; OutputStream out = new
	 * FileOutputStream(imgFilePath); out.write(b); out.flush(); out.close();
	 * return true; } catch (Exception e) { return false; } }
	 * 
	 * 
	 * private String createImageFileFromSOAP(com.jcommerce.ws.server.UploadFile
	 * uploadFile) { String ret = null; if (uploadFile == null) { return ret; }
	 * else { String type = uploadFile.getContentType().getValue(); String
	 * imgStr = uploadFile.getContent(); if
	 * (type.equals(com.jcommerce.ws.server.UploadFileType.JPG.getValue())) { //
	 * TODO Random random = new Random(); String fileName = new Date().getTime() +
	 * random.nextInt(1000) + ""; String filePath = "./image/" + fileName +
	 * ".jpg"; if (generateImage(imgStr, filePath)) { ret = filePath; } } }
	 * return ret; }
	 * 
	 * private com.jcommerce.ws.server.UploadFile createImageSOAPFromDB(String
	 * imageFilePath) { if ((imageFilePath == null) ||
	 * (imageFilePath.trim().equals(""))) { return null; }
	 * com.jcommerce.ws.server.UploadFile uploadFile = new
	 * com.jcommerce.ws.server.UploadFile();
	 * uploadFile.setContent(getImageStr(imageFilePath));
	 * uploadFile.setContentType(com.jcommerce.ws.server.UploadFileType.JPG);
	 * return uploadFile; }
	 */

	public com.jcommerce.core.service.Criteria getCoreCriteria(com.jcommerce.ws.server.QueryCondition[] conditions, com.jcommerce.ws.server.QueryOrder[] orders) {
		if (((conditions == null) || (conditions.length == 0)) && ((orders == null) || (orders.length == 0))) {
			return null;
		}
		com.jcommerce.core.service.Criteria ret = new com.jcommerce.core.service.Criteria();
		if (conditions != null) {
			for (int i = 0; i < conditions.length; i++) {
				com.jcommerce.core.service.Condition coreCondition = new com.jcommerce.core.service.Condition();
				coreCondition.setField(conditions[i].getField());
				coreCondition.setValue(conditions[i].getValue());
				coreCondition.setOperator(conditions[i].getOperator().getValue());
				ret.addCondition(coreCondition);
			}
		}
		if (orders != null) {
			for (int i = 0; i < orders.length; i++) {
				com.jcommerce.core.service.Order coreOrder = new com.jcommerce.core.service.Order();
				coreOrder.setField(orders[i].getField());
				coreOrder.setAscend(orders[i].getAscend());
				ret.addOrder(coreOrder);
			}
		}

		return ret;
	}

	public com.jcommerce.core.service.Criteria createDefaultCriteria() {
		com.jcommerce.core.service.Criteria ret = new com.jcommerce.core.service.Criteria();
		com.jcommerce.core.service.Order coreOrder = new com.jcommerce.core.service.Order();
		coreOrder.setField("id");
		coreOrder.setAscend(true);
		ret.addOrder(coreOrder);
		return ret;
	}

	public com.jcommerce.core.model.AccountLog getCoreAccountLog(com.jcommerce.ws.server.AccountLog input) {
		com.jcommerce.core.model.AccountLog ret = new com.jcommerce.core.model.AccountLog();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		if ((String.valueOf(input.getUserMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getUserMoney()).indexOf("Inf") < 0)) {
			ret.setUserMoney(input.getUserMoney());
		}

		if ((String.valueOf(input.getFrozenMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getFrozenMoney()).indexOf("Inf") < 0)) {
			ret.setFrozenMoney(input.getFrozenMoney());
		}

		ret.setRankPoints(input.getRankPoints());
		ret.setPayPoints(input.getPayPoints());
		if (input.getChangeTime() != null) {
			ret.setChangeTime(new Timestamp(input.getChangeTime().getTime()));
		}

		ret.setChangeDescription(input.getChangeDescription());
		ret.setChangeType(input.getChangeType());
		return ret;
	}

	public com.jcommerce.ws.server.AccountLog getWSDLAccountLog(com.jcommerce.core.model.AccountLog input) {
		com.jcommerce.ws.server.AccountLog ret = new com.jcommerce.ws.server.AccountLog();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setUserMoney(input.getUserMoney());
		ret.setFrozenMoney(input.getFrozenMoney());
		ret.setRankPoints(input.getRankPoints());
		ret.setPayPoints(input.getPayPoints());
		ret.setChangeTime(input.getChangeTime());
		ret.setChangeDescription(input.getChangeDescription());
		ret.setChangeType(input.getChangeType());
		return ret;
	}

	public com.jcommerce.core.model.AccountLog[] getCoreAccountLogList(com.jcommerce.ws.server.AccountLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AccountLog[] retList = new com.jcommerce.core.model.AccountLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAccountLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AccountLog[] getWSDLAccountLogList(com.jcommerce.core.model.AccountLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AccountLog[] retList = new com.jcommerce.ws.server.AccountLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAccountLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AdminAction getCoreAdminAction(com.jcommerce.ws.server.AdminAction input) {
		com.jcommerce.core.model.AdminAction ret = new com.jcommerce.core.model.AdminAction();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setParent((com.jcommerce.core.model.AdminAction) (dbAccessImpl.getBean0("AdminAction", String.valueOf(input.getParent()))));
		return ret;
	}

	public com.jcommerce.ws.server.AdminAction getWSDLAdminAction(com.jcommerce.core.model.AdminAction input) {
		com.jcommerce.ws.server.AdminAction ret = new com.jcommerce.ws.server.AdminAction();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.AdminAction[] getCoreAdminActionList(com.jcommerce.ws.server.AdminAction[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AdminAction[] retList = new com.jcommerce.core.model.AdminAction[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdminAction(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AdminAction[] getWSDLAdminActionList(com.jcommerce.core.model.AdminAction[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AdminAction[] retList = new com.jcommerce.ws.server.AdminAction[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdminAction(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AdminLog getCoreAdminLog(com.jcommerce.ws.server.AdminLog input) {
		com.jcommerce.core.model.AdminLog ret = new com.jcommerce.core.model.AdminLog();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		if (input.getLogTime() != null) {
			ret.setLogTime(new Timestamp(input.getLogTime().getTime()));
		}
		ret.setLogInfo(input.getLogInfo());
		ret.setIP(input.getIP());
		return ret;
	}

	public com.jcommerce.ws.server.AdminLog getWSDLAdminLog(com.jcommerce.core.model.AdminLog input) {
		com.jcommerce.ws.server.AdminLog ret = new com.jcommerce.ws.server.AdminLog();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setLogTime(input.getLogTime());
		ret.setLogInfo(input.getLogInfo());
		ret.setIP(input.getIP());
		return ret;
	}

	public com.jcommerce.core.model.AdminLog[] getCoreAdminLogList(com.jcommerce.ws.server.AdminLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AdminLog[] retList = new com.jcommerce.core.model.AdminLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdminLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AdminLog[] getWSDLAdminLogList(com.jcommerce.core.model.AdminLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AdminLog[] retList = new com.jcommerce.ws.server.AdminLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdminLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AdminMessage getCoreAdminMessage(com.jcommerce.ws.server.AdminMessage input) {
		com.jcommerce.core.model.AdminMessage ret = new com.jcommerce.core.model.AdminMessage();
		ret.setId(input.getId());
		ret.setSenderID(input.getSenderID());
		ret.setReceiverID(input.getReceiverID());
		if (input.getSentTime() != null) {
			ret.setSentTime(new Timestamp(input.getSentTime().getTime()));
		}
		if (input.getReadTime() != null) {
			ret.setReadTime(new Timestamp(input.getReadTime().getTime()));
		}
		ret.setReaded(input.getReaded());
		ret.setDeleted(input.getDeleted());
		ret.setMessage(input.getMessage());
		ret.setTitle(input.getTitle());
		return ret;
	}

	public com.jcommerce.ws.server.AdminMessage getWSDLAdminMessage(com.jcommerce.core.model.AdminMessage input) {
		com.jcommerce.ws.server.AdminMessage ret = new com.jcommerce.ws.server.AdminMessage();
		ret.setId(input.getId());
		ret.setSenderID(input.getSenderID());
		ret.setReceiverID(input.getReceiverID());
		ret.setSentTime(input.getSentTime());
		ret.setReadTime(input.getReadTime());
		ret.setReaded(input.isReaded());
		ret.setDeleted(input.isDeleted());
		ret.setMessage(input.getMessage());
		ret.setTitle(input.getTitle());
		return ret;
	}

	public com.jcommerce.core.model.AdminMessage[] getCoreAdminMessageList(com.jcommerce.ws.server.AdminMessage[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AdminMessage[] retList = new com.jcommerce.core.model.AdminMessage[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdminMessage(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AdminMessage[] getWSDLAdminMessageList(com.jcommerce.core.model.AdminMessage[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AdminMessage[] retList = new com.jcommerce.ws.server.AdminMessage[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdminMessage(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AdminUser getCoreAdminUser(com.jcommerce.ws.server.AdminUser input) {
		com.jcommerce.core.model.AdminUser ret = new com.jcommerce.core.model.AdminUser();
		ret.setId(input.getId());
		ret.setPassword(input.getPassword());
		ret.setEmail(input.getEmail());
		if (input.getLastLogin() != null) {
			ret.setLastLogin(new Timestamp(input.getLastLogin().getTime()));
		}
		ret.setLastIP(input.getLastIP());
		if (input.getAddTime() != null) {
			ret.setAddTime(new Timestamp(input.getAddTime().getTime()));
		}
		ret.setActionList(input.getActionList());
		ret.setNavigatorList(input.getNavigatorList());
		ret.setLanguageType(input.getLanguageType());
		ret.setTodolist(input.getTodolist());
		ret.setAgency((com.jcommerce.core.model.Agency) (dbAccessImpl.getBean0("Agency", String.valueOf(input.getAgency()))));
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.ws.server.AdminUser getWSDLAdminUser(com.jcommerce.core.model.AdminUser input) {
		com.jcommerce.ws.server.AdminUser ret = new com.jcommerce.ws.server.AdminUser();
		ret.setId(input.getId());
		ret.setPassword(input.getPassword());
		ret.setEmail(input.getEmail());
		ret.setLastLogin(input.getLastLogin());
		ret.setLastIP(input.getLastIP());
		ret.setAddTime(input.getAddTime());
		ret.setActionList(input.getActionList());
		ret.setNavigatorList(input.getNavigatorList());
		ret.setLanguageType(input.getLanguageType());
		ret.setTodolist(input.getTodolist());
		if (input.getAgency() != null) {
			ret.setAgency(input.getAgency().getId());
		}
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.core.model.AdminUser[] getCoreAdminUserList(com.jcommerce.ws.server.AdminUser[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AdminUser[] retList = new com.jcommerce.core.model.AdminUser[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdminUser(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AdminUser[] getWSDLAdminUserList(com.jcommerce.core.model.AdminUser[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AdminUser[] retList = new com.jcommerce.ws.server.AdminUser[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdminUser(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AdPosition getCoreAdPosition(com.jcommerce.ws.server.AdPosition input) {
		com.jcommerce.core.model.AdPosition ret = new com.jcommerce.core.model.AdPosition();
		ret.setId(input.getId());
		ret.setPositionName(input.getPositionName());
		ret.setAdWidth(input.getAdWidth());
		ret.setAdHeight(input.getAdHeight());
		ret.setPositionStyle(input.getPositionStyle());
		return ret;
	}

	public com.jcommerce.ws.server.AdPosition getWSDLAdPosition(com.jcommerce.core.model.AdPosition input) {
		com.jcommerce.ws.server.AdPosition ret = new com.jcommerce.ws.server.AdPosition();
		ret.setId(input.getId());
		ret.setPositionName(input.getPositionName());
		ret.setAdWidth(input.getAdWidth());
		ret.setAdHeight(input.getAdHeight());
		ret.setPositionStyle(input.getPositionStyle());
		return ret;
	}

	public com.jcommerce.core.model.AdPosition[] getCoreAdPositionList(com.jcommerce.ws.server.AdPosition[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AdPosition[] retList = new com.jcommerce.core.model.AdPosition[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdPosition(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AdPosition[] getWSDLAdPositionList(com.jcommerce.core.model.AdPosition[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AdPosition[] retList = new com.jcommerce.ws.server.AdPosition[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdPosition(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Adsense getCoreAdsense(com.jcommerce.ws.server.Adsense input) {
		com.jcommerce.core.model.Adsense ret = new com.jcommerce.core.model.Adsense();
		ret.setId(input.getId());
		ret.setAdvertisement((com.jcommerce.core.model.Advertisement) (dbAccessImpl.getBean0("Advertisement", String.valueOf(input.getAdvertisement()))));
		ret.setReferer(input.getReferer());
		ret.setClicks(input.getClicks());
		return ret;
	}

	public com.jcommerce.ws.server.Adsense getWSDLAdsense(com.jcommerce.core.model.Adsense input) {
		com.jcommerce.ws.server.Adsense ret = new com.jcommerce.ws.server.Adsense();
		ret.setId(input.getId());
		if (input.getAdvertisement() != null) {
			ret.setAdvertisement(input.getAdvertisement().getId());
		}
		ret.setReferer(input.getReferer());
		ret.setClicks(input.getClicks());
		return ret;
	}

	public com.jcommerce.core.model.Adsense[] getCoreAdsenseList(com.jcommerce.ws.server.Adsense[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Adsense[] retList = new com.jcommerce.core.model.Adsense[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdsense(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Adsense[] getWSDLAdsenseList(com.jcommerce.core.model.Adsense[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Adsense[] retList = new com.jcommerce.ws.server.Adsense[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdsense(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Advertisement getCoreAdvertisement(com.jcommerce.ws.server.Advertisement input) {
		com.jcommerce.core.model.Advertisement ret = new com.jcommerce.core.model.Advertisement();
		ret.setId(input.getId());
		ret.setAdPosition((com.jcommerce.core.model.AdPosition) (dbAccessImpl.getBean0("AdPosition", String.valueOf(input.getAdPosition()))));
		ret.setMediaType(input.getMediaType());
		ret.setAdName(input.getAdName());
		ret.setAdLink(input.getAdLink());
		ret.setAdCode(input.getAdCode());
		if (input.getEndTime() != null) {
			ret.setEndTime(new Timestamp(input.getEndTime().getTime()));
		}
		ret.setLinkMan(input.getLinkMan());
		ret.setLinkEmail(input.getLinkEmail());
		ret.setLinkPhone(input.getLinkPhone());
		ret.setClickCount(input.getClickCount());
		ret.setEnabled(input.getEnabled());
		if (input.getStartTime() != null) {
			ret.setStartTime(new Timestamp(input.getStartTime().getTime()));
		}
		return ret;
	}

	public com.jcommerce.ws.server.Advertisement getWSDLAdvertisement(com.jcommerce.core.model.Advertisement input) {
		com.jcommerce.ws.server.Advertisement ret = new com.jcommerce.ws.server.Advertisement();
		ret.setId(input.getId());
		if (input.getAdPosition() != null) {
			ret.setAdPosition(input.getAdPosition().getId());
		}
		ret.setMediaType(input.getMediaType());
		ret.setAdName(input.getAdName());
		ret.setAdLink(input.getAdLink());
		ret.setAdCode(input.getAdCode());
		ret.setEndTime(input.getEndTime());
		ret.setLinkMan(input.getLinkMan());
		ret.setLinkEmail(input.getLinkEmail());
		ret.setLinkPhone(input.getLinkPhone());
		ret.setClickCount(input.getClickCount());
		ret.setEnabled(input.isEnabled());
		ret.setStartTime(input.getStartTime());
		return ret;
	}

	public com.jcommerce.core.model.Advertisement[] getCoreAdvertisementList(com.jcommerce.ws.server.Advertisement[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Advertisement[] retList = new com.jcommerce.core.model.Advertisement[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAdvertisement(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Advertisement[] getWSDLAdvertisementList(com.jcommerce.core.model.Advertisement[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Advertisement[] retList = new com.jcommerce.ws.server.Advertisement[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAdvertisement(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AffiliateLog getCoreAffiliateLog(com.jcommerce.ws.server.AffiliateLog input) {
		com.jcommerce.core.model.AffiliateLog ret = new com.jcommerce.core.model.AffiliateLog();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		if ((String.valueOf(input.getMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getMoney()).indexOf("Inf") < 0)) {
			ret.setMoney(input.getMoney());
		}

		ret.setOrder((com.jcommerce.core.model.Order) (dbAccessImpl.getBean0("Order", String.valueOf(input.getOrder()))));
		ret.setPoints(input.getPoints());
		ret.setSeparateType(input.getSeparateType());
		if (input.getTime() != null) {
			ret.setTime(new Timestamp(input.getTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.AffiliateLog getWSDLAffiliateLog(com.jcommerce.core.model.AffiliateLog input) {
		com.jcommerce.ws.server.AffiliateLog ret = new com.jcommerce.ws.server.AffiliateLog();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setMoney(input.getMoney());
		if (input.getOrder() != null) {
			ret.setOrder(input.getOrder().getId());
		}
		ret.setPoints(input.getPoints());
		ret.setSeparateType(input.getSeparateType());
		ret.setTime(input.getTime());
		return ret;
	}

	public com.jcommerce.core.model.AffiliateLog[] getCoreAffiliateLogList(com.jcommerce.ws.server.AffiliateLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AffiliateLog[] retList = new com.jcommerce.core.model.AffiliateLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAffiliateLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AffiliateLog[] getWSDLAffiliateLogList(com.jcommerce.core.model.AffiliateLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AffiliateLog[] retList = new com.jcommerce.ws.server.AffiliateLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAffiliateLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Agency getCoreAgency(com.jcommerce.ws.server.Agency input) {
		com.jcommerce.core.model.Agency ret = new com.jcommerce.core.model.Agency();
		ret.setId(input.getId());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.ws.server.Agency getWSDLAgency(com.jcommerce.core.model.Agency input) {
		com.jcommerce.ws.server.Agency ret = new com.jcommerce.ws.server.Agency();
		ret.setId(input.getId());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.core.model.Agency[] getCoreAgencyList(com.jcommerce.ws.server.Agency[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Agency[] retList = new com.jcommerce.core.model.Agency[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAgency(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Agency[] getWSDLAgencyList(com.jcommerce.core.model.Agency[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Agency[] retList = new com.jcommerce.ws.server.Agency[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAgency(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Article getCoreArticle(com.jcommerce.ws.server.Article input) {
		com.jcommerce.core.model.Article ret = new com.jcommerce.core.model.Article();
		ret.setId(input.getId());
		if (input.getAddTime() != null) {
			ret.setAddTime(new Timestamp(input.getAddTime().getTime()));
		}
		ret.setArticleCategory((com.jcommerce.core.model.ArticleCategory) (dbAccessImpl.getBean0("ArticleCategory", String.valueOf(input.getArticleCategory()))));
		ret.setContent(input.getContent());
		ret.setAuthor(input.getAuthor());
		ret.setAuthorEmail(input.getAuthorEmail());
		ret.setKeywords(input.getKeywords());
		ret.setArticleType(input.getArticleType());
		ret.setOpen(input.getOpen());
		ret.setFileURL(input.getFileURL());
		ret.setOpenType(input.getOpenType());
		ret.setLink(input.getLink());
		ret.setTitle(input.getTitle());
		return ret;
	}

	public com.jcommerce.ws.server.Article getWSDLArticle(com.jcommerce.core.model.Article input) {
		com.jcommerce.ws.server.Article ret = new com.jcommerce.ws.server.Article();
		ret.setId(input.getId());
		ret.setAddTime(input.getAddTime());
		if (input.getArticleCategory() != null) {
			ret.setArticleCategory(input.getArticleCategory().getId());
		}
		ret.setContent(input.getContent());
		ret.setAuthor(input.getAuthor());
		ret.setAuthorEmail(input.getAuthorEmail());
		ret.setKeywords(input.getKeywords());
		ret.setArticleType(input.getArticleType());
		ret.setOpen(input.isOpen());
		ret.setFileURL(input.getFileURL());
		ret.setOpenType(input.getOpenType());
		ret.setLink(input.getLink());
		ret.setTitle(input.getTitle());
		return ret;
	}

	public com.jcommerce.core.model.Article[] getCoreArticleList(com.jcommerce.ws.server.Article[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Article[] retList = new com.jcommerce.core.model.Article[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreArticle(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Article[] getWSDLArticleList(com.jcommerce.core.model.Article[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Article[] retList = new com.jcommerce.ws.server.Article[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLArticle(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.ArticleCategory getCoreArticleCategory(com.jcommerce.ws.server.ArticleCategory input) {
		com.jcommerce.core.model.ArticleCategory ret = new com.jcommerce.core.model.ArticleCategory();
		ret.setId(input.getId());
		ret.setKeywords(input.getKeywords());
		ret.setSortOrder(input.getSortOrder());
		ret.setShowInNavigator(input.getShowInNavigator());
		int[] articlecategoryList = input.getChildren();
		if (articlecategoryList != null) {
			Set<ArticleCategory> articlecategorys = new HashSet<ArticleCategory>();
			for (int i = 0; i < articlecategoryList.length; i++) {
				com.jcommerce.core.model.ArticleCategory articlecategory = new com.jcommerce.core.model.ArticleCategory();
				articlecategory = (com.jcommerce.core.model.ArticleCategory) dbAccessImpl.getBean0("ArticleCategory", String.valueOf(articlecategoryList[i]));
				articlecategorys.add(articlecategory);
			}
			ret.setChildren(articlecategorys);
		}

		ret.setName(input.getName());
		ret.setParent((com.jcommerce.core.model.ArticleCategory) (dbAccessImpl.getBean0("ArticleCategory", String.valueOf(input.getParent()))));
		ret.setDescription(input.getDescription());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.ArticleCategory getWSDLArticleCategory(com.jcommerce.core.model.ArticleCategory input) {
		com.jcommerce.ws.server.ArticleCategory ret = new com.jcommerce.ws.server.ArticleCategory();
		ret.setId(input.getId());
		ret.setKeywords(input.getKeywords());
		ret.setSortOrder(input.getSortOrder());
		ret.setShowInNavigator(input.isShowInNavigator());
		Set articlecategoryList = input.getChildren();
		if (articlecategoryList != null) {
			int[] articlecategorys = new int[articlecategoryList.size()];
			int articlecategoryCounter = 0;
			Iterator articlecategoryItor = articlecategoryList.iterator();
			while (articlecategoryItor.hasNext()) {
				ArticleCategory articlecategory = (ArticleCategory) articlecategoryItor.next();
				articlecategorys[articlecategoryCounter++] = articlecategory.getId();
			}
			ret.setChildren(articlecategorys);
		}
		ret.setName(input.getName());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setDescription(input.getDescription());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.ArticleCategory[] getCoreArticleCategoryList(com.jcommerce.ws.server.ArticleCategory[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.ArticleCategory[] retList = new com.jcommerce.core.model.ArticleCategory[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreArticleCategory(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.ArticleCategory[] getWSDLArticleCategoryList(com.jcommerce.core.model.ArticleCategory[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.ArticleCategory[] retList = new com.jcommerce.ws.server.ArticleCategory[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLArticleCategory(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Attribute getCoreAttribute(com.jcommerce.ws.server.Attribute input) {
		com.jcommerce.core.model.Attribute ret = new com.jcommerce.core.model.Attribute();
		ret.setId(input.getId());
		ret.setSortOrder(input.getSortOrder());
		ret.setGoodsType((com.jcommerce.core.model.GoodsType) (dbAccessImpl.getBean0("GoodsType", String.valueOf(input.getGoodsType()))));
		ret.setInputType(input.getInputType());
		ret.setLinked(input.getLinked());
		ret.setName(input.getName());
		ret.setIndex(input.getIndex());
		ret.setGroup(input.getGroup());
		ret.setValues(input.getValues());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.Attribute getWSDLAttribute(com.jcommerce.core.model.Attribute input) {
		com.jcommerce.ws.server.Attribute ret = new com.jcommerce.ws.server.Attribute();
		ret.setId(input.getId());
		ret.setSortOrder(input.getSortOrder());
		if (input.getGoodsType() != null) {
			ret.setGoodsType(input.getGoodsType().getId());
		}
		ret.setInputType(input.getInputType());
		ret.setLinked(input.isLinked());
		ret.setName(input.getName());
		ret.setIndex(input.getIndex());
		ret.setGroup(input.getGroup());
		ret.setValues(input.getValues());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.Attribute[] getCoreAttributeList(com.jcommerce.ws.server.Attribute[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Attribute[] retList = new com.jcommerce.core.model.Attribute[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAttribute(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Attribute[] getWSDLAttributeList(com.jcommerce.core.model.Attribute[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Attribute[] retList = new com.jcommerce.ws.server.Attribute[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAttribute(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AuctionLog getCoreAuctionLog(com.jcommerce.ws.server.AuctionLog input) {
		com.jcommerce.core.model.AuctionLog ret = new com.jcommerce.core.model.AuctionLog();
		ret.setId(input.getId());
		ret.setActId(input.getActId());
		ret.setBidUser(input.getBidUser());
		if ((String.valueOf(input.getBidPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getBidPrice()).indexOf("Inf") < 0)) {
			ret.setBidPrice(input.getBidPrice());
		}

		if (input.getBidTime() != null) {
			ret.setBidTime(new Timestamp(input.getBidTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.AuctionLog getWSDLAuctionLog(com.jcommerce.core.model.AuctionLog input) {
		com.jcommerce.ws.server.AuctionLog ret = new com.jcommerce.ws.server.AuctionLog();
		ret.setId(input.getId());
		ret.setActId(input.getActId());
		ret.setBidUser(input.getBidUser());
		ret.setBidPrice(input.getBidPrice());
		ret.setBidTime(input.getBidTime());
		return ret;
	}

	public com.jcommerce.core.model.AuctionLog[] getCoreAuctionLogList(com.jcommerce.ws.server.AuctionLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AuctionLog[] retList = new com.jcommerce.core.model.AuctionLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAuctionLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AuctionLog[] getWSDLAuctionLogList(com.jcommerce.core.model.AuctionLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AuctionLog[] retList = new com.jcommerce.ws.server.AuctionLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAuctionLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.AutoManage getCoreAutoManage(com.jcommerce.ws.server.AutoManage input) {
		com.jcommerce.core.model.AutoManage ret = new com.jcommerce.core.model.AutoManage();
		ret.setId(input.getId());
		if (input.getEndTime() != null) {
			ret.setEndTime(new Timestamp(input.getEndTime().getTime()));
		}

		if (input.getStartTime() != null) {
			ret.setStartTime(new Timestamp(input.getStartTime().getTime()));
		}

		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.AutoManage getWSDLAutoManage(com.jcommerce.core.model.AutoManage input) {
		com.jcommerce.ws.server.AutoManage ret = new com.jcommerce.ws.server.AutoManage();
		ret.setId(input.getId());
		ret.setEndTime(input.getEndTime());
		ret.setStartTime(input.getStartTime());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.AutoManage[] getCoreAutoManageList(com.jcommerce.ws.server.AutoManage[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.AutoManage[] retList = new com.jcommerce.core.model.AutoManage[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreAutoManage(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.AutoManage[] getWSDLAutoManageList(com.jcommerce.core.model.AutoManage[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.AutoManage[] retList = new com.jcommerce.ws.server.AutoManage[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLAutoManage(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.BonusType getCoreBonusType(com.jcommerce.ws.server.BonusType input) {
		com.jcommerce.core.model.BonusType ret = new com.jcommerce.core.model.BonusType();
		ret.setId(input.getId());
		if ((String.valueOf(input.getMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getMoney()).indexOf("Inf") < 0)) {
			ret.setMoney(input.getMoney());
		}

		if ((String.valueOf(input.getMinAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getMinAmount()).indexOf("Inf") < 0)) {
			ret.setMinAmount(input.getMinAmount());
		}

		if ((String.valueOf(input.getMaxAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getMaxAmount()).indexOf("Inf") < 0)) {
			ret.setMaxAmount(input.getMaxAmount());
		}

		ret.setSendType(input.getSendType());
		if ((String.valueOf(input.getMinGoodsAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getMinGoodsAmount()).indexOf("Inf") < 0)) {
			ret.setMinGoodsAmount(input.getMinGoodsAmount());
		}

		if (input.getSendStart() != null) {
			ret.setSendStart(new Timestamp(input.getSendStart().getTime()));
		}

		if (input.getSendEnd() != null) {
			ret.setSendEnd(new Timestamp(input.getSendEnd().getTime()));
		}

		if (input.getUseStart() != null) {
			ret.setUseStart(new Timestamp(input.getUseStart().getTime()));
		}

		if (input.getUseEnd() != null) {
			ret.setUseEnd(new Timestamp(input.getUseEnd().getTime()));
		}

		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.ws.server.BonusType getWSDLBonusType(com.jcommerce.core.model.BonusType input) {
		com.jcommerce.ws.server.BonusType ret = new com.jcommerce.ws.server.BonusType();
		ret.setId(input.getId());
		ret.setMoney(input.getMoney());
		ret.setMinAmount(input.getMinAmount());
		ret.setMaxAmount(input.getMaxAmount());
		ret.setSendType(input.getSendType());
		ret.setMinGoodsAmount(input.getMinGoodsAmount());
		ret.setSendStart(input.getSendStart());
		ret.setSendEnd(input.getSendEnd());
		ret.setUseStart(input.getUseStart());
		ret.setUseEnd(input.getUseEnd());
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.core.model.BonusType[] getCoreBonusTypeList(com.jcommerce.ws.server.BonusType[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.BonusType[] retList = new com.jcommerce.core.model.BonusType[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreBonusType(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.BonusType[] getWSDLBonusTypeList(com.jcommerce.core.model.BonusType[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.BonusType[] retList = new com.jcommerce.ws.server.BonusType[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLBonusType(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.BookingGoods getCoreBookingGoods(com.jcommerce.ws.server.BookingGoods input) {
		com.jcommerce.core.model.BookingGoods ret = new com.jcommerce.core.model.BookingGoods();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setEmail(input.getEmail());
		ret.setPhone(input.getPhone());
		ret.setLinker(input.getLinker());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setGoodsDescription(input.getGoodsDescription());
		ret.setGoodsNumber(input.getGoodsNumber());
		ret.setDisposed(input.getDisposed());
		ret.setDisposeUser(input.getDisposeUser());
		if (input.getDisposeTime() != null) {
			ret.setDisposeTime(new Timestamp(input.getDisposeTime().getTime()));
		}

		ret.setDisposeNote(input.getDisposeNote());
		if (input.getTime() != null) {
			ret.setTime(new Timestamp(input.getTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.BookingGoods getWSDLBookingGoods(com.jcommerce.core.model.BookingGoods input) {
		com.jcommerce.ws.server.BookingGoods ret = new com.jcommerce.ws.server.BookingGoods();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setEmail(input.getEmail());
		ret.setPhone(input.getPhone());
		ret.setLinker(input.getLinker());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setGoodsDescription(input.getGoodsDescription());
		ret.setGoodsNumber(input.getGoodsNumber());
		ret.setDisposed(input.isDisposed());
		ret.setDisposeUser(input.getDisposeUser());
		ret.setDisposeTime(input.getDisposeTime());
		ret.setDisposeNote(input.getDisposeNote());
		ret.setTime(input.getTime());
		return ret;
	}

	public com.jcommerce.core.model.BookingGoods[] getCoreBookingGoodsList(com.jcommerce.ws.server.BookingGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.BookingGoods[] retList = new com.jcommerce.core.model.BookingGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreBookingGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.BookingGoods[] getWSDLBookingGoodsList(com.jcommerce.core.model.BookingGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.BookingGoods[] retList = new com.jcommerce.ws.server.BookingGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLBookingGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Brand getCoreBrand(com.jcommerce.ws.server.Brand input) {
		com.jcommerce.core.model.Brand ret = new com.jcommerce.core.model.Brand();
		ret.setId(input.getId());
		ret.setSortOrder(input.getSortOrder());
		ret.setLogo(input.getLogo());
		ret.setSiteUrl(input.getSiteUrl());
		ret.setShow(input.getShow());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.ws.server.Brand getWSDLBrand(com.jcommerce.core.model.Brand input) {
		com.jcommerce.ws.server.Brand ret = new com.jcommerce.ws.server.Brand();
		ret.setId(input.getId());
		ret.setSortOrder(input.getSortOrder());
		ret.setLogo(input.getLogo());
		ret.setSiteUrl(input.getSiteUrl());
		ret.setShow(input.isShow());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.core.model.Brand[] getCoreBrandList(com.jcommerce.ws.server.Brand[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Brand[] retList = new com.jcommerce.core.model.Brand[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreBrand(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Brand[] getWSDLBrandList(com.jcommerce.core.model.Brand[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Brand[] retList = new com.jcommerce.ws.server.Brand[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLBrand(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Card getCoreCard(com.jcommerce.ws.server.Card input) {
		com.jcommerce.core.model.Card ret = new com.jcommerce.core.model.Card();
		ret.setId(input.getId());
		if ((String.valueOf(input.getFee()).indexOf("NaN") < 0) && (String.valueOf(input.getFee()).indexOf("Inf") < 0)) {
			ret.setFee(input.getFee());
		}

		if ((String.valueOf(input.getFreeMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getFreeMoney()).indexOf("Inf") < 0)) {
			ret.setFreeMoney(input.getFreeMoney());
		}

		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		ret.setImage(input.getImage());
		return ret;
	}

	public com.jcommerce.ws.server.Card getWSDLCard(com.jcommerce.core.model.Card input) {
		com.jcommerce.ws.server.Card ret = new com.jcommerce.ws.server.Card();
		ret.setId(input.getId());
		ret.setFee(input.getFee());
		ret.setFreeMoney(input.getFreeMoney());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		ret.setImage(input.getImage());
		return ret;
	}

	public com.jcommerce.core.model.Card[] getCoreCardList(com.jcommerce.ws.server.Card[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Card[] retList = new com.jcommerce.core.model.Card[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreCard(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Card[] getWSDLCardList(com.jcommerce.core.model.Card[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Card[] retList = new com.jcommerce.ws.server.Card[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLCard(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Cart getCoreCart(com.jcommerce.ws.server.Cart input) {
		com.jcommerce.core.model.Cart ret = new com.jcommerce.core.model.Cart();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setExtensionCode(input.getExtensionCode());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setGoodsNumber(input.getGoodsNumber());
		if ((String.valueOf(input.getMarketPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getMarketPrice()).indexOf("Inf") < 0)) {
			ret.setMarketPrice(input.getMarketPrice());
		}

		ret.setRealGoods(input.getRealGoods());
		ret.setSession((com.jcommerce.core.model.Session) (dbAccessImpl.getBean0("Session", String.valueOf(input.getSession()))));
		ret.setGoodsSN(input.getGoodsSN());
		ret.setGoodsName(input.getGoodsName());
		if ((String.valueOf(input.getGoodsPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getGoodsPrice()).indexOf("Inf") < 0)) {
			ret.setGoodsPrice(input.getGoodsPrice());
		}

		ret.setGift(input.getGift());
		ret.setHandSelectable(input.getHandSelectable());
		ret.setGoodsAttribute((com.jcommerce.core.model.GoodsAttribute) (dbAccessImpl.getBean0("GoodsAttribute", String.valueOf(input.getGoodsAttribute()))));
		ret.setParent((com.jcommerce.core.model.Cart) (dbAccessImpl.getBean0("Cart", String.valueOf(input.getParent()))));
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.Cart getWSDLCart(com.jcommerce.core.model.Cart input) {
		com.jcommerce.ws.server.Cart ret = new com.jcommerce.ws.server.Cart();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setExtensionCode(input.getExtensionCode());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setGoodsNumber(input.getGoodsNumber());
		ret.setMarketPrice(input.getMarketPrice());
		ret.setRealGoods(input.isRealGoods());
		if (input.getSession() != null) {
			try {
				ret.setSession(Integer.parseInt(input.getSession().getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ret.setGoodsSN(input.getGoodsSN());
		ret.setGoodsName(input.getGoodsName());
		ret.setGoodsPrice(input.getGoodsPrice());
		ret.setGift(input.isGift());
		ret.setHandSelectable(input.isHandSelectable());
		if (input.getGoodsAttribute() != null) {
			ret.setGoodsAttribute(input.getGoodsAttribute().getId());
		}
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.Cart[] getCoreCartList(com.jcommerce.ws.server.Cart[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Cart[] retList = new com.jcommerce.core.model.Cart[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreCart(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Cart[] getWSDLCartList(com.jcommerce.core.model.Cart[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Cart[] retList = new com.jcommerce.ws.server.Cart[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLCart(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Category getCoreCategory(com.jcommerce.ws.server.Category input) {
		com.jcommerce.core.model.Category ret = new com.jcommerce.core.model.Category();
		ret.setId(input.getId());
		ret.setKeywords(input.getKeywords());
		ret.setSortOrder(input.getSortOrder());
		ret.setShowInNavigator(input.getShowInNavigator());
		if (input.getChildren() != null) {
			int[] categoryList = input.getChildren().getId();
			if (categoryList != null) {
				Set<Category> categorys = new HashSet<Category>();
				for (int i = 0; i < categoryList.length; i++) {
					com.jcommerce.core.model.Category category = new com.jcommerce.core.model.Category();
					category = (com.jcommerce.core.model.Category) dbAccessImpl.getBean0("Category", String.valueOf(categoryList[i]));
					categorys.add(category);
				}
				ret.setChildren(categorys);
			}
		}

		ret.setShow(input.getShow());
		if (input.getGoodsList() != null) {
			int[] goodsList = input.getGoodsList().getId();
			if (goodsList != null) {
				Set<Goods> goodss = new HashSet<Goods>();
				for (int i = 0; i < goodsList.length; i++) {
					com.jcommerce.core.model.Goods goods = new com.jcommerce.core.model.Goods();
					goods = (com.jcommerce.core.model.Goods) dbAccessImpl.getBean0("Goods", String.valueOf(goodsList[i]));
					goodss.add(goods);
				}
				ret.setGoodsList(goodss);
			}
		}

		ret.setTemplateFile(input.getTemplateFile());
		ret.setMeasureUnit(input.getMeasureUnit());
		ret.setGrade(input.getGrade());
		ret.setFilterAttribute((com.jcommerce.core.model.Attribute) (dbAccessImpl.getBean0("Attribute", String.valueOf(input.getFilterAttribute()))));
		ret.setName(input.getName());
		ret.setParent((com.jcommerce.core.model.Category) (dbAccessImpl.getBean0("Category", String.valueOf(input.getParent()))));
		ret.setStyle(input.getStyle());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.ws.server.Category getWSDLCategory(com.jcommerce.core.model.Category input) {
		com.jcommerce.ws.server.Category ret = new com.jcommerce.ws.server.Category();
		ret.setId(input.getId());
		ret.setKeywords(input.getKeywords());
		ret.setSortOrder(input.getSortOrder());
		ret.setShowInNavigator(input.isShowInNavigator());
		Set categoryList = input.getChildren();
		if (categoryList != null) {
			int[] categorys = new int[categoryList.size()];
			int categoryCounter = 0;
			Iterator categoryItor = categoryList.iterator();
			while (categoryItor.hasNext()) {
				Category category = (Category) categoryItor.next();
				categorys[categoryCounter++] = category.getId();
			}
			ObjIdList objIdList = new ObjIdList();
			objIdList.setId(categorys);
			ret.setChildren(objIdList);
		}
		ret.setShow(input.isShow());
		Set goodsList = input.getGoodsList();
		if (goodsList != null) {
			int[] goodss = new int[goodsList.size()];
			int goodsCounter = 0;
			Iterator goodsItor = goodsList.iterator();
			while (goodsItor.hasNext()) {
				Goods goods = (Goods) goodsItor.next();
				goodss[goodsCounter++] = goods.getId();
			}
			ObjIdList objIdList = new ObjIdList();
			objIdList.setId(goodss);
			ret.setGoodsList(objIdList);
		}
		ret.setTemplateFile(input.getTemplateFile());
		ret.setMeasureUnit(input.getMeasureUnit());
		ret.setGrade(input.getGrade());
		if (input.getFilterAttribute() != null) {
			ret.setFilterAttribute(input.getFilterAttribute().getId());
		}
		ret.setName(input.getName());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		} else {
			ret.setParent(0);
		}
		ret.setStyle(input.getStyle());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.core.model.Category[] getCoreCategoryList(com.jcommerce.ws.server.Category[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Category[] retList = new com.jcommerce.core.model.Category[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreCategory(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Category[] getWSDLCategoryList(com.jcommerce.core.model.Category[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Category[] retList = new com.jcommerce.ws.server.Category[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLCategory(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.CollectGoods getCoreCollectGoods(com.jcommerce.ws.server.CollectGoods input) {
		com.jcommerce.core.model.CollectGoods ret = new com.jcommerce.core.model.CollectGoods();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		if (input.getAddTime() != null) {
			ret.setAddTime(new Timestamp(input.getAddTime().getTime()));
		}

		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setAttention(input.getAttention());
		return ret;
	}

	public com.jcommerce.ws.server.CollectGoods getWSDLCollectGoods(com.jcommerce.core.model.CollectGoods input) {
		com.jcommerce.ws.server.CollectGoods ret = new com.jcommerce.ws.server.CollectGoods();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setAddTime(input.getAddTime());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setAttention(input.isAttention());
		return ret;
	}

	public com.jcommerce.core.model.CollectGoods[] getCoreCollectGoodsList(com.jcommerce.ws.server.CollectGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.CollectGoods[] retList = new com.jcommerce.core.model.CollectGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreCollectGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.CollectGoods[] getWSDLCollectGoodsList(com.jcommerce.core.model.CollectGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.CollectGoods[] retList = new com.jcommerce.ws.server.CollectGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLCollectGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Comment getCoreComment(com.jcommerce.ws.server.Comment input) {
		com.jcommerce.core.model.Comment ret = new com.jcommerce.core.model.Comment();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setEmail(input.getEmail());
		if (input.getAddTime() != null) {
			ret.setAddTime(new Timestamp(input.getAddTime().getTime()));
		}

		ret.setContent(input.getContent());
		int[] commentList = input.getChildren();
		if (commentList != null) {
			Set<Comment> comments = new HashSet<Comment>();
			for (int i = 0; i < commentList.length; i++) {
				com.jcommerce.core.model.Comment comment = new com.jcommerce.core.model.Comment();
				comment = (com.jcommerce.core.model.Comment) dbAccessImpl.getBean0("Comment", String.valueOf(commentList[i]));
				comments.add(comment);
			}
			ret.setChildren(comments);
		}

//		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setCommentType(input.getCommentType());
		ret.setCommentRank(input.getCommentRank());
		ret.setIpAddress(input.getIpAddress());
		ret.setUserName(input.getUserName());
		ret.setParent((com.jcommerce.core.model.Comment) (dbAccessImpl.getBean0("Comment", String.valueOf(input.getParent()))));
		ret.setStatus(input.getStatus());
		return ret;
	}

	public com.jcommerce.ws.server.Comment getWSDLComment(com.jcommerce.core.model.Comment input) {
		com.jcommerce.ws.server.Comment ret = new com.jcommerce.ws.server.Comment();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setEmail(input.getEmail());
		ret.setAddTime(input.getAddTime());
		ret.setContent(input.getContent());
		Set commentList = input.getChildren();
		if (commentList != null) {
			int[] comments = new int[commentList.size()];
			int commentCounter = 0;
			Iterator commentItor = commentList.iterator();
			while (commentItor.hasNext()) {
				Comment comment = (Comment) commentItor.next();
				comments[commentCounter++] = comment.getId();
			}
			ret.setChildren(comments);
		}
//		if (input.getGoods() != null) {
//			ret.setGoods(input.getGoods().getId());
//		}
		ret.setCommentType(input.getCommentType());
		ret.setCommentRank(input.getCommentRank());
		ret.setIpAddress(input.getIpAddress());
		ret.setUserName(input.getUserName());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setStatus(input.isStatus());
		return ret;
	}

	public com.jcommerce.core.model.Comment[] getCoreCommentList(com.jcommerce.ws.server.Comment[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Comment[] retList = new com.jcommerce.core.model.Comment[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreComment(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Comment[] getWSDLCommentList(com.jcommerce.core.model.Comment[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Comment[] retList = new com.jcommerce.ws.server.Comment[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLComment(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Crons getCoreCrons(com.jcommerce.ws.server.Crons input) {
		com.jcommerce.core.model.Crons ret = new com.jcommerce.core.model.Crons();
		ret.setId(input.getId());
		ret.setCronCode(input.getCronCode());
		ret.setCronName(input.getCronName());
		ret.setCronDesc(input.getCronDesc());
		ret.setCronConfig(input.getCronConfig());
		ret.setCronOrder(input.getCronOrder());
		if (input.getThisTime() != null) {
			ret.setThisTime(new Timestamp(input.getThisTime().getTime()));
		}

		if (input.getNextTime() != null) {
			ret.setNextTime(new Timestamp(input.getNextTime().getTime()));
		}

		ret.setDay(input.getDay());
		ret.setWeek(input.getWeek());
		ret.setHour(input.getHour());
		ret.setEnable(input.getEnable());
		ret.setRunOnce(input.getRunOnce());
		ret.setAllowIp(input.getAllowIp());
		ret.setAllowFiles(input.getAllowFiles());
		ret.setMinutes(input.getMinutes());
		ret.setMinutes(input.getMinutes());
		return ret;
	}

	public com.jcommerce.ws.server.Crons getWSDLCrons(com.jcommerce.core.model.Crons input) {
		com.jcommerce.ws.server.Crons ret = new com.jcommerce.ws.server.Crons();
		ret.setId(input.getId());
		ret.setCronCode(input.getCronCode());
		ret.setCronName(input.getCronName());
		ret.setCronDesc(input.getCronDesc());
		ret.setCronConfig(input.getCronConfig());
		ret.setCronOrder(input.getCronOrder());
		ret.setThisTime(input.getThisTime());
		ret.setNextTime(input.getNextTime());
		ret.setDay(input.getDay());
		ret.setWeek(input.getWeek());
		ret.setHour(input.getHour());
		ret.setEnable(input.isEnable());
		ret.setRunOnce(input.isRunOnce());
		ret.setAllowIp(input.getAllowIp());
		ret.setAllowFiles(input.getAllowFiles());
		ret.setMinutes(input.getMinutes());
		return ret;
	}

	public com.jcommerce.core.model.Crons[] getCoreCronsList(com.jcommerce.ws.server.Crons[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Crons[] retList = new com.jcommerce.core.model.Crons[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreCrons(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Crons[] getWSDLCronsList(com.jcommerce.core.model.Crons[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Crons[] retList = new com.jcommerce.ws.server.Crons[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLCrons(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.EmailList getCoreEmailList(com.jcommerce.ws.server.EmailList input) {
		com.jcommerce.core.model.EmailList ret = new com.jcommerce.core.model.EmailList();
		ret.setId(input.getId());
		ret.setEmail(input.getEmail());
		ret.setConfirm(input.getConfirm());
		ret.setHash(input.getHash());
		return ret;
	}

	public com.jcommerce.ws.server.EmailList getWSDLEmailList(com.jcommerce.core.model.EmailList input) {
		com.jcommerce.ws.server.EmailList ret = new com.jcommerce.ws.server.EmailList();
		ret.setId(input.getId());
		ret.setEmail(input.getEmail());
		ret.setConfirm(input.isConfirm());
		ret.setHash(input.getHash());
		return ret;
	}

	public com.jcommerce.core.model.EmailList[] getCoreEmailListList(com.jcommerce.ws.server.EmailList[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.EmailList[] retList = new com.jcommerce.core.model.EmailList[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreEmailList(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.EmailList[] getWSDLEmailListList(com.jcommerce.core.model.EmailList[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.EmailList[] retList = new com.jcommerce.ws.server.EmailList[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLEmailList(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.EmailSendList getCoreEmailSendList(com.jcommerce.ws.server.EmailSendList input) {
		com.jcommerce.core.model.EmailSendList ret = new com.jcommerce.core.model.EmailSendList();
		ret.setId(input.getId());
		ret.setEmail(input.getEmail());
		ret.setTemplateId(input.getTemplateId());
		ret.setEmailContent(input.getEmailContent());
		if (input.getLastSend() != null) {
			ret.setLastSend(new Timestamp(input.getLastSend().getTime()));
		}

		ret.setPriority(input.getPriority());
		ret.setError(input.getError());
		return ret;
	}

	public com.jcommerce.ws.server.EmailSendList getWSDLEmailSendList(com.jcommerce.core.model.EmailSendList input) {
		com.jcommerce.ws.server.EmailSendList ret = new com.jcommerce.ws.server.EmailSendList();
		ret.setId(input.getId());
		ret.setEmail(input.getEmail());
		ret.setTemplateId(input.getTemplateId());
		ret.setEmailContent(input.getEmailContent());
		ret.setLastSend(input.getLastSend());
		ret.setPriority(input.getPriority());
		ret.setError(input.getError());
		return ret;
	}

	public com.jcommerce.core.model.EmailSendList[] getCoreEmailSendListList(com.jcommerce.ws.server.EmailSendList[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.EmailSendList[] retList = new com.jcommerce.core.model.EmailSendList[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreEmailSendList(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.EmailSendList[] getWSDLEmailSendListList(com.jcommerce.core.model.EmailSendList[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.EmailSendList[] retList = new com.jcommerce.ws.server.EmailSendList[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLEmailSendList(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.ErrorLog getCoreErrorLog(com.jcommerce.ws.server.ErrorLog input) {
		com.jcommerce.core.model.ErrorLog ret = new com.jcommerce.core.model.ErrorLog();
		ret.setId(input.getId());
		ret.setInfo(input.getInfo());
		if (input.getTime() != null) {
			ret.setTime(new Timestamp(input.getTime().getTime()));
		}

		ret.setFile(input.getFile());
		return ret;
	}

	public com.jcommerce.ws.server.ErrorLog getWSDLErrorLog(com.jcommerce.core.model.ErrorLog input) {
		com.jcommerce.ws.server.ErrorLog ret = new com.jcommerce.ws.server.ErrorLog();
		ret.setId(input.getId());
		ret.setInfo(input.getInfo());
		ret.setTime(input.getTime());
		ret.setFile(input.getFile());
		return ret;
	}

	public com.jcommerce.core.model.ErrorLog[] getCoreErrorLogList(com.jcommerce.ws.server.ErrorLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.ErrorLog[] retList = new com.jcommerce.core.model.ErrorLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreErrorLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.ErrorLog[] getWSDLErrorLogList(com.jcommerce.core.model.ErrorLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.ErrorLog[] retList = new com.jcommerce.ws.server.ErrorLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLErrorLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.FailedLogin getCoreFailedLogin(com.jcommerce.ws.server.FailedLogin input) {
		com.jcommerce.core.model.FailedLogin ret = new com.jcommerce.core.model.FailedLogin();
		ret.setId(input.getId());
		if (input.getLastUpdate() != null) {
			ret.setLastUpdate(new Timestamp(input.getLastUpdate().getTime()));
		}

		ret.setCount(input.getCount());
		return ret;
	}

	public com.jcommerce.ws.server.FailedLogin getWSDLFailedLogin(com.jcommerce.core.model.FailedLogin input) {
		com.jcommerce.ws.server.FailedLogin ret = new com.jcommerce.ws.server.FailedLogin();
		ret.setId(input.getId());
		ret.setLastUpdate(input.getLastUpdate());
		ret.setCount(input.getCount());
		return ret;
	}

	public com.jcommerce.core.model.FailedLogin[] getCoreFailedLoginList(com.jcommerce.ws.server.FailedLogin[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.FailedLogin[] retList = new com.jcommerce.core.model.FailedLogin[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreFailedLogin(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.FailedLogin[] getWSDLFailedLoginList(com.jcommerce.core.model.FailedLogin[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.FailedLogin[] retList = new com.jcommerce.ws.server.FailedLogin[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLFailedLogin(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.FavourableActivity getCoreFavourableActivity(com.jcommerce.ws.server.FavourableActivity input) {
		com.jcommerce.core.model.FavourableActivity ret = new com.jcommerce.core.model.FavourableActivity();
		ret.setId(input.getId());
		if (input.getEndTime() != null) {
			ret.setEndTime(new Timestamp(input.getEndTime().getTime()));
		}

		ret.setSortOrder(input.getSortOrder());
		if ((String.valueOf(input.getMinAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getMinAmount()).indexOf("Inf") < 0)) {
			ret.setMinAmount(input.getMinAmount());
		}

		if ((String.valueOf(input.getMaxAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getMaxAmount()).indexOf("Inf") < 0)) {
			ret.setMaxAmount(input.getMaxAmount());
		}

		ret.setGift(input.getGift());
		ret.setActName(input.getActName());
		ret.setUserRank(input.getUserRank());
		ret.setActRange(input.getActRange());
		ret.setActRangeExt(input.getActRangeExt());
		ret.setActType(input.getActType());
		if ((String.valueOf(input.getActTypeExt()).indexOf("NaN") < 0) && (String.valueOf(input.getActTypeExt()).indexOf("Inf") < 0)) {
			ret.setActTypeExt(input.getActTypeExt());
		}

		if (input.getStartTime() != null) {
			ret.setStartTime(new Timestamp(input.getStartTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.FavourableActivity getWSDLFavourableActivity(com.jcommerce.core.model.FavourableActivity input) {
		com.jcommerce.ws.server.FavourableActivity ret = new com.jcommerce.ws.server.FavourableActivity();
		ret.setId(input.getId());
		ret.setEndTime(input.getEndTime());
		ret.setSortOrder(input.getSortOrder());
		ret.setMinAmount(input.getMinAmount());
		ret.setMaxAmount(input.getMaxAmount());
		ret.setGift(input.getGift());
		ret.setActName(input.getActName());
		ret.setUserRank(input.getUserRank());
		ret.setActRange(input.getActRange());
		ret.setActRangeExt(input.getActRangeExt());
		ret.setActType(input.getActType());
		ret.setActTypeExt(input.getActTypeExt());
		ret.setStartTime(input.getStartTime());
		return ret;
	}

	public com.jcommerce.core.model.FavourableActivity[] getCoreFavourableActivityList(com.jcommerce.ws.server.FavourableActivity[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.FavourableActivity[] retList = new com.jcommerce.core.model.FavourableActivity[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreFavourableActivity(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.FavourableActivity[] getWSDLFavourableActivityList(com.jcommerce.core.model.FavourableActivity[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.FavourableActivity[] retList = new com.jcommerce.ws.server.FavourableActivity[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLFavourableActivity(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Feedback getCoreFeedback(com.jcommerce.ws.server.Feedback input) {
		com.jcommerce.core.model.Feedback ret = new com.jcommerce.core.model.Feedback();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		int[] feedbackList = input.getChildren();
		if (feedbackList != null) {
			Set<Feedback> feedbacks = new HashSet<Feedback>();
			for (int i = 0; i < feedbackList.length; i++) {
				com.jcommerce.core.model.Feedback feedback = new com.jcommerce.core.model.Feedback();
				feedback = (com.jcommerce.core.model.Feedback) dbAccessImpl.getBean0("Feedback", String.valueOf(feedbackList[i]));
				feedbacks.add(feedback);
			}
			ret.setChildren(feedbacks);
		}

		ret.setUserName(input.getUserName());
		ret.setUserEmail(input.getUserEmail());
		ret.setMsgTitle(input.getMsgTitle());
		ret.setMsgType(input.getMsgType());
		ret.setMsgContent(input.getMsgContent());
		if (input.getMsgTime() != null) {
			ret.setMsgTime(new Timestamp(input.getMsgTime().getTime()));
		}

		ret.setOrderID(input.getOrderID());
		ret.setParent((com.jcommerce.core.model.Feedback) (dbAccessImpl.getBean0("Feedback", String.valueOf(input.getParent()))));
		return ret;
	}

	public com.jcommerce.ws.server.Feedback getWSDLFeedback(com.jcommerce.core.model.Feedback input) {
		com.jcommerce.ws.server.Feedback ret = new com.jcommerce.ws.server.Feedback();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		Set feedbackList = input.getChildren();
		if (feedbackList != null) {
			int[] feedbacks = new int[feedbackList.size()];
			int feedbackCounter = 0;
			Iterator feedbackItor = feedbackList.iterator();
			while (feedbackItor.hasNext()) {
				Feedback feedback = (Feedback) feedbackItor.next();
				feedbacks[feedbackCounter++] = feedback.getId();
			}
			ret.setChildren(feedbacks);
		}
		ret.setUserName(input.getUserName());
		ret.setUserEmail(input.getUserEmail());
		ret.setMsgTitle(input.getMsgTitle());
		ret.setMsgType(input.getMsgType());
		ret.setMsgContent(input.getMsgContent());
		ret.setMsgTime(input.getMsgTime());
		ret.setOrderID(input.getOrderID());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.Feedback[] getCoreFeedbackList(com.jcommerce.ws.server.Feedback[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Feedback[] retList = new com.jcommerce.core.model.Feedback[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreFeedback(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Feedback[] getWSDLFeedbackList(com.jcommerce.core.model.Feedback[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Feedback[] retList = new com.jcommerce.ws.server.Feedback[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLFeedback(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.FriendLink getCoreFriendLink(com.jcommerce.ws.server.FriendLink input) {
		com.jcommerce.core.model.FriendLink ret = new com.jcommerce.core.model.FriendLink();
		ret.setId(input.getId());
		ret.setLogo(input.getLogo());
		ret.setUrl(input.getUrl());
		ret.setShowOrder(input.getShowOrder());
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.ws.server.FriendLink getWSDLFriendLink(com.jcommerce.core.model.FriendLink input) {
		com.jcommerce.ws.server.FriendLink ret = new com.jcommerce.ws.server.FriendLink();
		ret.setId(input.getId());
		ret.setLogo(input.getLogo());
		ret.setUrl(input.getUrl());
		ret.setShowOrder(input.getShowOrder());
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.core.model.FriendLink[] getCoreFriendLinkList(com.jcommerce.ws.server.FriendLink[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.FriendLink[] retList = new com.jcommerce.core.model.FriendLink[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreFriendLink(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.FriendLink[] getWSDLFriendLinkList(com.jcommerce.core.model.FriendLink[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.FriendLink[] retList = new com.jcommerce.ws.server.FriendLink[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLFriendLink(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Gallery getCoreGallery(com.jcommerce.ws.server.Gallery input) {
		com.jcommerce.core.model.Gallery ret = new com.jcommerce.core.model.Gallery();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setOriginalImage(input.getOriginalImage());
		ret.setImageUrl(input.getImageUrl());
		ret.setThumbUrl(input.getThumbUrl());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.ws.server.Gallery getWSDLGallery(com.jcommerce.core.model.Gallery input) {
		com.jcommerce.ws.server.Gallery ret = new com.jcommerce.ws.server.Gallery();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setOriginalImage(input.getOriginalImage());
		ret.setImageUrl(input.getImageUrl());
		ret.setThumbUrl(input.getThumbUrl());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.core.model.Gallery[] getCoreGalleryList(com.jcommerce.ws.server.Gallery[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Gallery[] retList = new com.jcommerce.core.model.Gallery[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGallery(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Gallery[] getWSDLGalleryList(com.jcommerce.core.model.Gallery[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Gallery[] retList = new com.jcommerce.ws.server.Gallery[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGallery(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Goods getCoreGoods(com.jcommerce.ws.server.Goods input) {
		com.jcommerce.core.model.Goods ret = new com.jcommerce.core.model.Goods();
		ret.setId(input.getId());
		ret.setDeleted(input.getDeleted());
		// record current time
		Date currentDate = new Date();
		ret.setAddTime(new Timestamp(currentDate.getTime()));
		ret.setClickCount(input.getClickCount());
		ret.setSN(input.getSN());
		ret.setIntegral(input.getIntegral());
		ret.setExtensionCode(input.getExtensionCode());
		ret.setKeywords(input.getKeywords());
		ret.setSortOrder(input.getSortOrder());
		ret.setNameStyle(input.getNameStyle());
		ret.setMainCategory((com.jcommerce.core.model.Category) (dbAccessImpl.getBean0("Category", String.valueOf(input.getMainCategory()))));
		int[] categoryList = input.getCategories();
		if (categoryList != null) {
			Set<Category> categorys = new HashSet<Category>();
			for (int i = 0; i < categoryList.length; i++) {
				com.jcommerce.core.model.Category category = new com.jcommerce.core.model.Category();
				category = (com.jcommerce.core.model.Category) dbAccessImpl.getBean0("Category", String.valueOf(categoryList[i]));
				categorys.add(category);
			}
			ret.setCategories(categorys);
		}

		ret.setBrand((com.jcommerce.core.model.Brand) (dbAccessImpl.getBean0("Brand", String.valueOf(input.getBrand()))));
		ret.setProviderName(input.getProviderName());
		ret.setNumber(input.getNumber());
		if ((String.valueOf(input.getWeight()).indexOf("NaN") < 0) && (String.valueOf(input.getWeight()).indexOf("Inf") < 0)) {
			ret.setWeight(input.getWeight());
		}

		if ((String.valueOf(input.getMarketPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getMarketPrice()).indexOf("Inf") < 0)) {
			ret.setMarketPrice(input.getMarketPrice());
		}

		if ((String.valueOf(input.getShopPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getShopPrice()).indexOf("Inf") < 0)) {
			ret.setShopPrice(input.getShopPrice());
		}

		if ((String.valueOf(input.getPromotePrice()).indexOf("NaN") < 0) && (String.valueOf(input.getPromotePrice()).indexOf("Inf") < 0)) {
			ret.setPromotePrice(input.getPromotePrice());
		}
		if (input.getPromoteStart() != null) {
			ret.setPromoteStart(new Timestamp(input.getPromoteStart().getTime()));
		}
		if (input.getPromoteEnd() != null) {
			ret.setPromoteEnd(new Timestamp(input.getPromoteEnd().getTime()));
		}
		ret.setWarnNumber(input.getWarnNumber());
		ret.setBrief(input.getBrief());
		ret.setThumb(input.getThumb());
		ret.setOriginalImage(input.getOriginalImage());
		ret.setRealGoods(input.getRealGoods());
		ret.setOnSale(input.getOnSale());
		ret.setAloneSale(input.getAloneSale());
		ret.setBestSold(input.getBestSold());
		ret.setNewAdded(input.getNewAdded());
		ret.setHotSold(input.getHotSold());
		ret.setPromoted(input.getPromoted());
		if (input.getLastUpdate() != null) {
			ret.setLastUpdate(new Timestamp(input.getLastUpdate().getTime()));
		}
		ret.setSellerNote(input.getSellerNote());
		ret.setGiveIntegral(input.getGiveIntegral());
		ret.setBonusType((com.jcommerce.core.model.BonusType) (dbAccessImpl.getBean0("BonusType", String.valueOf(input.getBonusType()))));
		int[] galleryList = input.getGalleries();
		if (galleryList != null) {
			Set<Gallery> gallerys = new HashSet<Gallery>();
			for (int i = 0; i < galleryList.length; i++) {
				com.jcommerce.core.model.Gallery gallery = new com.jcommerce.core.model.Gallery();
				gallery = (com.jcommerce.core.model.Gallery) dbAccessImpl.getBean0("Gallery", String.valueOf(galleryList[i]));
				gallerys.add(gallery);
			}
			ret.setGalleries(gallerys);
		}

		int[] articleList = input.getArticles();
		if (articleList != null) {
			Set<Article> articles = new HashSet<Article>();
			for (int i = 0; i < articleList.length; i++) {
				com.jcommerce.core.model.Article article = new com.jcommerce.core.model.Article();
				article = (com.jcommerce.core.model.Article) dbAccessImpl.getBean0("Article", String.valueOf(articleList[i]));
				articles.add(article);
			}
			ret.setArticles(articles);
		}

		ret.setName(input.getName());
		com.jcommerce.ws.server.GoodsAttribute[] goodsattributeList = input.getAttributes();
		if (goodsattributeList != null) {
			Set<GoodsAttribute> goodsattributes = new HashSet<GoodsAttribute>();
			for (int i = 0; i < goodsattributeList.length; i++) {
				com.jcommerce.core.model.GoodsAttribute goodsattribute = new com.jcommerce.core.model.GoodsAttribute();
				goodsattribute = getCoreGoodsAttribute(goodsattributeList[i]);
				goodsattributes.add(goodsattribute);
			}
			ret.setAttributes(goodsattributes);
		}

		ret.setDescription(input.getDescription());
		ret.setImage(input.getImage());
		ret.setType((com.jcommerce.core.model.GoodsType) (dbAccessImpl.getBean0("GoodsType", String.valueOf(input.getType()))));
		return ret;
	}

	public com.jcommerce.ws.server.Goods getWSDLGoods(com.jcommerce.core.model.Goods input) {
		com.jcommerce.ws.server.Goods ret = new com.jcommerce.ws.server.Goods();
		ret.setId(input.getId());
		ret.setDeleted(input.isDeleted());
		ret.setAddTime(input.getAddTime());
		ret.setClickCount(input.getClickCount());
		ret.setSN(input.getSN());
		ret.setIntegral(input.getIntegral());
		ret.setExtensionCode(input.getExtensionCode());
		ret.setKeywords(input.getKeywords());
		ret.setSortOrder(input.getSortOrder());
		ret.setNameStyle(input.getNameStyle());
		if (input.getMainCategory() != null) {
			ret.setMainCategory(input.getMainCategory().getId());
		}
		Set categoryList = input.getCategories();
		if (categoryList != null) {
			int[] categorys = new int[categoryList.size()];
			int categoryCounter = 0;
			Iterator categoryItor = categoryList.iterator();
			while (categoryItor.hasNext()) {
				Category category = (Category) categoryItor.next();
				categorys[categoryCounter++] = category.getId();
			}
			ret.setCategories(categorys);
		}
		if (input.getBrand() != null) {
			ret.setBrand(input.getBrand().getId());
		}
		ret.setProviderName(input.getProviderName());
		ret.setNumber(input.getNumber());
		ret.setWeight(input.getWeight());
		ret.setMarketPrice(input.getMarketPrice());
		ret.setShopPrice(input.getShopPrice());
		ret.setPromotePrice(input.getPromotePrice());
		ret.setPromoteStart(input.getPromoteStart());
		ret.setPromoteEnd(input.getPromoteEnd());
		ret.setWarnNumber(input.getWarnNumber());
		ret.setBrief(input.getBrief());
		ret.setThumb(input.getThumb());
		ret.setOriginalImage(input.getOriginalImage());
		ret.setRealGoods(input.isRealGoods());
		ret.setOnSale(input.isOnSale());
		ret.setAloneSale(input.isAloneSale());
		ret.setBestSold(input.isBestSold());
		ret.setNewAdded(input.isNewAdded());
		ret.setHotSold(input.isHotSold());
		ret.setPromoted(input.isPromoted());
		ret.setLastUpdate(input.getLastUpdate());
		ret.setSellerNote(input.getSellerNote());
		ret.setGiveIntegral(input.getGiveIntegral());
		if (input.getBonusType() != null) {
			ret.setBonusType(input.getBonusType().getId());
		}
		Set galleryList = input.getGalleries();
		if (galleryList != null) {
			int[] gallerys = new int[galleryList.size()];
			int galleryCounter = 0;
			Iterator galleryItor = galleryList.iterator();
			while (galleryItor.hasNext()) {
				Gallery gallery = (Gallery) galleryItor.next();
				gallerys[galleryCounter++] = gallery.getId();
			}
			ret.setGalleries(gallerys);
		}
		Set articleList = input.getArticles();
		if (articleList != null) {
			int[] articles = new int[articleList.size()];
			int articleCounter = 0;
			Iterator articleItor = articleList.iterator();
			while (articleItor.hasNext()) {
				Article article = (Article) articleItor.next();
				articles[articleCounter++] = article.getId();
			}
			ret.setArticles(articles);
		}
		ret.setName(input.getName());
		Set goodsattributeList = input.getAttributes();
		if (goodsattributeList != null) {
			com.jcommerce.ws.server.GoodsAttribute[] goodsattributes = new com.jcommerce.ws.server.GoodsAttribute[goodsattributeList.size()];
			int goodsattributeCounter = 0;
			Iterator goodsattributeItor = goodsattributeList.iterator();
			while (goodsattributeItor.hasNext()) {
				GoodsAttribute goodsattribute = (GoodsAttribute) goodsattributeItor.next();
				goodsattributes[goodsattributeCounter++] = getWSDLGoodsAttribute(goodsattribute);
			}
			ret.setAttributes(goodsattributes);
		}
		ret.setDescription(input.getDescription());
		ret.setImage(input.getImage());
		if (input.getType() != null) {
			ret.setType(input.getType().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.Goods[] getCoreGoodsList(com.jcommerce.ws.server.Goods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Goods[] retList = new com.jcommerce.core.model.Goods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Goods[] getWSDLGoodsList(com.jcommerce.core.model.Goods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Goods[] retList = new com.jcommerce.ws.server.Goods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.GoodsActivity getCoreGoodsActivity(com.jcommerce.ws.server.GoodsActivity input) {
		com.jcommerce.core.model.GoodsActivity ret = new com.jcommerce.core.model.GoodsActivity();
		ret.setId(input.getId());
		if (input.getEndTime() != null) {
			ret.setEndTime(new Timestamp(input.getEndTime().getTime()));
		}

		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setFinished(input.getFinished());
		ret.setExtraInfo(input.getExtraInfo());
		ret.setName(input.getName());
		if (input.getStartTime() != null) {
			ret.setStartTime(new Timestamp(input.getStartTime().getTime()));
		}

		ret.setDescription(input.getDescription());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.GoodsActivity getWSDLGoodsActivity(com.jcommerce.core.model.GoodsActivity input) {
		com.jcommerce.ws.server.GoodsActivity ret = new com.jcommerce.ws.server.GoodsActivity();
		ret.setId(input.getId());
		ret.setEndTime(input.getEndTime());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setFinished(input.isFinished());
		ret.setExtraInfo(input.getExtraInfo());
		ret.setName(input.getName());
		ret.setStartTime(input.getStartTime());
		ret.setDescription(input.getDescription());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.GoodsActivity[] getCoreGoodsActivityList(com.jcommerce.ws.server.GoodsActivity[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.GoodsActivity[] retList = new com.jcommerce.core.model.GoodsActivity[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGoodsActivity(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.GoodsActivity[] getWSDLGoodsActivityList(com.jcommerce.core.model.GoodsActivity[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.GoodsActivity[] retList = new com.jcommerce.ws.server.GoodsActivity[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGoodsActivity(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.GoodsArticle getCoreGoodsArticle(com.jcommerce.ws.server.GoodsArticle input) {
		com.jcommerce.core.model.GoodsArticle ret = new com.jcommerce.core.model.GoodsArticle();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setArticle((com.jcommerce.core.model.Article) (dbAccessImpl.getBean0("Article", String.valueOf(input.getArticle()))));
		return ret;
	}

	public com.jcommerce.ws.server.GoodsArticle getWSDLGoodsArticle(com.jcommerce.core.model.GoodsArticle input) {
		com.jcommerce.ws.server.GoodsArticle ret = new com.jcommerce.ws.server.GoodsArticle();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		if (input.getArticle() != null) {
			ret.setArticle(input.getArticle().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.GoodsArticle[] getCoreGoodsArticleList(com.jcommerce.ws.server.GoodsArticle[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.GoodsArticle[] retList = new com.jcommerce.core.model.GoodsArticle[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGoodsArticle(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.GoodsArticle[] getWSDLGoodsArticleList(com.jcommerce.core.model.GoodsArticle[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.GoodsArticle[] retList = new com.jcommerce.ws.server.GoodsArticle[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGoodsArticle(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.GoodsAttribute getCoreGoodsAttribute(com.jcommerce.ws.server.GoodsAttribute input) {
		com.jcommerce.core.model.GoodsAttribute ret = new com.jcommerce.core.model.GoodsAttribute();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setPrice(input.getPrice());
		ret.setValue(input.getValue());
		ret.setAttribute((com.jcommerce.core.model.Attribute) (dbAccessImpl.getBean0("Attribute", String.valueOf(input.getAttribute()))));
		return ret;
	}

	public com.jcommerce.ws.server.GoodsAttribute getWSDLGoodsAttribute(com.jcommerce.core.model.GoodsAttribute input) {
		com.jcommerce.ws.server.GoodsAttribute ret = new com.jcommerce.ws.server.GoodsAttribute();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setPrice(input.getPrice());
		ret.setValue(input.getValue());
		if (input.getAttribute() != null) {
			ret.setAttribute(input.getAttribute().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.GoodsAttribute[] getCoreGoodsAttributeList(com.jcommerce.ws.server.GoodsAttribute[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.GoodsAttribute[] retList = new com.jcommerce.core.model.GoodsAttribute[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGoodsAttribute(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.GoodsAttribute[] getWSDLGoodsAttributeList(com.jcommerce.core.model.GoodsAttribute[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.GoodsAttribute[] retList = new com.jcommerce.ws.server.GoodsAttribute[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGoodsAttribute(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.GoodsType getCoreGoodsType(com.jcommerce.ws.server.GoodsType input) {
		com.jcommerce.core.model.GoodsType ret = new com.jcommerce.core.model.GoodsType();
		ret.setId(input.getId());
		ret.setAttributeGroup(input.getAttributeGroup());
		ret.setName(input.getName());
		ret.setEnabled(input.getEnabled());
		return ret;
	}

	public com.jcommerce.ws.server.GoodsType getWSDLGoodsType(com.jcommerce.core.model.GoodsType input) {
		com.jcommerce.ws.server.GoodsType ret = new com.jcommerce.ws.server.GoodsType();
		ret.setId(input.getId());
		ret.setAttributeGroup(input.getAttributeGroup());
		ret.setName(input.getName());
		ret.setEnabled(input.isEnabled());
		return ret;
	}

	public com.jcommerce.core.model.GoodsType[] getCoreGoodsTypeList(com.jcommerce.ws.server.GoodsType[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.GoodsType[] retList = new com.jcommerce.core.model.GoodsType[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGoodsType(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.GoodsType[] getWSDLGoodsTypeList(com.jcommerce.core.model.GoodsType[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.GoodsType[] retList = new com.jcommerce.ws.server.GoodsType[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGoodsType(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.GroupGoods getCoreGroupGoods(com.jcommerce.ws.server.GroupGoods input) {
		com.jcommerce.core.model.GroupGoods ret = new com.jcommerce.core.model.GroupGoods();
		ret.setId(input.getId());
		int[] groupgoodsList = input.getChildren();
		if (groupgoodsList != null) {
			Set<GroupGoods> groupgoodss = new HashSet<GroupGoods>();
			for (int i = 0; i < groupgoodsList.length; i++) {
				com.jcommerce.core.model.GroupGoods groupgoods = new com.jcommerce.core.model.GroupGoods();
				groupgoods = (com.jcommerce.core.model.GroupGoods) dbAccessImpl.getBean0("GroupGoods", String.valueOf(groupgoodsList[i]));
				groupgoodss.add(groupgoods);
			}
			ret.setChildren(groupgoodss);
		}

		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		if ((String.valueOf(input.getGoodsPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getGoodsPrice()).indexOf("Inf") < 0)) {
			ret.setGoodsPrice(input.getGoodsPrice());
		}

		ret.setParent((com.jcommerce.core.model.GroupGoods) (dbAccessImpl.getBean0("GroupGoods", String.valueOf(input.getParent()))));
		return ret;
	}

	public com.jcommerce.ws.server.GroupGoods getWSDLGroupGoods(com.jcommerce.core.model.GroupGoods input) {
		com.jcommerce.ws.server.GroupGoods ret = new com.jcommerce.ws.server.GroupGoods();
		ret.setId(input.getId());
		Set groupgoodsList = input.getChildren();
		if (groupgoodsList != null) {
			int[] groupgoodss = new int[groupgoodsList.size()];
			int groupgoodsCounter = 0;
			Iterator groupgoodsItor = groupgoodsList.iterator();
			while (groupgoodsItor.hasNext()) {
				GroupGoods groupgoods = (GroupGoods) groupgoodsItor.next();
				groupgoodss[groupgoodsCounter++] = groupgoods.getId();
			}
			ret.setChildren(groupgoodss);
		}
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setGoodsPrice(input.getGoodsPrice());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.GroupGoods[] getCoreGroupGoodsList(com.jcommerce.ws.server.GroupGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.GroupGoods[] retList = new com.jcommerce.core.model.GroupGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreGroupGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.GroupGoods[] getWSDLGroupGoodsList(com.jcommerce.core.model.GroupGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.GroupGoods[] retList = new com.jcommerce.ws.server.GroupGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLGroupGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Keywords getCoreKeywords(com.jcommerce.ws.server.Keywords input) {
		com.jcommerce.core.model.Keywords ret = new com.jcommerce.core.model.Keywords();
		ret.setId(input.getId());
		ret.setCount(input.getCount());
		ret.setSearchEngine(input.getSearchEngine());
		ret.setKeyword(input.getKeyword());
		if (input.getDate() != null) {
			ret.setDate(new Timestamp(input.getDate().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.Keywords getWSDLKeywords(com.jcommerce.core.model.Keywords input) {
		com.jcommerce.ws.server.Keywords ret = new com.jcommerce.ws.server.Keywords();
		ret.setId(input.getId());
		ret.setCount(input.getCount());
		ret.setSearchEngine(input.getSearchEngine());
		ret.setKeyword(input.getKeyword());
		ret.setDate(input.getDate());
		return ret;
	}

	public com.jcommerce.core.model.Keywords[] getCoreKeywordsList(com.jcommerce.ws.server.Keywords[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Keywords[] retList = new com.jcommerce.core.model.Keywords[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreKeywords(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Keywords[] getWSDLKeywordsList(com.jcommerce.core.model.Keywords[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Keywords[] retList = new com.jcommerce.ws.server.Keywords[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLKeywords(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.LinkGoods getCoreLinkGoods(com.jcommerce.ws.server.LinkGoods input) {
		com.jcommerce.core.model.LinkGoods ret = new com.jcommerce.core.model.LinkGoods();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setLinkGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getLinkGoods()))));
		ret.setBidirectional(input.getBidirectional());
		return ret;
	}

	public com.jcommerce.ws.server.LinkGoods getWSDLLinkGoods(com.jcommerce.core.model.LinkGoods input) {
		com.jcommerce.ws.server.LinkGoods ret = new com.jcommerce.ws.server.LinkGoods();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		if (input.getLinkGoods() != null) {
			ret.setLinkGoods(input.getLinkGoods().getId());
		}
		ret.setBidirectional(input.isBidirectional());
		return ret;
	}

	public com.jcommerce.core.model.LinkGoods[] getCoreLinkGoodsList(com.jcommerce.ws.server.LinkGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.LinkGoods[] retList = new com.jcommerce.core.model.LinkGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreLinkGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.LinkGoods[] getWSDLLinkGoodsList(com.jcommerce.core.model.LinkGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.LinkGoods[] retList = new com.jcommerce.ws.server.LinkGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLLinkGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.MailTemplate getCoreMailTemplate(com.jcommerce.ws.server.MailTemplate input) {
		com.jcommerce.core.model.MailTemplate ret = new com.jcommerce.core.model.MailTemplate();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setContent(input.getContent());
		if (input.getLastSend() != null) {
			ret.setLastSend(new Timestamp(input.getLastSend().getTime()));
		}

		ret.setHtml(input.getHtml());
		if (input.getLastModify() != null) {
			ret.setLastModify(new Timestamp(input.getLastModify().getTime()));
		}

		ret.setType(input.getType());
		ret.setSubject(input.getSubject());
		return ret;
	}

	public com.jcommerce.ws.server.MailTemplate getWSDLMailTemplate(com.jcommerce.core.model.MailTemplate input) {
		com.jcommerce.ws.server.MailTemplate ret = new com.jcommerce.ws.server.MailTemplate();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setContent(input.getContent());
		ret.setLastSend(input.getLastSend());
		ret.setHtml(input.isHtml());
		ret.setLastModify(input.getLastModify());
		ret.setType(input.getType());
		ret.setSubject(input.getSubject());
		return ret;
	}

	public com.jcommerce.core.model.MailTemplate[] getCoreMailTemplateList(com.jcommerce.ws.server.MailTemplate[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.MailTemplate[] retList = new com.jcommerce.core.model.MailTemplate[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreMailTemplate(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.MailTemplate[] getWSDLMailTemplateList(com.jcommerce.core.model.MailTemplate[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.MailTemplate[] retList = new com.jcommerce.ws.server.MailTemplate[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLMailTemplate(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.MemberPrice getCoreMemberPrice(com.jcommerce.ws.server.MemberPrice input) {
		com.jcommerce.core.model.MemberPrice ret = new com.jcommerce.core.model.MemberPrice();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setUserRank((com.jcommerce.core.model.UserRank) (dbAccessImpl.getBean0("UserRank", String.valueOf(input.getUserRank()))));
		if ((String.valueOf(input.getUserPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getUserPrice()).indexOf("Inf") < 0)) {
			ret.setUserPrice(input.getUserPrice());
		}

		return ret;
	}

	public com.jcommerce.ws.server.MemberPrice getWSDLMemberPrice(com.jcommerce.core.model.MemberPrice input) {
		com.jcommerce.ws.server.MemberPrice ret = new com.jcommerce.ws.server.MemberPrice();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		if (input.getUserRank() != null) {
			ret.setUserRank(input.getUserRank().getId());
		}
		ret.setUserPrice(input.getUserPrice());
		return ret;
	}

	public com.jcommerce.core.model.MemberPrice[] getCoreMemberPriceList(com.jcommerce.ws.server.MemberPrice[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.MemberPrice[] retList = new com.jcommerce.core.model.MemberPrice[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreMemberPrice(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.MemberPrice[] getWSDLMemberPriceList(com.jcommerce.core.model.MemberPrice[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.MemberPrice[] retList = new com.jcommerce.ws.server.MemberPrice[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLMemberPrice(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Navigation getCoreNavigation(com.jcommerce.ws.server.Navigation input) {
		com.jcommerce.core.model.Navigation ret = new com.jcommerce.core.model.Navigation();
		ret.setId(input.getId());
		ret.setShow(input.getShow());
		ret.setUrl(input.getUrl());
		ret.setCategoryType(input.getCategoryType());
		ret.setCategoryId(input.getCategoryId());
		ret.setViewOrder(input.getViewOrder());
		ret.setOpenNew(input.getOpenNew());
		ret.setName(input.getName());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.Navigation getWSDLNavigation(com.jcommerce.core.model.Navigation input) {
		com.jcommerce.ws.server.Navigation ret = new com.jcommerce.ws.server.Navigation();
		ret.setId(input.getId());
		ret.setShow(input.isShow());
		ret.setUrl(input.getUrl());
		ret.setCategoryType(input.getCategoryType());
		ret.setCategoryId(input.getCategoryId());
		ret.setViewOrder(input.getViewOrder());
		ret.setOpenNew(input.isOpenNew());
		ret.setName(input.getName());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.Navigation[] getCoreNavigationList(com.jcommerce.ws.server.Navigation[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Navigation[] retList = new com.jcommerce.core.model.Navigation[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreNavigation(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Navigation[] getWSDLNavigationList(com.jcommerce.core.model.Navigation[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Navigation[] retList = new com.jcommerce.ws.server.Navigation[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLNavigation(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Order getCoreOrder(com.jcommerce.ws.server.Order input) {
		com.jcommerce.core.model.Order ret = new com.jcommerce.core.model.Order();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setEmail(input.getEmail());
		if (input.getAddTime() != null) {
			ret.setAddTime(new Timestamp(input.getAddTime().getTime()));
		}

		ret.setAgency((com.jcommerce.core.model.Agency) (dbAccessImpl.getBean0("Agency", String.valueOf(input.getAgency()))));
		ret.setReferer(input.getReferer());
		ret.setSN(input.getSN());
		ret.setShippingStatus(input.getShippingStatus());
		ret.setRegion((com.jcommerce.core.model.Region) (dbAccessImpl.getBean0("Region", String.valueOf(input.getRegion()))));
		ret.setPayStatus(input.getPayStatus());
		ret.setConsignee(input.getConsignee());
		ret.setZip(input.getZip());
		ret.setPhone(input.getPhone());
		ret.setMobile(input.getMobile());
		ret.setSignBuilding(input.getSignBuilding());
		ret.setBestTime(input.getBestTime());
		ret.setPostScript(input.getPostScript());
		ret.setPackName(input.getPackName());
		ret.setCardName(input.getCardName());
		ret.setCardMessage(input.getCardMessage());
		ret.setInvoicePayee(input.getInvoicePayee());
		ret.setInvoiceContent(input.getInvoiceContent());
		if ((String.valueOf(input.getGoodsAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getGoodsAmount()).indexOf("Inf") < 0)) {
			ret.setGoodsAmount(input.getGoodsAmount());
		}

		if ((String.valueOf(input.getShippingFee()).indexOf("NaN") < 0) && (String.valueOf(input.getShippingFee()).indexOf("Inf") < 0)) {
			ret.setShippingFee(input.getShippingFee());
		}

		if ((String.valueOf(input.getInsureFee()).indexOf("NaN") < 0) && (String.valueOf(input.getInsureFee()).indexOf("Inf") < 0)) {
			ret.setInsureFee(input.getInsureFee());
		}

		if ((String.valueOf(input.getPayFee()).indexOf("NaN") < 0) && (String.valueOf(input.getPayFee()).indexOf("Inf") < 0)) {
			ret.setPayFee(input.getPayFee());
		}

		ret.setPayment((com.jcommerce.core.model.Payment) (dbAccessImpl.getBean0("Payment", String.valueOf(input.getPayment()))));
		ret.setShipping((com.jcommerce.core.model.Shipping) (dbAccessImpl.getBean0("Shipping", String.valueOf(input.getShipping()))));
		ret.setHowOss(input.getHowOss());
		ret.setHowSurplus(input.getHowSurplus());
		if ((String.valueOf(input.getMoneyPaid()).indexOf("NaN") < 0) && (String.valueOf(input.getMoneyPaid()).indexOf("Inf") < 0)) {
			ret.setMoneyPaid(input.getMoneyPaid());
		}

		if ((String.valueOf(input.getSurplus()).indexOf("NaN") < 0) && (String.valueOf(input.getSurplus()).indexOf("Inf") < 0)) {
			ret.setSurplus(input.getSurplus());
		}

		ret.setIntegral(input.getIntegral());
		if ((String.valueOf(input.getIntegralMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getIntegralMoney()).indexOf("Inf") < 0)) {
			ret.setIntegralMoney(input.getIntegralMoney());
		}

		if ((String.valueOf(input.getOrderAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getOrderAmount()).indexOf("Inf") < 0)) {
			ret.setOrderAmount(input.getOrderAmount());
		}

		if ((String.valueOf(input.getBonusMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getBonusMoney()).indexOf("Inf") < 0)) {
			ret.setBonusMoney(input.getBonusMoney());
		}

		ret.setFromAD(input.getFromAD());
		if (input.getConfirmTime() != null) {
			ret.setConfirmTime(new Timestamp(input.getConfirmTime().getTime()));
		}

		if (input.getPayTime() != null) {
			ret.setPayTime(new Timestamp(input.getPayTime().getTime()));
		}

		if (input.getShippingTime() != null) {
			ret.setShippingTime(new Timestamp(input.getShippingTime().getTime()));
		}

		ret.setPack((com.jcommerce.core.model.Pack) (dbAccessImpl.getBean0("Pack", String.valueOf(input.getPack()))));
		ret.setCard((com.jcommerce.core.model.Card) (dbAccessImpl.getBean0("Card", String.valueOf(input.getCard()))));
		ret.setUserBonus((com.jcommerce.core.model.UserBonus) (dbAccessImpl.getBean0("UserBonus", String.valueOf(input.getUserBonus()))));
		ret.setInvoiceNO(input.getInvoiceNO());
		ret.setExtensionCode(input.getExtensionCode());
		ret.setExtensionId(input.getExtensionId());
		ret.setToBuyer(input.getToBuyer());
		ret.setPayNote(input.getPayNote());
		ret.setInvoceType(input.getInvoceType());
		if ((String.valueOf(input.getTax()).indexOf("NaN") < 0) && (String.valueOf(input.getTax()).indexOf("Inf") < 0)) {
			ret.setTax(input.getTax());
		}

		ret.setSeparate(input.getSeparate());
		if ((String.valueOf(input.getDiscount()).indexOf("NaN") < 0) && (String.valueOf(input.getDiscount()).indexOf("Inf") < 0)) {
			ret.setDiscount(input.getDiscount());
		}

		ret.setParent((com.jcommerce.core.model.Order) (dbAccessImpl.getBean0("Order", String.valueOf(input.getParent()))));
		ret.setStatus(input.getStatus());
		ret.setAddress(input.getAddress());
		return ret;
	}

	public com.jcommerce.ws.server.Order getWSDLOrder(com.jcommerce.core.model.Order input) {
		com.jcommerce.ws.server.Order ret = new com.jcommerce.ws.server.Order();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setEmail(input.getEmail());
		ret.setAddTime(input.getAddTime());
		if (input.getAgency() != null) {
			ret.setAgency(input.getAgency().getId());
		}
		ret.setReferer(input.getReferer());
		ret.setSN(input.getSN());
		ret.setShippingStatus(input.getShippingStatus());
		if (input.getRegion() != null) {
			ret.setRegion(input.getRegion().getId());
		}
		ret.setPayStatus(input.getPayStatus());
		ret.setConsignee(input.getConsignee());
		ret.setZip(input.getZip());
		ret.setPhone(input.getPhone());
		ret.setMobile(input.getMobile());
		ret.setSignBuilding(input.getSignBuilding());
		ret.setBestTime(input.getBestTime());
		ret.setPostScript(input.getPostScript());
		ret.setPackName(input.getPackName());
		ret.setCardName(input.getCardName());
		ret.setCardMessage(input.getCardMessage());
		ret.setInvoicePayee(input.getInvoicePayee());
		ret.setInvoiceContent(input.getInvoiceContent());
		ret.setGoodsAmount(input.getGoodsAmount());
		ret.setShippingFee(input.getShippingFee());
		ret.setInsureFee(input.getInsureFee());
		ret.setPayFee(input.getPayFee());
		if (input.getPayment() != null) {
			ret.setPayment(input.getPayment().getId());
		}
		if (input.getShipping() != null) {
			ret.setShipping(input.getShipping().getId());
		}
		ret.setHowOss(input.getHowOss());
		ret.setHowSurplus(input.getHowSurplus());
		ret.setMoneyPaid(input.getMoneyPaid());
		ret.setSurplus(input.getSurplus());
		ret.setIntegral(input.getIntegral());
		ret.setIntegralMoney(input.getIntegralMoney());
		ret.setOrderAmount(input.getOrderAmount());
		ret.setBonusMoney(input.getBonusMoney());
		ret.setFromAD(input.getFromAD());
		ret.setConfirmTime(input.getConfirmTime());
		ret.setPayTime(input.getPayTime());
		ret.setShippingTime(input.getShippingTime());
		if (input.getPack() != null) {
			ret.setPack(input.getPack().getId());
		}
		if (input.getCard() != null) {
			ret.setCard(input.getCard().getId());
		}
		if (input.getUserBonus() != null) {
			ret.setUserBonus(input.getUserBonus().getId());
		}
		ret.setInvoiceNO(input.getInvoiceNO());
		ret.setExtensionCode(input.getExtensionCode());
		ret.setExtensionId(input.getExtensionId());
		ret.setToBuyer(input.getToBuyer());
		ret.setPayNote(input.getPayNote());
		ret.setInvoceType(input.getInvoceType());
		ret.setTax(input.getTax());
		ret.setSeparate(input.isSeparate());
		ret.setDiscount(input.getDiscount());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setStatus(input.getStatus());
		ret.setAddress(input.getAddress());
		return ret;
	}

	public com.jcommerce.core.model.Order[] getCoreOrderList(com.jcommerce.ws.server.Order[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Order[] retList = new com.jcommerce.core.model.Order[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreOrder(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Order[] getWSDLOrderList(com.jcommerce.core.model.Order[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Order[] retList = new com.jcommerce.ws.server.Order[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLOrder(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.OrderAction getCoreOrderAction(com.jcommerce.ws.server.OrderAction input) {
		com.jcommerce.core.model.OrderAction ret = new com.jcommerce.core.model.OrderAction();
		ret.setId(input.getId());
		if (input.getLogTime() != null) {
			ret.setLogTime(new Timestamp(input.getLogTime().getTime()));
		}

		ret.setOrder((com.jcommerce.core.model.Order) (dbAccessImpl.getBean0("Order", String.valueOf(input.getOrder()))));
		ret.setShippingStatus(input.getShippingStatus());
		ret.setPayStatus(input.getPayStatus());
		ret.setActionUser(input.getActionUser());
		ret.setOrderStatus(input.getOrderStatus());
		ret.setActionNote(input.getActionNote());
		return ret;
	}

	public com.jcommerce.ws.server.OrderAction getWSDLOrderAction(com.jcommerce.core.model.OrderAction input) {
		com.jcommerce.ws.server.OrderAction ret = new com.jcommerce.ws.server.OrderAction();
		ret.setId(input.getId());
		ret.setLogTime(input.getLogTime());
		if (input.getOrder() != null) {
			ret.setOrder(input.getOrder().getId());
		}
		ret.setShippingStatus(input.getShippingStatus());
		ret.setPayStatus(input.getPayStatus());
		ret.setActionUser(input.getActionUser());
		ret.setOrderStatus(input.getOrderStatus());
		ret.setActionNote(input.getActionNote());
		return ret;
	}

	public com.jcommerce.core.model.OrderAction[] getCoreOrderActionList(com.jcommerce.ws.server.OrderAction[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.OrderAction[] retList = new com.jcommerce.core.model.OrderAction[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreOrderAction(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.OrderAction[] getWSDLOrderActionList(com.jcommerce.core.model.OrderAction[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.OrderAction[] retList = new com.jcommerce.ws.server.OrderAction[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLOrderAction(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.OrderGoods getCoreOrderGoods(com.jcommerce.ws.server.OrderGoods input) {
		com.jcommerce.core.model.OrderGoods ret = new com.jcommerce.core.model.OrderGoods();
		ret.setId(input.getId());
		ret.setOrder((com.jcommerce.core.model.Order) (dbAccessImpl.getBean0("Order", String.valueOf(input.getOrder()))));
		ret.setExtensionCode(input.getExtensionCode());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setGoodsNumber(input.getGoodsNumber());
		if ((String.valueOf(input.getMarketPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getMarketPrice()).indexOf("Inf") < 0)) {
			ret.setMarketPrice(input.getMarketPrice());
		}

		ret.setRealGoods(input.getRealGoods());
		ret.setGoodsSN(input.getGoodsSN());
		ret.setGoodsName(input.getGoodsName());
		if ((String.valueOf(input.getGoodsPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getGoodsPrice()).indexOf("Inf") < 0)) {
			ret.setGoodsPrice(input.getGoodsPrice());
		}

		ret.setGift(input.getGift());
		ret.setGoodsAttribute(input.getGoodsAttribute());
		ret.setSendNumber(input.getSendNumber());
		ret.setParent((com.jcommerce.core.model.OrderGoods) (dbAccessImpl.getBean0("OrderGoods", String.valueOf(input.getParent()))));
		return ret;
	}

	public com.jcommerce.ws.server.OrderGoods getWSDLOrderGoods(com.jcommerce.core.model.OrderGoods input) {
		com.jcommerce.ws.server.OrderGoods ret = new com.jcommerce.ws.server.OrderGoods();
		ret.setId(input.getId());
		if (input.getOrder() != null) {
			ret.setOrder(input.getOrder().getId());
		}
		ret.setExtensionCode(input.getExtensionCode());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setGoodsNumber(input.getGoodsNumber());
		ret.setMarketPrice(input.getMarketPrice());
		ret.setRealGoods(input.isRealGoods());
		ret.setGoodsSN(input.getGoodsSN());
		ret.setGoodsName(input.getGoodsName());
		ret.setGoodsPrice(input.getGoodsPrice());
		ret.setGift(input.isGift());
		ret.setGoodsAttribute(input.getGoodsAttribute());
		ret.setSendNumber(input.getSendNumber());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.OrderGoods[] getCoreOrderGoodsList(com.jcommerce.ws.server.OrderGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.OrderGoods[] retList = new com.jcommerce.core.model.OrderGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreOrderGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.OrderGoods[] getWSDLOrderGoodsList(com.jcommerce.core.model.OrderGoods[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.OrderGoods[] retList = new com.jcommerce.ws.server.OrderGoods[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLOrderGoods(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Pack getCorePack(com.jcommerce.ws.server.Pack input) {
		com.jcommerce.core.model.Pack ret = new com.jcommerce.core.model.Pack();
		ret.setId(input.getId());
		ret.setFee(input.getFee());
		ret.setFreeMoney(input.getFreeMoney());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		ret.setImage(input.getImage());
		return ret;
	}

	public com.jcommerce.ws.server.Pack getWSDLPack(com.jcommerce.core.model.Pack input) {
		com.jcommerce.ws.server.Pack ret = new com.jcommerce.ws.server.Pack();
		ret.setId(input.getId());
		ret.setFee(input.getFee());
		ret.setFreeMoney(input.getFreeMoney());
		ret.setName(input.getName());
		ret.setDescription(input.getDescription());
		ret.setImage(input.getImage());
		return ret;
	}

	public com.jcommerce.core.model.Pack[] getCorePackList(com.jcommerce.ws.server.Pack[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Pack[] retList = new com.jcommerce.core.model.Pack[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCorePack(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Pack[] getWSDLPackList(com.jcommerce.core.model.Pack[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Pack[] retList = new com.jcommerce.ws.server.Pack[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLPack(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.PayLog getCorePayLog(com.jcommerce.ws.server.PayLog input) {
		com.jcommerce.core.model.PayLog ret = new com.jcommerce.core.model.PayLog();
		ret.setId(input.getId());
		ret.setOrder((com.jcommerce.core.model.Order) (dbAccessImpl.getBean0("Order", String.valueOf(input.getOrder()))));
		if ((String.valueOf(input.getOrderAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getOrderAmount()).indexOf("Inf") < 0)) {
			ret.setOrderAmount(input.getOrderAmount());
		}

		ret.setOrderType(input.getOrderType());
		ret.setPaid(input.getPaid());
		return ret;
	}

	public com.jcommerce.ws.server.PayLog getWSDLPayLog(com.jcommerce.core.model.PayLog input) {
		com.jcommerce.ws.server.PayLog ret = new com.jcommerce.ws.server.PayLog();
		ret.setId(input.getId());
		if (input.getOrder() != null) {
			ret.setOrder(input.getOrder().getId());
		}
		ret.setOrderAmount(input.getOrderAmount());
		ret.setOrderType(input.getOrderType());
		ret.setPaid(input.isPaid());
		return ret;
	}

	public com.jcommerce.core.model.PayLog[] getCorePayLogList(com.jcommerce.ws.server.PayLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.PayLog[] retList = new com.jcommerce.core.model.PayLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCorePayLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.PayLog[] getWSDLPayLogList(com.jcommerce.core.model.PayLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.PayLog[] retList = new com.jcommerce.ws.server.PayLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLPayLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Payment getCorePayment(com.jcommerce.ws.server.Payment input) {
		com.jcommerce.core.model.Payment ret = new com.jcommerce.core.model.Payment();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setOrder(input.getOrder());
		ret.setFee(input.getFee());
		ret.setConfig(input.getConfig());
		ret.setCod(input.getCod());
		ret.setOnline(input.getOnline());
		ret.setName(input.getName());
		ret.setEnabled(input.getEnabled());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.ws.server.Payment getWSDLPayment(com.jcommerce.core.model.Payment input) {
		com.jcommerce.ws.server.Payment ret = new com.jcommerce.ws.server.Payment();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setOrder(input.getOrder());
		ret.setFee(input.getFee());
		ret.setConfig(input.getConfig());
		ret.setCod(input.isCod());
		ret.setOnline(input.isOnline());
		ret.setName(input.getName());
		ret.setEnabled(input.isEnabled());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.core.model.Payment[] getCorePaymentList(com.jcommerce.ws.server.Payment[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Payment[] retList = new com.jcommerce.core.model.Payment[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCorePayment(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Payment[] getWSDLPaymentList(com.jcommerce.core.model.Payment[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Payment[] retList = new com.jcommerce.ws.server.Payment[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLPayment(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Plugins getCorePlugins(com.jcommerce.ws.server.Plugins input) {
		com.jcommerce.core.model.Plugins ret = new com.jcommerce.core.model.Plugins();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setLibrary(input.getLibrary());
		ret.setAssign(input.getAssign());
		if (input.getInstallDate() != null) {
			ret.setInstallDate(new Timestamp(input.getInstallDate().getTime()));
		}

		ret.setVersion(input.getVersion());
		return ret;
	}

	public com.jcommerce.ws.server.Plugins getWSDLPlugins(com.jcommerce.core.model.Plugins input) {
		com.jcommerce.ws.server.Plugins ret = new com.jcommerce.ws.server.Plugins();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setLibrary(input.getLibrary());
		ret.setAssign(input.isAssign());
		ret.setInstallDate(input.getInstallDate());
		ret.setVersion(input.getVersion());
		return ret;
	}

	public com.jcommerce.core.model.Plugins[] getCorePluginsList(com.jcommerce.ws.server.Plugins[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Plugins[] retList = new com.jcommerce.core.model.Plugins[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCorePlugins(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Plugins[] getWSDLPluginsList(com.jcommerce.core.model.Plugins[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Plugins[] retList = new com.jcommerce.ws.server.Plugins[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLPlugins(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Region getCoreRegion(com.jcommerce.ws.server.Region input) {
		com.jcommerce.core.model.Region ret = new com.jcommerce.core.model.Region();
		ret.setId(input.getId());
		ret.setAgency((com.jcommerce.core.model.Agency) (dbAccessImpl.getBean0("Agency", String.valueOf(input.getAgency()))));
		int[] regionList = input.getChildren();
		if (regionList != null) {
			Set<Region> regions = new HashSet<Region>();
			for (int i = 0; i < regionList.length; i++) {
				com.jcommerce.core.model.Region region = new com.jcommerce.core.model.Region();
				region = (com.jcommerce.core.model.Region) dbAccessImpl.getBean0("Region", String.valueOf(regionList[i]));
				regions.add(region);
			}
			ret.setChildren(regions);
		}

		int[] shippingareaList = input.getAreas();
		if (shippingareaList != null) {
			Set<ShippingArea> shippingareas = new HashSet<ShippingArea>();
			for (int i = 0; i < shippingareaList.length; i++) {
				com.jcommerce.core.model.ShippingArea shippingarea = new com.jcommerce.core.model.ShippingArea();
				shippingarea = (com.jcommerce.core.model.ShippingArea) dbAccessImpl.getBean0("ShippingArea", String.valueOf(shippingareaList[i]));
				shippingareas.add(shippingarea);
			}
			ret.setAreas(shippingareas);
		}

		ret.setName(input.getName());
		ret.setParent((com.jcommerce.core.model.Region) (dbAccessImpl.getBean0("Region", String.valueOf(input.getParent()))));
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.Region getWSDLRegion(com.jcommerce.core.model.Region input) {
		com.jcommerce.ws.server.Region ret = new com.jcommerce.ws.server.Region();
		ret.setId(input.getId());
		if (input.getAgency() != null) {
			ret.setAgency(input.getAgency().getId());
		}
		Set regionList = input.getChildren();
		if (regionList != null) {
			int[] regions = new int[regionList.size()];
			int regionCounter = 0;
			Iterator regionItor = regionList.iterator();
			while (regionItor.hasNext()) {
				Region region = (Region) regionItor.next();
				regions[regionCounter++] = region.getId();
			}
			ret.setChildren(regions);
		}
		Set shippingareaList = input.getAreas();
		if (shippingareaList != null) {
			int[] shippingareas = new int[shippingareaList.size()];
			int shippingareaCounter = 0;
			Iterator shippingareaItor = shippingareaList.iterator();
			while (shippingareaItor.hasNext()) {
				ShippingArea shippingarea = (ShippingArea) shippingareaItor.next();
				shippingareas[shippingareaCounter++] = shippingarea.getId();
			}
			ret.setAreas(shippingareas);
		}
		ret.setName(input.getName());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.Region[] getCoreRegionList(com.jcommerce.ws.server.Region[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Region[] retList = new com.jcommerce.core.model.Region[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreRegion(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Region[] getWSDLRegionList(com.jcommerce.core.model.Region[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Region[] retList = new com.jcommerce.ws.server.Region[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLRegion(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.SearchEngine getCoreSearchEngine(com.jcommerce.ws.server.SearchEngine input) {
		com.jcommerce.core.model.SearchEngine ret = new com.jcommerce.core.model.SearchEngine();
		ret.setId(input.getId());
		ret.setCount(input.getCount());
		ret.setSearchEngine(input.getSearchEngine());
		if (input.getDate() != null) {
			ret.setDate(new Timestamp(input.getDate().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.SearchEngine getWSDLSearchEngine(com.jcommerce.core.model.SearchEngine input) {
		com.jcommerce.ws.server.SearchEngine ret = new com.jcommerce.ws.server.SearchEngine();
		ret.setId(input.getId());
		ret.setCount(input.getCount());
		ret.setSearchEngine(input.getSearchEngine());
		ret.setDate(input.getDate());
		return ret;
	}

	public com.jcommerce.core.model.SearchEngine[] getCoreSearchEngineList(com.jcommerce.ws.server.SearchEngine[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.SearchEngine[] retList = new com.jcommerce.core.model.SearchEngine[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreSearchEngine(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.SearchEngine[] getWSDLSearchEngineList(com.jcommerce.core.model.SearchEngine[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.SearchEngine[] retList = new com.jcommerce.ws.server.SearchEngine[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLSearchEngine(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Session getCoreSession(com.jcommerce.ws.server.Session input) {
		com.jcommerce.core.model.Session ret = new com.jcommerce.core.model.Session();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setIP(input.getIP());
		if (input.getExpiry() != null) {
			ret.setExpiry(new Timestamp(input.getExpiry().getTime()));
		}

		ret.setData(input.getData());
		return ret;
	}

	public com.jcommerce.ws.server.Session getWSDLSession(com.jcommerce.core.model.Session input) {
		com.jcommerce.ws.server.Session ret = new com.jcommerce.ws.server.Session();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setIP(input.getIP());
		ret.setExpiry(input.getExpiry());
		ret.setData(input.getData());
		return ret;
	}

	public com.jcommerce.core.model.Session[] getCoreSessionList(com.jcommerce.ws.server.Session[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Session[] retList = new com.jcommerce.core.model.Session[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreSession(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Session[] getWSDLSessionList(com.jcommerce.core.model.Session[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Session[] retList = new com.jcommerce.ws.server.Session[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLSession(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.SessionsData getCoreSessionsData(com.jcommerce.ws.server.SessionsData input) {
		com.jcommerce.core.model.SessionsData ret = new com.jcommerce.core.model.SessionsData();
		ret.setId(input.getId());
		if (input.getExpiry() != null) {
			ret.setExpiry(new Timestamp(input.getExpiry().getTime()));
		}

		ret.setSesskey(input.getSesskey());
		ret.setData(input.getData());
		return ret;
	}

	public com.jcommerce.ws.server.SessionsData getWSDLSessionsData(com.jcommerce.core.model.SessionsData input) {
		com.jcommerce.ws.server.SessionsData ret = new com.jcommerce.ws.server.SessionsData();
		ret.setId(input.getId());
		ret.setExpiry(input.getExpiry());
		ret.setSesskey(input.getSesskey());
		ret.setData(input.getData());
		return ret;
	}

	public com.jcommerce.core.model.SessionsData[] getCoreSessionsDataList(com.jcommerce.ws.server.SessionsData[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.SessionsData[] retList = new com.jcommerce.core.model.SessionsData[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreSessionsData(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.SessionsData[] getWSDLSessionsDataList(com.jcommerce.core.model.SessionsData[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.SessionsData[] retList = new com.jcommerce.ws.server.SessionsData[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLSessionsData(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Shipping getCoreShipping(com.jcommerce.ws.server.Shipping input) {
		com.jcommerce.core.model.Shipping ret = new com.jcommerce.core.model.Shipping();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setInsure(input.getInsure());
		ret.setSupportCod(input.getSupportCod());
		ret.setName(input.getName());
		ret.setEnabled(input.getEnabled());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.ws.server.Shipping getWSDLShipping(com.jcommerce.core.model.Shipping input) {
		com.jcommerce.ws.server.Shipping ret = new com.jcommerce.ws.server.Shipping();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setInsure(input.getInsure());
		ret.setSupportCod(input.isSupportCod());
		ret.setName(input.getName());
		ret.setEnabled(input.isEnabled());
		ret.setDescription(input.getDescription());
		return ret;
	}

	public com.jcommerce.core.model.Shipping[] getCoreShippingList(com.jcommerce.ws.server.Shipping[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Shipping[] retList = new com.jcommerce.core.model.Shipping[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreShipping(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Shipping[] getWSDLShippingList(com.jcommerce.core.model.Shipping[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Shipping[] retList = new com.jcommerce.ws.server.Shipping[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLShipping(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.ShippingArea getCoreShippingArea(com.jcommerce.ws.server.ShippingArea input) {
		com.jcommerce.core.model.ShippingArea ret = new com.jcommerce.core.model.ShippingArea();
		ret.setId(input.getId());
		ret.setShipping((com.jcommerce.core.model.Shipping) (dbAccessImpl.getBean0("Shipping", String.valueOf(input.getShipping()))));
		ret.setConfig(input.getConfig());
		int[] regionList = input.getRegions();
		if (regionList != null) {
			Set<Region> regions = new HashSet<Region>();
			for (int i = 0; i < regionList.length; i++) {
				com.jcommerce.core.model.Region region = new com.jcommerce.core.model.Region();
				region = (com.jcommerce.core.model.Region) dbAccessImpl.getBean0("Region", String.valueOf(regionList[i]));
				regions.add(region);
			}
			ret.setRegions(regions);
		}

		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.ws.server.ShippingArea getWSDLShippingArea(com.jcommerce.core.model.ShippingArea input) {
		com.jcommerce.ws.server.ShippingArea ret = new com.jcommerce.ws.server.ShippingArea();
		ret.setId(input.getId());
		if (input.getShipping() != null) {
			ret.setShipping(input.getShipping().getId());
		}
		ret.setConfig(input.getConfig());
		Set regionList = input.getRegions();
		if (regionList != null) {
			int[] regions = new int[regionList.size()];
			int regionCounter = 0;
			Iterator regionItor = regionList.iterator();
			while (regionItor.hasNext()) {
				Region region = (Region) regionItor.next();
				regions[regionCounter++] = region.getId();
			}
			ret.setRegions(regions);
		}
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.core.model.ShippingArea[] getCoreShippingAreaList(com.jcommerce.ws.server.ShippingArea[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.ShippingArea[] retList = new com.jcommerce.core.model.ShippingArea[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreShippingArea(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.ShippingArea[] getWSDLShippingAreaList(com.jcommerce.core.model.ShippingArea[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.ShippingArea[] retList = new com.jcommerce.ws.server.ShippingArea[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLShippingArea(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.ShopConfig getCoreShopConfig(com.jcommerce.ws.server.ShopConfig input) {
		com.jcommerce.core.model.ShopConfig ret = new com.jcommerce.core.model.ShopConfig();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setSortOrder(input.getSortOrder());
		int[] shopconfigList = input.getChildren();
		if (shopconfigList != null) {
			Set<ShopConfig> shopconfigs = new HashSet<ShopConfig>();
			for (int i = 0; i < shopconfigList.length; i++) {
				com.jcommerce.core.model.ShopConfig shopconfig = new com.jcommerce.core.model.ShopConfig();
				shopconfig = (com.jcommerce.core.model.ShopConfig) dbAccessImpl.getBean0("ShopConfig", String.valueOf(shopconfigList[i]));
				shopconfigs.add(shopconfig);
			}
			ret.setChildren(shopconfigs);
		}

		ret.setStoreRange(input.getStoreRange());
		ret.setStoreDir(input.getStoreDir());
		ret.setParent((com.jcommerce.core.model.ShopConfig) (dbAccessImpl.getBean0("ShopConfig", String.valueOf(input.getParent()))));
		ret.setValue(input.getValue());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.ws.server.ShopConfig getWSDLShopConfig(com.jcommerce.core.model.ShopConfig input) {
		com.jcommerce.ws.server.ShopConfig ret = new com.jcommerce.ws.server.ShopConfig();
		ret.setId(input.getId());
		ret.setCode(input.getCode());
		ret.setSortOrder(input.getSortOrder());
		Set shopconfigList = input.getChildren();
		if (shopconfigList != null) {
			int[] shopconfigs = new int[shopconfigList.size()];
			int shopconfigCounter = 0;
			Iterator shopconfigItor = shopconfigList.iterator();
			while (shopconfigItor.hasNext()) {
				ShopConfig shopconfig = (ShopConfig) shopconfigItor.next();
				shopconfigs[shopconfigCounter++] = shopconfig.getId();
			}
			ret.setChildren(shopconfigs);
		}
		ret.setStoreRange(input.getStoreRange());
		ret.setStoreDir(input.getStoreDir());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setValue(input.getValue());
		ret.setType(input.getType());
		return ret;
	}

	public com.jcommerce.core.model.ShopConfig[] getCoreShopConfigList(com.jcommerce.ws.server.ShopConfig[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.ShopConfig[] retList = new com.jcommerce.core.model.ShopConfig[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreShopConfig(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.ShopConfig[] getWSDLShopConfigList(com.jcommerce.core.model.ShopConfig[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.ShopConfig[] retList = new com.jcommerce.ws.server.ShopConfig[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLShopConfig(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.SnatchLog getCoreSnatchLog(com.jcommerce.ws.server.SnatchLog input) {
		com.jcommerce.core.model.SnatchLog ret = new com.jcommerce.core.model.SnatchLog();
		ret.setId(input.getId());
		if ((String.valueOf(input.getBidPrice()).indexOf("NaN") < 0) && (String.valueOf(input.getBidPrice()).indexOf("Inf") < 0)) {
			ret.setBidPrice(input.getBidPrice());
		}

		if (input.getBidTime() != null) {
			ret.setBidTime(new Timestamp(input.getBidTime().getTime()));
		}

		ret.setSnatchId(input.getSnatchId());
		ret.setUserId(input.getUserId());
		return ret;
	}

	public com.jcommerce.ws.server.SnatchLog getWSDLSnatchLog(com.jcommerce.core.model.SnatchLog input) {
		com.jcommerce.ws.server.SnatchLog ret = new com.jcommerce.ws.server.SnatchLog();
		ret.setId(input.getId());
		ret.setBidPrice(input.getBidPrice());
		ret.setBidTime(input.getBidTime());
		ret.setSnatchId(input.getSnatchId());
		ret.setUserId(input.getUserId());
		return ret;
	}

	public com.jcommerce.core.model.SnatchLog[] getCoreSnatchLogList(com.jcommerce.ws.server.SnatchLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.SnatchLog[] retList = new com.jcommerce.core.model.SnatchLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreSnatchLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.SnatchLog[] getWSDLSnatchLogList(com.jcommerce.core.model.SnatchLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.SnatchLog[] retList = new com.jcommerce.ws.server.SnatchLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLSnatchLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Stats getCoreStats(com.jcommerce.ws.server.Stats input) {
		com.jcommerce.core.model.Stats ret = new com.jcommerce.core.model.Stats();
		ret.setId(input.getId());
		ret.setIP(input.getIP());
		if (input.getAccessTime() != null) {
			ret.setAccessTime(new Timestamp(input.getAccessTime().getTime()));
		}

		ret.setVisitTimes(input.getVisitTimes());
		ret.setBrowser(input.getBrowser());
		ret.setSystem(input.getSystem());
		ret.setLanguage(input.getLanguage());
		ret.setArea(input.getArea());
		ret.setRefererDomain(input.getRefererDomain());
		ret.setRefererPath(input.getRefererPath());
		ret.setAccessUrl(input.getAccessUrl());
		return ret;
	}

	public com.jcommerce.ws.server.Stats getWSDLStats(com.jcommerce.core.model.Stats input) {
		com.jcommerce.ws.server.Stats ret = new com.jcommerce.ws.server.Stats();
		ret.setId(input.getId());
		ret.setIP(input.getIP());
		ret.setAccessTime(input.getAccessTime());
		ret.setVisitTimes(input.getVisitTimes());
		ret.setBrowser(input.getBrowser());
		ret.setSystem(input.getSystem());
		ret.setLanguage(input.getLanguage());
		ret.setArea(input.getArea());
		ret.setRefererDomain(input.getRefererDomain());
		ret.setRefererPath(input.getRefererPath());
		ret.setAccessUrl(input.getAccessUrl());
		return ret;
	}

	public com.jcommerce.core.model.Stats[] getCoreStatsList(com.jcommerce.ws.server.Stats[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Stats[] retList = new com.jcommerce.core.model.Stats[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreStats(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Stats[] getWSDLStatsList(com.jcommerce.core.model.Stats[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Stats[] retList = new com.jcommerce.ws.server.Stats[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLStats(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Tag getCoreTag(com.jcommerce.ws.server.Tag input) {
		com.jcommerce.core.model.Tag ret = new com.jcommerce.core.model.Tag();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setTagWords(input.getTagWords());
		return ret;
	}

	public com.jcommerce.ws.server.Tag getWSDLTag(com.jcommerce.core.model.Tag input) {
		com.jcommerce.ws.server.Tag ret = new com.jcommerce.ws.server.Tag();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setTagWords(input.getTagWords());
		return ret;
	}

	public com.jcommerce.core.model.Tag[] getCoreTagList(com.jcommerce.ws.server.Tag[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Tag[] retList = new com.jcommerce.core.model.Tag[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreTag(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Tag[] getWSDLTagList(com.jcommerce.core.model.Tag[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Tag[] retList = new com.jcommerce.ws.server.Tag[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLTag(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Topic getCoreTopic(com.jcommerce.ws.server.Topic input) {
		com.jcommerce.core.model.Topic ret = new com.jcommerce.core.model.Topic();
		ret.setId(input.getId());
		if (input.getEndTime() != null) {
			ret.setEndTime(new Timestamp(input.getEndTime().getTime()));
		}

		ret.setIntro(input.getIntro());
		ret.setTemplate(input.getTemplate());
		ret.setCss(input.getCss());
		ret.setTitle(input.getTitle());
		ret.setData(input.getData());
		if (input.getStartTime() != null) {
			ret.setStartTime(new Timestamp(input.getStartTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.Topic getWSDLTopic(com.jcommerce.core.model.Topic input) {
		com.jcommerce.ws.server.Topic ret = new com.jcommerce.ws.server.Topic();
		ret.setId(input.getId());
		ret.setEndTime(input.getEndTime());
		ret.setIntro(input.getIntro());
		ret.setTemplate(input.getTemplate());
		ret.setCss(input.getCss());
		ret.setTitle(input.getTitle());
		ret.setData(input.getData());
		ret.setStartTime(input.getStartTime());
		return ret;
	}

	public com.jcommerce.core.model.Topic[] getCoreTopicList(com.jcommerce.ws.server.Topic[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Topic[] retList = new com.jcommerce.core.model.Topic[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreTopic(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Topic[] getWSDLTopicList(com.jcommerce.core.model.Topic[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Topic[] retList = new com.jcommerce.ws.server.Topic[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLTopic(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.User getCoreUser(com.jcommerce.ws.server.User input) {
		com.jcommerce.core.model.User ret = new com.jcommerce.core.model.User();
		ret.setId(input.getId());
		if ((String.valueOf(input.getFrozenMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getFrozenMoney()).indexOf("Inf") < 0)) {
			ret.setFrozenMoney(input.getFrozenMoney());
		}

		ret.setRankPoints(input.getRankPoints());
		ret.setPayPoints(input.getPayPoints());
		ret.setPassword(input.getPassword());
		ret.setEmail(input.getEmail());
		ret.setQuestion(input.getQuestion());
		ret.setAnswer(input.getAnswer());
		ret.setSex(input.getSex());
		ret.setBirthday(input.getBirthday());
		if ((String.valueOf(input.getMoney()).indexOf("NaN") < 0) && (String.valueOf(input.getMoney()).indexOf("Inf") < 0)) {
			ret.setMoney(input.getMoney());
		}

		if (input.getRegisterTime() != null) {
			ret.setRegisterTime(new Timestamp(input.getRegisterTime().getTime()));
		}

		if (input.getLastLogin() != null) {
			ret.setLastLogin(new Timestamp(input.getLastLogin().getTime()));
		}

		if (input.getLastTime() != null) {
			ret.setLastTime(new Timestamp(input.getLastTime().getTime()));
		}

		ret.setLastIP(input.getLastIP());
		ret.setVisitCount(input.getVisitCount());
		ret.setSpecial(input.getSpecial());
		ret.setSalt(input.getSalt());
		ret.setAlias(input.getAlias());
		ret.setMSN(input.getMSN());
		ret.setQQ(input.getQQ());
		ret.setOfficePhone(input.getOfficePhone());
		ret.setHomePhone(input.getHomePhone());
		ret.setMobilePhone(input.getMobilePhone());
		ret.setValidated(input.getValidated());
		if ((String.valueOf(input.getCreditLine()).indexOf("NaN") < 0) && (String.valueOf(input.getCreditLine()).indexOf("Inf") < 0)) {
			ret.setCreditLine(input.getCreditLine());
		}

		ret.setName(input.getName());
		ret.setParent((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getParent()))));
		ret.setRank(input.getRank());
		ret.setFlag(input.getFlag());
		ret.setAddress((com.jcommerce.core.model.UserAddress) (dbAccessImpl.getBean0("UserAddress", String.valueOf(input.getAddress()))));
		return ret;
	}

	public com.jcommerce.ws.server.User getWSDLUser(com.jcommerce.core.model.User input) {
		com.jcommerce.ws.server.User ret = new com.jcommerce.ws.server.User();
		ret.setId(input.getId());
		ret.setFrozenMoney(input.getFrozenMoney());
		ret.setRankPoints(input.getRankPoints());
		ret.setPayPoints(input.getPayPoints());
		ret.setPassword(input.getPassword());
		ret.setEmail(input.getEmail());
		ret.setQuestion(input.getQuestion());
		ret.setAnswer(input.getAnswer());
		ret.setSex(input.getSex());
		ret.setBirthday(input.getBirthday());
		ret.setMoney(input.getMoney());
		ret.setRegisterTime(input.getRegisterTime());
		ret.setLastLogin(input.getLastLogin());
		ret.setLastTime(input.getLastTime());
		ret.setLastIP(input.getLastIP());
		ret.setVisitCount(input.getVisitCount());
		ret.setSpecial(input.isSpecial());
		ret.setSalt(input.getSalt());
		ret.setAlias(input.getAlias());
		ret.setMSN(input.getMSN());
		ret.setQQ(input.getQQ());
		ret.setOfficePhone(input.getOfficePhone());
		ret.setHomePhone(input.getHomePhone());
		ret.setMobilePhone(input.getMobilePhone());
		ret.setValidated(input.isValidated());
		ret.setCreditLine(input.getCreditLine());
		ret.setName(input.getName());
		if (input.getParent() != null) {
			ret.setParent(input.getParent().getId());
		}
		ret.setRank(input.getRank());
		ret.setFlag(input.getFlag());
		if (input.getAddress() != null) {
			ret.setAddress(input.getAddress().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.User[] getCoreUserList(com.jcommerce.ws.server.User[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.User[] retList = new com.jcommerce.core.model.User[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreUser(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.User[] getWSDLUserList(com.jcommerce.core.model.User[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.User[] retList = new com.jcommerce.ws.server.User[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLUser(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.UserAccount getCoreUserAccount(com.jcommerce.ws.server.UserAccount input) {
		com.jcommerce.core.model.UserAccount ret = new com.jcommerce.core.model.UserAccount();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		if (input.getAddTime() != null) {
			ret.setAddTime(new Timestamp(input.getAddTime().getTime()));
		}

		ret.setPayment(input.getPayment());
		ret.setPaid(input.getPaid());
		ret.setAdminUser(input.getAdminUser());
		if ((String.valueOf(input.getAmount()).indexOf("NaN") < 0) && (String.valueOf(input.getAmount()).indexOf("Inf") < 0)) {
			ret.setAmount(input.getAmount());
		}

		if (input.getPaidTime() != null) {
			ret.setPaidTime(new Timestamp(input.getPaidTime().getTime()));
		}

		ret.setAdminNote(input.getAdminNote());
		ret.setUserNote(input.getUserNote());
		ret.setProcessType(input.getProcessType());
		return ret;
	}

	public com.jcommerce.ws.server.UserAccount getWSDLUserAccount(com.jcommerce.core.model.UserAccount input) {
		com.jcommerce.ws.server.UserAccount ret = new com.jcommerce.ws.server.UserAccount();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setAddTime(input.getAddTime());
		ret.setPayment(input.getPayment());
		ret.setPaid(input.isPaid());
		ret.setAdminUser(input.getAdminUser());
		ret.setAmount(input.getAmount());
		ret.setPaidTime(input.getPaidTime());
		ret.setAdminNote(input.getAdminNote());
		ret.setUserNote(input.getUserNote());
		ret.setProcessType(input.getProcessType());
		return ret;
	}

	public com.jcommerce.core.model.UserAccount[] getCoreUserAccountList(com.jcommerce.ws.server.UserAccount[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.UserAccount[] retList = new com.jcommerce.core.model.UserAccount[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreUserAccount(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.UserAccount[] getWSDLUserAccountList(com.jcommerce.core.model.UserAccount[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.UserAccount[] retList = new com.jcommerce.ws.server.UserAccount[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLUserAccount(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.UserAddress getCoreUserAddress(com.jcommerce.ws.server.UserAddress input) {
		com.jcommerce.core.model.UserAddress ret = new com.jcommerce.core.model.UserAddress();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setEmail(input.getEmail());
		ret.setRegion((com.jcommerce.core.model.Region) (dbAccessImpl.getBean0("Region", String.valueOf(input.getRegion()))));
		ret.setConsignee(input.getConsignee());
		ret.setZip(input.getZip());
		ret.setPhone(input.getPhone());
		ret.setMobile(input.getMobile());
		ret.setSignBuilding(input.getSignBuilding());
		ret.setBestTime(input.getBestTime());
		ret.setName(input.getName());
		ret.setAddress(input.getAddress());
		return ret;
	}

	public com.jcommerce.ws.server.UserAddress getWSDLUserAddress(com.jcommerce.core.model.UserAddress input) {
		com.jcommerce.ws.server.UserAddress ret = new com.jcommerce.ws.server.UserAddress();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		ret.setEmail(input.getEmail());
		if (input.getRegion() != null) {
			ret.setRegion(input.getRegion().getId());
		}
		ret.setConsignee(input.getConsignee());
		ret.setZip(input.getZip());
		ret.setPhone(input.getPhone());
		ret.setMobile(input.getMobile());
		ret.setSignBuilding(input.getSignBuilding());
		ret.setBestTime(input.getBestTime());
		ret.setName(input.getName());
		ret.setAddress(input.getAddress());
		return ret;
	}

	public com.jcommerce.core.model.UserAddress[] getCoreUserAddressList(com.jcommerce.ws.server.UserAddress[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.UserAddress[] retList = new com.jcommerce.core.model.UserAddress[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreUserAddress(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.UserAddress[] getWSDLUserAddressList(com.jcommerce.core.model.UserAddress[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.UserAddress[] retList = new com.jcommerce.ws.server.UserAddress[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLUserAddress(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.UserBonus getCoreUserBonus(com.jcommerce.ws.server.UserBonus input) {
		com.jcommerce.core.model.UserBonus ret = new com.jcommerce.core.model.UserBonus();
		ret.setId(input.getId());
		ret.setUser((com.jcommerce.core.model.User) (dbAccessImpl.getBean0("User", String.valueOf(input.getUser()))));
		ret.setOrder((com.jcommerce.core.model.Order) (dbAccessImpl.getBean0("Order", String.valueOf(input.getOrder()))));
		ret.setBonusSN(input.getBonusSN());
		if (input.getUsedTime() != null) {
			ret.setUsedTime(new Timestamp(input.getUsedTime().getTime()));
		}

		ret.setEmailed(input.getEmailed());
		ret.setType((com.jcommerce.core.model.BonusType) (dbAccessImpl.getBean0("BonusType", String.valueOf(input.getType()))));
		return ret;
	}

	public com.jcommerce.ws.server.UserBonus getWSDLUserBonus(com.jcommerce.core.model.UserBonus input) {
		com.jcommerce.ws.server.UserBonus ret = new com.jcommerce.ws.server.UserBonus();
		ret.setId(input.getId());
		if (input.getUser() != null) {
			ret.setUser(input.getUser().getId());
		}
		if (input.getOrder() != null) {
			ret.setOrder(input.getOrder().getId());
		}
		ret.setBonusSN(input.getBonusSN());
		ret.setUsedTime(input.getUsedTime());
		ret.setEmailed(input.isEmailed());
		if (input.getType() != null) {
			ret.setType(input.getType().getId());
		}
		return ret;
	}

	public com.jcommerce.core.model.UserBonus[] getCoreUserBonusList(com.jcommerce.ws.server.UserBonus[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.UserBonus[] retList = new com.jcommerce.core.model.UserBonus[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreUserBonus(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.UserBonus[] getWSDLUserBonusList(com.jcommerce.core.model.UserBonus[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.UserBonus[] retList = new com.jcommerce.ws.server.UserBonus[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLUserBonus(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.UserRank getCoreUserRank(com.jcommerce.ws.server.UserRank input) {
		com.jcommerce.core.model.UserRank ret = new com.jcommerce.core.model.UserRank();
		ret.setId(input.getId());
		ret.setSpecial(input.getSpecial());
		ret.setDiscount(input.getDiscount());
		ret.setMaxPoints(input.getMaxPoints());
		ret.setMinPoints(input.getMinPoints());
		ret.setShowPrice(input.getShowPrice());
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.ws.server.UserRank getWSDLUserRank(com.jcommerce.core.model.UserRank input) {
		com.jcommerce.ws.server.UserRank ret = new com.jcommerce.ws.server.UserRank();
		ret.setId(input.getId());
		ret.setSpecial(input.isSpecial());
		ret.setDiscount(input.getDiscount());
		ret.setMaxPoints(input.getMaxPoints());
		ret.setMinPoints(input.getMinPoints());
		ret.setShowPrice(input.isShowPrice());
		ret.setName(input.getName());
		return ret;
	}

	public com.jcommerce.core.model.UserRank[] getCoreUserRankList(com.jcommerce.ws.server.UserRank[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.UserRank[] retList = new com.jcommerce.core.model.UserRank[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreUserRank(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.UserRank[] getWSDLUserRankList(com.jcommerce.core.model.UserRank[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.UserRank[] retList = new com.jcommerce.ws.server.UserRank[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLUserRank(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.VirtualCard getCoreVirtualCard(com.jcommerce.ws.server.VirtualCard input) {
		com.jcommerce.core.model.VirtualCard ret = new com.jcommerce.core.model.VirtualCard();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setCardSn(input.getCardSn());
		ret.setCardPassword(input.getCardPassword());
		if (input.getAddDate() != null) {
			ret.setAddDate(new Timestamp(input.getAddDate().getTime()));
		}

		if (input.getEndDate() != null) {
			ret.setEndDate(new Timestamp(input.getEndDate().getTime()));
		}

		ret.setOrderSn(input.getOrderSn());
		ret.setCrc32(input.getCrc32());
		ret.setSold(input.getSold());
		return ret;
	}

	public com.jcommerce.ws.server.VirtualCard getWSDLVirtualCard(com.jcommerce.core.model.VirtualCard input) {
		com.jcommerce.ws.server.VirtualCard ret = new com.jcommerce.ws.server.VirtualCard();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setCardSn(input.getCardSn());
		ret.setCardPassword(input.getCardPassword());
		ret.setAddDate(input.getAddDate());
		ret.setEndDate(input.getEndDate());
		ret.setOrderSn(input.getOrderSn());
		ret.setCrc32(input.getCrc32());
		ret.setSold(input.isSold());
		return ret;
	}

	public com.jcommerce.core.model.VirtualCard[] getCoreVirtualCardList(com.jcommerce.ws.server.VirtualCard[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.VirtualCard[] retList = new com.jcommerce.core.model.VirtualCard[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreVirtualCard(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.VirtualCard[] getWSDLVirtualCardList(com.jcommerce.core.model.VirtualCard[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.VirtualCard[] retList = new com.jcommerce.ws.server.VirtualCard[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLVirtualCard(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Vote getCoreVote(com.jcommerce.ws.server.Vote input) {
		com.jcommerce.core.model.Vote ret = new com.jcommerce.core.model.Vote();
		ret.setId(input.getId());
		if (input.getEndTime() != null) {
			ret.setEndTime(new Timestamp(input.getEndTime().getTime()));
		}

		ret.setVoteName(input.getVoteName());
		ret.setVoteCount(input.getVoteCount());
		ret.setMultipleSelection(input.getMultipleSelection());
		if (input.getStartTime() != null) {
			ret.setStartTime(new Timestamp(input.getStartTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.Vote getWSDLVote(com.jcommerce.core.model.Vote input) {
		com.jcommerce.ws.server.Vote ret = new com.jcommerce.ws.server.Vote();
		ret.setId(input.getId());
		ret.setEndTime(input.getEndTime());
		ret.setVoteName(input.getVoteName());
		ret.setVoteCount(input.getVoteCount());
		ret.setMultipleSelection(input.isMultipleSelection());
		ret.setStartTime(input.getStartTime());
		return ret;
	}

	public com.jcommerce.core.model.Vote[] getCoreVoteList(com.jcommerce.ws.server.Vote[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Vote[] retList = new com.jcommerce.core.model.Vote[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreVote(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Vote[] getWSDLVoteList(com.jcommerce.core.model.Vote[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Vote[] retList = new com.jcommerce.ws.server.Vote[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLVote(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.VoteData getCoreVoteData(com.jcommerce.ws.server.VoteData input) {
		com.jcommerce.core.model.VoteData ret = new com.jcommerce.core.model.VoteData();
		ret.setId(input.getId());
		ret.setVote((com.jcommerce.core.model.Vote) (dbAccessImpl.getBean0("Vote", String.valueOf(input.getVote()))));
		ret.setItemName(input.getItemName());
		ret.setItemCount(input.getItemCount());
		return ret;
	}

	public com.jcommerce.ws.server.VoteData getWSDLVoteData(com.jcommerce.core.model.VoteData input) {
		com.jcommerce.ws.server.VoteData ret = new com.jcommerce.ws.server.VoteData();
		ret.setId(input.getId());
		if (input.getVote() != null) {
			ret.setVote(input.getVote().getId());
		}
		ret.setItemName(input.getItemName());
		ret.setItemCount(input.getItemCount());
		return ret;
	}

	public com.jcommerce.core.model.VoteData[] getCoreVoteDataList(com.jcommerce.ws.server.VoteData[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.VoteData[] retList = new com.jcommerce.core.model.VoteData[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreVoteData(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.VoteData[] getWSDLVoteDataList(com.jcommerce.core.model.VoteData[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.VoteData[] retList = new com.jcommerce.ws.server.VoteData[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLVoteData(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.VoteLog getCoreVoteLog(com.jcommerce.ws.server.VoteLog input) {
		com.jcommerce.core.model.VoteLog ret = new com.jcommerce.core.model.VoteLog();
		ret.setId(input.getId());
		ret.setIpAddress(input.getIpAddress());
		ret.setVote((com.jcommerce.core.model.Vote) (dbAccessImpl.getBean0("Vote", String.valueOf(input.getVote()))));
		if (input.getVoteTime() != null) {
			ret.setVoteTime(new Timestamp(input.getVoteTime().getTime()));
		}

		return ret;
	}

	public com.jcommerce.ws.server.VoteLog getWSDLVoteLog(com.jcommerce.core.model.VoteLog input) {
		com.jcommerce.ws.server.VoteLog ret = new com.jcommerce.ws.server.VoteLog();
		ret.setId(input.getId());
		ret.setIpAddress(input.getIpAddress());
		if (input.getVote() != null) {
			ret.setVote(input.getVote().getId());
		}
		ret.setVoteTime(input.getVoteTime());
		return ret;
	}

	public com.jcommerce.core.model.VoteLog[] getCoreVoteLogList(com.jcommerce.ws.server.VoteLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.VoteLog[] retList = new com.jcommerce.core.model.VoteLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreVoteLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.VoteLog[] getWSDLVoteLogList(com.jcommerce.core.model.VoteLog[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.VoteLog[] retList = new com.jcommerce.ws.server.VoteLog[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLVoteLog(input[i]);
		}
		return retList;
	}

	public com.jcommerce.core.model.Wholesale getCoreWholesale(com.jcommerce.ws.server.Wholesale input) {
		com.jcommerce.core.model.Wholesale ret = new com.jcommerce.core.model.Wholesale();
		ret.setId(input.getId());
		ret.setGoods((com.jcommerce.core.model.Goods) (dbAccessImpl.getBean0("Goods", String.valueOf(input.getGoods()))));
		ret.setGoodsName(input.getGoodsName());
		ret.setRankIds(input.getRankIds());
		ret.setPrices(input.getPrices());
		ret.setEnabled(input.getEnabled());
		return ret;
	}

	public com.jcommerce.ws.server.Wholesale getWSDLWholesale(com.jcommerce.core.model.Wholesale input) {
		com.jcommerce.ws.server.Wholesale ret = new com.jcommerce.ws.server.Wholesale();
		ret.setId(input.getId());
		if (input.getGoods() != null) {
			ret.setGoods(input.getGoods().getId());
		}
		ret.setGoodsName(input.getGoodsName());
		ret.setRankIds(input.getRankIds());
		ret.setPrices(input.getPrices());
		ret.setEnabled(input.isEnabled());
		return ret;
	}

	public com.jcommerce.core.model.Wholesale[] getCoreWholesaleList(com.jcommerce.ws.server.Wholesale[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.core.model.Wholesale[] retList = new com.jcommerce.core.model.Wholesale[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getCoreWholesale(input[i]);
		}
		return retList;
	}

	public com.jcommerce.ws.server.Wholesale[] getWSDLWholesaleList(com.jcommerce.core.model.Wholesale[] input) {
		if ((input == null) || (input.length == 0)) {
			return null;
		}
		com.jcommerce.ws.server.Wholesale[] retList = new com.jcommerce.ws.server.Wholesale[input.length];
		for (int i = 0; i < input.length; i++) {
			retList[i] = getWSDLWholesale(input[i]);
		}
		return retList;
	}

}
