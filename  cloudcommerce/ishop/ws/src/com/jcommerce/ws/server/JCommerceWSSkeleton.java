/**
 * JCommerceWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package com.jcommerce.ws.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.jcommerce.core.model.*;
import org.apache.axiom.om.*;
import org.apache.axiom.om.xpath.AXIOMXPath;
import com.jcommerce.ws.agent.impl.DBAccessImpl;
import com.jcommerce.ws.agent.impl.AdapterImpl;
import org.apache.axis2.context.*;
import com.jcommerce.core.service.Criteria;

/**
 * JCommerceWSSkeleton java skeleton for the axisService
 */
public class JCommerceWSSkeleton {

	DBAccessImpl dbImpl = null;
	AdapterImpl adapterImpl = null;
	private static final String DBACCESS_CLASS = "dbImpl";
	private static final String ADAPTER_CLASS = "adapterImpl";
	private static final String EMPTY_STR = "";

	/**
	 * every request will create a new dbImpl and adapterImpl by default.it is
	 * not good. so dbImpl and adapterImpl should be stored in
	 * configurationContext
	 * 
	 * @return
	 */
	private DBAccessImpl getDBAccessImpl() {
		if (dbImpl == null) {
			System.out.println("dbImpl == null..........");
			return dbImpl = new DBAccessImpl();
		} else {
			System.out.println("dbImpl exist..........");
			return dbImpl;
		}
	}

	private AdapterImpl getAdapterImpl() {
		if (adapterImpl == null) {
			System.out.println("adapterImpl == null..........");
			return adapterImpl = new AdapterImpl(dbImpl);
		} else {
			System.out.println("adapterImpl exist..........");
			return adapterImpl;
		}
	}

	private boolean getAllImpl() {
		System.out.println("getAllImpl..........");
		MessageContext context = MessageContext.getCurrentMessageContext();
		if ((context.getConfigurationContext().getProperty(DBACCESS_CLASS) == null) || (context.getConfigurationContext().getProperty(ADAPTER_CLASS) == null)) {
			return false;
		}
		return true;
	}

	/**
	 * store all impl into configurationContext
	 */
	private void iniAllImplInContext() {
		System.out.println("iniAllImplInContext..........");
		MessageContext context = MessageContext.getCurrentMessageContext();
		context.getConfigurationContext().setProperty(DBACCESS_CLASS, dbImpl);
		context.getConfigurationContext().setProperty(ADAPTER_CLASS, adapterImpl);
	}

	private void setAllImpl() {
		System.out.println("setAllImpl..........");
		MessageContext context = MessageContext.getCurrentMessageContext();
		dbImpl = (DBAccessImpl) (context.getConfigurationContext().getProperty(DBACCESS_CLASS));
		adapterImpl = (AdapterImpl) (context.getConfigurationContext().getProperty(ADAPTER_CLASS));
	}

