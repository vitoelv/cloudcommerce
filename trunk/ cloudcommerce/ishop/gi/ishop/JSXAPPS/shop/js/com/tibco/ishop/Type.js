jsx3.require("com.tibco.ishop.Attribute");
jsx3.Class.defineClass( 
"com.tibco.ishop.Type", 
 jsx3.gui.Block,
 null,
function(type){
	
	var updateRecord;
	type.attributeTotal;
	type.typeRecords = new jsx3.util.List();
	type.totalRecord;
	type.attributeTypeMap = new jsx3.util.List();
	type.init = function(){
		this.typeList = service.getServer().getJSXByName("typelist");
		this.pageControl = service.getServer().getJSXByName("blkPagation");
		this.pageControl.init();
		type.typeId=null;
		type.typeName=null;
		type.attributeGroup=null;
	};
	type.getTypeList = function(){
		return this.typeList;
	};
	type.getPageControl = function(){
		return this.pageControl;
	};
	type.getUpdateRecord = function(){
		updateRecord  = type.getTypeList().getSelectedNodes().get(0);
		return updateRecord;
	};
	type.getState = function(){
		var record = type.getUpdateRecord();
		return record.getAttribute("state");	
	};
	type.getTypeName = function(){
		var record = type.getUpdateRecord();
		return record.getAttribute("name");	
	};
	type.getAttributeGroup = function(){
		var record = type.getUpdateRecord();
		return record.getAttribute("attributegroup");	
	};
	type.getTypeId = function(){
		var record = type.getUpdateRecord();
		return record.getAttribute("id");
	};
	type.onAttributeClick = function(){
		type.typeId = type.getTypeId();
		service.onMenuClick("a21");
	};
	type.onEditClick = function(){
		var id = type.getTypeId();
		type.getTypeDetail(id);
	};
	type.onDeleteClick = function(){
		var id = type.getTypeId();
		var name = type.getTypeName();
		if(confirm("删除商品类型将会删除该类型下的所有属性.确认要删除类型"+name+"吗？")){
			type.deleteType(id);
		}
	};
	type.getStart = function(objJSXClick,targetPage){
		var start=0;
		var presentPage = type.getPageControl().getPresentPage();		
		if (objJSXClick==type.getPageControl().nextImg)
		{     
			start =presentPage*type.getPageControl().getShowRecordNumber()+1;
			type.getPageControl().setPresentPage(++presentPage);
		}
		else if(objJSXClick==type.getPageControl().previousImg){
			 start = type.getPageControl().getShowRecordNumber()*(presentPage-2)+1;
			 type.getPageControl().setPresentPage(--presentPage);
		}
		if(targetPage!=null){
			type.getPageControl().setPresentPage(targetPage);
			start = type.getPageControl().getShowRecordNumber()*(--targetPage);
		}
		return start;
	};
	type.getType = function(objJSXClick,targetPage){
		var objService = service.getServer().loadResource("getType_xml");
		objService.start=type.getStart(objJSXClick,targetPage);
		objService.count = type.getPageControl().getShowRecordNumber();
		objService.setOperation("OPERATION");
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.onGetTypeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
		objService.doCall();
		};
	type.getTypeDetail = function(id){
		 var objService = service.getServer().loadResource("getTypeDetail_xml");
		 objService.setOperation("OPERATION");
		 objService.id = id ;
         objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.onGetTypeDetailSuccess);
         objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
         objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
		 objService.doCall();
	};
	type.onGetTypeSuccess = function(){
		var doc = type.getTypeList().getXML();
		var childeNodes = doc.getChildNodes();
		type.getTypeAttributeAcount(childeNodes);
		type.getTypeList().repaintData();
		type.getPageControl().setTotalRecord(type.totalRecord);
		type.getPageControl().setTotalPage();
	};
	type.getTypeAttributeAcount = function(typeRecords){
		for(var i=0;i<typeRecords.size();i++){
			var array = new Array();			
			var objService = service.getServer().loadResource("getAttribute_xml");
			objService.start = 0;
			objService.count = 0;
			objService.id = typeRecords.get(i).getAttribute("id");
			type.attributeTypeMap.add({id:objService.id,array:array});
			objService.array = array;
			objService.updateReord = typeRecords.get(i) ;
			objService.setOperation("OPERATION");
			objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.getTypeAttributeAcountSucess);
			objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
			objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
			objService.doCall();
		}
		 
	};
	type.deleteType = function(id){
		type.deleteAttributeByType(id);
		var objService = service.getServer().loadResource("deleteType_xml");
        objService.setOperation("OPERATION");     
	    objService.deleteId = id;
	    objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.onDeleteTypeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
        objService.doCall();
	};
	type.deleteAttributeByType = function(id){
		var ids = type.getAttributeIds(id);
		for(var i=0;i<ids.length;i++){
			com.tibco.ishop.Attribute.deleteAttribute(ids[i],false);
		}
	};
	type.getAttributeIds = function(typeId){
		for(var i=0;i<type.attributeTypeMap.size();i++){
			var idObj = type.attributeTypeMap.get(i);
			if(idObj.id==typeId)
				return idObj.array;
		}
	};
	type.updateType = function(ruleName){
		var objService = service.getServer().loadResource(ruleName);
        objService.setOperation("OPERATION");     
	  //objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.onUpdateTypeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
        objService.doCall();
	};
	type.updateTypeList = function(id,commandType){
		var objService = service.getServer().loadResource("updateTypeList_xml");
        objService.setOperation("OPERATION"); 
		objService.id = id;
		objService.commandType = commandType;
		if(objService.commandType=="insert")
			 type.onUpdateTypeListSuccess = type.onAddTypeSuccess;
		else
			type.onUpdateTypeListSuccess = type.onUpdateTypeSuccess;
	    objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.onUpdateTypeListSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
        objService.doCall();
	};
	type.addType = function(){
		var objService = service.getServer().loadResource("addType_xml");
        objService.setOperation("OPERATION");     
	    objService.subscribe(jsx3.net.Service.ON_SUCCESS, type.onAddTypeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, type.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, type.onOperationInvalid);
        objService.doCall();
	
	};
	type.onGetTypeDetailSuccess = function(){
		service.onMenuClick("a20");
		service.getServer().getJSXByName("blktypeEdit").setEditArea(type.typeId,type.typeName,type.attributeGroup);
	};
	type.onUpdateTypeSuccess = function(){
		alert("updateSucess");
		service.loadPage("components/updateSucess.xml");
		service.getServer().getJSXByName("blkUpdateSucess").init("GoodsType");
	};
	type.onDeleteTypeSuccess = function(){
		alert("deletesucess");
		type.getType();
	};
	type.getTypeAttributeAcountSucess = function(){};
	type.onAddTypeSuccess = function(){
		alert("addSucess");
		service.loadPage("components/addSucess.xml");
		//service.getServer().getJSXByName("blkAddSucess").setType("Brand");
		service.getServer().getJSXByName("blkAddSucess").init("GoodsType");
	};
	type.onOperationError = function(){};
	type.onOperationInvalid = function(){};




});