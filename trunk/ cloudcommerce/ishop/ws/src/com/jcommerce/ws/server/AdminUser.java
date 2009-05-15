
/**
 * AdminUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:41 LKT)
 */
            
                package com.jcommerce.ws.server;
            

            /**
            *  AdminUser bean class
            */
        
        public  class AdminUser
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AdminUser
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
                        * field for Id
                        */

                        
                                    protected int localId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getId(){
                               return localId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Id
                               */
                               public void setId(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localIdTracker = false;
                                              
                                       } else {
                                          localIdTracker = true;
                                       }
                                   
                                            this.localId=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNameTracker = true;
                                       } else {
                                          localNameTracker = false;
                                              
                                       }
                                   
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for Password
                        */

                        
                                    protected java.lang.String localPassword ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPasswordTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPassword(){
                               return localPassword;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Password
                               */
                               public void setPassword(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPasswordTracker = true;
                                       } else {
                                          localPasswordTracker = false;
                                              
                                       }
                                   
                                            this.localPassword=param;
                                    

                               }
                            

                        /**
                        * field for Email
                        */

                        
                                    protected java.lang.String localEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEmail(){
                               return localEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Email
                               */
                               public void setEmail(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localEmailTracker = true;
                                       } else {
                                          localEmailTracker = false;
                                              
                                       }
                                   
                                            this.localEmail=param;
                                    

                               }
                            

                        /**
                        * field for LastIP
                        */

                        
                                    protected java.lang.String localLastIP ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastIPTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLastIP(){
                               return localLastIP;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastIP
                               */
                               public void setLastIP(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLastIPTracker = true;
                                       } else {
                                          localLastIPTracker = false;
                                              
                                       }
                                   
                                            this.localLastIP=param;
                                    

                               }
                            

                        /**
                        * field for LastLogin
                        */

                        
                                    protected java.util.Date localLastLogin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastLoginTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getLastLogin(){
                               return localLastLogin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastLogin
                               */
                               public void setLastLogin(java.util.Date param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLastLoginTracker = true;
                                       } else {
                                          localLastLoginTracker = false;
                                              
                                       }
                                   
                                            this.localLastLogin=param;
                                    

                               }
                            

                        /**
                        * field for AddTime
                        */

                        
                                    protected java.util.Date localAddTime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAddTimeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getAddTime(){
                               return localAddTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AddTime
                               */
                               public void setAddTime(java.util.Date param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAddTimeTracker = true;
                                       } else {
                                          localAddTimeTracker = false;
                                              
                                       }
                                   
                                            this.localAddTime=param;
                                    

                               }
                            

                        /**
                        * field for ActionList
                        */

                        
                                    protected java.lang.String localActionList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localActionListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getActionList(){
                               return localActionList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ActionList
                               */
                               public void setActionList(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localActionListTracker = true;
                                       } else {
                                          localActionListTracker = false;
                                              
                                       }
                                   
                                            this.localActionList=param;
                                    

                               }
                            

                        /**
                        * field for NavigatorList
                        */

                        
                                    protected java.lang.String localNavigatorList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNavigatorListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNavigatorList(){
                               return localNavigatorList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NavigatorList
                               */
                               public void setNavigatorList(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNavigatorListTracker = true;
                                       } else {
                                          localNavigatorListTracker = false;
                                              
                                       }
                                   
                                            this.localNavigatorList=param;
                                    

                               }
                            

                        /**
                        * field for LanguageType
                        */

                        
                                    protected java.lang.String localLanguageType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLanguageTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLanguageType(){
                               return localLanguageType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LanguageType
                               */
                               public void setLanguageType(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLanguageTypeTracker = true;
                                       } else {
                                          localLanguageTypeTracker = false;
                                              
                                       }
                                   
                                            this.localLanguageType=param;
                                    

                               }
                            

                        /**
                        * field for Todolist
                        */

                        
                                    protected java.lang.String localTodolist ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTodolistTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTodolist(){
                               return localTodolist;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Todolist
                               */
                               public void setTodolist(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTodolistTracker = true;
                                       } else {
                                          localTodolistTracker = false;
                                              
                                       }
                                   
                                            this.localTodolist=param;
                                    

                               }
                            

                        /**
                        * field for Agency
                        */

                        
                                    protected int localAgency ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAgencyTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getAgency(){
                               return localAgency;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Agency
                               */
                               public void setAgency(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localAgencyTracker = false;
                                              
                                       } else {
                                          localAgencyTracker = true;
                                       }
                                   
                                            this.localAgency=param;
                                    

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
                       AdminUser.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":AdminUser",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AdminUser",
                           xmlWriter);
                   }

               
                   }
                if (localIdTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("id");
                                    }
                                
                                               if (localId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNameTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"name", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"name");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("name");
                                    }
                                

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPasswordTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"password", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"password");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("password");
                                    }
                                

                                          if (localPassword==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("password cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPassword);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEmailTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"email", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"email");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("email");
                                    }
                                

                                          if (localEmail==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLastIPTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"lastIP", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"lastIP");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("lastIP");
                                    }
                                

                                          if (localLastIP==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("lastIP cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLastIP);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLastLoginTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"lastLogin", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"lastLogin");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("lastLogin");
                                    }
                                

                                          if (localLastLogin==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("lastLogin cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastLogin));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAddTimeTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"addTime", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"addTime");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("addTime");
                                    }
                                

                                          if (localAddTime==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("addTime cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddTime));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localActionListTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"actionList", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"actionList");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("actionList");
                                    }
                                

                                          if (localActionList==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("actionList cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localActionList);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNavigatorListTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"navigatorList", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"navigatorList");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("navigatorList");
                                    }
                                

                                          if (localNavigatorList==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("navigatorList cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNavigatorList);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLanguageTypeTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"languageType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"languageType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("languageType");
                                    }
                                

                                          if (localLanguageType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("languageType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLanguageType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTodolistTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"todolist", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"todolist");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("todolist");
                                    }
                                

                                          if (localTodolist==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("todolist cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTodolist);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAgencyTracker){
                                    namespace = "http://ws.jcommerce.com/";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"agency", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"agency");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("agency");
                                    }
                                
                                               if (localAgency==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("agency cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgency));
                                               }
                                    
                                   xmlWriter.writeEndElement();
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


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                            } if (localNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "name"));
                                 
                                        if (localName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
                                        }
                                    } if (localPasswordTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "password"));
                                 
                                        if (localPassword != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPassword));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("password cannot be null!!");
                                        }
                                    } if (localEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "email"));
                                 
                                        if (localEmail != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
                                        }
                                    } if (localLastIPTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "lastIP"));
                                 
                                        if (localLastIP != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastIP));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("lastIP cannot be null!!");
                                        }
                                    } if (localLastLoginTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "lastLogin"));
                                 
                                        if (localLastLogin != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastLogin));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("lastLogin cannot be null!!");
                                        }
                                    } if (localAddTimeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "addTime"));
                                 
                                        if (localAddTime != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddTime));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("addTime cannot be null!!");
                                        }
                                    } if (localActionListTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "actionList"));
                                 
                                        if (localActionList != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActionList));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("actionList cannot be null!!");
                                        }
                                    } if (localNavigatorListTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "navigatorList"));
                                 
                                        if (localNavigatorList != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNavigatorList));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("navigatorList cannot be null!!");
                                        }
                                    } if (localLanguageTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "languageType"));
                                 
                                        if (localLanguageType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLanguageType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("languageType cannot be null!!");
                                        }
                                    } if (localTodolistTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "todolist"));
                                 
                                        if (localTodolist != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTodolist));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("todolist cannot be null!!");
                                        }
                                    } if (localAgencyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.jcommerce.com/",
                                                                      "agency"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgency));
                            }

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
        public static AdminUser parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AdminUser object =
                new AdminUser();

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
                    
                            if (!"AdminUser".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AdminUser)com.jcommerce.ws.server.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","id").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","name").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","password").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPassword(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","email").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","lastIP").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastIP(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","lastLogin").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastLogin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","addTime").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAddTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","actionList").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setActionList(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","navigatorList").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNavigatorList(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","languageType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLanguageType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","todolist").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTodolist(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.jcommerce.com/","agency").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAgency(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setAgency(java.lang.Integer.MIN_VALUE);
                                           
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
           
          