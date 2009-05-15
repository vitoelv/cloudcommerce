package com.jcommerce.ws.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.jcommerce.core.model.ModelObject;
import com.jcommerce.ws.server.XXXREQChoice_type0;

public class skeletonCodeGenerator {
	PrintStream out;

	public void init() {
		try {
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream("E://dev_ws/ishop/example/SkeletonCode.out")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dismiss() {
		out.close();
		System.out.println("end.......");
	}
	
	/**
	 * private void createBrandResp(List<ModelObject> objList, XXXRESP xxxResp){
		com.jcommerce.core.model.Brand[] coreBrandList = new com.jcommerce.core.model.Brand[objList.size()];
		objList.toArray(coreBrandList);
		System.out.println("coreBrandList size "+ coreBrandList.length);
		Brand[] list = adapterImpl.getWSDLBrandList(coreBrandList);
		System.out.println("list.length"+ list.length);
		BrandList brandList = new BrandList();
		brandList.setBrand(list);
		xxxResp.setBrandList(brandList);		
	}
	 * @return
	 */
	private void printCreateSingleRespStr(String modelName){
		String coreListName = "coreList";
		String wsdlListName = modelName.toLowerCase()+"List";
		String fullModelName = "com.jcommerce.core.model."+modelName;		
		out.println("private void create"+modelName+"Resp(List<ModelObject> objList, XXXRESP xxxResp){");
		out.println(fullModelName +"[] "+coreListName +" = new "+ fullModelName + "[objList.size()];");
		out.println("objList.toArray(coreList);");
		out.println("System.out.println(\"coreList size \"+ coreList.length);");
		out.println(modelName+"[] list = adapterImpl.getWSDL"+modelName+"List(coreList);");
		out.println("System.out.println(\"list.length\"+ list.length);");
		out.println(modelName+"List "+wsdlListName+" = new "+ modelName+"List();");
		out.println(wsdlListName+".set"+modelName+"(list);");
		out.println("xxxResp.set"+modelName+"List("+wsdlListName+");");
		out.println("}");
	}
	
	/**
	 * private void createReadResp(String targetType, List<ModelObject> objList, XXXRESP xxxResp){
		System.out.println("objList size "+ objList.size());
		if (targetType.equals("Brand")) {
			createBrandResp(objList,xxxResp);
		}
		if (targetType.equals("Goods")) {
			createGoodsResp(objList,xxxResp);
		}
		if (targetType.equals("Category")) {
			createCategoryResp(objList,xxxResp);
		}		
	}
	 * @param modelName
	 */
	private void printCreateRespStr(){		
		out.println("private void createReadResp(String targetType, List<ModelObject> objList, XXXRESP xxxResp){");
		out.println("System.out.println(\"objList size \"+ objList.size());");
		File path = new File("E://dev_ws/ishop/core/src/com/jcommerce/core/model");
		String[] fileList = path.list();
		for (int i = 0; i < fileList.length; i++) {
			int index = fileList[i].indexOf(".java");
			if (index > 0) {
				String modelName = fileList[i].substring(0, index);
				if (modelName.equals("Constants") || (modelName.equals("ModelObject"))) {

				} else {
					out.println("if (targetType.equals(\""+modelName+"\")) {");
					out.println("create"+modelName+"Resp(objList,xxxResp);");
					out.println("}");
				}
			}
		}
		
		out.println("}");
	}
	
	/**
	 * 	private ModelObject[] parseModelInRequest(com.jcommerce.ws.server.REQUEST request) {
		System.out.println("parseSingleModelInRequest...");
		ModelObject[] ret = null;
		String targetType = request.getREQUEST().getTargetType().getValue();
		XXXREQChoice_type0 choice = request.getREQUEST().getXXXREQChoice_type0();
		if (choice != null) {
			if (targetType.equals("Brand")) {
				if (choice.getBrandList() != null) {
					ret = adapterImpl.getCoreBrandList(choice.getBrandList().getBrand());
				}
			}
			if (targetType.equals("Goods")) {
				if (choice.getGoodsList() != null) {
					ret = adapterImpl.getCoreGoodsList(choice.getGoodsList().getGoods());
				}
			}
			if (targetType.equals("Category")) {
				if (choice.getCategoryList() != null) {
					ret = adapterImpl.getCoreCategoryList(choice.getCategoryList().getCategory());
				}
			}
		}
		return ret;
	}
	 */
	private void printParseReqStr(){		
		out.println("private ModelObject[] parseModelInRequest(com.jcommerce.ws.server.REQUEST request) {");
		out.println("System.out.println(\"parseModelInRequest...\");");
		out.println("ModelObject[] ret = null;");
		out.println("String targetType = request.getREQUEST().getTargetType().getValue();");
		out.println("XXXREQChoice_type0 choice = request.getREQUEST().getXXXREQChoice_type0();");
		out.println("if (choice != null) {");
		File path = new File("E://dev_ws/ishop/core/src/com/jcommerce/core/model");
		String[] fileList = path.list();
		for (int i = 0; i < fileList.length; i++) {
			int index = fileList[i].indexOf(".java");
			if (index > 0) {
				String modelName = fileList[i].substring(0, index);
				if (modelName.equals("Constants") || (modelName.equals("ModelObject"))) {

				} else {
					out.println("if (targetType.equals(\""+modelName+"\")) {");
					out.println("if (choice.get"+modelName+"List() != null) {");
					out.println("ret = adapterImpl.getCore"+modelName+"List(choice.get"+modelName+"List().get"+modelName+"());");
					out.println("}");
					out.println("}");
				}
			}
		}		
		out.println("}");
		out.println("return ret;");
		out.println("}");
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		skeletonCodeGenerator gen = new skeletonCodeGenerator();
		gen.init();
//		File path = new File("E://dev_ws/ishop/core/src/com/jcommerce/core/model");
//		String[] fileList = path.list();
//		for (int i = 0; i < fileList.length; i++) {
//			int index = fileList[i].indexOf(".java");
//			if (index > 0) {
//				String modelName = fileList[i].substring(0, index);
//				if (modelName.equals("Constants") || (modelName.equals("ModelObject"))) {
//
//				} else {
//					gen.printCreateSingleRespStr(modelName);
//				}
//			}
//			gen.out.println("");
//		}
		gen.printParseReqStr();
		gen.dismiss();

	}
}
