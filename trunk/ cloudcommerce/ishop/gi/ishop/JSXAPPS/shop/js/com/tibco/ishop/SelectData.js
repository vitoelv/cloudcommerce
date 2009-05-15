jsx3.require("jsx3.gui.Select");
jsx3.Class.defineClass(
"com.tibco.ishop.SelectData", 
jsx3.gui.Select,
null,
function(data){
	
	data.getGoodsTypeSelect = function(type){
		var objService = service.getServer().loadResource("getType_xml");
		objService.setOperation("OPERATION");
		objService.start=0;
		objService.count=0;
		if(type==0)
			data.sucessCallBack = data.generalShowAttributeGoodsTypeSelect;
		else if(type==1)
			data.sucessCallBack = data.generalAddAttributeGoodsTypeSelect;
		else if(type==2)
			data.sucessCallBack = data.generalAddGoodsGoodsTypeSelect;
		else 
			data.sucessCallBack = data.generalAddCategoryGoodsTypeSelect;
		
		 objService.subscribe(jsx3.net.Service.ON_SUCCESS, data.sucessCallBack);
		 objService.subscribe(jsx3.net.Service.ON_ERROR, data.onOperationError);
         objService.subscribe(jsx3.net.Service.ON_INVALID, data.onOperationInvalid);
         objService.doCall();
	};
	data.generalShowAttributeGoodsTypeSelect = function(){
		data.generateSelectData("全部商品类型","typelist","xsl/TypeSelect.xsl","typeselectdata","selGoodsType");
		data.setFirstSelect("typeselectdata","selGoodsType");
	 };
	data.generalAddAttributeGoodsTypeSelect = function(){
		data.generateSelectData("请选择...","typelist","xsl/TypeSelect.xsl","typeselectdata","selGoodsType");
		data.setFirstSelect("typeselectdata","selGoodsType");
	};
	data.generalAddGoodsGoodsTypeSelect = function(){
		data.generateSelectData("","typelist","xsl/TypeSelect.xsl","typeselectdata","selGoodsType");
		data.setFirstSelect("typeselectdata","selGoodsType");
	};
	data.generalAddCategoryGoodsTypeSelect = function(){
		data.generateSelectData("请选择商品类型","typelist","xsl/TypeSelect.xsl","typeselectdata","selGoodsType");
		data.setFirstSelect("typeselectdata","selGoodsType");
	};
	data.generalParentCategory = function(type){
		data.type = type;
		var objService = service.getServer().loadResource("getCategory_xml");
		objService.setOperation("OPERATION");
		objService.subscribe(jsx3.net.Service.ON_SUCCESS,data, data.GetCategorySuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, data.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, data.onOperationInvalid);
		objService.doCall();
	};
	data.GetCategorySuccess = function(){
		var space="";
		var responseCache = service.getServer().getCache().getDocument("categorylist");
		var childNodes = responseCache.getChildNodes();
		for(var i=0;i<childNodes.size();i++){
			//space="";
			var presentRecord = childNodes.get(i);
			data.creat(space,null,presentRecord,responseCache);
			childNodes = responseCache.getChildNodes();
		};
		if(data.type==0)
			data.generateSelectData("顶级分类","categorylist","xsl/parentCategorySelect.xsl","parentcategoryselectdata","selParentName");
		else
			data.generateSelectData("全部分类","categorylist","xsl/parentCategorySelect.xsl","parentcategoryselectdata","selParentName");
		data.setFirstSelect("parentcategoryselectdata","selParentName");
	}
	data.creat = function(space,parentRecord,presentRecord,responseCache){
		//alert(space);
		var name = presentRecord.getAttribute("name");
		 presentRecord.setAttribute("name",space+name);
		 //alert(presentRecord);
		 space+="";
		var childNodes = presentRecord.getChildNodes();
		for(var i=childNodes.size()-1;i>=0;i--){
			var childRecord = childNodes.get(i);
			var childId = childRecord.getAttribute("childId");
		//	alert(childRecord)
			if(childId==null){
				continue;
			}
			var insertRecord=responseCache.selectSingleNode("//record[@id='"+childId+"']");
			presentRecord.removeChild(childRecord);
			data.creat(space,presentRecord,insertRecord,responseCache);
			childNodes = presentRecord.getChildNodes();
		}
		 if(parentRecord!=null)
			 parentRecord.appendChild(presentRecord);
		
	};

	data.generateAttributeGroup = function(objJSX,recordId){
		var record = objJSX.getRecordNode(recordId);
		var temp = record.getAttribute("jsxAtttibuteGroup");
		var group =service.splitString(record.getAttribute("jsxAtttibuteGroup"));
		var doc = new jsx3.xml.CDF.Document.newDocument();
		for(var i=0;i<group.length;i++){
			var newRecord = new Object();
			newRecord.jsxid=i;
			newRecord.jsxtext=group[i];
			doc.insertRecord(newRecord);
		}
		service.getServer().getCache().setDocument("groupselectdata",doc);
		service.getServer().getJSXByName("selAttributeGroup").repaint();
			
	};
	data.getAttributeByType = function(id){
		if(id=="a"){
			alert(id);
			return;
		}	
		 var objService = service.getServer().loadResource("getAttribute_xml");
		 objService.setOperation("OPERATION");
		 objService.start=0;
		 objService.id = id;
		 objService.count=0;
		 objService.subscribe(jsx3.net.Service.ON_SUCCESS, data.onAttributeListSuccess);
		 objService.doCall();
	};
	data.onAttributeListSuccess = function(e){
		data.generateSelectData("请选择筛选属性","attributelist","xsl/attributeSelece.xsl","attributeselectdata","selAttribute");
	}
	data.generateSelectData = function(parm,cacheId,xslDco,targetCacheId,objJSXName){
		var SourceXML = service.getServer().getCache().getDocument(cacheId);
		var transformDoc = new jsx3.xml.Document().load(service.getServer().resolveURI(xslDco));
		var transformXSL = jsx3.xml.XslDocument.wrap(transformDoc);
		if(parm!=null)
		transformXSL.setParam("firstNode",parm);
		var resultDoc = transformXSL.transformToObject(SourceXML);
		service.getServer().getCache().setDocument(targetCacheId,resultDoc);
		//service.getServer().getJSXByName(objJSXName).repaint();

	};
	data.generalBrandSelect = function(type){
		var objService = service.getServer().loadResource("getBrand_xml");
		objService.count = 0;
		objService.start = 1;
		objService.setOperation("OPERATION");
		if(type==0)
			data.sucessCallBack = data.generalAddGoodsBrandSelect;
		else 
			data.sucessCallBack = data.generalGoodsListBrandSelect;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, data.sucessCallBack);
        objService.subscribe(jsx3.net.Service.ON_ERROR, data.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, data.onOperationInvalid);
        objService.doCall();
	};
	data.generalAddGoodsBrandSelect = function(){
		data.generateSelectData("请选择...","brandlist","xsl/BrandSelect.xsl","brandselect","selGoodBrand");
		data.setFirstSelect("brandselect","selGoodBrand");
	};
	data.generalGoodsListBrandSelect = function(){
		data.generateSelectData("所有品牌","brandlist","xsl/BrandSelect.xsl","brandselect","selGoodBrand");
		data.setFirstSelect("brandselect","selGoodBrand");
	};
	data.onOperationError = function(){};
	data.onOperationInvalid = function(){};
	data.setFirstSelect = function(cacheId,objName){
		var doc = service.getServer().getCache().getDocument(cacheId);
		var first = doc.getFirstChild();
		var value = first.getAttribute("jsxid");
		service.getServer().getJSXByName(objName).setValue(value).repaint();
		
	};
});