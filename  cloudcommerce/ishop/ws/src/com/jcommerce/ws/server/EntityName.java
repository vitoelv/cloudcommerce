
/**
 * EntityName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */
            
                package com.jcommerce.ws.server;
            

            /**
            *  EntityName bean class
            */
        
        public  class EntityName
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://ws.jcommerce.com/",
                "EntityName",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://ws.jcommerce.com/")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for EntityName
                        */

                        
                                    protected java.lang.String localEntityName ;
                                
                            private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
                            
                                protected EntityName(java.lang.String value, boolean isRegisterValue) {
                                    localEntityName = value;
                                    if (isRegisterValue){
                                        
                                               _table_.put(localEntityName, this);
                                           
                                    }

                                }
                            
                                    public static final java.lang.String _AccountLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AccountLog");
                                
                                    public static final java.lang.String _AdminAction =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdminAction");
                                
                                    public static final java.lang.String _AdminLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdminLog");
                                
                                    public static final java.lang.String _AdminMessage =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdminMessage");
                                
                                    public static final java.lang.String _AdminUser =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdminUser");
                                
                                    public static final java.lang.String _AdPosition =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AdPosition");
                                
                                    public static final java.lang.String _Adsense =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Adsense");
                                
                                    public static final java.lang.String _Advertisement =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Advertisement");
                                
                                    public static final java.lang.String _AffiliateLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AffiliateLog");
                                
                                    public static final java.lang.String _Agency =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Agency");
                                
                                    public static final java.lang.String _Article =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Article");
                                
                                    public static final java.lang.String _ArticleCategory =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ArticleCategory");
                                
                                    public static final java.lang.String _Attribute =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Attribute");
                                
                                    public static final java.lang.String _AuctionLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AuctionLog");
                                
                                    public static final java.lang.String _AutoManage =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AutoManage");
                                
                                    public static final java.lang.String _BonusType =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BonusType");
                                
                                    public static final java.lang.String _BookingGoods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("BookingGoods");
                                
                                    public static final java.lang.String _Brand =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Brand");
                                
                                    public static final java.lang.String _Card =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Card");
                                
                                    public static final java.lang.String _Cart =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Cart");
                                
                                    public static final java.lang.String _Category =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Category");
                                
                                    public static final java.lang.String _CollectGoods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("CollectGoods");
                                
                                    public static final java.lang.String _Comment =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Comment");
                                
                                    public static final java.lang.String _Crons =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Crons");
                                
                                    public static final java.lang.String _EmailList =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EmailList");
                                
                                    public static final java.lang.String _EmailSendList =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("EmailSendList");
                                
                                    public static final java.lang.String _ErrorLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ErrorLog");
                                
                                    public static final java.lang.String _FailedLogin =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FailedLogin");
                                
                                    public static final java.lang.String _FavourableActivity =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FavourableActivity");
                                
                                    public static final java.lang.String _Feedback =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Feedback");
                                
                                    public static final java.lang.String _FriendLink =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("FriendLink");
                                
                                    public static final java.lang.String _Gallery =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Gallery");
                                
                                    public static final java.lang.String _Goods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Goods");
                                
                                    public static final java.lang.String _GoodsActivity =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GoodsActivity");
                                
                                    public static final java.lang.String _GoodsArticle =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GoodsArticle");
                                
                                    public static final java.lang.String _GoodsAttribute =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GoodsAttribute");
                                
                                    public static final java.lang.String _GoodsType =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GoodsType");
                                
                                    public static final java.lang.String _GroupGoods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("GroupGoods");
                                
                                    public static final java.lang.String _Keywords =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Keywords");
                                
                                    public static final java.lang.String _LinkGoods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("LinkGoods");
                                
                                    public static final java.lang.String _MailTemplate =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MailTemplate");
                                
                                    public static final java.lang.String _MemberPrice =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MemberPrice");
                                
                                    public static final java.lang.String _Navigation =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Navigation");
                                
                                    public static final java.lang.String _Order =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Order");
                                
                                    public static final java.lang.String _OrderAction =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OrderAction");
                                
                                    public static final java.lang.String _OrderGoods =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("OrderGoods");
                                
                                    public static final java.lang.String _Pack =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Pack");
                                
                                    public static final java.lang.String _PayLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("PayLog");
                                
                                    public static final java.lang.String _Payment =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Payment");
                                
                                    public static final java.lang.String _Plugins =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Plugins");
                                
                                    public static final java.lang.String _Region =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Region");
                                
                                    public static final java.lang.String _SearchEngine =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SearchEngine");
                                
                                    public static final java.lang.String _Session =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Session");
                                
                                    public static final java.lang.String _SessionsData =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SessionsData");
                                
                                    public static final java.lang.String _Shipping =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Shipping");
                                
                                    public static final java.lang.String _ShippingArea =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShippingArea");
                                
                                    public static final java.lang.String _ShopConfig =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("ShopConfig");
                                
                                    public static final java.lang.String _SnatchLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SnatchLog");
                                
                                    public static final java.lang.String _Stats =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Stats");
                                
                                    public static final java.lang.String _Tag =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Tag");
                                
                                    public static final java.lang.String _Topic =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Topic");
                                
                                    public static final java.lang.String _User =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("User");
                                
                                    public static final java.lang.String _UserAccount =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UserAccount");
                                
                                    public static final java.lang.String _UserAddress =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UserAddress");
                                
                                    public static final java.lang.String _UserBonus =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UserBonus");
                                
                                    public static final java.lang.String _UserRank =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("UserRank");
                                
                                    public static final java.lang.String _VirtualCard =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("VirtualCard");
                                
                                    public static final java.lang.String _Vote =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Vote");
                                
                                    public static final java.lang.String _VoteData =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("VoteData");
                                
                                    public static final java.lang.String _VoteLog =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("VoteLog");
                                
                                    public static final java.lang.String _Wholesale =
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Wholesale");
                                
                                public static final EntityName AccountLog =
                                    new EntityName(_AccountLog,true);
                            
                                public static final EntityName AdminAction =
                                    new EntityName(_AdminAction,true);
                            
                                public static final EntityName AdminLog =
                                    new EntityName(_AdminLog,true);
                            
                                public static final EntityName AdminMessage =
                                    new EntityName(_AdminMessage,true);
                            
                                public static final EntityName AdminUser =
                                    new EntityName(_AdminUser,true);
                            
                                public static final EntityName AdPosition =
                                    new EntityName(_AdPosition,true);
                            
                                public static final EntityName Adsense =
                                    new EntityName(_Adsense,true);
                            
                                public static final EntityName Advertisement =
                                    new EntityName(_Advertisement,true);
                            
                                public static final EntityName AffiliateLog =
                                    new EntityName(_AffiliateLog,true);
                            
                                public static final EntityName Agency =
                                    new EntityName(_Agency,true);
                            
                                public static final EntityName Article =
                                    new EntityName(_Article,true);
                            
                                public static final EntityName ArticleCategory =
                                    new EntityName(_ArticleCategory,true);
                            
                                public static final EntityName Attribute =
                                    new EntityName(_Attribute,true);
                            
                                public static final EntityName AuctionLog =
                                    new EntityName(_AuctionLog,true);
                            
                                public static final EntityName AutoManage =
                                    new EntityName(_AutoManage,true);
                            
                                public static final EntityName BonusType =
                                    new EntityName(_BonusType,true);
                            
                                public static final EntityName BookingGoods =
                                    new EntityName(_BookingGoods,true);
                            
                                public static final EntityName Brand =
                                    new EntityName(_Brand,true);
                            
                                public static final EntityName Card =
                                    new EntityName(_Card,true);
                            
                                public static final EntityName Cart =
                                    new EntityName(_Cart,true);
                            
                                public static final EntityName Category =
                                    new EntityName(_Category,true);
                            
                                public static final EntityName CollectGoods =
                                    new EntityName(_CollectGoods,true);
                            
                                public static final EntityName Comment =
                                    new EntityName(_Comment,true);
                            
                                public static final EntityName Crons =
                                    new EntityName(_Crons,true);
                            
                                public static final EntityName EmailList =
                                    new EntityName(_EmailList,true);
                            
                                public static final EntityName EmailSendList =
                                    new EntityName(_EmailSendList,true);
                            
                                public static final EntityName ErrorLog =
                                    new EntityName(_ErrorLog,true);
                            
                                public static final EntityName FailedLogin =
                                    new EntityName(_FailedLogin,true);
                            
                                public static final EntityName FavourableActivity =
                                    new EntityName(_FavourableActivity,true);
                            
                                public static final EntityName Feedback =
                                    new EntityName(_Feedback,true);
                            
                                public static final EntityName FriendLink =
                                    new EntityName(_FriendLink,true);
                            
                                public static final EntityName Gallery =
                                    new EntityName(_Gallery,true);
                            
                                public static final EntityName Goods =
                                    new EntityName(_Goods,true);
                            
                                public static final EntityName GoodsActivity =
                                    new EntityName(_GoodsActivity,true);
                            
                                public static final EntityName GoodsArticle =
                                    new EntityName(_GoodsArticle,true);
                            
                                public static final EntityName GoodsAttribute =
                                    new EntityName(_GoodsAttribute,true);
                            
                                public static final EntityName GoodsType =
                                    new EntityName(_GoodsType,true);
                            
                                public static final EntityName GroupGoods =
                                    new EntityName(_GroupGoods,true);
                            
                                public static final EntityName Keywords =
                                    new EntityName(_Keywords,true);
                            
                                public static final EntityName LinkGoods =
                                    new EntityName(_LinkGoods,true);
                            
                                public static final EntityName MailTemplate =
                                    new EntityName(_MailTemplate,true);
                            
                                public static final EntityName MemberPrice =
                                    new EntityName(_MemberPrice,true);
                            
                                public static final EntityName Navigation =
                                    new EntityName(_Navigation,true);
                            
                                public static final EntityName Order =
                                    new EntityName(_Order,true);
                            
                                public static final EntityName OrderAction =
                                    new EntityName(_OrderAction,true);
                            
                                public static final EntityName OrderGoods =
                                    new EntityName(_OrderGoods,true);
                            
                                public static final EntityName Pack =
                                    new EntityName(_Pack,true);
                            
                                public static final EntityName PayLog =
                                    new EntityName(_PayLog,true);
                            
                                public static final EntityName Payment =
                                    new EntityName(_Payment,true);
                            
                                public static final EntityName Plugins =
                                    new EntityName(_Plugins,true);
                            
                                public static final EntityName Region =
                                    new EntityName(_Region,true);
                            
                                public static final EntityName SearchEngine =
                                    new EntityName(_SearchEngine,true);
                            
                                public static final EntityName Session =
                                    new EntityName(_Session,true);
                            
                                public static final EntityName SessionsData =
                                    new EntityName(_SessionsData,true);
                            
                                public static final EntityName Shipping =
                                    new EntityName(_Shipping,true);
                            
                                public static final EntityName ShippingArea =
                                    new EntityName(_ShippingArea,true);
                            
                                public static final EntityName ShopConfig =
                                    new EntityName(_ShopConfig,true);
                            
                                public static final EntityName SnatchLog =
                                    new EntityName(_SnatchLog,true);
                            
                                public static final EntityName Stats =
                                    new EntityName(_Stats,true);
                            
                                public static final EntityName Tag =
                                    new EntityName(_Tag,true);
                            
                                public static final EntityName Topic =
                                    new EntityName(_Topic,true);
                            
                                public static final EntityName User =
                                    new EntityName(_User,true);
                            
                                public static final EntityName UserAccount =
                                    new EntityName(_UserAccount,true);
                            
                                public static final EntityName UserAddress =
                                    new EntityName(_UserAddress,true);
                            
                                public static final EntityName UserBonus =
                                    new EntityName(_UserBonus,true);
                            
                                public static final EntityName UserRank =
                                    new EntityName(_UserRank,true);
                            
                                public static final EntityName VirtualCard =
                                    new EntityName(_VirtualCard,true);
                            
                                public static final EntityName Vote =
                                    new EntityName(_Vote,true);
                            
                                public static final EntityName VoteData =
                                    new EntityName(_VoteData,true);
                            
                                public static final EntityName VoteLog =
                                    new EntityName(_VoteLog,true);
                            
                                public static final EntityName Wholesale =
                                    new EntityName(_Wholesale,true);
                            

                                public java.lang.String getValue() { return localEntityName;}

                                public boolean equals(java.lang.Object obj) {return (obj == this);}
                                public int hashCode() { return toString().hashCode();}
                                public java.lang.String toString() {
                                
                                        return localEntityName.toString();
                                    

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
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       EntityName.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
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
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://ws.jcommerce.com/");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":EntityName",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "EntityName",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localEntityName==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localEntityName);
                                            
                                         }
                                    
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


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEntityName)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static EntityName fromValue(java.lang.String value)
                      throws java.lang.IllegalArgumentException {
                    EntityName enumeration = (EntityName)
                       
                               _table_.get(value);
                           

                    if (enumeration==null) throw new java.lang.IllegalArgumentException();
                    return enumeration;
                }
                public static EntityName fromString(java.lang.String value,java.lang.String namespaceURI)
                      throws java.lang.IllegalArgumentException {
                    try {
                       
                                       return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                                   

                    } catch (java.lang.Exception e) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }

                public static EntityName fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return EntityName.Factory.fromString(content,namespaceUri);
                    } else {
                       return EntityName.Factory.fromString(content,"");
                    }
                }
            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static EntityName parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            EntityName object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList();
            

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    java.lang.String content = reader.getElementText();
                                    
                                        if (content.indexOf(":") > 0) {
                                            // this seems to be a Qname so find the namespace and send
                                            prefix = content.substring(0, content.indexOf(":"));
                                            namespaceuri = reader.getNamespaceURI(prefix);
                                            object = EntityName.Factory.fromString(content,namespaceuri);
                                        } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                            // check is done in fromString method
                                            object = EntityName.Factory.fromString(content,"");
                                        }
                                        
                                        
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          