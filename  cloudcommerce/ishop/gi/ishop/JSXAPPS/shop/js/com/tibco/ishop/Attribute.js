//jsx3.require("com.tibco.ishop.Type");
jsx3.Class.defineClass( 
"com.tibco.ishop.Attribute", 
 jsx3.gui.Block,
 null,
function(attribute){
	
	var updateRecord;
	attribute.totalRecord;
	attribute.init = function(){
		this.attributeList = service.getServer().getJSXByName("attributeList");
		this.pageControl = service.getServer().getJSXByName("blkPagation");
		this.pageControl.init();
		attribute.attributeId = null;
		attribute.attributeName = null;
		attribute.goodsType = null;
		attribute.type = null;
		attribute.index = null;
		attribute.linked = null;
		attribute.inputType = null;
		attribute.group = null;
		attribute.order = null;
		attribute.valueList = null;
	};
	attribute.getAttributeList = function(){
		return this.attributeList;	
	};
	attribute.getPageControl = function(){
		return this.pageControl;
	}
	attribute.getUpdateRecord = function(){
		updateRecord  = attribute.getAttributeList().getSelectedNodes().get(0);
		return updateRecord;
	};
	attribute.getAttributeId = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("id");	
	};
	attribute.getAttributeName = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("name");	
	};
	attribute.getGoodsType = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("goodstype");	
	};
	attribute.getType = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("type");	
	};
	attribute.getIndex = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("index");	
	};
	attribute.getLinked = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("linked");	
	};
	attribute.getInputType = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("inputtype");	
	};
	attribute.getGroup = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("group");	
	};
	attribute.getOrder = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("order");	
	};
	attribute.getValueList = function(){
		var record = attribute.getUpdateRecord();
		return record.getAttribute("valuelist");	
	};
	attribute.getStart = function(objJSXClick,targetPage){
		var start=0;
		var presentPage = attribute.getPageControl().getPresentPage();	
		if (objJSXClick==attribute.getPageControl().nextImg)
		{     alert("next");		
			start =presentPage*attribute.getPageControl().getShowRecordNumber()+1;
			attribute.getPageControl().setPresentPage(++presentPage);
		}
		else if(objJSXClick==attribute.getPageControl().previousImg){
			 start = attribute.getPageControl().getShowRecordNumber()*(presentPage-2)+1;
			 attribute.getPageControl().setPresentPage(--presentPage);
		}
		if(targetPage!=null){
			attribute.getPageControl().setPresentPage(targetPage);
			start = attribute.getPageControl().getShowRecordNumber()*(--targetPage);
		}
		return start;
	};
	attribute.initPage = function(){
		if(!com.tibco.ishop.Type.typeId){
			attribute.getAttributeData();
			//service.getServer().getJSXByName("selGoodsType").setValue("a");
		}
		else {
			attribute.getAttributeByType(com.tibco.ishop.Type.typeId);
			service.getServer().getJSXByName("selGoodsType").setValue(com.tibco.ishop.Type.typeId);
		}
	};
	attribute.getAttributeData = function(id,objJSXClick,targetPage){
		
		//debugger;
		 var objService = service.getServer().loadResource("getAttribute_xml");
		 objService.setOperation("OPERATION");
		 objService.start=attribute.getStart(objJSXClick,targetPage);
		 objService.count = attribute.getPageControl().getShowRecordNumber();
		 if(id!=null) objService.id=id;		 
		 objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onGetAttributeDataSuccess);
		 objService.doCall();
	};
	attribute.getAttributeDetail = function(id){
		var objService = service.getServer().loadResource("getAttributeDetail_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onGetAttributeDetailSuccess);
		objService.doCall();
	};
	attribute.getAttributeByType = function(id,objJSXClick){
		alert("1");
		service.getServer().getCache().clearById("attributelist");
		 var objService = service.getServer().loadResource("getAttribute_xml");
		 objService.setOperation("OPERATION");
		 objService.start = attribute.getStart(objJSXClick);
		 if(id!="0") objService.id = id;
		 objService.count = attribute.getPageControl().getShowRecordNumber();
		 objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onGetAttributeByTypeSuccess);
		 objService.doCall();
	};
	attribute.onPageImgClick = function(objJSXClick){
		var typeId = service.getServer().getJSXByName("selGoodsType").getValue();
		if(typeId=="0"){
			attribute.getAttributeData(null,objJSXClick);
		}
		else{
			attribute.getAttributeData(typeId,objJSXClick);
		}
	};
	attribute.onShowRecoreNumberChange = function(){
		var typeId = service.getServer().getJSXByName("selGoodsType").getValue();
		if(typeId=="0"){
			attribute.getAttributeData();
		}
		else{
			attribute.getAttributeByType(typeId);
		}
	};
	attribute.onShowPageNumberchange = function(objJSXChange,targetPage){
		var typeId = service.getServer().getJSXByName("selGoodsType").getValue();
		if(typeId=="0"){
			attribute.getAttributeData(null,null,targetPage);
		}
		else{
			attribute.getAttributeData(typeId,null,targetPage);
		}
		objJSXChange.setText("");
	};
	attribute.onGetAttributeDataSuccess = function(){
		
		var attributeList = service.getServer().getCache().getDocument("attributelist");	
		var typeList = service.getServer().getCache().getDocument("typelist");
		var childNodes = attributeList.getChildNodes();
		for(var i=0;i<childNodes.size();i++){
			var attRecord = childNodes.get(i);
			var id = attRecord.getAttribute("goodstype");
			var typeRecord = typeList.selectSingleNode("//record[@id = '" + id + "']") ;
			var typeName = typeRecord.getAttribute("name");	
			attRecord.setAttribute("goodstypename",typeName);		
		}
		attribute.getAttributeList().repaintData();
		attribute.getPageControl().setTotalRecord(attribute.totalRecord);
		attribute.getPageControl().setTotalPage();
	};
	attribute.onGetAttributeDetailSuccess = function(){
		service.onMenuClick("a22");
		service.getServer().getJSXByName("blkAttributeEdit").setEditArea(attribute.attributeId,attribute.attributeName,attribute.goodsType,attribute.type,attribute.index,attribute.linked,attribute.group,attribute.inputType,attribute.valueList);
	};
	attribute.onGetAttributeByTypeSuccess = function(){
		attribute.getPageControl().setPresentPage(1);
		attribute.onGetAttributeDataSuccess();
	};
	attribute.addAttribute = function(){
		var objService = service.getServer().loadResource("addAttribute_xml");
        objService.setOperation("OPERATION");     
	    objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onAddAttributeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, attribute.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, attribute.onOperationInvalid);
        objService.doCall();	
	};
	attribute.deleteAttribute = function(id,tag){
		var objService = service.getServer().loadResource("deleteAttribute_xml");
        objService.setOperation("OPERATION");    
		objService.id = id;
		if(tag!=false){
			objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onDeleteAttributeSuccess);
		}
        objService.subscribe(jsx3.net.Service.ON_ERROR, attribute.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, attribute.onOperationInvalid);
        objService.doCall();	
	};
	attribute.updateAttributeList = function(id,commandType){
		var objService = service.getServer().loadResource("updateAttributeList_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.commandType = commandType;
		if(objService.commandType=="insert")
			attribute.onUpdateAttributeListSuccess = attribute.onAddAttributeSuccess;
		else
			attribute.onUpdateAttributeListSuccess = attribute.onUpdateAttributeSuccess;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onUpdateAttributeListSuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, attribute.onOperationError);
		objService.subscribe(jsx3.net.Service.ON_INVALID, attribute.onOperationInvalid);
		objService.doCall();
	};
	attribute.updateAttribute = function(ruleName,id){
		var objService = service.getServer().loadResource(ruleName);
		objService.id = id;
        objService.setOperation("OPERATION");     
	    //objService.subscribe(jsx3.net.Service.ON_SUCCESS, attribute.onUpdateAttributeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, attribute.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, attribute.onOperationInvalid);
        objService.doCall();	
	};
	attribute.onAddAttributeSuccess = function(){
		alert("addSucess");
		service.loadPage("components/addSucess.xml");
		//service.getServer().getJSXByName("blkAddSucess").setType("Brand");
		service.getServer().getJSXByName("blkAddSucess").init("Attribute");
	};
	attribute.onDeleteAttributeSuccess = function(){
		attribute.getAttributeData();
	};
	attribute.onUpdateAttributeSuccess = function(){
		alert("updateSucess");
		service.loadPage("components/updateSucess.xml");
		service.getServer().getJSXByName("blkUpdateSucess").init("Attribute");
	};
	attribute.onOperationError = function(){};
	attribute.onOperationInvalid = function(){};
	attribute.onEditImgClick = function(){
		var id = attribute.getAttributeId();
		attribute.getAttributeDetail(id);
	};
	attribute.onDeleteImgClick = function(){
		var id = attribute.getAttributeId();
		var name = attribute.getAttributeName();
		if(confirm("确认要删除属性"+name+"吗?")){
			attribute.deleteAttribute(id);
		}
	};



});