package com.jcommerce.ws.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

import com.jcommerce.core.model.Category;
import com.jcommerce.core.model.ModelObject;
import org.apache.axis2.databinding.ADBBean;

public class AdapterCodeGenerator {

	PrintStream out;
	ArrayList list = new ArrayList();

	public void init() {
		try {
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream("E://dev_ws/ishop/example/AdapterCode.out")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dismiss() {
		out.close();
		list.clear();
		System.out.println("pro end.......");
	}
	
	/**
	 * Set<Category> categories = new HashSet<Category>();
		int[] categoryList = input.getCategories();
		for (int i = 0; i < categoryList.length; i++) {
			com.jcommerce.core.model.Category category = new com.jcommerce.core.model.Category();
			category = (com.jcommerce.core.model.Category) dbAccessImpl.getBean0("Category", String.valueOf(categoryList[i]));
			categories.add(category);
		}
		ret.setCategories(categories);
	 * @return
	 */
	private void printCoreCollectionStr(String modelName, String methodName, String wsdlMethodName){
		String coreName = modelName.toLowerCase();
		String coreListName = modelName.toLowerCase()+"s";
		String fullModelName = "com.jcommerce.core.model."+modelName;
		
		String wsdlListName = modelName.toLowerCase()+"List";
		out.println("int[] "+ wsdlListName+" = " + "input." + wsdlMethodName + "();"); 
		out.println("if ("+ wsdlListName+" != null){"); 
		out.println("Set<"+modelName+"> " + coreListName + " = new HashSet<"+modelName+">();"); 
		out.println("for (int i = 0; i < "+ wsdlListName+ ".length; i++) {"); 
		out.println(fullModelName + " "+ coreName + " = new "+ fullModelName +"();"); 
		out.println(coreName + " = ("+ fullModelName +") dbAccessImpl.getBean0(\""+ modelName +"\", String.valueOf("+wsdlListName+"[i]));");
		out.println(coreListName + ".add("+ coreName + ");");
		out.println("}");
		out.println("ret." + methodName + "(" + coreListName + ");");
		out.println("}");
	}
	
	private void printCoreTimeStampStr(String methodName, String wsdlMethodName){
		out.println("if (input."+wsdlMethodName+"() != null) {");
		out.println("ret." + methodName + "(new Timestamp(input." + wsdlMethodName + "().getTime()));");
		out.println("}");
	}
	
	private void printCoreDoubleStr(String methodName, String wsdlMethodName){
		out.println("if ((String.valueOf(input."+wsdlMethodName+"()).indexOf(\"NaN\")<0) && (String.valueOf(input."+wsdlMethodName+"()).indexOf(\"Inf\")<0)) {");
		out.println("ret." + methodName + "(input." + wsdlMethodName + "());");
		out.println("}");
	}
	
	private void printSpecStrForCart(){
		out.println("if (input.getSession() != null) {");
		out.println("try {");
		out.println("ret.setSession(Integer.parseInt(input.getSession().getId()));");
		out.println("} catch (Exception e) {");
		out.println("e.printStackTrace();");
		out.println("}");
		out.println("}");		
	}
	
	/**
	 * Set categoryList = input.getCategories();
		int[] categories = new int[categoryList.size()];
		int i = 0;
		Iterator categoryItor = categoryList.iterator();
		while (categoryItor.hasNext()) {
			Category category = (Category) categoryItor.next();
			categories[i++] = category.getId();
		}
		ret.setCategories(categories);
	 */
	private void printWSDLCollectionStr(String modelName, String methodName, String wsdlMethodName){
		String coreListName = modelName.toLowerCase()+"List";
		String wsdlListName = modelName.toLowerCase()+"s";
		String itorName = modelName.toLowerCase()+"Itor";
		String number = modelName.toLowerCase()+"Counter";
		String wsdlName = modelName.toLowerCase();
		out.println("Set "+coreListName+" = " + "input."+ methodName + "();"); 
		out.println("if ("+coreListName+" != null){"); 
		out.println("int[] "+ wsdlListName+" = new int[" + coreListName + ".size()];"); 
		out.println("int "+ number +" = 0;");
		out.println("Iterator "+ itorName+" = "+ coreListName +".iterator();");
		out.println("while ("+ itorName +".hasNext()) {");
		out.println(modelName+" "+ wsdlName+" = "+ "(" + modelName +")"+ itorName +".next();");
		out.println(wsdlListName +"["+number+"++] = "+ wsdlName+".getId();"); 
		out.println("}");
		out.println("ret." + wsdlMethodName + "(" + wsdlListName + ");");
		out.println("}");
	}

	public void newCoreMethod(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {

			ModelObject model = (ModelObject) Class.forName("com.jcommerce.core.model." + modelName).newInstance();
			ADBBean wsdlObj = (ADBBean) Class.forName("com.jcommerce.ws.server." + modelName).newInstance();
			String fucName = "public com.jcommerce.core.model." + modelName + " getCore" + modelName + "(com.jcommerce.ws.server." + modelName + " input){";
			out.println(fucName);
			String defineStr = "com.jcommerce.core.model." + modelName + " ret = new com.jcommerce.core.model." + modelName + "();";
			out.println(defineStr);
			Method[] methods = model.getClass().getDeclaredMethods();
			Method[] wsdlMethods = wsdlObj.getClass().getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				boolean setFlag = false;
				Method method = methods[i];				
				String methodName = method.getName();
				String type = "###";
				if (methodName.startsWith("set")) {
					Class[] cList = method.getParameterTypes();					
					String param = cList[0].getName();
					System.out.println(param);
					if(param.equals("java.util.Set")){
						Type[] typeList = method.getGenericParameterTypes();
						type = typeList[0].toString();
						System.out.println(type);
						int startIndex = type.lastIndexOf(".");
						int endIndex = type.lastIndexOf(">");
						if(type.indexOf("<com.jcommerce.core.model.")>0){
							type = type.substring(startIndex+1, endIndex);
							setFlag = true;
							System.out.println(type);
						}
					}
					for (int j = 0; j < wsdlMethods.length; j++) {
						Method wsdlMethod = wsdlMethods[j];
						String wsdlMethodName = wsdlMethod.getName();
						if ((wsdlMethodName.startsWith("get")) && (methodName.substring(3).equals(wsdlMethodName.substring(3)))) {
							String setStr = "";
							if(param.equals("java.sql.Timestamp")){
								printCoreTimeStampStr(methodName, wsdlMethodName);
							}else if(param.equalsIgnoreCase("double")){
								printCoreDoubleStr(methodName, wsdlMethodName);
							}else if(list.contains(param)){
								String tempType = param.substring(param.lastIndexOf(".")+1);
								setStr = "ret." + methodName + "((" + param+")"+"(dbAccessImpl.getBean0(\""+tempType+"\", String.valueOf("+"input." + wsdlMethodName + "()))));";
							}else if(setFlag){
								printCoreCollectionStr(type, methodName,wsdlMethodName );
								setFlag = false;
							}else{
								setStr = "ret." + methodName + "(input." + wsdlMethodName + "());";
							}
							out.println(setStr);
							break;
						}
					}
				}
			}
			out.println("return ret;");
			String end = "}";
			out.println(end);

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

	public void newCoreListMethod(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {

			ModelObject model = (ModelObject) Class.forName("com.jcommerce.core.model." + modelName).newInstance();
			ADBBean wsdlObj = (ADBBean) Class.forName("com.jcommerce.ws.server." + modelName).newInstance();
			String fucName = "public com.jcommerce.core.model." + modelName + "[] getCore" + modelName + "List(com.jcommerce.ws.server." + modelName + "[] input){";
			out.println(fucName);
			out.println("if((input == null)||(input.length == 0)){");
			out.println("return null;");
			out.println("}");
			out.println("com.jcommerce.core.model." + modelName + "[] retList = new com.jcommerce.core.model." + modelName + "[input.length];");
			out.println("for(int i = 0; i < input.length; i++){");
			String defineStr = "com.jcommerce.core.model." + modelName + " ret = new com.jcommerce.core.model." + modelName + "();";
			out.println(defineStr);
			Method[] methods = model.getClass().getDeclaredMethods();
			Method[] wsdlMethods = wsdlObj.getClass().getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				String methodName = method.getName();
				if (methodName.startsWith("set")) {
					for (int j = 0; j < wsdlMethods.length; j++) {
						Method wsdlMethod = wsdlMethods[j];
						String wsdlMethodName = wsdlMethod.getName();
						if ((wsdlMethodName.startsWith("get")) && (methodName.substring(3).equals(wsdlMethodName.substring(3)))) {
							String setStr = "ret." + methodName + "(input[i]." + wsdlMethodName + "());";
							out.println(setStr);
						}
					}
				}
			}
			out.println("}");
			out.println("return retList;");
			String end = "}";
			out.println(end);

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

	public void newCoreListMethod2(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {
			String fucName = "public com.jcommerce.core.model." + modelName + "[] getCore" + modelName + "List(com.jcommerce.ws.server." + modelName + "[] input){";
			out.println(fucName);
			out.println("if((input == null)||(input.length == 0)){");
			out.println("return null;");
			out.println("}");
			out.println("com.jcommerce.core.model." + modelName + "[] retList = new com.jcommerce.core.model." + modelName + "[input.length];");
			out.println("for(int i = 0; i < input.length; i++){");
			String defineStr = "retList[i] = getCore" + modelName + "(input[i]);";
			out.println(defineStr);
			out.println("}");
			out.println("return retList;");
			String end = "}";
			out.println(end);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newWSDLListMethod(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {

			ModelObject model = (ModelObject) Class.forName("com.jcommerce.core.model." + modelName).newInstance();
			ADBBean wsdlObj = (ADBBean) Class.forName("com.jcommerce.ws.server." + modelName).newInstance();
			String fucName = "public com.jcommerce.ws.server." + modelName + "[] getWSDL" + modelName + "List(com.jcommerce.core.model." + modelName + "[] input){";
			out.println(fucName);
			out.println("if((input == null)||(input.length == 0)){");
			out.println("return null;");
			out.println("}");
			out.println("com.jcommerce.ws.server." + modelName + "[] retList = new com.jcommerce.ws.server." + modelName + "[input.length];");
			out.println("for(int i = 0; i < input.length; i++){");
			String defineStr = "com.jcommerce.ws.server." + modelName + " ret = new com.jcommerce.ws.server." + modelName + "();";
			out.println(defineStr);
			Method[] methods = model.getClass().getDeclaredMethods();
			Method[] wsdlMethods = wsdlObj.getClass().getDeclaredMethods();
			for (int i = 0; i < wsdlMethods.length; i++) {
				Method wsdlMethod = wsdlMethods[i];
				String wsdlMethodName = wsdlMethod.getName();
				if (wsdlMethodName.startsWith("set")) {
					for (int j = 0; j < methods.length; j++) {
						Method method = methods[j];
						String methodName = method.getName();
						if ((methodName.startsWith("get")) && (wsdlMethodName.substring(3).equals(methodName.substring(3)))) {
							String setStr = "ret." + wsdlMethodName + "(input[i]." + methodName + "());";
							out.println(setStr);
						}
					}
				}
			}
			out.println("}");
			out.println("return retList;");
			String end = "}";
			out.println(end);

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

	public void newWSDLListMethod2(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {
			String fucName = "public com.jcommerce.ws.server." + modelName + "[] getWSDL" + modelName + "List(com.jcommerce.core.model." + modelName + "[] input){";
			out.println(fucName);
			out.println("if((input == null)||(input.length == 0)){");
			out.println("return null;");
			out.println("}");
			out.println("com.jcommerce.ws.server." + modelName + "[] retList = new com.jcommerce.ws.server." + modelName + "[input.length];");
			out.println("for(int i = 0; i < input.length; i++){");
			String defineStr = "retList[i] = getWSDL" + modelName + "(input[i]);";
			out.println(defineStr);
			out.println("}");
			out.println("return retList;");
			String end = "}";
			out.println(end);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newWSDLMethod(String modelName) {
		System.out.println("----------------------------");
		System.out.println("newObject(" + modelName + ")");
		try {

			ModelObject model = (ModelObject) Class.forName("com.jcommerce.core.model." + modelName).newInstance();
			ADBBean wsdlObj = (ADBBean) Class.forName("com.jcommerce.ws.server." + modelName).newInstance();
			String fucName = "public com.jcommerce.ws.server." + modelName + " getWSDL" + modelName + "(com.jcommerce.core.model." + modelName + " input){";
			out.println(fucName);
			String defineStr = "com.jcommerce.ws.server." + modelName + " ret = new com.jcommerce.ws.server." + modelName + "();";
			out.println(defineStr);
			Method[] methods = model.getClass().getDeclaredMethods();
			Method[] wsdlMethods = wsdlObj.getClass().getDeclaredMethods();
			for (int i = 0; i < wsdlMethods.length; i++) {
				boolean setFlag = false;
				Method wsdlMethod = wsdlMethods[i];
				String wsdlMethodName = wsdlMethod.getName();
				if (wsdlMethodName.startsWith("set")) {
					for (int j = 0; j < methods.length; j++) {
						Method method = methods[j];
						Class c = method.getReturnType();						
						boolean exist = list.contains(c.getName());						
						System.out.println(c.getName());
						String methodName = method.getName();
						if ((c.getName().equalsIgnoreCase("boolean"))&&(methodName.startsWith("is")) && (wsdlMethodName.substring(3).equals(methodName.substring(2)))) {
							out.println("ret." + wsdlMethodName + "(input." + methodName + "());");	
							break;
						}
						if ((methodName.startsWith("get")) && (wsdlMethodName.substring(3).equals(methodName.substring(3)))) {
							Type type = method.getGenericReturnType();
							String typeStr = "###";
							if(c.getName().equals("java.util.Set")){
								typeStr = type.toString();
								System.out.println(typeStr);
								int startIndex = typeStr.lastIndexOf(".");
								int endIndex = typeStr.lastIndexOf(">");
								if(typeStr.indexOf("<com.jcommerce.core.model.")>0){
									typeStr = typeStr.substring(startIndex+1, endIndex);
									setFlag = true;
									System.out.println(typeStr);
								}
							}
							if(exist){
								if(modelName.equals("Cart")&&(methodName.equals("getSession"))){
									//in this model, session is int not str, so do specical handle.
									printSpecStrForCart();
								}else{
									out.println("if(input." + methodName + "() != null){");
									out.println("ret." + wsdlMethodName + "(input." + methodName + "().getId());");
									out.println("}");	
								}								
							}else if(setFlag){
								printWSDLCollectionStr(typeStr, methodName, wsdlMethodName);
								setFlag = false;
							}else{
								out.println("ret." + wsdlMethodName + "(input." + methodName + "());");	
							}							
							break;
						}
					}
				}
			}
			out.println("return ret;");
			String end = "}";
			out.println(end);

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
	
	private void testTemp(String modelName){
		try {

			ModelObject model = (ModelObject) Class.forName("com.jcommerce.core.model." + modelName).newInstance();
			ADBBean wsdlObj = (ADBBean) Class.forName("com.jcommerce.ws.server." + modelName).newInstance();
			Method[] methods = model.getClass().getDeclaredMethods();
			Method[] wsdlMethods = wsdlObj.getClass().getDeclaredMethods();
			for (int i = 0; i < wsdlMethods.length; i++) {
				Method wsdlMethod = wsdlMethods[i];
				String wsdlMethodName = wsdlMethod.getName();
				if (wsdlMethodName.startsWith("set")) {
					for (int j = 0; j < methods.length; j++) {
						Method method = methods[j];
						Class c = method.getReturnType();
						boolean exist = list.contains(c.getName());
						String methodName = method.getName();
						if ((methodName.startsWith("get")) && (wsdlMethodName.substring(3).equals(methodName.substring(3)))) {
							String setStr = "";
							if(exist){
								setStr = "ret." + wsdlMethodName + "(input." + methodName + "().getId());";
							}else{
								setStr = "ret." + wsdlMethodName + "(input." + methodName + "());";	
							}
							
							out.println(setStr);
						}
					}
				}
			}

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
	
	
	private void fillList(){
		File path = new File("E://dev_ws/ishop/core/src/com/jcommerce/core/model");
		String[] fileList = path.list();
		for (int i = 0; i < fileList.length; i++) {
			int index = fileList[i].indexOf(".java");
			if (index > 0) {
				String modelName = fileList[i].substring(0, index);
				if (modelName.equals("Constants") || (modelName.equals("ModelObject"))) {

				} else {
					list.add("com.jcommerce.core.model."+modelName);
				}
			}
		}		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdapterCodeGenerator wsdlGen = new AdapterCodeGenerator();
		wsdlGen.init();
		wsdlGen.fillList();
		File path = new File("E://dev_ws/ishop/core/src/com/jcommerce/core/model");
		String[] fileList = path.list();
		for (int i = 0; i < fileList.length; i++) {
			int index = fileList[i].indexOf(".java");
			if (index > 0) {
				String modelName = fileList[i].substring(0, index);
				if (modelName.equals("Constants") || (modelName.equals("ModelObject"))) {

				} else{
					wsdlGen.newCoreMethod(modelName);
					wsdlGen.newWSDLMethod(modelName);
					wsdlGen.newCoreListMethod2(modelName);
					wsdlGen.newWSDLListMethod2(modelName);
				}
			}
			wsdlGen.out.println("");
		}
		wsdlGen.dismiss();

	}

}