	/**
	 * parse all nodes in the second level under REQUEST node ,for instance, Goods, Brand, etc.
	 * note find out from dubug process: 1, if a int field is empty, for instance, ws:id field in soap message is not filled, then soap message received in serve side should not contain this id node. 
	 * for instance id, sortOrder in Brand.
	 * 
	 * @return
	 */
	public HashMap<String, String> parseSingleAnyInRequest(OMElement root, String type) {
		HashMap<String, String> props = new HashMap<String, String>();
		try {
			// AXIOMXPath xpath = new AXIOMXPath(
			// "/soapenv:Envelope/soapenv:Body/ws:REQUEST/*/ws:"+ type);
			AXIOMXPath xpath = new AXIOMXPath("//./ws:" + type);
			xpath.addNamespace("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			xpath.addNamespace("ws", "http://ws.jcommerce.com/");

			List nodeList = xpath.selectNodes(root);
			System.out.println("nodeList size is " + nodeList.size());
			for (int i = 0; i < nodeList.size(); i++) {
				OMElement selectedNode = (OMElement) nodeList.get(i);
				System.out.println("******selectedNode type is" + selectedNode.getType());
				System.out.println("******selectedNode " + selectedNode.getLocalName());
				Iterator itorse = selectedNode.getChildElements();
				System.out.println("******firstnode " + selectedNode.getFirstElement().getLocalName());
				while (itorse.hasNext()) {
					OMNode node = (OMNode) itorse.next();
					System.out.println("itor hasnext...type is" + node.getType());
					if (node.getType() == OMNode.ELEMENT_NODE) {
						System.out.println("================================");
						OMElement omElement = (OMElement) node;
						String fieldName = omElement.getLocalName();
						String fieldValue = omElement.getText();
						System.out.println(omElement.getLocalName());
						System.out.println(omElement.getText());
						props.put(fieldName, fieldValue);
						System.out.println("================================");
					}

				}
			}
			System.out.println("end..");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}

	/**
	 * Auto generated method signature root points to REQUEST node.
	 * note: (com.jcommerce.core.model.Brand[]) objList.toArray() is not correct. (objList type is List<ModelObject>)
	 * an class cast error will be generated. ModelObject-->Brand must use objList.toArray(coreBrandList)
	 * com.jcommerce.core.model.Brand[] coreBrandList
	 * 
	 * @param rEQUEST
	 */

	public com.jcommerce.ws.server.RESPONSE OPERATION(com.jcommerce.ws.server.REQUEST request) {
		System.out.println("receive the request....");
		loadDBDriver();
		if (getAllImpl() == false) {
			dbImpl = getDBAccessImpl();
			adapterImpl = getAdapterImpl();
			iniAllImplInContext();
		} else {
			setAllImpl();
		}
		if ((dbImpl == null) || (adapterImpl == null)) {
			System.out.println("dbImpl or adapterImpl is null ....");
		}

		RESPONSE response = new RESPONSE();
		XXXRESP xxxResp = new XXXRESP();

		String commandType = request.getREQUEST().getCommandType().getValue();
		String targetType = request.getREQUEST().getTargetType().getValue();
		int count = 0;
		int start = 0;
		int totalNumber = 0;
		// newObjId value from insert operation.
		String newObjId = "-1";
		try {
			// call getList, multi object returned form db
			System.out.println("...objList...");
			List<ModelObject> objList = new ArrayList<ModelObject>();
			ModelObject[] coreObj = parseModelInRequest(request);
			System.out.println("...coreObj...");
			String id;
			if (coreObj != null) {
				id = dbImpl.getId(coreObj[0]);
			} else {
				if (commandType.equals("read")) {
					id = EMPTY_STR;
					if (request.getREQUEST().getReadCount() != null) {
						count = request.getREQUEST().getReadCount().getCount();
						start = request.getREQUEST().getReadCount().getStart();
					} else {
						count = 0;
						start = 0;
					}
					if (start == 0) {
						QueryCriteria criteria = request.getREQUEST().getCriteria();
						Criteria coreCriteria = null;
						if (criteria != null) {
							QueryCondition[] conditions = criteria.getCondition();
							QueryOrder[] orders = criteria.getOrder();
							coreCriteria = adapterImpl.getCoreCriteria(conditions, orders);
							if(coreCriteria != null){
								totalNumber = dbImpl.getTotalCount(targetType, coreCriteria);
							}else{
								totalNumber = dbImpl.getTotalCount(targetType);
							}
						} else {
							totalNumber = dbImpl.getTotalCount(targetType);
						}					
						xxxResp.setTotalNumber(totalNumber);
					}
					System.out.println("id is empty, query all! count = " + count + "start = " + start);
				} else {
					throw new java.lang.IllegalArgumentException("objList must not be empty in write operation!");
				}
			}
			System.out.println("id = " + id);
			if (commandType.equals("read")) {
				System.out.println("dbImpl.getListObj(targetType, id,count,start,criteria)");
				QueryCriteria criteria = request.getREQUEST().getCriteria();
				Criteria coreCriteria = null;
				if (criteria != null) {
					QueryCondition[] conditions = criteria.getCondition();
					QueryOrder[] orders = criteria.getOrder();
					coreCriteria = adapterImpl.getCoreCriteria(conditions, orders);
				} else {
					coreCriteria = adapterImpl.createDefaultCriteria();
				}
				objList = dbImpl.getListObj(targetType, id, count, start, coreCriteria);
				if ((objList == null) || (objList.size() == 0)) {
					// TODO
				} else {
					createReadResp(targetType, objList, xxxResp);
				}
			}
			if (commandType.equals("insert")) {
				newObjId = dbImpl.newObject(targetType, coreObj[0]);
				xxxResp.setObjId(Integer.parseInt(newObjId));
			}
			if (commandType.equals("update")) {
				if (id.trim().equals(EMPTY_STR)) {
					throw new java.lang.IllegalArgumentException("id must not be empty in update operation!");
				} else {
					dbImpl.updateObject(targetType, coreObj[0]);
				}
			}
			if (commandType.equals("delete")) {
				if (id.trim().equals(EMPTY_STR)) {
					throw new java.lang.IllegalArgumentException("id must not be empty in delete operation!");
				} else {
					dbImpl.deleteObject(targetType, id);
				}
			}
			if (commandType.equals("upsert")) {
				throw new java.lang.UnsupportedOperationException("upsert operation");
			}
			StatusType status = new StatusType();
			status.setCode(200);
			status.setMessage("OK");
			xxxResp.setStatus(status);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			StatusType status = new StatusType();
			status.setCode(400);
			status.setMessage(e.getMessage());
			xxxResp.setStatus(status);
		}
		response.setRESPONSE(xxxResp);
		System.out.println("return the reponse....");
		return response;
	}

	private ModelObject[] parseModelInRequest(com.jcommerce.ws.server.REQUEST request) {
		System.out.println("parseModelInRequest...");
		ModelObject[] ret = null;
		String targetType = request.getREQUEST().getTargetType().getValue();
		XXXREQChoice_type0 choice = request.getREQUEST().getXXXREQChoice_type0();
		if (choice != null) {
			if (targetType.equals("AccountLog")) {
				if (choice.getAccountLogList() != null) {
					ret = adapterImpl.getCoreAccountLogList(choice.getAccountLogList().getAccountLog());
				}
			}
			if (targetType.equals("AdminAction")) {
				if (choice.getAdminActionList() != null) {
					ret = adapterImpl.getCoreAdminActionList(choice.getAdminActionList().getAdminAction());
				}
			}
			if (targetType.equals("AdminLog")) {
				if (choice.getAdminLogList() != null) {
					ret = adapterImpl.getCoreAdminLogList(choice.getAdminLogList().getAdminLog());
				}
			}
			if (targetType.equals("AdminMessage")) {
				if (choice.getAdminMessageList() != null) {
					ret = adapterImpl.getCoreAdminMessageList(choice.getAdminMessageList().getAdminMessage());
				}
			}
			if (targetType.equals("AdminUser")) {
				if (choice.getAdminUserList() != null) {
					ret = adapterImpl.getCoreAdminUserList(choice.getAdminUserList().getAdminUser());
				}
			}
			if (targetType.equals("AdPosition")) {
				if (choice.getAdPositionList() != null) {
					ret = adapterImpl.getCoreAdPositionList(choice.getAdPositionList().getAdPosition());
				}
			}
			if (targetType.equals("Adsense")) {
				if (choice.getAdsenseList() != null) {
					ret = adapterImpl.getCoreAdsenseList(choice.getAdsenseList().getAdsense());
				}
			}
			if (targetType.equals("Advertisement")) {
				if (choice.getAdvertisementList() != null) {
					ret = adapterImpl.getCoreAdvertisementList(choice.getAdvertisementList().getAdvertisement());
				}
			}
			if (targetType.equals("AffiliateLog")) {
				if (choice.getAffiliateLogList() != null) {
					ret = adapterImpl.getCoreAffiliateLogList(choice.getAffiliateLogList().getAffiliateLog());
				}
			}
			if (targetType.equals("Agency")) {
				if (choice.getAgencyList() != null) {
					ret = adapterImpl.getCoreAgencyList(choice.getAgencyList().getAgency());
				}
			}
			if (targetType.equals("Article")) {
				if (choice.getArticleList() != null) {
					ret = adapterImpl.getCoreArticleList(choice.getArticleList().getArticle());
				}
			}
			if (targetType.equals("ArticleCategory")) {
				if (choice.getArticleCategoryList() != null) {
					ret = adapterImpl.getCoreArticleCategoryList(choice.getArticleCategoryList().getArticleCategory());
				}
			}
			if (targetType.equals("Attribute")) {
				if (choice.getAttributeList() != null) {
					ret = adapterImpl.getCoreAttributeList(choice.getAttributeList().getAttribute());
				}
			}
			if (targetType.equals("AuctionLog")) {
				if (choice.getAuctionLogList() != null) {
					ret = adapterImpl.getCoreAuctionLogList(choice.getAuctionLogList().getAuctionLog());
				}
			}
			if (targetType.equals("AutoManage")) {
				if (choice.getAutoManageList() != null) {
					ret = adapterImpl.getCoreAutoManageList(choice.getAutoManageList().getAutoManage());
				}
			}
			if (targetType.equals("BonusType")) {
				if (choice.getBonusTypeList() != null) {
					ret = adapterImpl.getCoreBonusTypeList(choice.getBonusTypeList().getBonusType());
				}
			}
			if (targetType.equals("BookingGoods")) {
				if (choice.getBookingGoodsList() != null) {
					ret = adapterImpl.getCoreBookingGoodsList(choice.getBookingGoodsList().getBookingGoods());
				}
			}
			if (targetType.equals("Brand")) {
				if (choice.getBrandList() != null) {
					ret = adapterImpl.getCoreBrandList(choice.getBrandList().getBrand());
				}
			}
			if (targetType.equals("Card")) {
				if (choice.getCardList() != null) {
					ret = adapterImpl.getCoreCardList(choice.getCardList().getCard());
				}
			}
			if (targetType.equals("Cart")) {
				if (choice.getCartList() != null) {
					ret = adapterImpl.getCoreCartList(choice.getCartList().getCart());
				}
			}
			if (targetType.equals("Category")) {
				if (choice.getCategoryList() != null) {
					ret = adapterImpl.getCoreCategoryList(choice.getCategoryList().getCategory());
				}
			}
			if (targetType.equals("CollectGoods")) {
				if (choice.getCollectGoodsList() != null) {
					ret = adapterImpl.getCoreCollectGoodsList(choice.getCollectGoodsList().getCollectGoods());
				}
			}
			if (targetType.equals("Comment")) {
				if (choice.getCommentList() != null) {
					ret = adapterImpl.getCoreCommentList(choice.getCommentList().getComment());
				}
			}
			if (targetType.equals("Crons")) {
				if (choice.getCronsList() != null) {
					ret = adapterImpl.getCoreCronsList(choice.getCronsList().getCrons());
				}
			}
			if (targetType.equals("EmailList")) {
				if (choice.getEmailListList() != null) {
					ret = adapterImpl.getCoreEmailListList(choice.getEmailListList().getEmailList());
				}
			}
			if (targetType.equals("EmailSendList")) {
				if (choice.getEmailSendListList() != null) {
					ret = adapterImpl.getCoreEmailSendListList(choice.getEmailSendListList().getEmailSendList());
				}
			}
			if (targetType.equals("ErrorLog")) {
				if (choice.getErrorLogList() != null) {
					ret = adapterImpl.getCoreErrorLogList(choice.getErrorLogList().getErrorLog());
				}
			}
			if (targetType.equals("FailedLogin")) {
				if (choice.getFailedLoginList() != null) {
					ret = adapterImpl.getCoreFailedLoginList(choice.getFailedLoginList().getFailedLogin());
				}
			}
			if (targetType.equals("FavourableActivity")) {
				if (choice.getFavourableActivityList() != null) {
					ret = adapterImpl.getCoreFavourableActivityList(choice.getFavourableActivityList().getFavourableActivity());
				}
			}
			if (targetType.equals("Feedback")) {
				if (choice.getFeedbackList() != null) {
					ret = adapterImpl.getCoreFeedbackList(choice.getFeedbackList().getFeedback());
				}
			}
			if (targetType.equals("FriendLink")) {
				if (choice.getFriendLinkList() != null) {
					ret = adapterImpl.getCoreFriendLinkList(choice.getFriendLinkList().getFriendLink());
				}
			}
			if (targetType.equals("Gallery")) {
				if (choice.getGalleryList() != null) {
					ret = adapterImpl.getCoreGalleryList(choice.getGalleryList().getGallery());
				}
			}
			if (targetType.equals("Goods")) {
				if (choice.getGoodsList() != null) {
					ret = adapterImpl.getCoreGoodsList(choice.getGoodsList().getGoods());
				}
			}
			if (targetType.equals("GoodsActivity")) {
				if (choice.getGoodsActivityList() != null) {
					ret = adapterImpl.getCoreGoodsActivityList(choice.getGoodsActivityList().getGoodsActivity());
				}
			}
			if (targetType.equals("GoodsArticle")) {
				if (choice.getGoodsArticleList() != null) {
					ret = adapterImpl.getCoreGoodsArticleList(choice.getGoodsArticleList().getGoodsArticle());
				}
			}
			if (targetType.equals("GoodsAttribute")) {
				if (choice.getGoodsAttributeList() != null) {
					ret = adapterImpl.getCoreGoodsAttributeList(choice.getGoodsAttributeList().getGoodsAttribute());
				}
			}
			if (targetType.equals("GoodsType")) {
				if (choice.getGoodsTypeList() != null) {
					ret = adapterImpl.getCoreGoodsTypeList(choice.getGoodsTypeList().getGoodsType());
				}
			}
			if (targetType.equals("GroupGoods")) {
				if (choice.getGroupGoodsList() != null) {
					ret = adapterImpl.getCoreGroupGoodsList(choice.getGroupGoodsList().getGroupGoods());
				}
			}
			if (targetType.equals("Keywords")) {
				if (choice.getKeywordsList() != null) {
					ret = adapterImpl.getCoreKeywordsList(choice.getKeywordsList().getKeywords());
				}
			}
			if (targetType.equals("LinkGoods")) {
				if (choice.getLinkGoodsList() != null) {
					ret = adapterImpl.getCoreLinkGoodsList(choice.getLinkGoodsList().getLinkGoods());
				}
			}
			if (targetType.equals("MailTemplate")) {
				if (choice.getMailTemplateList() != null) {
					ret = adapterImpl.getCoreMailTemplateList(choice.getMailTemplateList().getMailTemplate());
				}
			}
			if (targetType.equals("MemberPrice")) {
				if (choice.getMemberPriceList() != null) {
					ret = adapterImpl.getCoreMemberPriceList(choice.getMemberPriceList().getMemberPrice());
				}
			}
			if (targetType.equals("Navigation")) {
				if (choice.getNavigationList() != null) {
					ret = adapterImpl.getCoreNavigationList(choice.getNavigationList().getNavigation());
				}
			}
			if (targetType.equals("Order")) {
				if (choice.getOrderList() != null) {
					ret = adapterImpl.getCoreOrderList(choice.getOrderList().getOrder());
				}
			}
			if (targetType.equals("OrderAction")) {
				if (choice.getOrderActionList() != null) {
					ret = adapterImpl.getCoreOrderActionList(choice.getOrderActionList().getOrderAction());
				}
			}
			if (targetType.equals("OrderGoods")) {
				if (choice.getOrderGoodsList() != null) {
					ret = adapterImpl.getCoreOrderGoodsList(choice.getOrderGoodsList().getOrderGoods());
				}
			}
			if (targetType.equals("Pack")) {
				if (choice.getPackList() != null) {
					ret = adapterImpl.getCorePackList(choice.getPackList().getPack());
				}
			}
			if (targetType.equals("PayLog")) {
				if (choice.getPayLogList() != null) {
					ret = adapterImpl.getCorePayLogList(choice.getPayLogList().getPayLog());
				}
			}
			if (targetType.equals("Payment")) {
				if (choice.getPaymentList() != null) {
					ret = adapterImpl.getCorePaymentList(choice.getPaymentList().getPayment());
				}
			}
			if (targetType.equals("Plugins")) {
				if (choice.getPluginsList() != null) {
					ret = adapterImpl.getCorePluginsList(choice.getPluginsList().getPlugins());
				}
			}
			if (targetType.equals("Region")) {
				if (choice.getRegionList() != null) {
					ret = adapterImpl.getCoreRegionList(choice.getRegionList().getRegion());
				}
			}
			if (targetType.equals("SearchEngine")) {
				if (choice.getSearchEngineList() != null) {
					ret = adapterImpl.getCoreSearchEngineList(choice.getSearchEngineList().getSearchEngine());
				}
			}
			if (targetType.equals("Session")) {
				if (choice.getSessionList() != null) {
					ret = adapterImpl.getCoreSessionList(choice.getSessionList().getSession());
				}
			}
			if (targetType.equals("SessionsData")) {
				if (choice.getSessionsDataList() != null) {
					ret = adapterImpl.getCoreSessionsDataList(choice.getSessionsDataList().getSessionsData());
				}
			}
			if (targetType.equals("Shipping")) {
				if (choice.getShippingList() != null) {
					ret = adapterImpl.getCoreShippingList(choice.getShippingList().getShipping());
				}
			}
			if (targetType.equals("ShippingArea")) {
				if (choice.getShippingAreaList() != null) {
					ret = adapterImpl.getCoreShippingAreaList(choice.getShippingAreaList().getShippingArea());
				}
			}
			if (targetType.equals("ShopConfig")) {
				if (choice.getShopConfigList() != null) {
					ret = adapterImpl.getCoreShopConfigList(choice.getShopConfigList().getShopConfig());
				}
			}
			if (targetType.equals("SnatchLog")) {
				if (choice.getSnatchLogList() != null) {
					ret = adapterImpl.getCoreSnatchLogList(choice.getSnatchLogList().getSnatchLog());
				}
			}
			if (targetType.equals("Stats")) {
				if (choice.getStatsList() != null) {
					ret = adapterImpl.getCoreStatsList(choice.getStatsList().getStats());
				}
			}
			if (targetType.equals("Tag")) {
				if (choice.getTagList() != null) {
					ret = adapterImpl.getCoreTagList(choice.getTagList().getTag());
				}
			}
			if (targetType.equals("Topic")) {
				if (choice.getTopicList() != null) {
					ret = adapterImpl.getCoreTopicList(choice.getTopicList().getTopic());
				}
			}
			if (targetType.equals("User")) {
				if (choice.getUserList() != null) {
					ret = adapterImpl.getCoreUserList(choice.getUserList().getUser());
				}
			}
			if (targetType.equals("UserAccount")) {
				if (choice.getUserAccountList() != null) {
					ret = adapterImpl.getCoreUserAccountList(choice.getUserAccountList().getUserAccount());
				}
			}
			if (targetType.equals("UserAddress")) {
				if (choice.getUserAddressList() != null) {
					ret = adapterImpl.getCoreUserAddressList(choice.getUserAddressList().getUserAddress());
				}
			}
			if (targetType.equals("UserBonus")) {
				if (choice.getUserBonusList() != null) {
					ret = adapterImpl.getCoreUserBonusList(choice.getUserBonusList().getUserBonus());
				}
			}
			if (targetType.equals("UserRank")) {
				if (choice.getUserRankList() != null) {
					ret = adapterImpl.getCoreUserRankList(choice.getUserRankList().getUserRank());
				}
			}
			if (targetType.equals("VirtualCard")) {
				if (choice.getVirtualCardList() != null) {
					ret = adapterImpl.getCoreVirtualCardList(choice.getVirtualCardList().getVirtualCard());
				}
			}
			if (targetType.equals("Vote")) {
				if (choice.getVoteList() != null) {
					ret = adapterImpl.getCoreVoteList(choice.getVoteList().getVote());
				}
			}
			if (targetType.equals("VoteData")) {
				if (choice.getVoteDataList() != null) {
					ret = adapterImpl.getCoreVoteDataList(choice.getVoteDataList().getVoteData());
				}
			}
			if (targetType.equals("VoteLog")) {
				if (choice.getVoteLogList() != null) {
					ret = adapterImpl.getCoreVoteLogList(choice.getVoteLogList().getVoteLog());
				}
			}
			if (targetType.equals("Wholesale")) {
				if (choice.getWholesaleList() != null) {
					ret = adapterImpl.getCoreWholesaleList(choice.getWholesaleList().getWholesale());
				}
			}
		}
		return ret;
	}

	/**
	 * call testDB to load sql driver. because dbAccessImpl load driver always
	 * generate 'no suitable driver' error
	 */
	private void loadDBDriver() {
		System.out.println("loadDBDriver...");
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

//	private com.jcommerce.ws.server.RESPONSE test(com.jcommerce.ws.server.REQUEST request) {
//		System.out.println("receive the request....");
//		System.out.println("begin parseSingleAnyInRequest....");
//		loadDBDriver();
//		OMFactory fac = OMAbstractFactory.getOMFactory();
//		try {
//			OMElement root = request.getOMElement(null, fac);
//			System.out.println(root.getLocalName());
//			System.out.println(root.getText());
//			OMElement child = root.getFirstElement();
//			System.out.println(child.getLocalName());
//			System.out.println(root.getNamespace().getNamespaceURI());
//			System.out.println(root.getNamespace().getPrefix());
//
//			Iterator itorse = root.getChildElements();
//			while (itorse.hasNext()) {
//				OMNode node = (OMNode) itorse.next();
//				System.out.println("...");
//
//				if (node.getType() == OMNode.ELEMENT_NODE) {
//					System.out.println("...1...");
//					OMElement omElement = (OMElement) node;
//					System.out.println(omElement.getLocalName());
//					System.out.println(omElement.getText());
//				}
//			}
//
//			HashMap<String, String> props = parseSingleAnyInRequest(root, "Brand");
//			System.out.println("create DBAccessImpl...");
//			DBAccessImpl dbImpl = new DBAccessImpl();
//			System.out.println("call newOBject...");
//			dbImpl.newObject("Brand", props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		RESPONSE response = new RESPONSE();
//		XXXRESP xxxResp = new XXXRESP();
//		BrandList brandList = new BrandList();
//		Brand[] list = new Brand[1];
//		for (int i = 0; i < list.length; i++) {
//			list[0] = new Brand();
//			list[0].setName("sunerniang");
//			list[0].setShow(true);
//			list[0].setSiteUrl("www.sunerniang.com");
//		}
//
//		brandList.setBrand(list);
//		xxxResp.setBrandList(brandList);
//		StatusType status = new StatusType();
//		status.setCode(200);
//		status.setMessage("OK");
//		xxxResp.setStatus(status);
//		xxxResp.setObjId(10);
//		response.setRESPONSE(xxxResp);
//		System.out.println("return the reponse....");
//		return response;
//		// TODO : fill this with the necessary business logic
//		// throw new java.lang.UnsupportedOperationException("Please implement "
//		// + this.getClass().getName() + "#OPERATION");
//	}

//	public com.jcommerce.ws.server.RESPONSE testOperationBaseXML(com.jcommerce.ws.server.REQUEST request) {
//		System.out.println("receive the request....");
//		loadDBDriver();
//		dbImpl = getDBAccessImpl();
//		adapterImpl = getAdapterImpl();
//		String commandType = request.getREQUEST().getCommandType().getValue();
//		String targetType = request.getREQUEST().getTargetType().getValue();
//		// newObjId value from insert operation.
//		String newObjId = "-1";
//		// call getbean, single object returned from db
//		HashMap<String, String> signleObj = new HashMap<String, String>();
//		// call getList, multi object returned form db
//		List<HashMap<String, String>> objList = new ArrayList<HashMap<String, String>>();
//		OMFactory fac = OMAbstractFactory.getOMFactory();
//		try {
//			OMElement root = request.getOMElement(null, fac);
//			System.out.println(root.getLocalName());
//			System.out.println(root.getText());
//			OMElement child = root.getFirstElement();
//			System.out.println(child.getLocalName());
//			System.out.println(root.getNamespace().getNamespaceURI());
//			System.out.println(root.getNamespace().getPrefix());
//
//			Iterator itorse = root.getChildElements();
//			while (itorse.hasNext()) {
//				OMNode node = (OMNode) itorse.next();
//				System.out.println("...");
//
//				if (node.getType() == OMNode.ELEMENT_NODE) {
//					System.out.println("...1...");
//					OMElement omElement = (OMElement) node;
//					System.out.println(omElement.getLocalName());
//					System.out.println(omElement.getText());
//				}
//			}
//
//			HashMap<String, String> props = parseSingleAnyInRequest(root, targetType);
//			String id = props.get("id");
//			System.out.println("create DBAccessImpl...");
//			System.out.println("id = " + id);
//			if (commandType.equals("read")) {
//				if (id.trim().equals("")) {
//					signleObj = dbImpl.getBean(targetType, id);
//				} else {
//					objList = dbImpl.getList(targetType);
//				}
//			}
//			if (commandType.equals("insert")) {
//				newObjId = dbImpl.newObject(targetType, props);
//			}
//			if (commandType.equals("update")) {
//				if (id.trim().equals("")) {
//					throw new java.lang.IllegalArgumentException("id must not be empty in update operation!");
//				} else {
//					dbImpl.updateObject(targetType, id, props);
//				}
//			}
//			if (commandType.equals("delete")) {
//				if (id.trim().equals("")) {
//					throw new java.lang.IllegalArgumentException("id must not be empty in delete operation!");
//				} else {
//					dbImpl.deleteObject(targetType, id);
//				}
//			}
//			if (commandType.equals("upsert")) {
//				throw new java.lang.UnsupportedOperationException("upsert operation");
//			}
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		RESPONSE response = new RESPONSE();
//		XXXRESP xxxResp = new XXXRESP();
//		BrandList brandList = new BrandList();
//		Brand[] list = new Brand[1];
//		for (int i = 0; i < list.length; i++) {
//			list[0] = new Brand();
//			list[0].setName("sunerniang");
//			list[0].setShow(true);
//			list[0].setSiteUrl("www.sunerniang.com");
//		}
//
//		brandList.setBrand(list);
//		xxxResp.setBrandList(brandList);
//		StatusType status = new StatusType();
//		status.setCode(200);
//		status.setMessage("OK");
//		xxxResp.setStatus(status);
//		xxxResp.setObjId(Integer.parseInt(newObjId));
//		response.setRESPONSE(xxxResp);
//		System.out.println("return the reponse....");
//		return response;
//		// TODO : fill this with the necessary business logic
//		// throw new java.lang.UnsupportedOperationException("Please implement "
//		// + this.getClass().getName() + "#OPERATION");
//	}

	private boolean validateMessage(com.jcommerce.ws.server.REQUEST request) {
		boolean bproceed = true;
		// TODO
		return bproceed;
	}

	private void createAccountLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AccountLog[] coreList = new com.jcommerce.core.model.AccountLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AccountLog[] list = adapterImpl.getWSDLAccountLogList(coreList);
		System.out.println("list.length" + list.length);
		AccountLogList accountlogList = new AccountLogList();
		accountlogList.setAccountLog(list);
		xxxResp.setAccountLogList(accountlogList);
	}

	private void createAdminActionResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AdminAction[] coreList = new com.jcommerce.core.model.AdminAction[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AdminAction[] list = adapterImpl.getWSDLAdminActionList(coreList);
		System.out.println("list.length" + list.length);
		AdminActionList adminactionList = new AdminActionList();
		adminactionList.setAdminAction(list);
		xxxResp.setAdminActionList(adminactionList);
	}

	private void createAdminLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AdminLog[] coreList = new com.jcommerce.core.model.AdminLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AdminLog[] list = adapterImpl.getWSDLAdminLogList(coreList);
		System.out.println("list.length" + list.length);
		AdminLogList adminlogList = new AdminLogList();
		adminlogList.setAdminLog(list);
		xxxResp.setAdminLogList(adminlogList);
	}

	private void createAdminMessageResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AdminMessage[] coreList = new com.jcommerce.core.model.AdminMessage[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AdminMessage[] list = adapterImpl.getWSDLAdminMessageList(coreList);
		System.out.println("list.length" + list.length);
		AdminMessageList adminmessageList = new AdminMessageList();
		adminmessageList.setAdminMessage(list);
		xxxResp.setAdminMessageList(adminmessageList);
	}

	private void createAdminUserResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AdminUser[] coreList = new com.jcommerce.core.model.AdminUser[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AdminUser[] list = adapterImpl.getWSDLAdminUserList(coreList);
		System.out.println("list.length" + list.length);
		AdminUserList adminuserList = new AdminUserList();
		adminuserList.setAdminUser(list);
		xxxResp.setAdminUserList(adminuserList);
	}

	private void createAdPositionResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AdPosition[] coreList = new com.jcommerce.core.model.AdPosition[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AdPosition[] list = adapterImpl.getWSDLAdPositionList(coreList);
		System.out.println("list.length" + list.length);
		AdPositionList adpositionList = new AdPositionList();
		adpositionList.setAdPosition(list);
		xxxResp.setAdPositionList(adpositionList);
	}

	private void createAdsenseResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Adsense[] coreList = new com.jcommerce.core.model.Adsense[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Adsense[] list = adapterImpl.getWSDLAdsenseList(coreList);
		System.out.println("list.length" + list.length);
		AdsenseList adsenseList = new AdsenseList();
		adsenseList.setAdsense(list);
		xxxResp.setAdsenseList(adsenseList);
	}

	private void createAdvertisementResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Advertisement[] coreList = new com.jcommerce.core.model.Advertisement[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Advertisement[] list = adapterImpl.getWSDLAdvertisementList(coreList);
		System.out.println("list.length" + list.length);
		AdvertisementList advertisementList = new AdvertisementList();
		advertisementList.setAdvertisement(list);
		xxxResp.setAdvertisementList(advertisementList);
	}

	private void createAffiliateLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AffiliateLog[] coreList = new com.jcommerce.core.model.AffiliateLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AffiliateLog[] list = adapterImpl.getWSDLAffiliateLogList(coreList);
		System.out.println("list.length" + list.length);
		AffiliateLogList affiliatelogList = new AffiliateLogList();
		affiliatelogList.setAffiliateLog(list);
		xxxResp.setAffiliateLogList(affiliatelogList);
	}

