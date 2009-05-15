
/**
 * XXXRESP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */
            
                package com.jcommerce.ws.server;
            

            /**
            *  XXXRESP bean class
            */
        
        public  class XXXRESP
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = XXXRESP
                Namespace URI = http://ws.jcommerce.com/
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://ws.jcommerce.com/")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for ObjId
                        */

                        
                                    protected int localObjId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localObjIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getObjId(){
                               return localObjId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ObjId
                               */
                               public void setObjId(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localObjIdTracker = false;
                                              
                                       } else {
                                          localObjIdTracker = true;
                                       }
                                   
                                            this.localObjId=param;
                                    

                               }
                            

                        /**
                        * field for TotalNumber
                        */

                        
                                    protected int localTotalNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTotalNumberTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getTotalNumber(){
                               return localTotalNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TotalNumber
                               */
                               public void setTotalNumber(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localTotalNumberTracker = false;
                                              
                                       } else {
                                          localTotalNumberTracker = true;
                                       }
                                   
                                            this.localTotalNumber=param;
                                    

                               }
                            

                        /**
                        * field for AccountLogList
                        */

                        
                                    protected com.jcommerce.ws.server.AccountLogList localAccountLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAccountLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AccountLogList
                           */
                           public  com.jcommerce.ws.server.AccountLogList getAccountLogList(){
                               return localAccountLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AccountLogList
                               */
                               public void setAccountLogList(com.jcommerce.ws.server.AccountLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAccountLogListTracker = true;
                                       } else {
                                          localAccountLogListTracker = false;
                                              
                                       }
                                   
                                            this.localAccountLogList=param;
                                    

                               }
                            

                        /**
                        * field for AdminActionList
                        */

                        
                                    protected com.jcommerce.ws.server.AdminActionList localAdminActionList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdminActionListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdminActionList
                           */
                           public  com.jcommerce.ws.server.AdminActionList getAdminActionList(){
                               return localAdminActionList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdminActionList
                               */
                               public void setAdminActionList(com.jcommerce.ws.server.AdminActionList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdminActionListTracker = true;
                                       } else {
                                          localAdminActionListTracker = false;
                                              
                                       }
                                   
                                            this.localAdminActionList=param;
                                    

                               }
                            

                        /**
                        * field for AdminLogList
                        */

                        
                                    protected com.jcommerce.ws.server.AdminLogList localAdminLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdminLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdminLogList
                           */
                           public  com.jcommerce.ws.server.AdminLogList getAdminLogList(){
                               return localAdminLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdminLogList
                               */
                               public void setAdminLogList(com.jcommerce.ws.server.AdminLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdminLogListTracker = true;
                                       } else {
                                          localAdminLogListTracker = false;
                                              
                                       }
                                   
                                            this.localAdminLogList=param;
                                    

                               }
                            

                        /**
                        * field for AdminMessageList
                        */

                        
                                    protected com.jcommerce.ws.server.AdminMessageList localAdminMessageList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdminMessageListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdminMessageList
                           */
                           public  com.jcommerce.ws.server.AdminMessageList getAdminMessageList(){
                               return localAdminMessageList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdminMessageList
                               */
                               public void setAdminMessageList(com.jcommerce.ws.server.AdminMessageList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdminMessageListTracker = true;
                                       } else {
                                          localAdminMessageListTracker = false;
                                              
                                       }
                                   
                                            this.localAdminMessageList=param;
                                    

                               }
                            

                        /**
                        * field for AdminUserList
                        */

                        
                                    protected com.jcommerce.ws.server.AdminUserList localAdminUserList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdminUserListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdminUserList
                           */
                           public  com.jcommerce.ws.server.AdminUserList getAdminUserList(){
                               return localAdminUserList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdminUserList
                               */
                               public void setAdminUserList(com.jcommerce.ws.server.AdminUserList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdminUserListTracker = true;
                                       } else {
                                          localAdminUserListTracker = false;
                                              
                                       }
                                   
                                            this.localAdminUserList=param;
                                    

                               }
                            

                        /**
                        * field for AdPositionList
                        */

                        
                                    protected com.jcommerce.ws.server.AdPositionList localAdPositionList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdPositionListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdPositionList
                           */
                           public  com.jcommerce.ws.server.AdPositionList getAdPositionList(){
                               return localAdPositionList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdPositionList
                               */
                               public void setAdPositionList(com.jcommerce.ws.server.AdPositionList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdPositionListTracker = true;
                                       } else {
                                          localAdPositionListTracker = false;
                                              
                                       }
                                   
                                            this.localAdPositionList=param;
                                    

                               }
                            

                        /**
                        * field for AdsenseList
                        */

                        
                                    protected com.jcommerce.ws.server.AdsenseList localAdsenseList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdsenseListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdsenseList
                           */
                           public  com.jcommerce.ws.server.AdsenseList getAdsenseList(){
                               return localAdsenseList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdsenseList
                               */
                               public void setAdsenseList(com.jcommerce.ws.server.AdsenseList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdsenseListTracker = true;
                                       } else {
                                          localAdsenseListTracker = false;
                                              
                                       }
                                   
                                            this.localAdsenseList=param;
                                    

                               }
                            

                        /**
                        * field for AdvertisementList
                        */

                        
                                    protected com.jcommerce.ws.server.AdvertisementList localAdvertisementList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdvertisementListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AdvertisementList
                           */
                           public  com.jcommerce.ws.server.AdvertisementList getAdvertisementList(){
                               return localAdvertisementList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AdvertisementList
                               */
                               public void setAdvertisementList(com.jcommerce.ws.server.AdvertisementList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdvertisementListTracker = true;
                                       } else {
                                          localAdvertisementListTracker = false;
                                              
                                       }
                                   
                                            this.localAdvertisementList=param;
                                    

                               }
                            

                        /**
                        * field for AffiliateLogList
                        */

                        
                                    protected com.jcommerce.ws.server.AffiliateLogList localAffiliateLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAffiliateLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AffiliateLogList
                           */
                           public  com.jcommerce.ws.server.AffiliateLogList getAffiliateLogList(){
                               return localAffiliateLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AffiliateLogList
                               */
                               public void setAffiliateLogList(com.jcommerce.ws.server.AffiliateLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAffiliateLogListTracker = true;
                                       } else {
                                          localAffiliateLogListTracker = false;
                                              
                                       }
                                   
                                            this.localAffiliateLogList=param;
                                    

                               }
                            

                        /**
                        * field for AgencyList
                        */

                        
                                    protected com.jcommerce.ws.server.AgencyList localAgencyList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAgencyListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AgencyList
                           */
                           public  com.jcommerce.ws.server.AgencyList getAgencyList(){
                               return localAgencyList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AgencyList
                               */
                               public void setAgencyList(com.jcommerce.ws.server.AgencyList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAgencyListTracker = true;
                                       } else {
                                          localAgencyListTracker = false;
                                              
                                       }
                                   
                                            this.localAgencyList=param;
                                    

                               }
                            

                        /**
                        * field for ArticleList
                        */

                        
                                    protected com.jcommerce.ws.server.ArticleList localArticleList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localArticleListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.ArticleList
                           */
                           public  com.jcommerce.ws.server.ArticleList getArticleList(){
                               return localArticleList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ArticleList
                               */
                               public void setArticleList(com.jcommerce.ws.server.ArticleList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localArticleListTracker = true;
                                       } else {
                                          localArticleListTracker = false;
                                              
                                       }
                                   
                                            this.localArticleList=param;
                                    

                               }
                            

                        /**
                        * field for ArticleCategoryList
                        */

                        
                                    protected com.jcommerce.ws.server.ArticleCategoryList localArticleCategoryList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localArticleCategoryListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.ArticleCategoryList
                           */
                           public  com.jcommerce.ws.server.ArticleCategoryList getArticleCategoryList(){
                               return localArticleCategoryList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ArticleCategoryList
                               */
                               public void setArticleCategoryList(com.jcommerce.ws.server.ArticleCategoryList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localArticleCategoryListTracker = true;
                                       } else {
                                          localArticleCategoryListTracker = false;
                                              
                                       }
                                   
                                            this.localArticleCategoryList=param;
                                    

                               }
                            

                        /**
                        * field for AttributeList
                        */

                        
                                    protected com.jcommerce.ws.server.AttributeList localAttributeList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAttributeListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AttributeList
                           */
                           public  com.jcommerce.ws.server.AttributeList getAttributeList(){
                               return localAttributeList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AttributeList
                               */
                               public void setAttributeList(com.jcommerce.ws.server.AttributeList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAttributeListTracker = true;
                                       } else {
                                          localAttributeListTracker = false;
                                              
                                       }
                                   
                                            this.localAttributeList=param;
                                    

                               }
                            

                        /**
                        * field for AuctionLogList
                        */

                        
                                    protected com.jcommerce.ws.server.AuctionLogList localAuctionLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAuctionLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AuctionLogList
                           */
                           public  com.jcommerce.ws.server.AuctionLogList getAuctionLogList(){
                               return localAuctionLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AuctionLogList
                               */
                               public void setAuctionLogList(com.jcommerce.ws.server.AuctionLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAuctionLogListTracker = true;
                                       } else {
                                          localAuctionLogListTracker = false;
                                              
                                       }
                                   
                                            this.localAuctionLogList=param;
                                    

                               }
                            

                        /**
                        * field for AutoManageList
                        */

                        
                                    protected com.jcommerce.ws.server.AutoManageList localAutoManageList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAutoManageListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.AutoManageList
                           */
                           public  com.jcommerce.ws.server.AutoManageList getAutoManageList(){
                               return localAutoManageList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AutoManageList
                               */
                               public void setAutoManageList(com.jcommerce.ws.server.AutoManageList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAutoManageListTracker = true;
                                       } else {
                                          localAutoManageListTracker = false;
                                              
                                       }
                                   
                                            this.localAutoManageList=param;
                                    

                               }
                            

                        /**
                        * field for BonusTypeList
                        */

                        
                                    protected com.jcommerce.ws.server.BonusTypeList localBonusTypeList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBonusTypeListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.BonusTypeList
                           */
                           public  com.jcommerce.ws.server.BonusTypeList getBonusTypeList(){
                               return localBonusTypeList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BonusTypeList
                               */
                               public void setBonusTypeList(com.jcommerce.ws.server.BonusTypeList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBonusTypeListTracker = true;
                                       } else {
                                          localBonusTypeListTracker = false;
                                              
                                       }
                                   
                                            this.localBonusTypeList=param;
                                    

                               }
                            

                        /**
                        * field for BookingGoodsList
                        */

                        
                                    protected com.jcommerce.ws.server.BookingGoodsList localBookingGoodsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBookingGoodsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.BookingGoodsList
                           */
                           public  com.jcommerce.ws.server.BookingGoodsList getBookingGoodsList(){
                               return localBookingGoodsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BookingGoodsList
                               */
                               public void setBookingGoodsList(com.jcommerce.ws.server.BookingGoodsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBookingGoodsListTracker = true;
                                       } else {
                                          localBookingGoodsListTracker = false;
                                              
                                       }
                                   
                                            this.localBookingGoodsList=param;
                                    

                               }
                            

                        /**
                        * field for BrandList
                        */

                        
                                    protected com.jcommerce.ws.server.BrandList localBrandList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBrandListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.BrandList
                           */
                           public  com.jcommerce.ws.server.BrandList getBrandList(){
                               return localBrandList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BrandList
                               */
                               public void setBrandList(com.jcommerce.ws.server.BrandList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBrandListTracker = true;
                                       } else {
                                          localBrandListTracker = false;
                                              
                                       }
                                   
                                            this.localBrandList=param;
                                    

                               }
                            

                        /**
                        * field for CardList
                        */

                        
                                    protected com.jcommerce.ws.server.CardList localCardList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCardListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.CardList
                           */
                           public  com.jcommerce.ws.server.CardList getCardList(){
                               return localCardList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CardList
                               */
                               public void setCardList(com.jcommerce.ws.server.CardList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCardListTracker = true;
                                       } else {
                                          localCardListTracker = false;
                                              
                                       }
                                   
                                            this.localCardList=param;
                                    

                               }
                            

                        /**
                        * field for CartList
                        */

                        
                                    protected com.jcommerce.ws.server.CartList localCartList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCartListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.CartList
                           */
                           public  com.jcommerce.ws.server.CartList getCartList(){
                               return localCartList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CartList
                               */
                               public void setCartList(com.jcommerce.ws.server.CartList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCartListTracker = true;
                                       } else {
                                          localCartListTracker = false;
                                              
                                       }
                                   
                                            this.localCartList=param;
                                    

                               }
                            

                        /**
                        * field for CategoryList
                        */

                        
                                    protected com.jcommerce.ws.server.CategoryList localCategoryList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCategoryListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.CategoryList
                           */
                           public  com.jcommerce.ws.server.CategoryList getCategoryList(){
                               return localCategoryList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CategoryList
                               */
                               public void setCategoryList(com.jcommerce.ws.server.CategoryList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCategoryListTracker = true;
                                       } else {
                                          localCategoryListTracker = false;
                                              
                                       }
                                   
                                            this.localCategoryList=param;
                                    

                               }
                            

                        /**
                        * field for CollectGoodsList
                        */

                        
                                    protected com.jcommerce.ws.server.CollectGoodsList localCollectGoodsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCollectGoodsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.CollectGoodsList
                           */
                           public  com.jcommerce.ws.server.CollectGoodsList getCollectGoodsList(){
                               return localCollectGoodsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CollectGoodsList
                               */
                               public void setCollectGoodsList(com.jcommerce.ws.server.CollectGoodsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCollectGoodsListTracker = true;
                                       } else {
                                          localCollectGoodsListTracker = false;
                                              
                                       }
                                   
                                            this.localCollectGoodsList=param;
                                    

                               }
                            

                        /**
                        * field for CommentList
                        */

                        
                                    protected com.jcommerce.ws.server.CommentList localCommentList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCommentListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.CommentList
                           */
                           public  com.jcommerce.ws.server.CommentList getCommentList(){
                               return localCommentList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CommentList
                               */
                               public void setCommentList(com.jcommerce.ws.server.CommentList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCommentListTracker = true;
                                       } else {
                                          localCommentListTracker = false;
                                              
                                       }
                                   
                                            this.localCommentList=param;
                                    

                               }
                            

                        /**
                        * field for CronsList
                        */

                        
                                    protected com.jcommerce.ws.server.CronsList localCronsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCronsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.CronsList
                           */
                           public  com.jcommerce.ws.server.CronsList getCronsList(){
                               return localCronsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CronsList
                               */
                               public void setCronsList(com.jcommerce.ws.server.CronsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCronsListTracker = true;
                                       } else {
                                          localCronsListTracker = false;
                                              
                                       }
                                   
                                            this.localCronsList=param;
                                    

                               }
                            

                        /**
                        * field for EmailListList
                        */

                        
                                    protected com.jcommerce.ws.server.EmailListList localEmailListList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailListListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.EmailListList
                           */
                           public  com.jcommerce.ws.server.EmailListList getEmailListList(){
                               return localEmailListList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EmailListList
                               */
                               public void setEmailListList(com.jcommerce.ws.server.EmailListList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localEmailListListTracker = true;
                                       } else {
                                          localEmailListListTracker = false;
                                              
                                       }
                                   
                                            this.localEmailListList=param;
                                    

                               }
                            

                        /**
                        * field for EmailSendListList
                        */

                        
                                    protected com.jcommerce.ws.server.EmailSendListList localEmailSendListList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailSendListListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.EmailSendListList
                           */
                           public  com.jcommerce.ws.server.EmailSendListList getEmailSendListList(){
                               return localEmailSendListList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EmailSendListList
                               */
                               public void setEmailSendListList(com.jcommerce.ws.server.EmailSendListList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localEmailSendListListTracker = true;
                                       } else {
                                          localEmailSendListListTracker = false;
                                              
                                       }
                                   
                                            this.localEmailSendListList=param;
                                    

                               }
                            

                        /**
                        * field for ErrorLogList
                        */

                        
                                    protected com.jcommerce.ws.server.ErrorLogList localErrorLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localErrorLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.ErrorLogList
                           */
                           public  com.jcommerce.ws.server.ErrorLogList getErrorLogList(){
                               return localErrorLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ErrorLogList
                               */
                               public void setErrorLogList(com.jcommerce.ws.server.ErrorLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localErrorLogListTracker = true;
                                       } else {
                                          localErrorLogListTracker = false;
                                              
                                       }
                                   
                                            this.localErrorLogList=param;
                                    

                               }
                            

                        /**
                        * field for FailedLoginList
                        */

                        
                                    protected com.jcommerce.ws.server.FailedLoginList localFailedLoginList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFailedLoginListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.FailedLoginList
                           */
                           public  com.jcommerce.ws.server.FailedLoginList getFailedLoginList(){
                               return localFailedLoginList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FailedLoginList
                               */
                               public void setFailedLoginList(com.jcommerce.ws.server.FailedLoginList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFailedLoginListTracker = true;
                                       } else {
                                          localFailedLoginListTracker = false;
                                              
                                       }
                                   
                                            this.localFailedLoginList=param;
                                    

                               }
                            

                        /**
                        * field for FavourableActivityList
                        */

                        
                                    protected com.jcommerce.ws.server.FavourableActivityList localFavourableActivityList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFavourableActivityListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.FavourableActivityList
                           */
                           public  com.jcommerce.ws.server.FavourableActivityList getFavourableActivityList(){
                               return localFavourableActivityList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FavourableActivityList
                               */
                               public void setFavourableActivityList(com.jcommerce.ws.server.FavourableActivityList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFavourableActivityListTracker = true;
                                       } else {
                                          localFavourableActivityListTracker = false;
                                              
                                       }
                                   
                                            this.localFavourableActivityList=param;
                                    

                               }
                            

                        /**
                        * field for FeedbackList
                        */

                        
                                    protected com.jcommerce.ws.server.FeedbackList localFeedbackList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFeedbackListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.FeedbackList
                           */
                           public  com.jcommerce.ws.server.FeedbackList getFeedbackList(){
                               return localFeedbackList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FeedbackList
                               */
                               public void setFeedbackList(com.jcommerce.ws.server.FeedbackList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFeedbackListTracker = true;
                                       } else {
                                          localFeedbackListTracker = false;
                                              
                                       }
                                   
                                            this.localFeedbackList=param;
                                    

                               }
                            

                        /**
                        * field for FriendLinkList
                        */

                        
                                    protected com.jcommerce.ws.server.FriendLinkList localFriendLinkList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFriendLinkListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.FriendLinkList
                           */
                           public  com.jcommerce.ws.server.FriendLinkList getFriendLinkList(){
                               return localFriendLinkList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FriendLinkList
                               */
                               public void setFriendLinkList(com.jcommerce.ws.server.FriendLinkList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFriendLinkListTracker = true;
                                       } else {
                                          localFriendLinkListTracker = false;
                                              
                                       }
                                   
                                            this.localFriendLinkList=param;
                                    

                               }
                            

                        /**
                        * field for GalleryList
                        */

                        
                                    protected com.jcommerce.ws.server.GalleryList localGalleryList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGalleryListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GalleryList
                           */
                           public  com.jcommerce.ws.server.GalleryList getGalleryList(){
                               return localGalleryList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GalleryList
                               */
                               public void setGalleryList(com.jcommerce.ws.server.GalleryList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGalleryListTracker = true;
                                       } else {
                                          localGalleryListTracker = false;
                                              
                                       }
                                   
                                            this.localGalleryList=param;
                                    

                               }
                            

                        /**
                        * field for GoodsList
                        */

                        
                                    protected com.jcommerce.ws.server.GoodsList localGoodsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGoodsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GoodsList
                           */
                           public  com.jcommerce.ws.server.GoodsList getGoodsList(){
                               return localGoodsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsList
                               */
                               public void setGoodsList(com.jcommerce.ws.server.GoodsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGoodsListTracker = true;
                                       } else {
                                          localGoodsListTracker = false;
                                              
                                       }
                                   
                                            this.localGoodsList=param;
                                    

                               }
                            

                        /**
                        * field for GoodsActivityList
                        */

                        
                                    protected com.jcommerce.ws.server.GoodsActivityList localGoodsActivityList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGoodsActivityListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GoodsActivityList
                           */
                           public  com.jcommerce.ws.server.GoodsActivityList getGoodsActivityList(){
                               return localGoodsActivityList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsActivityList
                               */
                               public void setGoodsActivityList(com.jcommerce.ws.server.GoodsActivityList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGoodsActivityListTracker = true;
                                       } else {
                                          localGoodsActivityListTracker = false;
                                              
                                       }
                                   
                                            this.localGoodsActivityList=param;
                                    

                               }
                            

                        /**
                        * field for GoodsArticleList
                        */

                        
                                    protected com.jcommerce.ws.server.GoodsArticleList localGoodsArticleList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGoodsArticleListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GoodsArticleList
                           */
                           public  com.jcommerce.ws.server.GoodsArticleList getGoodsArticleList(){
                               return localGoodsArticleList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsArticleList
                               */
                               public void setGoodsArticleList(com.jcommerce.ws.server.GoodsArticleList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGoodsArticleListTracker = true;
                                       } else {
                                          localGoodsArticleListTracker = false;
                                              
                                       }
                                   
                                            this.localGoodsArticleList=param;
                                    

                               }
                            

                        /**
                        * field for GoodsAttributeList
                        */

                        
                                    protected com.jcommerce.ws.server.GoodsAttributeList localGoodsAttributeList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGoodsAttributeListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GoodsAttributeList
                           */
                           public  com.jcommerce.ws.server.GoodsAttributeList getGoodsAttributeList(){
                               return localGoodsAttributeList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsAttributeList
                               */
                               public void setGoodsAttributeList(com.jcommerce.ws.server.GoodsAttributeList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGoodsAttributeListTracker = true;
                                       } else {
                                          localGoodsAttributeListTracker = false;
                                              
                                       }
                                   
                                            this.localGoodsAttributeList=param;
                                    

                               }
                            

                        /**
                        * field for GoodsTypeList
                        */

                        
                                    protected com.jcommerce.ws.server.GoodsTypeList localGoodsTypeList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGoodsTypeListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GoodsTypeList
                           */
                           public  com.jcommerce.ws.server.GoodsTypeList getGoodsTypeList(){
                               return localGoodsTypeList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsTypeList
                               */
                               public void setGoodsTypeList(com.jcommerce.ws.server.GoodsTypeList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGoodsTypeListTracker = true;
                                       } else {
                                          localGoodsTypeListTracker = false;
                                              
                                       }
                                   
                                            this.localGoodsTypeList=param;
                                    

                               }
                            

                        /**
                        * field for GroupGoodsList
                        */

                        
                                    protected com.jcommerce.ws.server.GroupGoodsList localGroupGoodsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupGoodsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.GroupGoodsList
                           */
                           public  com.jcommerce.ws.server.GroupGoodsList getGroupGoodsList(){
                               return localGroupGoodsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GroupGoodsList
                               */
                               public void setGroupGoodsList(com.jcommerce.ws.server.GroupGoodsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGroupGoodsListTracker = true;
                                       } else {
                                          localGroupGoodsListTracker = false;
                                              
                                       }
                                   
                                            this.localGroupGoodsList=param;
                                    

                               }
                            

                        /**
                        * field for KeywordsList
                        */

                        
                                    protected com.jcommerce.ws.server.KeywordsList localKeywordsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localKeywordsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.KeywordsList
                           */
                           public  com.jcommerce.ws.server.KeywordsList getKeywordsList(){
                               return localKeywordsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param KeywordsList
                               */
                               public void setKeywordsList(com.jcommerce.ws.server.KeywordsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localKeywordsListTracker = true;
                                       } else {
                                          localKeywordsListTracker = false;
                                              
                                       }
                                   
                                            this.localKeywordsList=param;
                                    

                               }
                            

                        /**
                        * field for LinkGoodsList
                        */

                        
                                    protected com.jcommerce.ws.server.LinkGoodsList localLinkGoodsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLinkGoodsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.LinkGoodsList
                           */
                           public  com.jcommerce.ws.server.LinkGoodsList getLinkGoodsList(){
                               return localLinkGoodsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LinkGoodsList
                               */
                               public void setLinkGoodsList(com.jcommerce.ws.server.LinkGoodsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLinkGoodsListTracker = true;
                                       } else {
                                          localLinkGoodsListTracker = false;
                                              
                                       }
                                   
                                            this.localLinkGoodsList=param;
                                    

                               }
                            

                        /**
                        * field for MailTemplateList
                        */

                        
                                    protected com.jcommerce.ws.server.MailTemplateList localMailTemplateList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMailTemplateListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.MailTemplateList
                           */
                           public  com.jcommerce.ws.server.MailTemplateList getMailTemplateList(){
                               return localMailTemplateList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MailTemplateList
                               */
                               public void setMailTemplateList(com.jcommerce.ws.server.MailTemplateList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMailTemplateListTracker = true;
                                       } else {
                                          localMailTemplateListTracker = false;
                                              
                                       }
                                   
                                            this.localMailTemplateList=param;
                                    

                               }
                            

                        /**
                        * field for MemberPriceList
                        */

                        
                                    protected com.jcommerce.ws.server.MemberPriceList localMemberPriceList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMemberPriceListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.MemberPriceList
                           */
                           public  com.jcommerce.ws.server.MemberPriceList getMemberPriceList(){
                               return localMemberPriceList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MemberPriceList
                               */
                               public void setMemberPriceList(com.jcommerce.ws.server.MemberPriceList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMemberPriceListTracker = true;
                                       } else {
                                          localMemberPriceListTracker = false;
                                              
                                       }
                                   
                                            this.localMemberPriceList=param;
                                    

                               }
                            

                        /**
                        * field for NavigationList
                        */

                        
                                    protected com.jcommerce.ws.server.NavigationList localNavigationList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNavigationListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.NavigationList
                           */
                           public  com.jcommerce.ws.server.NavigationList getNavigationList(){
                               return localNavigationList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NavigationList
                               */
                               public void setNavigationList(com.jcommerce.ws.server.NavigationList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNavigationListTracker = true;
                                       } else {
                                          localNavigationListTracker = false;
                                              
                                       }
                                   
                                            this.localNavigationList=param;
                                    

                               }
                            

                        /**
                        * field for OrderList
                        */

                        
                                    protected com.jcommerce.ws.server.OrderList localOrderList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrderListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.OrderList
                           */
                           public  com.jcommerce.ws.server.OrderList getOrderList(){
                               return localOrderList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OrderList
                               */
                               public void setOrderList(com.jcommerce.ws.server.OrderList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOrderListTracker = true;
                                       } else {
                                          localOrderListTracker = false;
                                              
                                       }
                                   
                                            this.localOrderList=param;
                                    

                               }
                            

                        /**
                        * field for OrderActionList
                        */

                        
                                    protected com.jcommerce.ws.server.OrderActionList localOrderActionList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrderActionListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.OrderActionList
                           */
                           public  com.jcommerce.ws.server.OrderActionList getOrderActionList(){
                               return localOrderActionList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OrderActionList
                               */
                               public void setOrderActionList(com.jcommerce.ws.server.OrderActionList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOrderActionListTracker = true;
                                       } else {
                                          localOrderActionListTracker = false;
                                              
                                       }
                                   
                                            this.localOrderActionList=param;
                                    

                               }
                            

                        /**
                        * field for OrderGoodsList
                        */

                        
                                    protected com.jcommerce.ws.server.OrderGoodsList localOrderGoodsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrderGoodsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.OrderGoodsList
                           */
                           public  com.jcommerce.ws.server.OrderGoodsList getOrderGoodsList(){
                               return localOrderGoodsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OrderGoodsList
                               */
                               public void setOrderGoodsList(com.jcommerce.ws.server.OrderGoodsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOrderGoodsListTracker = true;
                                       } else {
                                          localOrderGoodsListTracker = false;
                                              
                                       }
                                   
                                            this.localOrderGoodsList=param;
                                    

                               }
                            

                        /**
                        * field for PackList
                        */

                        
                                    protected com.jcommerce.ws.server.PackList localPackList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPackListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.PackList
                           */
                           public  com.jcommerce.ws.server.PackList getPackList(){
                               return localPackList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PackList
                               */
                               public void setPackList(com.jcommerce.ws.server.PackList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPackListTracker = true;
                                       } else {
                                          localPackListTracker = false;
                                              
                                       }
                                   
                                            this.localPackList=param;
                                    

                               }
                            

                        /**
                        * field for PayLogList
                        */

                        
                                    protected com.jcommerce.ws.server.PayLogList localPayLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPayLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.PayLogList
                           */
                           public  com.jcommerce.ws.server.PayLogList getPayLogList(){
                               return localPayLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PayLogList
                               */
                               public void setPayLogList(com.jcommerce.ws.server.PayLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPayLogListTracker = true;
                                       } else {
                                          localPayLogListTracker = false;
                                              
                                       }
                                   
                                            this.localPayLogList=param;
                                    

                               }
                            

                        /**
                        * field for PaymentList
                        */

                        
                                    protected com.jcommerce.ws.server.PaymentList localPaymentList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPaymentListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.PaymentList
                           */
                           public  com.jcommerce.ws.server.PaymentList getPaymentList(){
                               return localPaymentList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PaymentList
                               */
                               public void setPaymentList(com.jcommerce.ws.server.PaymentList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPaymentListTracker = true;
                                       } else {
                                          localPaymentListTracker = false;
                                              
                                       }
                                   
                                            this.localPaymentList=param;
                                    

                               }
                            

                        /**
                        * field for PluginsList
                        */

                        
                                    protected com.jcommerce.ws.server.PluginsList localPluginsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPluginsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.PluginsList
                           */
                           public  com.jcommerce.ws.server.PluginsList getPluginsList(){
                               return localPluginsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PluginsList
                               */
                               public void setPluginsList(com.jcommerce.ws.server.PluginsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPluginsListTracker = true;
                                       } else {
                                          localPluginsListTracker = false;
                                              
                                       }
                                   
                                            this.localPluginsList=param;
                                    

                               }
                            

                        /**
                        * field for RegionList
                        */

                        
                                    protected com.jcommerce.ws.server.RegionList localRegionList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRegionListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.RegionList
                           */
                           public  com.jcommerce.ws.server.RegionList getRegionList(){
                               return localRegionList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RegionList
                               */
                               public void setRegionList(com.jcommerce.ws.server.RegionList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRegionListTracker = true;
                                       } else {
                                          localRegionListTracker = false;
                                              
                                       }
                                   
                                            this.localRegionList=param;
                                    

                               }
                            

                        /**
                        * field for SearchEngineList
                        */

                        
                                    protected com.jcommerce.ws.server.SearchEngineList localSearchEngineList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSearchEngineListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.SearchEngineList
                           */
                           public  com.jcommerce.ws.server.SearchEngineList getSearchEngineList(){
                               return localSearchEngineList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SearchEngineList
                               */
                               public void setSearchEngineList(com.jcommerce.ws.server.SearchEngineList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSearchEngineListTracker = true;
                                       } else {
                                          localSearchEngineListTracker = false;
                                              
                                       }
                                   
                                            this.localSearchEngineList=param;
                                    

                               }
                            

                        /**
                        * field for SessionList
                        */

                        
                                    protected com.jcommerce.ws.server.SessionList localSessionList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSessionListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.SessionList
                           */
                           public  com.jcommerce.ws.server.SessionList getSessionList(){
                               return localSessionList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SessionList
                               */
                               public void setSessionList(com.jcommerce.ws.server.SessionList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSessionListTracker = true;
                                       } else {
                                          localSessionListTracker = false;
                                              
                                       }
                                   
                                            this.localSessionList=param;
                                    

                               }
                            

                        /**
                        * field for SessionsDataList
                        */

                        
                                    protected com.jcommerce.ws.server.SessionsDataList localSessionsDataList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSessionsDataListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.SessionsDataList
                           */
                           public  com.jcommerce.ws.server.SessionsDataList getSessionsDataList(){
                               return localSessionsDataList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SessionsDataList
                               */
                               public void setSessionsDataList(com.jcommerce.ws.server.SessionsDataList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSessionsDataListTracker = true;
                                       } else {
                                          localSessionsDataListTracker = false;
                                              
                                       }
                                   
                                            this.localSessionsDataList=param;
                                    

                               }
                            

                        /**
                        * field for ShippingList
                        */

                        
                                    protected com.jcommerce.ws.server.ShippingList localShippingList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShippingListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.ShippingList
                           */
                           public  com.jcommerce.ws.server.ShippingList getShippingList(){
                               return localShippingList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShippingList
                               */
                               public void setShippingList(com.jcommerce.ws.server.ShippingList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localShippingListTracker = true;
                                       } else {
                                          localShippingListTracker = false;
                                              
                                       }
                                   
                                            this.localShippingList=param;
                                    

                               }
                            

                        /**
                        * field for ShippingAreaList
                        */

                        
                                    protected com.jcommerce.ws.server.ShippingAreaList localShippingAreaList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShippingAreaListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.ShippingAreaList
                           */
                           public  com.jcommerce.ws.server.ShippingAreaList getShippingAreaList(){
                               return localShippingAreaList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShippingAreaList
                               */
                               public void setShippingAreaList(com.jcommerce.ws.server.ShippingAreaList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localShippingAreaListTracker = true;
                                       } else {
                                          localShippingAreaListTracker = false;
                                              
                                       }
                                   
                                            this.localShippingAreaList=param;
                                    

                               }
                            

                        /**
                        * field for ShopConfigList
                        */

                        
                                    protected com.jcommerce.ws.server.ShopConfigList localShopConfigList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShopConfigListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.ShopConfigList
                           */
                           public  com.jcommerce.ws.server.ShopConfigList getShopConfigList(){
                               return localShopConfigList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShopConfigList
                               */
                               public void setShopConfigList(com.jcommerce.ws.server.ShopConfigList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localShopConfigListTracker = true;
                                       } else {
                                          localShopConfigListTracker = false;
                                              
                                       }
                                   
                                            this.localShopConfigList=param;
                                    

                               }
                            

                        /**
                        * field for SnatchLogList
                        */

                        
                                    protected com.jcommerce.ws.server.SnatchLogList localSnatchLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSnatchLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.SnatchLogList
                           */
                           public  com.jcommerce.ws.server.SnatchLogList getSnatchLogList(){
                               return localSnatchLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SnatchLogList
                               */
                               public void setSnatchLogList(com.jcommerce.ws.server.SnatchLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSnatchLogListTracker = true;
                                       } else {
                                          localSnatchLogListTracker = false;
                                              
                                       }
                                   
                                            this.localSnatchLogList=param;
                                    

                               }
                            

                        /**
                        * field for StatsList
                        */

                        
                                    protected com.jcommerce.ws.server.StatsList localStatsList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatsListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.StatsList
                           */
                           public  com.jcommerce.ws.server.StatsList getStatsList(){
                               return localStatsList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatsList
                               */
                               public void setStatsList(com.jcommerce.ws.server.StatsList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localStatsListTracker = true;
                                       } else {
                                          localStatsListTracker = false;
                                              
                                       }
                                   
                                            this.localStatsList=param;
                                    

                               }
                            

                        /**
                        * field for TagList
                        */

                        
                                    protected com.jcommerce.ws.server.TagList localTagList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTagListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.TagList
                           */
                           public  com.jcommerce.ws.server.TagList getTagList(){
                               return localTagList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TagList
                               */
                               public void setTagList(com.jcommerce.ws.server.TagList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTagListTracker = true;
                                       } else {
                                          localTagListTracker = false;
                                              
                                       }
                                   
                                            this.localTagList=param;
                                    

                               }
                            

                        /**
                        * field for TopicList
                        */

                        
                                    protected com.jcommerce.ws.server.TopicList localTopicList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTopicListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.TopicList
                           */
                           public  com.jcommerce.ws.server.TopicList getTopicList(){
                               return localTopicList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TopicList
                               */
                               public void setTopicList(com.jcommerce.ws.server.TopicList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTopicListTracker = true;
                                       } else {
                                          localTopicListTracker = false;
                                              
                                       }
                                   
                                            this.localTopicList=param;
                                    

                               }
                            

                        /**
                        * field for UserList
                        */

                        
                                    protected com.jcommerce.ws.server.UserList localUserList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.UserList
                           */
                           public  com.jcommerce.ws.server.UserList getUserList(){
                               return localUserList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserList
                               */
                               public void setUserList(com.jcommerce.ws.server.UserList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUserListTracker = true;
                                       } else {
                                          localUserListTracker = false;
                                              
                                       }
                                   
                                            this.localUserList=param;
                                    

                               }
                            

                        /**
                        * field for UserAccountList
                        */

                        
                                    protected com.jcommerce.ws.server.UserAccountList localUserAccountList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserAccountListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.UserAccountList
                           */
                           public  com.jcommerce.ws.server.UserAccountList getUserAccountList(){
                               return localUserAccountList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserAccountList
                               */
                               public void setUserAccountList(com.jcommerce.ws.server.UserAccountList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUserAccountListTracker = true;
                                       } else {
                                          localUserAccountListTracker = false;
                                              
                                       }
                                   
                                            this.localUserAccountList=param;
                                    

                               }
                            

                        /**
                        * field for UserAddressList
                        */

                        
                                    protected com.jcommerce.ws.server.UserAddressList localUserAddressList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserAddressListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.UserAddressList
                           */
                           public  com.jcommerce.ws.server.UserAddressList getUserAddressList(){
                               return localUserAddressList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserAddressList
                               */
                               public void setUserAddressList(com.jcommerce.ws.server.UserAddressList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUserAddressListTracker = true;
                                       } else {
                                          localUserAddressListTracker = false;
                                              
                                       }
                                   
                                            this.localUserAddressList=param;
                                    

                               }
                            

                        /**
                        * field for UserBonusList
                        */

                        
                                    protected com.jcommerce.ws.server.UserBonusList localUserBonusList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserBonusListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.UserBonusList
                           */
                           public  com.jcommerce.ws.server.UserBonusList getUserBonusList(){
                               return localUserBonusList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserBonusList
                               */
                               public void setUserBonusList(com.jcommerce.ws.server.UserBonusList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUserBonusListTracker = true;
                                       } else {
                                          localUserBonusListTracker = false;
                                              
                                       }
                                   
                                            this.localUserBonusList=param;
                                    

                               }
                            

                        /**
                        * field for UserRankList
                        */

                        
                                    protected com.jcommerce.ws.server.UserRankList localUserRankList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUserRankListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.UserRankList
                           */
                           public  com.jcommerce.ws.server.UserRankList getUserRankList(){
                               return localUserRankList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UserRankList
                               */
                               public void setUserRankList(com.jcommerce.ws.server.UserRankList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUserRankListTracker = true;
                                       } else {
                                          localUserRankListTracker = false;
                                              
                                       }
                                   
                                            this.localUserRankList=param;
                                    

                               }
                            

                        /**
                        * field for VirtualCardList
                        */

                        
                                    protected com.jcommerce.ws.server.VirtualCardList localVirtualCardList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVirtualCardListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.VirtualCardList
                           */
                           public  com.jcommerce.ws.server.VirtualCardList getVirtualCardList(){
                               return localVirtualCardList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VirtualCardList
                               */
                               public void setVirtualCardList(com.jcommerce.ws.server.VirtualCardList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVirtualCardListTracker = true;
                                       } else {
                                          localVirtualCardListTracker = false;
                                              
                                       }
                                   
                                            this.localVirtualCardList=param;
                                    

                               }
                            

                        /**
                        * field for VoteList
                        */

                        
                                    protected com.jcommerce.ws.server.VoteList localVoteList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVoteListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.VoteList
                           */
                           public  com.jcommerce.ws.server.VoteList getVoteList(){
                               return localVoteList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VoteList
                               */
                               public void setVoteList(com.jcommerce.ws.server.VoteList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVoteListTracker = true;
                                       } else {
                                          localVoteListTracker = false;
                                              
                                       }
                                   
                                            this.localVoteList=param;
                                    

                               }
                            

                        /**
                        * field for VoteDataList
                        */

                        
                                    protected com.jcommerce.ws.server.VoteDataList localVoteDataList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVoteDataListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.VoteDataList
                           */
                           public  com.jcommerce.ws.server.VoteDataList getVoteDataList(){
                               return localVoteDataList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VoteDataList
                               */
                               public void setVoteDataList(com.jcommerce.ws.server.VoteDataList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVoteDataListTracker = true;
                                       } else {
                                          localVoteDataListTracker = false;
                                              
                                       }
                                   
                                            this.localVoteDataList=param;
                                    

                               }
                            

                        /**
                        * field for VoteLogList
                        */

                        
                                    protected com.jcommerce.ws.server.VoteLogList localVoteLogList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVoteLogListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.VoteLogList
                           */
                           public  com.jcommerce.ws.server.VoteLogList getVoteLogList(){
                               return localVoteLogList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VoteLogList
                               */
                               public void setVoteLogList(com.jcommerce.ws.server.VoteLogList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVoteLogListTracker = true;
                                       } else {
                                          localVoteLogListTracker = false;
                                              
                                       }
                                   
                                            this.localVoteLogList=param;
                                    

                               }
                            

                        /**
                        * field for WholesaleList
                        */

                        
                                    protected com.jcommerce.ws.server.WholesaleList localWholesaleList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWholesaleListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.WholesaleList
                           */
                           public  com.jcommerce.ws.server.WholesaleList getWholesaleList(){
                               return localWholesaleList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WholesaleList
                               */
                               public void setWholesaleList(com.jcommerce.ws.server.WholesaleList param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localWholesaleListTracker = true;
                                       } else {
                                          localWholesaleListTracker = false;
                                              
                                       }
                                   
                                            this.localWholesaleList=param;
                                    

                               }
                            

                        /**
                        * field for Status
                        */

                        
                                    protected com.jcommerce.ws.server.StatusType localStatus ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.jcommerce.ws.server.StatusType
                           */
                           public  com.jcommerce.ws.server.StatusType getStatus(){
                               return localStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Status
                               */
                               public void setStatus(com.jcommerce.ws.server.StatusType param){
                            
                                            this.localStatus=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       XXXRESP.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://ws.jcommerce.com/");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":XXXRESP",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "XXXRESP",
                           xmlWriter);
                   }

               
                   }
                if (localObjIdTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"objId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"objId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("objId");
                                    }
                                
                                               if (localObjId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("objId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localObjId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTotalNumberTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"totalNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"totalNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("totalNumber");
                                    }
                                
                                               if (localTotalNumber==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("totalNumber cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalNumber));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAccountLogListTracker){
                                            if (localAccountLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AccountLogList cannot be null!!");
                                            }
                                           localAccountLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AccountLogList"),
                                               factory,xmlWriter);
                                        } if (localAdminActionListTracker){
                                            if (localAdminActionList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdminActionList cannot be null!!");
                                            }
                                           localAdminActionList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminActionList"),
                                               factory,xmlWriter);
                                        } if (localAdminLogListTracker){
                                            if (localAdminLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdminLogList cannot be null!!");
                                            }
                                           localAdminLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminLogList"),
                                               factory,xmlWriter);
                                        } if (localAdminMessageListTracker){
                                            if (localAdminMessageList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdminMessageList cannot be null!!");
                                            }
                                           localAdminMessageList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminMessageList"),
                                               factory,xmlWriter);
                                        } if (localAdminUserListTracker){
                                            if (localAdminUserList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdminUserList cannot be null!!");
                                            }
                                           localAdminUserList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminUserList"),
                                               factory,xmlWriter);
                                        } if (localAdPositionListTracker){
                                            if (localAdPositionList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdPositionList cannot be null!!");
                                            }
                                           localAdPositionList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdPositionList"),
                                               factory,xmlWriter);
                                        } if (localAdsenseListTracker){
                                            if (localAdsenseList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdsenseList cannot be null!!");
                                            }
                                           localAdsenseList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdsenseList"),
                                               factory,xmlWriter);
                                        } if (localAdvertisementListTracker){
                                            if (localAdvertisementList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AdvertisementList cannot be null!!");
                                            }
                                           localAdvertisementList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdvertisementList"),
                                               factory,xmlWriter);
                                        } if (localAffiliateLogListTracker){
                                            if (localAffiliateLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AffiliateLogList cannot be null!!");
                                            }
                                           localAffiliateLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AffiliateLogList"),
                                               factory,xmlWriter);
                                        } if (localAgencyListTracker){
                                            if (localAgencyList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AgencyList cannot be null!!");
                                            }
                                           localAgencyList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AgencyList"),
                                               factory,xmlWriter);
                                        } if (localArticleListTracker){
                                            if (localArticleList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ArticleList cannot be null!!");
                                            }
                                           localArticleList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","ArticleList"),
                                               factory,xmlWriter);
                                        } if (localArticleCategoryListTracker){
                                            if (localArticleCategoryList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ArticleCategoryList cannot be null!!");
                                            }
                                           localArticleCategoryList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","ArticleCategoryList"),
                                               factory,xmlWriter);
                                        } if (localAttributeListTracker){
                                            if (localAttributeList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AttributeList cannot be null!!");
                                            }
                                           localAttributeList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AttributeList"),
                                               factory,xmlWriter);
                                        } if (localAuctionLogListTracker){
                                            if (localAuctionLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AuctionLogList cannot be null!!");
                                            }
                                           localAuctionLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AuctionLogList"),
                                               factory,xmlWriter);
                                        } if (localAutoManageListTracker){
                                            if (localAutoManageList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AutoManageList cannot be null!!");
                                            }
                                           localAutoManageList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","AutoManageList"),
                                               factory,xmlWriter);
                                        } if (localBonusTypeListTracker){
                                            if (localBonusTypeList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BonusTypeList cannot be null!!");
                                            }
                                           localBonusTypeList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","BonusTypeList"),
                                               factory,xmlWriter);
                                        } if (localBookingGoodsListTracker){
                                            if (localBookingGoodsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BookingGoodsList cannot be null!!");
                                            }
                                           localBookingGoodsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","BookingGoodsList"),
                                               factory,xmlWriter);
                                        } if (localBrandListTracker){
                                            if (localBrandList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BrandList cannot be null!!");
                                            }
                                           localBrandList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","BrandList"),
                                               factory,xmlWriter);
                                        } if (localCardListTracker){
                                            if (localCardList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CardList cannot be null!!");
                                            }
                                           localCardList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","CardList"),
                                               factory,xmlWriter);
                                        } if (localCartListTracker){
                                            if (localCartList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CartList cannot be null!!");
                                            }
                                           localCartList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","CartList"),
                                               factory,xmlWriter);
                                        } if (localCategoryListTracker){
                                            if (localCategoryList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CategoryList cannot be null!!");
                                            }
                                           localCategoryList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","CategoryList"),
                                               factory,xmlWriter);
                                        } if (localCollectGoodsListTracker){
                                            if (localCollectGoodsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CollectGoodsList cannot be null!!");
                                            }
                                           localCollectGoodsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","CollectGoodsList"),
                                               factory,xmlWriter);
                                        } if (localCommentListTracker){
                                            if (localCommentList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CommentList cannot be null!!");
                                            }
                                           localCommentList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","CommentList"),
                                               factory,xmlWriter);
                                        } if (localCronsListTracker){
                                            if (localCronsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CronsList cannot be null!!");
                                            }
                                           localCronsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","CronsList"),
                                               factory,xmlWriter);
                                        } if (localEmailListListTracker){
                                            if (localEmailListList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EmailListList cannot be null!!");
                                            }
                                           localEmailListList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","EmailListList"),
                                               factory,xmlWriter);
                                        } if (localEmailSendListListTracker){
                                            if (localEmailSendListList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EmailSendListList cannot be null!!");
                                            }
                                           localEmailSendListList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","EmailSendListList"),
                                               factory,xmlWriter);
                                        } if (localErrorLogListTracker){
                                            if (localErrorLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ErrorLogList cannot be null!!");
                                            }
                                           localErrorLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","ErrorLogList"),
                                               factory,xmlWriter);
                                        } if (localFailedLoginListTracker){
                                            if (localFailedLoginList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FailedLoginList cannot be null!!");
                                            }
                                           localFailedLoginList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","FailedLoginList"),
                                               factory,xmlWriter);
                                        } if (localFavourableActivityListTracker){
                                            if (localFavourableActivityList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FavourableActivityList cannot be null!!");
                                            }
                                           localFavourableActivityList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","FavourableActivityList"),
                                               factory,xmlWriter);
                                        } if (localFeedbackListTracker){
                                            if (localFeedbackList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FeedbackList cannot be null!!");
                                            }
                                           localFeedbackList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","FeedbackList"),
                                               factory,xmlWriter);
                                        } if (localFriendLinkListTracker){
                                            if (localFriendLinkList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FriendLinkList cannot be null!!");
                                            }
                                           localFriendLinkList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","FriendLinkList"),
                                               factory,xmlWriter);
                                        } if (localGalleryListTracker){
                                            if (localGalleryList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GalleryList cannot be null!!");
                                            }
                                           localGalleryList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GalleryList"),
                                               factory,xmlWriter);
                                        } if (localGoodsListTracker){
                                            if (localGoodsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GoodsList cannot be null!!");
                                            }
                                           localGoodsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsList"),
                                               factory,xmlWriter);
                                        } if (localGoodsActivityListTracker){
                                            if (localGoodsActivityList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GoodsActivityList cannot be null!!");
                                            }
                                           localGoodsActivityList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsActivityList"),
                                               factory,xmlWriter);
                                        } if (localGoodsArticleListTracker){
                                            if (localGoodsArticleList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GoodsArticleList cannot be null!!");
                                            }
                                           localGoodsArticleList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsArticleList"),
                                               factory,xmlWriter);
                                        } if (localGoodsAttributeListTracker){
                                            if (localGoodsAttributeList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GoodsAttributeList cannot be null!!");
                                            }
                                           localGoodsAttributeList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsAttributeList"),
                                               factory,xmlWriter);
                                        } if (localGoodsTypeListTracker){
                                            if (localGoodsTypeList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GoodsTypeList cannot be null!!");
                                            }
                                           localGoodsTypeList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsTypeList"),
                                               factory,xmlWriter);
                                        } if (localGroupGoodsListTracker){
                                            if (localGroupGoodsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GroupGoodsList cannot be null!!");
                                            }
                                           localGroupGoodsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","GroupGoodsList"),
                                               factory,xmlWriter);
                                        } if (localKeywordsListTracker){
                                            if (localKeywordsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("KeywordsList cannot be null!!");
                                            }
                                           localKeywordsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","KeywordsList"),
                                               factory,xmlWriter);
                                        } if (localLinkGoodsListTracker){
                                            if (localLinkGoodsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("LinkGoodsList cannot be null!!");
                                            }
                                           localLinkGoodsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","LinkGoodsList"),
                                               factory,xmlWriter);
                                        } if (localMailTemplateListTracker){
                                            if (localMailTemplateList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MailTemplateList cannot be null!!");
                                            }
                                           localMailTemplateList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","MailTemplateList"),
                                               factory,xmlWriter);
                                        } if (localMemberPriceListTracker){
                                            if (localMemberPriceList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MemberPriceList cannot be null!!");
                                            }
                                           localMemberPriceList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","MemberPriceList"),
                                               factory,xmlWriter);
                                        } if (localNavigationListTracker){
                                            if (localNavigationList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NavigationList cannot be null!!");
                                            }
                                           localNavigationList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","NavigationList"),
                                               factory,xmlWriter);
                                        } if (localOrderListTracker){
                                            if (localOrderList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("OrderList cannot be null!!");
                                            }
                                           localOrderList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","OrderList"),
                                               factory,xmlWriter);
                                        } if (localOrderActionListTracker){
                                            if (localOrderActionList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("OrderActionList cannot be null!!");
                                            }
                                           localOrderActionList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","OrderActionList"),
                                               factory,xmlWriter);
                                        } if (localOrderGoodsListTracker){
                                            if (localOrderGoodsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("OrderGoodsList cannot be null!!");
                                            }
                                           localOrderGoodsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","OrderGoodsList"),
                                               factory,xmlWriter);
                                        } if (localPackListTracker){
                                            if (localPackList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PackList cannot be null!!");
                                            }
                                           localPackList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","PackList"),
                                               factory,xmlWriter);
                                        } if (localPayLogListTracker){
                                            if (localPayLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PayLogList cannot be null!!");
                                            }
                                           localPayLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","PayLogList"),
                                               factory,xmlWriter);
                                        } if (localPaymentListTracker){
                                            if (localPaymentList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PaymentList cannot be null!!");
                                            }
                                           localPaymentList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","PaymentList"),
                                               factory,xmlWriter);
                                        } if (localPluginsListTracker){
                                            if (localPluginsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PluginsList cannot be null!!");
                                            }
                                           localPluginsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","PluginsList"),
                                               factory,xmlWriter);
                                        } if (localRegionListTracker){
                                            if (localRegionList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("RegionList cannot be null!!");
                                            }
                                           localRegionList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","RegionList"),
                                               factory,xmlWriter);
                                        } if (localSearchEngineListTracker){
                                            if (localSearchEngineList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SearchEngineList cannot be null!!");
                                            }
                                           localSearchEngineList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","SearchEngineList"),
                                               factory,xmlWriter);
                                        } if (localSessionListTracker){
                                            if (localSessionList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SessionList cannot be null!!");
                                            }
                                           localSessionList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","SessionList"),
                                               factory,xmlWriter);
                                        } if (localSessionsDataListTracker){
                                            if (localSessionsDataList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SessionsDataList cannot be null!!");
                                            }
                                           localSessionsDataList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","SessionsDataList"),
                                               factory,xmlWriter);
                                        } if (localShippingListTracker){
                                            if (localShippingList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ShippingList cannot be null!!");
                                            }
                                           localShippingList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","ShippingList"),
                                               factory,xmlWriter);
                                        } if (localShippingAreaListTracker){
                                            if (localShippingAreaList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ShippingAreaList cannot be null!!");
                                            }
                                           localShippingAreaList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","ShippingAreaList"),
                                               factory,xmlWriter);
                                        } if (localShopConfigListTracker){
                                            if (localShopConfigList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ShopConfigList cannot be null!!");
                                            }
                                           localShopConfigList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","ShopConfigList"),
                                               factory,xmlWriter);
                                        } if (localSnatchLogListTracker){
                                            if (localSnatchLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SnatchLogList cannot be null!!");
                                            }
                                           localSnatchLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","SnatchLogList"),
                                               factory,xmlWriter);
                                        } if (localStatsListTracker){
                                            if (localStatsList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("StatsList cannot be null!!");
                                            }
                                           localStatsList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","StatsList"),
                                               factory,xmlWriter);
                                        } if (localTagListTracker){
                                            if (localTagList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TagList cannot be null!!");
                                            }
                                           localTagList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","TagList"),
                                               factory,xmlWriter);
                                        } if (localTopicListTracker){
                                            if (localTopicList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TopicList cannot be null!!");
                                            }
                                           localTopicList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","TopicList"),
                                               factory,xmlWriter);
                                        } if (localUserListTracker){
                                            if (localUserList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UserList cannot be null!!");
                                            }
                                           localUserList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserList"),
                                               factory,xmlWriter);
                                        } if (localUserAccountListTracker){
                                            if (localUserAccountList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UserAccountList cannot be null!!");
                                            }
                                           localUserAccountList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserAccountList"),
                                               factory,xmlWriter);
                                        } if (localUserAddressListTracker){
                                            if (localUserAddressList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UserAddressList cannot be null!!");
                                            }
                                           localUserAddressList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserAddressList"),
                                               factory,xmlWriter);
                                        } if (localUserBonusListTracker){
                                            if (localUserBonusList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UserBonusList cannot be null!!");
                                            }
                                           localUserBonusList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserBonusList"),
                                               factory,xmlWriter);
                                        } if (localUserRankListTracker){
                                            if (localUserRankList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UserRankList cannot be null!!");
                                            }
                                           localUserRankList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserRankList"),
                                               factory,xmlWriter);
                                        } if (localVirtualCardListTracker){
                                            if (localVirtualCardList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VirtualCardList cannot be null!!");
                                            }
                                           localVirtualCardList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","VirtualCardList"),
                                               factory,xmlWriter);
                                        } if (localVoteListTracker){
                                            if (localVoteList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VoteList cannot be null!!");
                                            }
                                           localVoteList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","VoteList"),
                                               factory,xmlWriter);
                                        } if (localVoteDataListTracker){
                                            if (localVoteDataList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VoteDataList cannot be null!!");
                                            }
                                           localVoteDataList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","VoteDataList"),
                                               factory,xmlWriter);
                                        } if (localVoteLogListTracker){
                                            if (localVoteLogList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VoteLogList cannot be null!!");
                                            }
                                           localVoteLogList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","VoteLogList"),
                                               factory,xmlWriter);
                                        } if (localWholesaleListTracker){
                                            if (localWholesaleList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WholesaleList cannot be null!!");
                                            }
                                           localWholesaleList.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","WholesaleList"),
                                               factory,xmlWriter);
                                        }
                                            if (localStatus==null){
                                                 throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
                                            }
                                           localStatus.serialize(new javax.xml.namespace.QName("http://ws.jcommerce.com/","status"),
                                               factory,xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localObjIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "objId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localObjId));
                            } if (localTotalNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "totalNumber"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalNumber));
                            } if (localAccountLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AccountLogList"));
                            
                            
                                    if (localAccountLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AccountLogList cannot be null!!");
                                    }
                                    elementList.add(localAccountLogList);
                                } if (localAdminActionListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdminActionList"));
                            
                            
                                    if (localAdminActionList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdminActionList cannot be null!!");
                                    }
                                    elementList.add(localAdminActionList);
                                } if (localAdminLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdminLogList"));
                            
                            
                                    if (localAdminLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdminLogList cannot be null!!");
                                    }
                                    elementList.add(localAdminLogList);
                                } if (localAdminMessageListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdminMessageList"));
                            
                            
                                    if (localAdminMessageList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdminMessageList cannot be null!!");
                                    }
                                    elementList.add(localAdminMessageList);
                                } if (localAdminUserListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdminUserList"));
                            
                            
                                    if (localAdminUserList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdminUserList cannot be null!!");
                                    }
                                    elementList.add(localAdminUserList);
                                } if (localAdPositionListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdPositionList"));
                            
                            
                                    if (localAdPositionList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdPositionList cannot be null!!");
                                    }
                                    elementList.add(localAdPositionList);
                                } if (localAdsenseListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdsenseList"));
                            
                            
                                    if (localAdsenseList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdsenseList cannot be null!!");
                                    }
                                    elementList.add(localAdsenseList);
                                } if (localAdvertisementListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AdvertisementList"));
                            
                            
                                    if (localAdvertisementList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AdvertisementList cannot be null!!");
                                    }
                                    elementList.add(localAdvertisementList);
                                } if (localAffiliateLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AffiliateLogList"));
                            
                            
                                    if (localAffiliateLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AffiliateLogList cannot be null!!");
                                    }
                                    elementList.add(localAffiliateLogList);
                                } if (localAgencyListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AgencyList"));
                            
                            
                                    if (localAgencyList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AgencyList cannot be null!!");
                                    }
                                    elementList.add(localAgencyList);
                                } if (localArticleListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "ArticleList"));
                            
                            
                                    if (localArticleList==null){
                                         throw new org.apache.axis2.databinding.ADBException("ArticleList cannot be null!!");
                                    }
                                    elementList.add(localArticleList);
                                } if (localArticleCategoryListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "ArticleCategoryList"));
                            
                            
                                    if (localArticleCategoryList==null){
                                         throw new org.apache.axis2.databinding.ADBException("ArticleCategoryList cannot be null!!");
                                    }
                                    elementList.add(localArticleCategoryList);
                                } if (localAttributeListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AttributeList"));
                            
                            
                                    if (localAttributeList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AttributeList cannot be null!!");
                                    }
                                    elementList.add(localAttributeList);
                                } if (localAuctionLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AuctionLogList"));
                            
                            
                                    if (localAuctionLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AuctionLogList cannot be null!!");
                                    }
                                    elementList.add(localAuctionLogList);
                                } if (localAutoManageListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "AutoManageList"));
                            
                            
                                    if (localAutoManageList==null){
                                         throw new org.apache.axis2.databinding.ADBException("AutoManageList cannot be null!!");
                                    }
                                    elementList.add(localAutoManageList);
                                } if (localBonusTypeListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "BonusTypeList"));
                            
                            
                                    if (localBonusTypeList==null){
                                         throw new org.apache.axis2.databinding.ADBException("BonusTypeList cannot be null!!");
                                    }
                                    elementList.add(localBonusTypeList);
                                } if (localBookingGoodsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "BookingGoodsList"));
                            
                            
                                    if (localBookingGoodsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("BookingGoodsList cannot be null!!");
                                    }
                                    elementList.add(localBookingGoodsList);
                                } if (localBrandListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "BrandList"));
                            
                            
                                    if (localBrandList==null){
                                         throw new org.apache.axis2.databinding.ADBException("BrandList cannot be null!!");
                                    }
                                    elementList.add(localBrandList);
                                } if (localCardListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "CardList"));
                            
                            
                                    if (localCardList==null){
                                         throw new org.apache.axis2.databinding.ADBException("CardList cannot be null!!");
                                    }
                                    elementList.add(localCardList);
                                } if (localCartListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "CartList"));
                            
                            
                                    if (localCartList==null){
                                         throw new org.apache.axis2.databinding.ADBException("CartList cannot be null!!");
                                    }
                                    elementList.add(localCartList);
                                } if (localCategoryListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "CategoryList"));
                            
                            
                                    if (localCategoryList==null){
                                         throw new org.apache.axis2.databinding.ADBException("CategoryList cannot be null!!");
                                    }
                                    elementList.add(localCategoryList);
                                } if (localCollectGoodsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "CollectGoodsList"));
                            
                            
                                    if (localCollectGoodsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("CollectGoodsList cannot be null!!");
                                    }
                                    elementList.add(localCollectGoodsList);
                                } if (localCommentListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "CommentList"));
                            
                            
                                    if (localCommentList==null){
                                         throw new org.apache.axis2.databinding.ADBException("CommentList cannot be null!!");
                                    }
                                    elementList.add(localCommentList);
                                } if (localCronsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "CronsList"));
                            
                            
                                    if (localCronsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("CronsList cannot be null!!");
                                    }
                                    elementList.add(localCronsList);
                                } if (localEmailListListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "EmailListList"));
                            
                            
                                    if (localEmailListList==null){
                                         throw new org.apache.axis2.databinding.ADBException("EmailListList cannot be null!!");
                                    }
                                    elementList.add(localEmailListList);
                                } if (localEmailSendListListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "EmailSendListList"));
                            
                            
                                    if (localEmailSendListList==null){
                                         throw new org.apache.axis2.databinding.ADBException("EmailSendListList cannot be null!!");
                                    }
                                    elementList.add(localEmailSendListList);
                                } if (localErrorLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "ErrorLogList"));
                            
                            
                                    if (localErrorLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("ErrorLogList cannot be null!!");
                                    }
                                    elementList.add(localErrorLogList);
                                } if (localFailedLoginListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "FailedLoginList"));
                            
                            
                                    if (localFailedLoginList==null){
                                         throw new org.apache.axis2.databinding.ADBException("FailedLoginList cannot be null!!");
                                    }
                                    elementList.add(localFailedLoginList);
                                } if (localFavourableActivityListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "FavourableActivityList"));
                            
                            
                                    if (localFavourableActivityList==null){
                                         throw new org.apache.axis2.databinding.ADBException("FavourableActivityList cannot be null!!");
                                    }
                                    elementList.add(localFavourableActivityList);
                                } if (localFeedbackListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "FeedbackList"));
                            
                            
                                    if (localFeedbackList==null){
                                         throw new org.apache.axis2.databinding.ADBException("FeedbackList cannot be null!!");
                                    }
                                    elementList.add(localFeedbackList);
                                } if (localFriendLinkListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "FriendLinkList"));
                            
                            
                                    if (localFriendLinkList==null){
                                         throw new org.apache.axis2.databinding.ADBException("FriendLinkList cannot be null!!");
                                    }
                                    elementList.add(localFriendLinkList);
                                } if (localGalleryListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GalleryList"));
                            
                            
                                    if (localGalleryList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GalleryList cannot be null!!");
                                    }
                                    elementList.add(localGalleryList);
                                } if (localGoodsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GoodsList"));
                            
                            
                                    if (localGoodsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GoodsList cannot be null!!");
                                    }
                                    elementList.add(localGoodsList);
                                } if (localGoodsActivityListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GoodsActivityList"));
                            
                            
                                    if (localGoodsActivityList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GoodsActivityList cannot be null!!");
                                    }
                                    elementList.add(localGoodsActivityList);
                                } if (localGoodsArticleListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GoodsArticleList"));
                            
                            
                                    if (localGoodsArticleList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GoodsArticleList cannot be null!!");
                                    }
                                    elementList.add(localGoodsArticleList);
                                } if (localGoodsAttributeListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GoodsAttributeList"));
                            
                            
                                    if (localGoodsAttributeList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GoodsAttributeList cannot be null!!");
                                    }
                                    elementList.add(localGoodsAttributeList);
                                } if (localGoodsTypeListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GoodsTypeList"));
                            
                            
                                    if (localGoodsTypeList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GoodsTypeList cannot be null!!");
                                    }
                                    elementList.add(localGoodsTypeList);
                                } if (localGroupGoodsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "GroupGoodsList"));
                            
                            
                                    if (localGroupGoodsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("GroupGoodsList cannot be null!!");
                                    }
                                    elementList.add(localGroupGoodsList);
                                } if (localKeywordsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "KeywordsList"));
                            
                            
                                    if (localKeywordsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("KeywordsList cannot be null!!");
                                    }
                                    elementList.add(localKeywordsList);
                                } if (localLinkGoodsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "LinkGoodsList"));
                            
                            
                                    if (localLinkGoodsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("LinkGoodsList cannot be null!!");
                                    }
                                    elementList.add(localLinkGoodsList);
                                } if (localMailTemplateListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "MailTemplateList"));
                            
                            
                                    if (localMailTemplateList==null){
                                         throw new org.apache.axis2.databinding.ADBException("MailTemplateList cannot be null!!");
                                    }
                                    elementList.add(localMailTemplateList);
                                } if (localMemberPriceListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "MemberPriceList"));
                            
                            
                                    if (localMemberPriceList==null){
                                         throw new org.apache.axis2.databinding.ADBException("MemberPriceList cannot be null!!");
                                    }
                                    elementList.add(localMemberPriceList);
                                } if (localNavigationListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "NavigationList"));
                            
                            
                                    if (localNavigationList==null){
                                         throw new org.apache.axis2.databinding.ADBException("NavigationList cannot be null!!");
                                    }
                                    elementList.add(localNavigationList);
                                } if (localOrderListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "OrderList"));
                            
                            
                                    if (localOrderList==null){
                                         throw new org.apache.axis2.databinding.ADBException("OrderList cannot be null!!");
                                    }
                                    elementList.add(localOrderList);
                                } if (localOrderActionListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "OrderActionList"));
                            
                            
                                    if (localOrderActionList==null){
                                         throw new org.apache.axis2.databinding.ADBException("OrderActionList cannot be null!!");
                                    }
                                    elementList.add(localOrderActionList);
                                } if (localOrderGoodsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "OrderGoodsList"));
                            
                            
                                    if (localOrderGoodsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("OrderGoodsList cannot be null!!");
                                    }
                                    elementList.add(localOrderGoodsList);
                                } if (localPackListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "PackList"));
                            
                            
                                    if (localPackList==null){
                                         throw new org.apache.axis2.databinding.ADBException("PackList cannot be null!!");
                                    }
                                    elementList.add(localPackList);
                                } if (localPayLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "PayLogList"));
                            
                            
                                    if (localPayLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("PayLogList cannot be null!!");
                                    }
                                    elementList.add(localPayLogList);
                                } if (localPaymentListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "PaymentList"));
                            
                            
                                    if (localPaymentList==null){
                                         throw new org.apache.axis2.databinding.ADBException("PaymentList cannot be null!!");
                                    }
                                    elementList.add(localPaymentList);
                                } if (localPluginsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "PluginsList"));
                            
                            
                                    if (localPluginsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("PluginsList cannot be null!!");
                                    }
                                    elementList.add(localPluginsList);
                                } if (localRegionListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "RegionList"));
                            
                            
                                    if (localRegionList==null){
                                         throw new org.apache.axis2.databinding.ADBException("RegionList cannot be null!!");
                                    }
                                    elementList.add(localRegionList);
                                } if (localSearchEngineListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "SearchEngineList"));
                            
                            
                                    if (localSearchEngineList==null){
                                         throw new org.apache.axis2.databinding.ADBException("SearchEngineList cannot be null!!");
                                    }
                                    elementList.add(localSearchEngineList);
                                } if (localSessionListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "SessionList"));
                            
                            
                                    if (localSessionList==null){
                                         throw new org.apache.axis2.databinding.ADBException("SessionList cannot be null!!");
                                    }
                                    elementList.add(localSessionList);
                                } if (localSessionsDataListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "SessionsDataList"));
                            
                            
                                    if (localSessionsDataList==null){
                                         throw new org.apache.axis2.databinding.ADBException("SessionsDataList cannot be null!!");
                                    }
                                    elementList.add(localSessionsDataList);
                                } if (localShippingListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "ShippingList"));
                            
                            
                                    if (localShippingList==null){
                                         throw new org.apache.axis2.databinding.ADBException("ShippingList cannot be null!!");
                                    }
                                    elementList.add(localShippingList);
                                } if (localShippingAreaListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "ShippingAreaList"));
                            
                            
                                    if (localShippingAreaList==null){
                                         throw new org.apache.axis2.databinding.ADBException("ShippingAreaList cannot be null!!");
                                    }
                                    elementList.add(localShippingAreaList);
                                } if (localShopConfigListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "ShopConfigList"));
                            
                            
                                    if (localShopConfigList==null){
                                         throw new org.apache.axis2.databinding.ADBException("ShopConfigList cannot be null!!");
                                    }
                                    elementList.add(localShopConfigList);
                                } if (localSnatchLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "SnatchLogList"));
                            
                            
                                    if (localSnatchLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("SnatchLogList cannot be null!!");
                                    }
                                    elementList.add(localSnatchLogList);
                                } if (localStatsListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "StatsList"));
                            
                            
                                    if (localStatsList==null){
                                         throw new org.apache.axis2.databinding.ADBException("StatsList cannot be null!!");
                                    }
                                    elementList.add(localStatsList);
                                } if (localTagListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "TagList"));
                            
                            
                                    if (localTagList==null){
                                         throw new org.apache.axis2.databinding.ADBException("TagList cannot be null!!");
                                    }
                                    elementList.add(localTagList);
                                } if (localTopicListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "TopicList"));
                            
                            
                                    if (localTopicList==null){
                                         throw new org.apache.axis2.databinding.ADBException("TopicList cannot be null!!");
                                    }
                                    elementList.add(localTopicList);
                                } if (localUserListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "UserList"));
                            
                            
                                    if (localUserList==null){
                                         throw new org.apache.axis2.databinding.ADBException("UserList cannot be null!!");
                                    }
                                    elementList.add(localUserList);
                                } if (localUserAccountListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "UserAccountList"));
                            
                            
                                    if (localUserAccountList==null){
                                         throw new org.apache.axis2.databinding.ADBException("UserAccountList cannot be null!!");
                                    }
                                    elementList.add(localUserAccountList);
                                } if (localUserAddressListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "UserAddressList"));
                            
                            
                                    if (localUserAddressList==null){
                                         throw new org.apache.axis2.databinding.ADBException("UserAddressList cannot be null!!");
                                    }
                                    elementList.add(localUserAddressList);
                                } if (localUserBonusListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "UserBonusList"));
                            
                            
                                    if (localUserBonusList==null){
                                         throw new org.apache.axis2.databinding.ADBException("UserBonusList cannot be null!!");
                                    }
                                    elementList.add(localUserBonusList);
                                } if (localUserRankListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "UserRankList"));
                            
                            
                                    if (localUserRankList==null){
                                         throw new org.apache.axis2.databinding.ADBException("UserRankList cannot be null!!");
                                    }
                                    elementList.add(localUserRankList);
                                } if (localVirtualCardListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "VirtualCardList"));
                            
                            
                                    if (localVirtualCardList==null){
                                         throw new org.apache.axis2.databinding.ADBException("VirtualCardList cannot be null!!");
                                    }
                                    elementList.add(localVirtualCardList);
                                } if (localVoteListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "VoteList"));
                            
                            
                                    if (localVoteList==null){
                                         throw new org.apache.axis2.databinding.ADBException("VoteList cannot be null!!");
                                    }
                                    elementList.add(localVoteList);
                                } if (localVoteDataListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "VoteDataList"));
                            
                            
                                    if (localVoteDataList==null){
                                         throw new org.apache.axis2.databinding.ADBException("VoteDataList cannot be null!!");
                                    }
                                    elementList.add(localVoteDataList);
                                } if (localVoteLogListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "VoteLogList"));
                            
                            
                                    if (localVoteLogList==null){
                                         throw new org.apache.axis2.databinding.ADBException("VoteLogList cannot be null!!");
                                    }
                                    elementList.add(localVoteLogList);
                                } if (localWholesaleListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "WholesaleList"));
                            
                            
                                    if (localWholesaleList==null){
                                         throw new org.apache.axis2.databinding.ADBException("WholesaleList cannot be null!!");
                                    }
                                    elementList.add(localWholesaleList);
                                }
                            elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "status"));
                            
                            
                                    if (localStatus==null){
                                         throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
                                    }
                                    elementList.add(localStatus);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static XXXRESP parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            XXXRESP object =
                new XXXRESP();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"XXXRESP".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (XXXRESP)com.jcommerce.ws.server.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","objId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setObjId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setObjId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","totalNumber").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTotalNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setTotalNumber(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AccountLogList").equals(reader.getName())){
                                
                                                object.setAccountLogList(com.jcommerce.ws.server.AccountLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminActionList").equals(reader.getName())){
                                
                                                object.setAdminActionList(com.jcommerce.ws.server.AdminActionList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminLogList").equals(reader.getName())){
                                
                                                object.setAdminLogList(com.jcommerce.ws.server.AdminLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminMessageList").equals(reader.getName())){
                                
                                                object.setAdminMessageList(com.jcommerce.ws.server.AdminMessageList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdminUserList").equals(reader.getName())){
                                
                                                object.setAdminUserList(com.jcommerce.ws.server.AdminUserList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdPositionList").equals(reader.getName())){
                                
                                                object.setAdPositionList(com.jcommerce.ws.server.AdPositionList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdsenseList").equals(reader.getName())){
                                
                                                object.setAdsenseList(com.jcommerce.ws.server.AdsenseList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AdvertisementList").equals(reader.getName())){
                                
                                                object.setAdvertisementList(com.jcommerce.ws.server.AdvertisementList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AffiliateLogList").equals(reader.getName())){
                                
                                                object.setAffiliateLogList(com.jcommerce.ws.server.AffiliateLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AgencyList").equals(reader.getName())){
                                
                                                object.setAgencyList(com.jcommerce.ws.server.AgencyList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","ArticleList").equals(reader.getName())){
                                
                                                object.setArticleList(com.jcommerce.ws.server.ArticleList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","ArticleCategoryList").equals(reader.getName())){
                                
                                                object.setArticleCategoryList(com.jcommerce.ws.server.ArticleCategoryList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AttributeList").equals(reader.getName())){
                                
                                                object.setAttributeList(com.jcommerce.ws.server.AttributeList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AuctionLogList").equals(reader.getName())){
                                
                                                object.setAuctionLogList(com.jcommerce.ws.server.AuctionLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","AutoManageList").equals(reader.getName())){
                                
                                                object.setAutoManageList(com.jcommerce.ws.server.AutoManageList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","BonusTypeList").equals(reader.getName())){
                                
                                                object.setBonusTypeList(com.jcommerce.ws.server.BonusTypeList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","BookingGoodsList").equals(reader.getName())){
                                
                                                object.setBookingGoodsList(com.jcommerce.ws.server.BookingGoodsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","BrandList").equals(reader.getName())){
                                
                                                object.setBrandList(com.jcommerce.ws.server.BrandList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","CardList").equals(reader.getName())){
                                
                                                object.setCardList(com.jcommerce.ws.server.CardList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","CartList").equals(reader.getName())){
                                
                                                object.setCartList(com.jcommerce.ws.server.CartList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","CategoryList").equals(reader.getName())){
                                
                                                object.setCategoryList(com.jcommerce.ws.server.CategoryList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","CollectGoodsList").equals(reader.getName())){
                                
                                                object.setCollectGoodsList(com.jcommerce.ws.server.CollectGoodsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","CommentList").equals(reader.getName())){
                                
                                                object.setCommentList(com.jcommerce.ws.server.CommentList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","CronsList").equals(reader.getName())){
                                
                                                object.setCronsList(com.jcommerce.ws.server.CronsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","EmailListList").equals(reader.getName())){
                                
                                                object.setEmailListList(com.jcommerce.ws.server.EmailListList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","EmailSendListList").equals(reader.getName())){
                                
                                                object.setEmailSendListList(com.jcommerce.ws.server.EmailSendListList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","ErrorLogList").equals(reader.getName())){
                                
                                                object.setErrorLogList(com.jcommerce.ws.server.ErrorLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","FailedLoginList").equals(reader.getName())){
                                
                                                object.setFailedLoginList(com.jcommerce.ws.server.FailedLoginList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","FavourableActivityList").equals(reader.getName())){
                                
                                                object.setFavourableActivityList(com.jcommerce.ws.server.FavourableActivityList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","FeedbackList").equals(reader.getName())){
                                
                                                object.setFeedbackList(com.jcommerce.ws.server.FeedbackList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","FriendLinkList").equals(reader.getName())){
                                
                                                object.setFriendLinkList(com.jcommerce.ws.server.FriendLinkList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GalleryList").equals(reader.getName())){
                                
                                                object.setGalleryList(com.jcommerce.ws.server.GalleryList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsList").equals(reader.getName())){
                                
                                                object.setGoodsList(com.jcommerce.ws.server.GoodsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsActivityList").equals(reader.getName())){
                                
                                                object.setGoodsActivityList(com.jcommerce.ws.server.GoodsActivityList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsArticleList").equals(reader.getName())){
                                
                                                object.setGoodsArticleList(com.jcommerce.ws.server.GoodsArticleList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsAttributeList").equals(reader.getName())){
                                
                                                object.setGoodsAttributeList(com.jcommerce.ws.server.GoodsAttributeList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GoodsTypeList").equals(reader.getName())){
                                
                                                object.setGoodsTypeList(com.jcommerce.ws.server.GoodsTypeList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","GroupGoodsList").equals(reader.getName())){
                                
                                                object.setGroupGoodsList(com.jcommerce.ws.server.GroupGoodsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","KeywordsList").equals(reader.getName())){
                                
                                                object.setKeywordsList(com.jcommerce.ws.server.KeywordsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","LinkGoodsList").equals(reader.getName())){
                                
                                                object.setLinkGoodsList(com.jcommerce.ws.server.LinkGoodsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","MailTemplateList").equals(reader.getName())){
                                
                                                object.setMailTemplateList(com.jcommerce.ws.server.MailTemplateList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","MemberPriceList").equals(reader.getName())){
                                
                                                object.setMemberPriceList(com.jcommerce.ws.server.MemberPriceList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","NavigationList").equals(reader.getName())){
                                
                                                object.setNavigationList(com.jcommerce.ws.server.NavigationList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","OrderList").equals(reader.getName())){
                                
                                                object.setOrderList(com.jcommerce.ws.server.OrderList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","OrderActionList").equals(reader.getName())){
                                
                                                object.setOrderActionList(com.jcommerce.ws.server.OrderActionList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","OrderGoodsList").equals(reader.getName())){
                                
                                                object.setOrderGoodsList(com.jcommerce.ws.server.OrderGoodsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","PackList").equals(reader.getName())){
                                
                                                object.setPackList(com.jcommerce.ws.server.PackList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","PayLogList").equals(reader.getName())){
                                
                                                object.setPayLogList(com.jcommerce.ws.server.PayLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","PaymentList").equals(reader.getName())){
                                
                                                object.setPaymentList(com.jcommerce.ws.server.PaymentList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","PluginsList").equals(reader.getName())){
                                
                                                object.setPluginsList(com.jcommerce.ws.server.PluginsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","RegionList").equals(reader.getName())){
                                
                                                object.setRegionList(com.jcommerce.ws.server.RegionList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","SearchEngineList").equals(reader.getName())){
                                
                                                object.setSearchEngineList(com.jcommerce.ws.server.SearchEngineList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","SessionList").equals(reader.getName())){
                                
                                                object.setSessionList(com.jcommerce.ws.server.SessionList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","SessionsDataList").equals(reader.getName())){
                                
                                                object.setSessionsDataList(com.jcommerce.ws.server.SessionsDataList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","ShippingList").equals(reader.getName())){
                                
                                                object.setShippingList(com.jcommerce.ws.server.ShippingList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","ShippingAreaList").equals(reader.getName())){
                                
                                                object.setShippingAreaList(com.jcommerce.ws.server.ShippingAreaList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","ShopConfigList").equals(reader.getName())){
                                
                                                object.setShopConfigList(com.jcommerce.ws.server.ShopConfigList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","SnatchLogList").equals(reader.getName())){
                                
                                                object.setSnatchLogList(com.jcommerce.ws.server.SnatchLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","StatsList").equals(reader.getName())){
                                
                                                object.setStatsList(com.jcommerce.ws.server.StatsList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","TagList").equals(reader.getName())){
                                
                                                object.setTagList(com.jcommerce.ws.server.TagList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","TopicList").equals(reader.getName())){
                                
                                                object.setTopicList(com.jcommerce.ws.server.TopicList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserList").equals(reader.getName())){
                                
                                                object.setUserList(com.jcommerce.ws.server.UserList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserAccountList").equals(reader.getName())){
                                
                                                object.setUserAccountList(com.jcommerce.ws.server.UserAccountList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserAddressList").equals(reader.getName())){
                                
                                                object.setUserAddressList(com.jcommerce.ws.server.UserAddressList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserBonusList").equals(reader.getName())){
                                
                                                object.setUserBonusList(com.jcommerce.ws.server.UserBonusList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","UserRankList").equals(reader.getName())){
                                
                                                object.setUserRankList(com.jcommerce.ws.server.UserRankList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","VirtualCardList").equals(reader.getName())){
                                
                                                object.setVirtualCardList(com.jcommerce.ws.server.VirtualCardList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","VoteList").equals(reader.getName())){
                                
                                                object.setVoteList(com.jcommerce.ws.server.VoteList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","VoteDataList").equals(reader.getName())){
                                
                                                object.setVoteDataList(com.jcommerce.ws.server.VoteDataList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","VoteLogList").equals(reader.getName())){
                                
                                                object.setVoteLogList(com.jcommerce.ws.server.VoteLogList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","WholesaleList").equals(reader.getName())){
                                
                                                object.setWholesaleList(com.jcommerce.ws.server.WholesaleList.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","status").equals(reader.getName())){
                                
                                                object.setStatus(com.jcommerce.ws.server.StatusType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          