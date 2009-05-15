jsx3.Class.defineClass( 
"com.tibco.ishop.Category", 
 jsx3.gui.Block,
 null,
function(category){
	var updateRecord;
	category.init = function(){
		 this.categoryList = service.getServer().getJSXByName("goodsCategoryList");
		 category.id;
	category.categoryName = null;
	category.navigationShow = null;
	category.show = null;
	category.parent = null;
	category.keyWords = null;
	category.description = null;
	category.style = null;
	category.order = null;
	category.measureUnit = null;
	category.grade = null;
	category.filterAttribute = null;
		// this.pageControl = service.getServer().getJSXByName("blkPagation");
		// this.pageControl.init();
	};
	category.getCategoryList = function(){
		return this.categoryList;
	};
	category.getPageControl = function(){
		return this.pageControl;
	};
	category.getRecord = function(){
		updateRecord =category.getCategoryList().getSelectedNodes().get(0);
		return updateRecord;
	 };
	category.getRecordId = function(){
		var record = category.getRecord();
		return record.getAttribute("jsxid");
	};
	category.getCategoryId = function(){
		var record = category.getRecord();
		return record.getAttribute("id");
	};
	category.getParent = function(){
		var record = category.getRecord();
		return record.getAttribute("parent");
	};
	category.getCategoryName = function(){
		var record = category.getRecord();
		return record.getAttribute("name");
	};
	category.getNavigationShow = function(){
		var record = category.getRecord();
		return record.getAttribute("shownavigation");
	};
	category.getShow = function(){
		var record = category.getRecord();
		return record.getAttribute("show");
	};
	category.getKeyWord = function(){
		var record = category.getRecord();
		return record.getAttribute("keywords");
	};
	category.getDescription = function(){
		var record = category.getRecord();
		return record.getAttribute("description");
	};
	category.getMeasureUnit = function(){
		var record = category.getRecord();
		return record.getAttribute("measureunit");
	};
	category.getStyle = function(){
		var record = category.getRecord();
		return record.getAttribute("style");
	};
	category.getOrder = function(){
		var record = category.getRecord();
		return record.getAttribute("order");
	};
	category.getGrade = function(){
		var record = category.getRecord();
		return record.getAttribute("grade");
	};
	category.getFilterAttribute = function(){
		var record = category.getRecord();
		return record.getAttribute("filterattribute");
	};
	category.getTemplateFile = function(){
		var record = category.getRecord();
		return record.getAttribute("templatefile");
	};
	category.addCategory = function(ruleName){
		 var objService = service.getServer().loadResource(ruleName);
         objService.setOperation("OPERATION");
		 objService.subscribe(jsx3.net.Service.ON_SUCCESS, category.onAddCategorySuccess);
         objService.subscribe(jsx3.net.Service.ON_ERROR, category.onOperationError);
         objService.subscribe(jsx3.net.Service.ON_INVALID, category.onOperationInvalid);
         objService.doCall();
	};
	category.updateCategory = function(ruleName){
		var objService = service.getServer().loadResource(ruleName);
		objService.setOperation("OPERATION");
		//objService.subscribe(jsx3.net.Service.ON_SUCCESS, category.onUpdateCategorySuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, category.onOperationError);
		objService.subscribe(jsx3.net.Service.ON_INVALID, category.onOperationInvalid);
		objService.doCall();
	};
	category.updateCategoryList = function(id,commandType){
		var objService = service.getServer().loadResource("updateCategoryList_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.commandType = commandType;
		if(commandType=="insert")
			category.updateCategoryListSuccess = category.onAddCategorySuccess;
		else 
			category.updateCategoryListSuccess = category.onUpdateCategorySuccess;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, category.updateCategoryListSuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, category.onOperationError);
		objService.subscribe(jsx3.net.Service.ON_INVALID, category.onOperationInvalid);
		objService.doCall();
	};

	category.getCategory = function(id){
		var objService = service.getServer().loadResource("getCategory_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, category.onGetCategorySuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, category.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, category.onOperationInvalid);
		objService.doCall();
	};
	category.getCategoryDetail = function(id){
		var objService = service.getServer().loadResource("getCategoryDetail_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, category.onGetCategoryDetailSuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, category.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, category.onOperationInvalid);
		objService.doCall();
	};

	category.deleteCategory = function(){
		var objService = service.getServer().loadResource("deleteCategory_xml");
		objService.setOperation("OPERATION");
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, category.onDeleteCategorySuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, category.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, category.onOperationInvalid);
		objService.doCall();
	};
	category.onDeleteClick = function(){
		var id = category.getCategoryId();
		var name = category.getCategoryName();
		if(confirm("删除前请确认分类"+name+"不是父级分类或者该分类下不存在商品")){
			category.deleteCategory(id);
		}
	};
	category.onEditClick = function(){
		var id = category.getCategoryId();
		category.getCategoryDetail(id);
	};
	category.onGetCategoryDetailSuccess = function(){
		service.onMenuClick("a18");
		service.getServer().getJSXByName("blkCategoryEdit").setEditArea(category.id,category.categoryName,category.navigationShow,category.show,
			category.parent,category.keyWords,category.description,category.style,category.order,category.measureUnit,category.grade,
			category.filterAttribute);
	};
	category.onAddCategorySuccess = function(){
		alert("addSucess");
		service.loadPage("components/addSucess.xml");
		//service.getServer().getJSXByName("blkAddSucess").setType("Brand");
		service.getServer().getJSXByName("blkAddSucess").init("Category");
	};
	category.onGetCategorySuccess = function(){
		var responseCache = service.getServer().getCache().getDocument("categorylist");
		var childNodes = responseCache.getChildNodes();
		for(var i=0;i<childNodes.size();i++){
			//alert(i);
			var presentRecord = childNodes.get(i);
			category.creat(null,presentRecord,responseCache);
			childNodes = responseCache.getChildNodes();
		//	alert("ok");
		//	alert(presentRecord);
			//var deleteNodes = presentRecord.selectNodes("//record[@childId]");
		//	alert(deleteNodes);
		//	for(var i=0;i<deleteNodes.size();i++){
		//	var deleteRecord = deleteNodes.get(i);
		//	presentRecord.removeChild(deleteRecord);
		//}
		
		
		}
		/*for(var i=0;i<deleteNodes.size();i++){
			var deleteRecord = deleteNodes.get(i);
			alert(deleteRecord);
			responseCache = service.getServer().getCache().getDocument("categoryData_xml");
			alert( responseCache.removeChild(deleteRecord));
		}*/
		
		/*var doc = service.getServer().getCache().getDocument("categoryData_xml");
		var childNodes = doc.getChildNodes();
		//alert(childNodes);
		var presentRecord = childNodes.get("0");alert(presentRecord);
		var insertRecord=doc.selectSingleNode("//record[@id='16']");
		var childNode = presentRecord.getChildNodes();
		presentRecord.appendChild(insertRecord);
		//alert(presentRecord);
		 childNode = presentRecord.getChildNodes();
		alert(childNode);*/
		category.getCategoryList().repaintData();

		
		
	};
	
	category.creat = function(parentRecord,presentRecord,responseCache){
		//alert(presentRecord);
		//var i = presentRecord.getChildIterator();
		var childNodes = presentRecord.getChildNodes();
		for(var i=childNodes.size()-1;i>=0;i--){
			var childRecord = childNodes.get(i);
			var childId = childRecord.getAttribute("childId");
		//	alert(childRecord)
			if(childId==null){
				continue;
			}
			var insertRecord=responseCache.selectSingleNode("//record[@id='"+childId+"']");
			//alert(insertRecord);
			//alert("remove");
			presentRecord.removeChild(childRecord);
			
			//presentRecord.appendChild(insertRecord);
			//alert(responseCache);
			category.creat(presentRecord,insertRecord,responseCache);
			childNodes = presentRecord.getChildNodes();
		}
		/*for(var i=0;i<childNodes.size();i++){
			var childRecord = childNodes.get(i);
			var childId = childRecord.getAttribute("childId");
		//	alert(childRecord)
			if(childId==null){
				continue;
			}
			var insertRecord=responseCache.selectSingleNode("//record[@id='"+childId+"']");
			//alert(insertRecord);
			//alert("remove");
			//presentRecord.removeChild(childRecord);
			
			//presentRecord.appendChild(insertRecord);
			//alert(responseCache);
			category.creat(presentRecord,insertRecord,responseCache);
			childNodes = presentRecord.getChildNodes();
		}/*
		
		/*if(i.hasNext()==false){
			alert("if");
			alert(parentRecord);
			parentRecord.appendChild(presentRecord);
			alert(parentRecord);
		}*/
	/*	while(i.hasNext()){
			alert("child");
			var childRecord = i.next();
			var childId = childRecord.getAttribute("childId");
			alert(childRecord)
			if(childId==null){
				alert("if");
				continue;
			}
			var insertRecord=responseCache.selectSingleNode("//record[@id='"+childId+"']");
			alert(insertRecord);
			alert("remove");
			presentRecord.removeChild(childRecord);
			//presentRecord.appendChild(insertRecord);
			//alert(responseCache);
			category.creat(presentRecord,insertRecord,responseCache);
		}*/
		// alert("finish");
		 if(parentRecord!=null)
		 parentRecord.appendChild(presentRecord);
		// alert(responseCache);
		// alert(parentRecord);
	};
	category.onUpdateCategorySuccess = function(){
		alert("updatesecess");
		service.loadPage("components/updateSucess.xml");
		service.getServer().getJSXByName("blkUpdateSucess").init("Category");
		
	};
	category.onOperationError = function(){};
	category.onDeleteCategorySuccess = function(){
		alert(category.getRecordId());

		category.getCategoryList().deleteRecord(category.getRecordId());
	};
	category.updateCategoryListSuccess = function(){
		alert("sucess");
	};
	category.onOperationInvalid = function(){};
});