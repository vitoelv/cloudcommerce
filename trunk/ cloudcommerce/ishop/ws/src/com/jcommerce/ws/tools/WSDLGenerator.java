package com.jcommerce.ws.tools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.*;

import org.apache.commons.beanutils.BeanUtils;

import com.jcommerce.core.model.ModelObject;

/**
 * 
 * @author david yang create wsdl file
 */
public class WSDLGenerator {

	PrintStream out;

	private void readFileds(ModelObject obj) {
		System.out.println("get object fields...");

		Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fn = field.getName();
			Class type = field.getType();
			// System.out.println("fn:" + fn + " field.getType():"
			// + field.getType());
			String pre = "<s:element minOccurs=" + "\"" + "0" + "\"" + " maxOccurs=" + "\"";
			String max = "1\"";
			String post = "/>";
			String name = " name=" + "\"" + fn + "\"";
			String msdlType = "";
			System.out.println(type.getName());
			if (type.equals(String.class)) {
				msdlType = "s:string";
			} else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
				msdlType = "s:boolean";
			} else if (type.equals(double.class) || type.equals(Double.class)) {
				msdlType = "s:double";
			} else if (type.equals(int.class) || type.equals(Integer.class)) {
				msdlType = "s:int";
			} else if (type.equals(Timestamp.class)) {
				msdlType = "s:date";
			} else if (type.equals(Time.class)) {
				msdlType = "s:date";
			} else if (type.equals(java.sql.Date.class)) {
				msdlType = "s:date";
			} else if (type.equals(java.util.Date.class)) {
				msdlType = "s:date";
			} else if (type.equals(Set.class)) {
				max = "unbounded\"";
				msdlType = "s:int";
			} else {
				msdlType = "s:int";
			}
			String typeInWSDL = " type=" + "\"" + msdlType + "\"";
			if((name.indexOf("_")>0)&&(type.equals(int.class) || type.equals(Integer.class))){
				
			}else{
				out.println(pre + max + name + typeInWSDL + post);	
			}
			
		}
	}

	public void init(String file) {
		try {
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dismiss() {
		out.close();
	}

	public void newObject(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {

			ModelObject model = (ModelObject) Class.forName("com.jcommerce.core.model." + modelName).newInstance();
			String s = "<s:complexType name=" + "\"" + modelName + "\"" + ">";
			out.println(s);
			out.println("<s:sequence>");
			readFileds(model);
			out.println("</s:sequence>");
			out.println("</s:complexType>");
			System.out.println(modelName + "-----end-------");

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printEntity(String modelName) {
		out.println("<s:enumeration value=\"" + modelName + "\"/>");
	}

	private void printEntityList(String modelName) {
		String s = "<s:complexType name=" + "\"" + modelName + "List\"" + ">";
		out.println(s);
		out.println("<s:sequence>");
		out.println("<s:element minOccurs=" + "\"" + "0" + "\"" + " maxOccurs=\"" + "unbounded\"" + " name=\"" + modelName + "\" type=\"" + "s0:" + modelName + "\"/>");
		out.println("</s:sequence>");
		out.println("</s:complexType>");
	}

	private void printRR(String modelName) {

		out.println("<s:element minOccurs=" + "\"" + "0" + "\"" + " maxOccurs=\"" + "1\"" + " name=\"" + modelName + "List\" type=\"" + "s0:" + modelName + "List\"/>");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WSDLGenerator wsdlGen = new WSDLGenerator();
		String file = "E://dev_ws/ishop/example/wsdlType.out";
		wsdlGen.init(file);
		File path = new File("E://dev_ws/ishop/core/src/com/jcommerce/core/model");
		String[] fileList = path.list();
		// for(int i = 0; i <fileList.length; i++){
		// int index = fileList[i].indexOf(".java");
		// if(index > 0){
		// String modelName = fileList[i].substring(0, index);
		// if(modelName.equals("Constants")||(modelName.equals("ModelObject"))){
		//			
		// }else{
		// wsdlGen.printEntityList(modelName);
		// }
		// }
		// }
		for (int i = 0; i < fileList.length; i++) {
			int index = fileList[i].indexOf(".java");
			if (index > 0) {
				String modelName = fileList[i].substring(0, index);
				if (modelName.equals("Constants") || (modelName.equals("ModelObject"))){
					
				}else {
					wsdlGen.newObject(modelName);
				}
			}
		}
		wsdlGen.dismiss();

	}

}
