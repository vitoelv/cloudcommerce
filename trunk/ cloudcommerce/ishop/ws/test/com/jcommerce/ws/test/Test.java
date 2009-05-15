package com.jcommerce.ws.test;

import javax.xml.stream.*;
import java.io.*;
import java.util.*;

import org.apache.axiom.om.impl.builder.*;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.xpath.*;
import org.apache.axiom.om.*;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.Manager;
import com.jcommerce.ws.server.QueryCondition;
import com.jcommerce.ws.server.QueryCriteria;
import com.jcommerce.ws.server.QueryOrder;

import javax.xml.namespace.*;
import java.util.*;

import java.security.*;
import java.security.cert.*;
import sun.security.x509.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class Test {

	OMElement root;

	public void ini() {
		try {
			XMLStreamReader parser = XMLInputFactory.newInstance()
					.createXMLStreamReader(
							new FileInputStream("E:\\soapTest1.xml"));
			// create the builder
			StAXOMBuilder builder = new StAXOMBuilder(parser);
			// get the root element (in this case the envelope)
			root = builder.getDocumentElement();
			System.out.println(root.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test mainTest = new Test();
		mainTest.ini();
//		mainTest.parseSingleAnyInRequest("Brand");
//		System.out.println(System.getProperty("user.dir"));
//		File file = new File("./1.jpg");
//		if(file.exists()){
//			System.out.println("exist");
//		}else{
//			System.out.println("No");
//		}
//		String s = mainTest.getImageStr("E:\\1.jpg");
//		System.out.println(s);
//		mainTest.generateImage(s, "E:\\2.jpg");
//		System.out.println("main end.....");
//        mainTest.loadKeyFromPKS12();
	}

	private void testNSsingleNode() {
		try {
			AXIOMXPath xpath = new AXIOMXPath(
					"/soapenv:Envelope/soapenv:Body/ws:REQUEST/ws:GoodsList/ws:Goods/ws:id");
			xpath.addNamespace("soapenv",
					"http://schemas.xmlsoap.org/soap/envelope/");
			xpath.addNamespace("ws", "http://ws.jcommerce.com/");

			OMElement selectedNode = (OMElement) xpath.selectSingleNode(root);
			System.out.println("================================");
			System.out.println(selectedNode.getText());
			System.out.println("================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testNSservalNode() {
		try {
			AXIOMXPath xpath = new AXIOMXPath(
					"/soapenv:Envelope/soapenv:Body/ws:REQUEST/ws:GoodsList/ws:Goods");
			xpath.addNamespace("soapenv",
					"http://schemas.xmlsoap.org/soap/envelope/");
			xpath.addNamespace("ws", "http://ws.jcommerce.com/");
			List nodeList = xpath.selectNodes(root);

			OMElement selectedNode = (OMElement) xpath.selectSingleNode(root);
			System.out.println("================================");
			System.out.println(selectedNode.getText());
			System.out.println(nodeList.size());
			System.out.println("================================");
			Iterator itorse = selectedNode.getChildElements();
			while (itorse.hasNext()) {
				OMNode node = (OMNode) itorse.next();
				System.out.println("...");

				if (node.getType() == OMNode.ELEMENT_NODE) {
					System.out.println("...1...");
					OMElement omElement = (OMElement) node;
					System.out.println(omElement.getLocalName());
					System.out.println(omElement.getText());
				}
			}

			System.out.println("parse end..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, HashMap<String, String>> getGoods() {
		Map<String, HashMap<String, String>> goodsMap = new HashMap<String, HashMap<String, String>>();
		try {
			AXIOMXPath xpath = new AXIOMXPath(
					"/soapenv:Envelope/soapenv:Body/ws:REQUEST/ws:GoodsList/ws:Goods");
			xpath.addNamespace("soapenv",
					"http://schemas.xmlsoap.org/soap/envelope/");
			xpath.addNamespace("ws", "http://ws.jcommerce.com/");
			List nodeList = xpath.selectNodes(root);
			
			for(int i = 0; i < nodeList.size(); i++){
				HashMap<String, String> props = new HashMap<String, String>();
				OMElement selectedNode = (OMElement) nodeList.get(i);
				Iterator itorse = selectedNode.getChildElements();
				while (itorse.hasNext()) {
					OMNode node = (OMNode) itorse.next();
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
				goodsMap.put(selectedNode.getLocalName(), props);
			}
			System.out.println("end..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsMap;
	}
	
	/**
	 * 解析REQUEST下第二级所有节点,for instance, Goods, Brand, etc.
	 * @return
	 */
	public HashMap<String, String> parseSingleAnyInRequest(String type) {
		HashMap<String, String> props = new HashMap<String, String>();
		try {			
			AXIOMXPath xpath = new AXIOMXPath(
					"/soapenv:Envelope/soapenv:Body/ws:REQUEST/*/ws:"+ type);
			xpath.addNamespace("soapenv",
					"http://schemas.xmlsoap.org/soap/envelope/");
			xpath.addNamespace("ws", "http://ws.jcommerce.com/");
			List nodeList = xpath.selectNodes(root);
			
			for(int i = 0; i < nodeList.size(); i++){
				
				OMElement selectedNode = (OMElement) nodeList.get(i);
				Iterator itorse = selectedNode.getChildElements();
				while (itorse.hasNext()) {
					OMNode node = (OMNode) itorse.next();
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
	
	private HashMap<String, String> parseSingleGoodsInRequest() {
		HashMap<String, String> props = new HashMap<String, String>();
		try {			
			AXIOMXPath xpath = new AXIOMXPath(
					"/soapenv:Envelope/soapenv:Body/ws:REQUEST/ws:GoodsList/ws:Goods");
			xpath.addNamespace("soapenv",
					"http://schemas.xmlsoap.org/soap/envelope/");
			xpath.addNamespace("ws", "http://ws.jcommerce.com/");
			List nodeList = xpath.selectNodes(root);
			
			for(int i = 0; i < nodeList.size(); i++){
				
				OMElement selectedNode = (OMElement) nodeList.get(i);
				Iterator itorse = selectedNode.getChildElements();
				while (itorse.hasNext()) {
					OMNode node = (OMNode) itorse.next();
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

	private void test() {
		try {
			XMLStreamReader parser = XMLInputFactory.newInstance()
					.createXMLStreamReader(
							new FileInputStream("E:\\soapTest.txt"));
			// create the builder
			StAXOMBuilder builder = new StAXOMBuilder(parser);
			// get the root element (in this case the envelope)

			OMElement root = builder.getDocumentElement();
			AXIOMXPath xpath = new AXIOMXPath(
					"/Envelope/Body/REQUEST/GoodsList/Goods[1]/id");
			OMElement selectedNode = (OMElement) xpath.selectSingleNode(root);
			Iterator itorse = selectedNode.getChildElements();
			while (itorse.hasNext()) {
				OMNode node = (OMNode) itorse.next();
				System.out.println("...");

				if (node.getType() == OMNode.ELEMENT_NODE) {
					System.out.println("...1...");
					OMElement omElement = (OMElement) node;
					System.out.println(omElement.getLocalName());
					System.out.println(omElement.getText());
				}
			}
			// OMElement header = root.getFirstElement();
			// System.out.println(header.getText());
			// System.out.println("********");
			// Iterator itor = root.getChildElements();
			int i = 0;
			int j = 0;
			// while(itor.hasNext()){
			// // OMNode node = (OMNode)itor.next();
			// // System.out.println("...");
			// // if(node.getType() == OMNode.TEXT_NODE){
			// // System.out.println("...1...");
			// // OMText omElement=(OMText)node;
			// // System.out.println(omElement.getText());
			// // }
			// // if(node.getType() == OMNode.ELEMENT_NODE){
			// // System.out.println("...1...");
			// // OMElement omElement=(OMElement)node;
			// // System.out.println(omElement.getLocalName());
			// // System.out.println(omElement.getText());
			// // Iterator itor1 = omElement.getChildElements();
			// // while(itor1.hasNext()){
			// //
			// // }
			// // }
			// // if(node instanceof OMText){
			// // i++;
			// // System.out.println(((OMText)node).getText());
			// // }
			// // if(node instanceof OMElement){
			// // System.out.println(((OMElement)node).getLocalName());
			// // System.out.println(((OMElement)node).getText());
			// // j++;
			// // }
			//                
			// }
			// System.out.println(i);
			// System.out.println(j);
			System.out.println("end..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getImageStr(String file)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try 
        {
            in = new FileInputStream(file);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

	/**
	 * 
	 * @param imgStr
	 * @param file 解码后的文件放的位置
	 * @return
	 */
	public boolean generateImage(String imgStr, String file)
    {//对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try 
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imgFilePath = file;//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);    
            out.write(b);
            out.flush();
            out.close();
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
	
	private void testEncrypt(){
		try{
			KeyStore ks = KeyStore.getInstance("PKCS12");
			String ps = "password1";
			char[] password = ps.toCharArray();
			java.io.FileInputStream fis =
		        new java.io.FileInputStream("C:\\tibco/bc/5.2/samples/keys/bcpartner1_key.p12");
		    ks.load(fis, password);
		    fis.close();
		    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)ks.getEntry("privateKeyAlias", new KeyStore.PasswordProtection(password));
	        PrivateKey myPrivateKey = pkEntry.getPrivateKey();
	        System.out.println(myPrivateKey.getAlgorithm());
	        System.out.println(myPrivateKey.getFormat());
		}catch(Exception e){
			e.printStackTrace();
		}	

	}
	
	private void loadCert(){
		try {  
            //前提：将证书库中的一条证书导出到证书文件(我写的例子里证书文件叫TC.cer)  
            //从证书文件TC.cer里读取证书信息  
            CertificateFactory cf = CertificateFactory.getInstance("X.509"); 
            FileInputStream in = new FileInputStream("C:\\tibco/bc/5.2/samples/keys/BusinessConnect-IntermediaryCA.cer"); 
            //将文件以文件流的形式读入证书类Certificate中 
            Certificate c = cf.generateCertificate(in); 
            System.err.println("转换成String后的证书信息："+c.toString()); 
              
              
            //或者不用上面代码的方法，直接从证书库中读取证书信息，和上面的结果一摸一样  
//            String pass="keystore";     
//            FileInputStream in2=new FileInputStream("C:/BocsoftKeyLib");     
//            KeyStore ks=KeyStore.getInstance("JKS");     
//            ks.load(in2,pass.toCharArray());  
//            String alias = "TestCertification"; //alias为条目的别名  
//            Certificate c=ks.getCertificate(alias);  
//            System.err.println("转换成String后的证书信息："+c.toString());  
              
              
            //获取获取X509Certificate类型的对象，这是证书类获取Certificate的子类，实现了更多方法  
            X509Certificate t=(X509Certificate)c;  
            //从信息中提取需要信息  
            System.out.println("版本号:"+t.getVersion());     
            System.out.println("序列号:"+t.getSerialNumber().toString(16));     
            System.out.println("主体名："+t.getSubjectDN());     
            System.out.println("签发者："+t.getIssuerDN());     
            System.out.println("有效期："+t.getNotBefore());     
            System.out.println("签名算法："+t.getSigAlgName());
            byte [] sig=t.getSignature();//签名值  
            PublicKey pk = t.getPublicKey();   
            byte [] pkenc=pk.getEncoded();     
            System.out.println("公钥：");     
            for(int i=0;i<pkenc.length;i++){  
                System.out.print(pkenc[i]+",");     
            }  
            System.err.println();  
              
              
            //证书的日期有效性检查，颁发的证书都有一个有效性的日期区间  
            Date TimeNow=new Date();        
            t.checkValidity(TimeNow);     
            System.out.println("证书的日期有效性检查:有效的证书日期！");     
  
              
            //验证证书签名的有效性，通过数字证书认证中心(CA)机构颁布给客户的CA证书，比如：caroot.crt文件  
            //我手里没有CA颁给我的证书，所以下面代码执行不了  
            /*FileInputStream in3=new FileInputStream("caroot.crt");    
            //获取CA证书 
            Certificate cac = cf.generateCertificate(in3);    
            //获取CA的公钥    
            PublicKey pbk=cac.getPublicKey();    
            //c为本地证书，也就是待检验的证书，用CA的公钥校验数字证书c的有效性 
            c.verify(pbk);*/  
              
              
        } catch(CertificateExpiredException e){//证书的日期有效性检查:过期     
            System.out.println("证书的日期有效性检查:过期");        
        } catch(CertificateNotYetValidException e){ //证书的日期有效性检查:尚未生效     
            System.out.println("证书的日期有效性检查:尚未生效");     
        } catch (CertificateException ce) {  
            ce.printStackTrace();  
        } catch (FileNotFoundException fe) {  
            fe.printStackTrace();  
        } /*catch (IOException ioe){ 
             
        } catch (KeyStoreException kse){ 
             
        }*/ catch (Exception e){  
            e.printStackTrace();  
        }  
  
	}
	
	private void loadKeyFromPKS12(){
		try   {
            //  Open an input stream on the keystore file 
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            String pfxFileName = "C:\\tibco/bc/5.2/samples/keys/bcpartner1_key.p12" ;
           String pfxPassword = "Password1" ;
           
           File fPkcs12  =   null ;
            if  (pfxFileName  !=   null )  {
                //  Open the file 
                fPkcs12  =   new  File(pfxFileName);
           } 
           
           
           FileInputStream fis  =   new  FileInputStream(fPkcs12);

            //  Create a keystore object 
            KeyStore keyStore  =   null ;
            try 
             {
                    //  Need BC provider for PKCS #12, BKS and UBER 
                     if  (Security.getProvider("BC")  ==   null )
                    {
                        throw   new  Exception( " 不能Load入BouncyCastle! " );
                   } 

                   keyStore  =  KeyStore.getInstance( "PKCS12" ,  "BC" );
           } 
            catch  (KeyStoreException ex)
            {
                 throw   new  Exception( " 不能正确解释pfx文件! " );
           } 
            catch  (NoSuchProviderException ex)
            {
                throw   new  Exception( " Security Provider配置有误! " );
           } 

            try 
             {
                //  Load the file into the keystore 
                keyStore.load(fis, pfxPassword.toCharArray());
           } 
            catch  (CertificateException ex)
            {
                throw   new  Exception( " 证书格式问题! " );
           } 
            catch  (NoSuchAlgorithmException ex)
            {
                throw   new  Exception( " 算法不支持! " );
               } 
            catch  (FileNotFoundException ex)
            {
                throw   new  Exception( " pfx文件没找到 " );
           } 
            catch  (IOException ex)
            {
                throw   new  Exception(ex.getMessage());
           } 
            Enumeration enumkey = keyStore.aliases();
            String keyAlias = null;
            if (enumkey.hasMoreElements()) // we are readin just one certificate.
            {
                keyAlias = (String)enumkey.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
            }

            // Now once we know the alias, we could get the keys.
            System.out.println("is key entry=" + keyStore.isKeyEntry(keyAlias));
            PrivateKey prikey = (PrivateKey) keyStore.getKey(keyAlias, pfxPassword.toCharArray());
            Certificate cert = keyStore.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();

            System.out.println("cert class = " + cert.getClass().getName());
            System.out.println("cert = " + cert);
            System.out.println("public key = " + pubkey);
            System.out.println("private key = " + prikey);
           
            // 获取我的证书链的中keyEntry的别名 
//            Certificate[] certs  =  keyStore.getCertificateChain( " david.turing " );
//           X509Certificate[] x509Certs  =  X509CertUtil.convertCertificates(certs);
//
//            if  (x509Certs  ==   null )
//            {
//                return ;
//           } 
//
//           x509Certs  =  X509CertUtil.orderX509CertChain(x509Certs);
//
//           X509Certificate keyPairCert  =  x509Certs[ 0 ];
//
//            int  iKeySize  =  X509CertUtil.getCertificateKeyLength(keyPairCert);
//           System.out.println( " 证书密钥算法= " + keyPairCert.getPublicKey().getAlgorithm());
//           System.out.println( " 证书密钥长度= " + iKeySize);

       }   catch  (Exception e)  {
           e.printStackTrace();
       }         
	}

	/**
	 * 备份skeleton中的代码
	 */
	private void codebak(){
//		if (commandType.equals("select")) {
//			QueryCriteria criteria= request.getREQUEST().getCriteria();
//			if(criteria != null){
//				QueryCondition[] conditions = criteria.getCondition();
//				QueryOrder[] orders = criteria.getOrder();
//				Criteria coreCriteria = adapterImpl.getCoreCriteria(conditions, orders);
//				System.out.println("dbImpl.getListObj(targetType, Criteria)");
//				objList = dbImpl.getListObj(targetType, coreCriteria);
//				if((objList == null)||(objList.size() == 0)){
//					//TODO 
//				}else{
//					System.out.println("objList size "+ objList.size());
//					if (targetType.equals("Goods")) {
//						createGoodsResp(objList,xxxResp);
//					}else{
//						throw new java.lang.IllegalArgumentException("only support query Goods!");
//					}
//				}
//				
//			}else{
//				throw new java.lang.IllegalArgumentException("criteria must not be empty in select operation!");
//			}		
//		}
	}

}