	private void createAgencyResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Agency[] coreList = new com.jcommerce.core.model.Agency[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Agency[] list = adapterImpl.getWSDLAgencyList(coreList);
		System.out.println("list.length" + list.length);
		AgencyList agencyList = new AgencyList();
		agencyList.setAgency(list);
		xxxResp.setAgencyList(agencyList);
	}

	private void createArticleResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Article[] coreList = new com.jcommerce.core.model.Article[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Article[] list = adapterImpl.getWSDLArticleList(coreList);
		System.out.println("list.length" + list.length);
		ArticleList articleList = new ArticleList();
		articleList.setArticle(list);
		xxxResp.setArticleList(articleList);
	}

	private void createArticleCategoryResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.ArticleCategory[] coreList = new com.jcommerce.core.model.ArticleCategory[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		ArticleCategory[] list = adapterImpl.getWSDLArticleCategoryList(coreList);
		System.out.println("list.length" + list.length);
		ArticleCategoryList articlecategoryList = new ArticleCategoryList();
		articlecategoryList.setArticleCategory(list);
		xxxResp.setArticleCategoryList(articlecategoryList);
	}

	private void createAttributeResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Attribute[] coreList = new com.jcommerce.core.model.Attribute[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Attribute[] list = adapterImpl.getWSDLAttributeList(coreList);
		System.out.println("list.length" + list.length);
		AttributeList attributeList = new AttributeList();
		attributeList.setAttribute(list);
		xxxResp.setAttributeList(attributeList);
	}

	private void createAuctionLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AuctionLog[] coreList = new com.jcommerce.core.model.AuctionLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AuctionLog[] list = adapterImpl.getWSDLAuctionLogList(coreList);
		System.out.println("list.length" + list.length);
		AuctionLogList auctionlogList = new AuctionLogList();
		auctionlogList.setAuctionLog(list);
		xxxResp.setAuctionLogList(auctionlogList);
	}

	private void createAutoManageResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.AutoManage[] coreList = new com.jcommerce.core.model.AutoManage[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		AutoManage[] list = adapterImpl.getWSDLAutoManageList(coreList);
		System.out.println("list.length" + list.length);
		AutoManageList automanageList = new AutoManageList();
		automanageList.setAutoManage(list);
		xxxResp.setAutoManageList(automanageList);
	}

	private void createBonusTypeResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.BonusType[] coreList = new com.jcommerce.core.model.BonusType[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		BonusType[] list = adapterImpl.getWSDLBonusTypeList(coreList);
		System.out.println("list.length" + list.length);
		BonusTypeList bonustypeList = new BonusTypeList();
		bonustypeList.setBonusType(list);
		xxxResp.setBonusTypeList(bonustypeList);
	}

	private void createBookingGoodsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.BookingGoods[] coreList = new com.jcommerce.core.model.BookingGoods[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		BookingGoods[] list = adapterImpl.getWSDLBookingGoodsList(coreList);
		System.out.println("list.length" + list.length);
		BookingGoodsList bookinggoodsList = new BookingGoodsList();
		bookinggoodsList.setBookingGoods(list);
		xxxResp.setBookingGoodsList(bookinggoodsList);
	}

	private void createBrandResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Brand[] coreList = new com.jcommerce.core.model.Brand[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Brand[] list = adapterImpl.getWSDLBrandList(coreList);
		System.out.println("list.length" + list.length);
		BrandList brandList = new BrandList();
		brandList.setBrand(list);
		xxxResp.setBrandList(brandList);
	}

	private void createCardResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Card[] coreList = new com.jcommerce.core.model.Card[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Card[] list = adapterImpl.getWSDLCardList(coreList);
		System.out.println("list.length" + list.length);
		CardList cardList = new CardList();
		cardList.setCard(list);
		xxxResp.setCardList(cardList);
	}

	private void createCartResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Cart[] coreList = new com.jcommerce.core.model.Cart[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Cart[] list = adapterImpl.getWSDLCartList(coreList);
		System.out.println("list.length" + list.length);
		CartList cartList = new CartList();
		cartList.setCart(list);
		xxxResp.setCartList(cartList);
	}

	private void createCategoryResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Category[] coreList = new com.jcommerce.core.model.Category[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Category[] list = adapterImpl.getWSDLCategoryList(coreList);
		System.out.println("list.length" + list.length);
		CategoryList categoryList = new CategoryList();
		categoryList.setCategory(list);
		xxxResp.setCategoryList(categoryList);
	}

	private void createCollectGoodsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.CollectGoods[] coreList = new com.jcommerce.core.model.CollectGoods[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		CollectGoods[] list = adapterImpl.getWSDLCollectGoodsList(coreList);
		System.out.println("list.length" + list.length);
		CollectGoodsList collectgoodsList = new CollectGoodsList();
		collectgoodsList.setCollectGoods(list);
		xxxResp.setCollectGoodsList(collectgoodsList);
	}

	private void createCommentResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Comment[] coreList = new com.jcommerce.core.model.Comment[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Comment[] list = adapterImpl.getWSDLCommentList(coreList);
		System.out.println("list.length" + list.length);
		CommentList commentList = new CommentList();
		commentList.setComment(list);
		xxxResp.setCommentList(commentList);
	}

	private void createCronsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Crons[] coreList = new com.jcommerce.core.model.Crons[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Crons[] list = adapterImpl.getWSDLCronsList(coreList);
		System.out.println("list.length" + list.length);
		CronsList cronsList = new CronsList();
		cronsList.setCrons(list);
		xxxResp.setCronsList(cronsList);
	}

	private void createEmailListResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.EmailList[] coreList = new com.jcommerce.core.model.EmailList[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		EmailList[] list = adapterImpl.getWSDLEmailListList(coreList);
		System.out.println("list.length" + list.length);
		EmailListList emaillistList = new EmailListList();
		emaillistList.setEmailList(list);
		xxxResp.setEmailListList(emaillistList);
	}

	private void createEmailSendListResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.EmailSendList[] coreList = new com.jcommerce.core.model.EmailSendList[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		EmailSendList[] list = adapterImpl.getWSDLEmailSendListList(coreList);
		System.out.println("list.length" + list.length);
		EmailSendListList emailsendlistList = new EmailSendListList();
		emailsendlistList.setEmailSendList(list);
		xxxResp.setEmailSendListList(emailsendlistList);
	}

	private void createErrorLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.ErrorLog[] coreList = new com.jcommerce.core.model.ErrorLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		ErrorLog[] list = adapterImpl.getWSDLErrorLogList(coreList);
		System.out.println("list.length" + list.length);
		ErrorLogList errorlogList = new ErrorLogList();
		errorlogList.setErrorLog(list);
		xxxResp.setErrorLogList(errorlogList);
	}

	private void createFailedLoginResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.FailedLogin[] coreList = new com.jcommerce.core.model.FailedLogin[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		FailedLogin[] list = adapterImpl.getWSDLFailedLoginList(coreList);
		System.out.println("list.length" + list.length);
		FailedLoginList failedloginList = new FailedLoginList();
		failedloginList.setFailedLogin(list);
		xxxResp.setFailedLoginList(failedloginList);
	}

	private void createFavourableActivityResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.FavourableActivity[] coreList = new com.jcommerce.core.model.FavourableActivity[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		FavourableActivity[] list = adapterImpl.getWSDLFavourableActivityList(coreList);
		System.out.println("list.length" + list.length);
		FavourableActivityList favourableactivityList = new FavourableActivityList();
		favourableactivityList.setFavourableActivity(list);
		xxxResp.setFavourableActivityList(favourableactivityList);
	}

	private void createFeedbackResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Feedback[] coreList = new com.jcommerce.core.model.Feedback[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Feedback[] list = adapterImpl.getWSDLFeedbackList(coreList);
		System.out.println("list.length" + list.length);
		FeedbackList feedbackList = new FeedbackList();
		feedbackList.setFeedback(list);
		xxxResp.setFeedbackList(feedbackList);
	}

	private void createFriendLinkResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.FriendLink[] coreList = new com.jcommerce.core.model.FriendLink[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		FriendLink[] list = adapterImpl.getWSDLFriendLinkList(coreList);
		System.out.println("list.length" + list.length);
		FriendLinkList friendlinkList = new FriendLinkList();
		friendlinkList.setFriendLink(list);
		xxxResp.setFriendLinkList(friendlinkList);
	}

	private void createGalleryResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Gallery[] coreList = new com.jcommerce.core.model.Gallery[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Gallery[] list = adapterImpl.getWSDLGalleryList(coreList);
		System.out.println("list.length" + list.length);
		GalleryList galleryList = new GalleryList();
		galleryList.setGallery(list);
		xxxResp.setGalleryList(galleryList);
	}

	private void createGoodsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Goods[] coreList = new com.jcommerce.core.model.Goods[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Goods[] list = adapterImpl.getWSDLGoodsList(coreList);
		System.out.println("list.length" + list.length);
		GoodsList goodsList = new GoodsList();
		goodsList.setGoods(list);
		xxxResp.setGoodsList(goodsList);
	}

	private void createGoodsActivityResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.GoodsActivity[] coreList = new com.jcommerce.core.model.GoodsActivity[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		GoodsActivity[] list = adapterImpl.getWSDLGoodsActivityList(coreList);
		System.out.println("list.length" + list.length);
		GoodsActivityList goodsactivityList = new GoodsActivityList();
		goodsactivityList.setGoodsActivity(list);
		xxxResp.setGoodsActivityList(goodsactivityList);
	}

	private void createGoodsArticleResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.GoodsArticle[] coreList = new com.jcommerce.core.model.GoodsArticle[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		GoodsArticle[] list = adapterImpl.getWSDLGoodsArticleList(coreList);
		System.out.println("list.length" + list.length);
		GoodsArticleList goodsarticleList = new GoodsArticleList();
		goodsarticleList.setGoodsArticle(list);
		xxxResp.setGoodsArticleList(goodsarticleList);
	}

	private void createGoodsAttributeResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.GoodsAttribute[] coreList = new com.jcommerce.core.model.GoodsAttribute[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		GoodsAttribute[] list = adapterImpl.getWSDLGoodsAttributeList(coreList);
		System.out.println("list.length" + list.length);
		GoodsAttributeList goodsattributeList = new GoodsAttributeList();
		goodsattributeList.setGoodsAttribute(list);
		xxxResp.setGoodsAttributeList(goodsattributeList);
	}

	private void createGoodsTypeResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.GoodsType[] coreList = new com.jcommerce.core.model.GoodsType[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		GoodsType[] list = adapterImpl.getWSDLGoodsTypeList(coreList);
		System.out.println("list.length" + list.length);
		GoodsTypeList goodstypeList = new GoodsTypeList();
		goodstypeList.setGoodsType(list);
		xxxResp.setGoodsTypeList(goodstypeList);
	}

	private void createGroupGoodsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.GroupGoods[] coreList = new com.jcommerce.core.model.GroupGoods[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		GroupGoods[] list = adapterImpl.getWSDLGroupGoodsList(coreList);
		System.out.println("list.length" + list.length);
		GroupGoodsList groupgoodsList = new GroupGoodsList();
		groupgoodsList.setGroupGoods(list);
		xxxResp.setGroupGoodsList(groupgoodsList);
	}

	private void createKeywordsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Keywords[] coreList = new com.jcommerce.core.model.Keywords[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Keywords[] list = adapterImpl.getWSDLKeywordsList(coreList);
		System.out.println("list.length" + list.length);
		KeywordsList keywordsList = new KeywordsList();
		keywordsList.setKeywords(list);
		xxxResp.setKeywordsList(keywordsList);
	}

	private void createLinkGoodsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.LinkGoods[] coreList = new com.jcommerce.core.model.LinkGoods[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		LinkGoods[] list = adapterImpl.getWSDLLinkGoodsList(coreList);
		System.out.println("list.length" + list.length);
		LinkGoodsList linkgoodsList = new LinkGoodsList();
		linkgoodsList.setLinkGoods(list);
		xxxResp.setLinkGoodsList(linkgoodsList);
	}

	private void createMailTemplateResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.MailTemplate[] coreList = new com.jcommerce.core.model.MailTemplate[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		MailTemplate[] list = adapterImpl.getWSDLMailTemplateList(coreList);
		System.out.println("list.length" + list.length);
		MailTemplateList mailtemplateList = new MailTemplateList();
		mailtemplateList.setMailTemplate(list);
		xxxResp.setMailTemplateList(mailtemplateList);
	}

	private void createMemberPriceResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.MemberPrice[] coreList = new com.jcommerce.core.model.MemberPrice[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		MemberPrice[] list = adapterImpl.getWSDLMemberPriceList(coreList);
		System.out.println("list.length" + list.length);
		MemberPriceList memberpriceList = new MemberPriceList();
		memberpriceList.setMemberPrice(list);
		xxxResp.setMemberPriceList(memberpriceList);
	}

	private void createNavigationResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Navigation[] coreList = new com.jcommerce.core.model.Navigation[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Navigation[] list = adapterImpl.getWSDLNavigationList(coreList);
		System.out.println("list.length" + list.length);
		NavigationList navigationList = new NavigationList();
		navigationList.setNavigation(list);
		xxxResp.setNavigationList(navigationList);
	}

	private void createOrderResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Order[] coreList = new com.jcommerce.core.model.Order[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Order[] list = adapterImpl.getWSDLOrderList(coreList);
		System.out.println("list.length" + list.length);
		OrderList orderList = new OrderList();
		orderList.setOrder(list);
		xxxResp.setOrderList(orderList);
	}

	private void createOrderActionResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.OrderAction[] coreList = new com.jcommerce.core.model.OrderAction[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		OrderAction[] list = adapterImpl.getWSDLOrderActionList(coreList);
		System.out.println("list.length" + list.length);
		OrderActionList orderactionList = new OrderActionList();
		orderactionList.setOrderAction(list);
		xxxResp.setOrderActionList(orderactionList);
	}

	private void createOrderGoodsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.OrderGoods[] coreList = new com.jcommerce.core.model.OrderGoods[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		OrderGoods[] list = adapterImpl.getWSDLOrderGoodsList(coreList);
		System.out.println("list.length" + list.length);
		OrderGoodsList ordergoodsList = new OrderGoodsList();
		ordergoodsList.setOrderGoods(list);
		xxxResp.setOrderGoodsList(ordergoodsList);
	}

	private void createPackResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Pack[] coreList = new com.jcommerce.core.model.Pack[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Pack[] list = adapterImpl.getWSDLPackList(coreList);
		System.out.println("list.length" + list.length);
		PackList packList = new PackList();
		packList.setPack(list);
		xxxResp.setPackList(packList);
	}

	private void createPayLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.PayLog[] coreList = new com.jcommerce.core.model.PayLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		PayLog[] list = adapterImpl.getWSDLPayLogList(coreList);
		System.out.println("list.length" + list.length);
		PayLogList paylogList = new PayLogList();
		paylogList.setPayLog(list);
		xxxResp.setPayLogList(paylogList);
	}

	private void createPaymentResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Payment[] coreList = new com.jcommerce.core.model.Payment[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Payment[] list = adapterImpl.getWSDLPaymentList(coreList);
		System.out.println("list.length" + list.length);
		PaymentList paymentList = new PaymentList();
		paymentList.setPayment(list);
		xxxResp.setPaymentList(paymentList);
	}

	private void createPluginsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Plugins[] coreList = new com.jcommerce.core.model.Plugins[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Plugins[] list = adapterImpl.getWSDLPluginsList(coreList);
		System.out.println("list.length" + list.length);
		PluginsList pluginsList = new PluginsList();
		pluginsList.setPlugins(list);
		xxxResp.setPluginsList(pluginsList);
	}

	private void createRegionResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Region[] coreList = new com.jcommerce.core.model.Region[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Region[] list = adapterImpl.getWSDLRegionList(coreList);
		System.out.println("list.length" + list.length);
		RegionList regionList = new RegionList();
		regionList.setRegion(list);
		xxxResp.setRegionList(regionList);
	}

	private void createSearchEngineResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.SearchEngine[] coreList = new com.jcommerce.core.model.SearchEngine[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		SearchEngine[] list = adapterImpl.getWSDLSearchEngineList(coreList);
		System.out.println("list.length" + list.length);
		SearchEngineList searchengineList = new SearchEngineList();
		searchengineList.setSearchEngine(list);
		xxxResp.setSearchEngineList(searchengineList);
	}

	private void createSessionResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Session[] coreList = new com.jcommerce.core.model.Session[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Session[] list = adapterImpl.getWSDLSessionList(coreList);
		System.out.println("list.length" + list.length);
		SessionList sessionList = new SessionList();
		sessionList.setSession(list);
		xxxResp.setSessionList(sessionList);
	}

	private void createSessionsDataResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.SessionsData[] coreList = new com.jcommerce.core.model.SessionsData[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		SessionsData[] list = adapterImpl.getWSDLSessionsDataList(coreList);
		System.out.println("list.length" + list.length);
		SessionsDataList sessionsdataList = new SessionsDataList();
		sessionsdataList.setSessionsData(list);
		xxxResp.setSessionsDataList(sessionsdataList);
	}

	private void createShippingResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Shipping[] coreList = new com.jcommerce.core.model.Shipping[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Shipping[] list = adapterImpl.getWSDLShippingList(coreList);
		System.out.println("list.length" + list.length);
		ShippingList shippingList = new ShippingList();
		shippingList.setShipping(list);
		xxxResp.setShippingList(shippingList);
	}

	private void createShippingAreaResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.ShippingArea[] coreList = new com.jcommerce.core.model.ShippingArea[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		ShippingArea[] list = adapterImpl.getWSDLShippingAreaList(coreList);
		System.out.println("list.length" + list.length);
		ShippingAreaList shippingareaList = new ShippingAreaList();
		shippingareaList.setShippingArea(list);
		xxxResp.setShippingAreaList(shippingareaList);
	}

	private void createShopConfigResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.ShopConfig[] coreList = new com.jcommerce.core.model.ShopConfig[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		ShopConfig[] list = adapterImpl.getWSDLShopConfigList(coreList);
		System.out.println("list.length" + list.length);
		ShopConfigList shopconfigList = new ShopConfigList();
		shopconfigList.setShopConfig(list);
		xxxResp.setShopConfigList(shopconfigList);
	}

	private void createSnatchLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.SnatchLog[] coreList = new com.jcommerce.core.model.SnatchLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		SnatchLog[] list = adapterImpl.getWSDLSnatchLogList(coreList);
		System.out.println("list.length" + list.length);
		SnatchLogList snatchlogList = new SnatchLogList();
		snatchlogList.setSnatchLog(list);
		xxxResp.setSnatchLogList(snatchlogList);
	}

	private void createStatsResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Stats[] coreList = new com.jcommerce.core.model.Stats[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Stats[] list = adapterImpl.getWSDLStatsList(coreList);
		System.out.println("list.length" + list.length);
		StatsList statsList = new StatsList();
		statsList.setStats(list);
		xxxResp.setStatsList(statsList);
	}

	private void createTagResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Tag[] coreList = new com.jcommerce.core.model.Tag[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Tag[] list = adapterImpl.getWSDLTagList(coreList);
		System.out.println("list.length" + list.length);
		TagList tagList = new TagList();
		tagList.setTag(list);
		xxxResp.setTagList(tagList);
	}

	private void createTopicResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Topic[] coreList = new com.jcommerce.core.model.Topic[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Topic[] list = adapterImpl.getWSDLTopicList(coreList);
		System.out.println("list.length" + list.length);
		TopicList topicList = new TopicList();
		topicList.setTopic(list);
		xxxResp.setTopicList(topicList);
	}

	private void createUserResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.User[] coreList = new com.jcommerce.core.model.User[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		User[] list = adapterImpl.getWSDLUserList(coreList);
		System.out.println("list.length" + list.length);
		UserList userList = new UserList();
		userList.setUser(list);
		xxxResp.setUserList(userList);
	}

	private void createUserAccountResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.UserAccount[] coreList = new com.jcommerce.core.model.UserAccount[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		UserAccount[] list = adapterImpl.getWSDLUserAccountList(coreList);
		System.out.println("list.length" + list.length);
		UserAccountList useraccountList = new UserAccountList();
		useraccountList.setUserAccount(list);
		xxxResp.setUserAccountList(useraccountList);
	}

	private void createUserAddressResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.UserAddress[] coreList = new com.jcommerce.core.model.UserAddress[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		UserAddress[] list = adapterImpl.getWSDLUserAddressList(coreList);
		System.out.println("list.length" + list.length);
		UserAddressList useraddressList = new UserAddressList();
		useraddressList.setUserAddress(list);
		xxxResp.setUserAddressList(useraddressList);
	}

	private void createUserBonusResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.UserBonus[] coreList = new com.jcommerce.core.model.UserBonus[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		UserBonus[] list = adapterImpl.getWSDLUserBonusList(coreList);
		System.out.println("list.length" + list.length);
		UserBonusList userbonusList = new UserBonusList();
		userbonusList.setUserBonus(list);
		xxxResp.setUserBonusList(userbonusList);
	}

	private void createUserRankResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.UserRank[] coreList = new com.jcommerce.core.model.UserRank[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		UserRank[] list = adapterImpl.getWSDLUserRankList(coreList);
		System.out.println("list.length" + list.length);
		UserRankList userrankList = new UserRankList();
		userrankList.setUserRank(list);
		xxxResp.setUserRankList(userrankList);
	}

	private void createVirtualCardResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.VirtualCard[] coreList = new com.jcommerce.core.model.VirtualCard[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		VirtualCard[] list = adapterImpl.getWSDLVirtualCardList(coreList);
		System.out.println("list.length" + list.length);
		VirtualCardList virtualcardList = new VirtualCardList();
		virtualcardList.setVirtualCard(list);
		xxxResp.setVirtualCardList(virtualcardList);
	}

	private void createVoteResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Vote[] coreList = new com.jcommerce.core.model.Vote[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Vote[] list = adapterImpl.getWSDLVoteList(coreList);
		System.out.println("list.length" + list.length);
		VoteList voteList = new VoteList();
		voteList.setVote(list);
		xxxResp.setVoteList(voteList);
	}

	private void createVoteDataResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.VoteData[] coreList = new com.jcommerce.core.model.VoteData[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		VoteData[] list = adapterImpl.getWSDLVoteDataList(coreList);
		System.out.println("list.length" + list.length);
		VoteDataList votedataList = new VoteDataList();
		votedataList.setVoteData(list);
		xxxResp.setVoteDataList(votedataList);
	}

	private void createVoteLogResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.VoteLog[] coreList = new com.jcommerce.core.model.VoteLog[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		VoteLog[] list = adapterImpl.getWSDLVoteLogList(coreList);
		System.out.println("list.length" + list.length);
		VoteLogList votelogList = new VoteLogList();
		votelogList.setVoteLog(list);
		xxxResp.setVoteLogList(votelogList);
	}

	private void createWholesaleResp(List<ModelObject> objList, XXXRESP xxxResp) {
		com.jcommerce.core.model.Wholesale[] coreList = new com.jcommerce.core.model.Wholesale[objList.size()];
		objList.toArray(coreList);
		System.out.println("coreList size " + coreList.length);
		Wholesale[] list = adapterImpl.getWSDLWholesaleList(coreList);
		System.out.println("list.length" + list.length);
		WholesaleList wholesaleList = new WholesaleList();
		wholesaleList.setWholesale(list);
		xxxResp.setWholesaleList(wholesaleList);
	}

	private void createReadResp(String targetType, List<ModelObject> objList, XXXRESP xxxResp) {
		System.out.println("objList size " + objList.size());
		if (targetType.equals("AccountLog")) {
			createAccountLogResp(objList, xxxResp);
		}
		if (targetType.equals("AdminAction")) {
			createAdminActionResp(objList, xxxResp);
		}
		if (targetType.equals("AdminLog")) {
			createAdminLogResp(objList, xxxResp);
		}
		if (targetType.equals("AdminMessage")) {
			createAdminMessageResp(objList, xxxResp);
		}
		if (targetType.equals("AdminUser")) {
			createAdminUserResp(objList, xxxResp);
		}
		if (targetType.equals("AdPosition")) {
			createAdPositionResp(objList, xxxResp);
		}
		if (targetType.equals("Adsense")) {
			createAdsenseResp(objList, xxxResp);
		}
		if (targetType.equals("Advertisement")) {
			createAdvertisementResp(objList, xxxResp);
		}
		if (targetType.equals("AffiliateLog")) {
			createAffiliateLogResp(objList, xxxResp);
		}
		if (targetType.equals("Agency")) {
			createAgencyResp(objList, xxxResp);
		}
		if (targetType.equals("Article")) {
			createArticleResp(objList, xxxResp);
		}
		if (targetType.equals("ArticleCategory")) {
			createArticleCategoryResp(objList, xxxResp);
		}
		if (targetType.equals("Attribute")) {
			createAttributeResp(objList, xxxResp);
		}
		if (targetType.equals("AuctionLog")) {
			createAuctionLogResp(objList, xxxResp);
		}
		if (targetType.equals("AutoManage")) {
			createAutoManageResp(objList, xxxResp);
		}
		if (targetType.equals("BonusType")) {
			createBonusTypeResp(objList, xxxResp);
		}
		if (targetType.equals("BookingGoods")) {
			createBookingGoodsResp(objList, xxxResp);
		}
		if (targetType.equals("Brand")) {
			createBrandResp(objList, xxxResp);
		}
		if (targetType.equals("Card")) {
			createCardResp(objList, xxxResp);
		}
		if (targetType.equals("Cart")) {
			createCartResp(objList, xxxResp);
		}
		if (targetType.equals("Category")) {
			createCategoryResp(objList, xxxResp);
		}
		if (targetType.equals("CollectGoods")) {
			createCollectGoodsResp(objList, xxxResp);
		}
		if (targetType.equals("Comment")) {
			createCommentResp(objList, xxxResp);
		}
		if (targetType.equals("Crons")) {
			createCronsResp(objList, xxxResp);
		}
		if (targetType.equals("EmailList")) {
			createEmailListResp(objList, xxxResp);
		}
		if (targetType.equals("EmailSendList")) {
			createEmailSendListResp(objList, xxxResp);
		}
		if (targetType.equals("ErrorLog")) {
			createErrorLogResp(objList, xxxResp);
		}
		if (targetType.equals("FailedLogin")) {
			createFailedLoginResp(objList, xxxResp);
		}
		if (targetType.equals("FavourableActivity")) {
			createFavourableActivityResp(objList, xxxResp);
		}
		if (targetType.equals("Feedback")) {
			createFeedbackResp(objList, xxxResp);
		}
		if (targetType.equals("FriendLink")) {
			createFriendLinkResp(objList, xxxResp);
		}
		if (targetType.equals("Gallery")) {
			createGalleryResp(objList, xxxResp);
		}
		if (targetType.equals("Goods")) {
			createGoodsResp(objList, xxxResp);
		}
		if (targetType.equals("GoodsActivity")) {
			createGoodsActivityResp(objList, xxxResp);
		}
		if (targetType.equals("GoodsArticle")) {
			createGoodsArticleResp(objList, xxxResp);
		}
		if (targetType.equals("GoodsAttribute")) {
			createGoodsAttributeResp(objList, xxxResp);
		}
		if (targetType.equals("GoodsType")) {
			createGoodsTypeResp(objList, xxxResp);
		}
		if (targetType.equals("GroupGoods")) {
			createGroupGoodsResp(objList, xxxResp);
		}
		if (targetType.equals("Keywords")) {
			createKeywordsResp(objList, xxxResp);
		}
		if (targetType.equals("LinkGoods")) {
			createLinkGoodsResp(objList, xxxResp);
		}
		if (targetType.equals("MailTemplate")) {
			createMailTemplateResp(objList, xxxResp);
		}
		if (targetType.equals("MemberPrice")) {
			createMemberPriceResp(objList, xxxResp);
		}
		if (targetType.equals("Navigation")) {
			createNavigationResp(objList, xxxResp);
		}
		if (targetType.equals("Order")) {
			createOrderResp(objList, xxxResp);
		}
		if (targetType.equals("OrderAction")) {
			createOrderActionResp(objList, xxxResp);
		}
		if (targetType.equals("OrderGoods")) {
			createOrderGoodsResp(objList, xxxResp);
		}
		if (targetType.equals("Pack")) {
			createPackResp(objList, xxxResp);
		}
		if (targetType.equals("PayLog")) {
			createPayLogResp(objList, xxxResp);
		}
		if (targetType.equals("Payment")) {
			createPaymentResp(objList, xxxResp);
		}
		if (targetType.equals("Plugins")) {
			createPluginsResp(objList, xxxResp);
		}
		if (targetType.equals("Region")) {
			createRegionResp(objList, xxxResp);
		}
		if (targetType.equals("SearchEngine")) {
			createSearchEngineResp(objList, xxxResp);
		}
		if (targetType.equals("Session")) {
			createSessionResp(objList, xxxResp);
		}
		if (targetType.equals("SessionsData")) {
			createSessionsDataResp(objList, xxxResp);
		}
		if (targetType.equals("Shipping")) {
			createShippingResp(objList, xxxResp);
		}
		if (targetType.equals("ShippingArea")) {
			createShippingAreaResp(objList, xxxResp);
		}
		if (targetType.equals("ShopConfig")) {
			createShopConfigResp(objList, xxxResp);
		}
		if (targetType.equals("SnatchLog")) {
			createSnatchLogResp(objList, xxxResp);
		}
		if (targetType.equals("Stats")) {
			createStatsResp(objList, xxxResp);
		}
		if (targetType.equals("Tag")) {
			createTagResp(objList, xxxResp);
		}
		if (targetType.equals("Topic")) {
			createTopicResp(objList, xxxResp);
		}
		if (targetType.equals("User")) {
			createUserResp(objList, xxxResp);
		}
		if (targetType.equals("UserAccount")) {
			createUserAccountResp(objList, xxxResp);
		}
		if (targetType.equals("UserAddress")) {
			createUserAddressResp(objList, xxxResp);
		}
		if (targetType.equals("UserBonus")) {
			createUserBonusResp(objList, xxxResp);
		}
		if (targetType.equals("UserRank")) {
			createUserRankResp(objList, xxxResp);
		}
		if (targetType.equals("VirtualCard")) {
			createVirtualCardResp(objList, xxxResp);
		}
		if (targetType.equals("Vote")) {
			createVoteResp(objList, xxxResp);
		}
		if (targetType.equals("VoteData")) {
			createVoteDataResp(objList, xxxResp);
		}
		if (targetType.equals("VoteLog")) {
			createVoteLogResp(objList, xxxResp);
		}
		if (targetType.equals("Wholesale")) {
			createWholesaleResp(objList, xxxResp);
		}
	}

}
