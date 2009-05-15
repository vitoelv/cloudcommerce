jsx3.lang.Class.defineClass(
"com.tibco.ishop.Entity",
jsx3.gui.Block,
null,
function(entity){
	
	var mainBlock;
	entity.init = function(parentName,entityListName){
		mainBlock = service.getServer().getJSXByName(parentName);
		this.pageControl = service.getServer().getJSXByName("blkPagation");
		this.entityListObjJSX = service.getServer().getJSXByName(entityListName);
		//me.pageControl.init();	
		//me.entityListObjJSX.init(entityListName);
		
	};

	entity.prototype.getPageControl = function(){
		return this.pageControl;
	};
	entity.prototype.getEntityListObjJSX = function(){
		return this.entityListObjJSX;
	};
	entity.addNewEntity = function(ruleName){
	  var objService = service.getServer().loadResource(ruleName);
      objService.setOperation("OPERATION");
	  objService.subscribe(jsx3.net.Service.ON_SUCCESS, entity.onOPERATIONSuccess);
	  objService.subscribe(jsx3.net.Service.ON_ERROR, entity.onOPERATIONError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, entity.onOPERATIONInvalid);
	  objService.doCall();	
	 };
	entity.onOPERATIONSuccess = function(objEvent){

		objEvent.target.getServer().alert("Success","The service call was successful.");
		

	};
	entity.onOPERATIONError = function(objEvent) {
      var myStatus = objEvent.target.getRequest().getStatus();
      objEvent.target.getServer().alert("Error","The service call failed. The HTTP Status code is: " + myStatus);
    };

    entity.onOPERATIONInvalid = function(ruleName,objEvent) {
      objEvent.target.getServer().alert("Invalid","The following message node just failed validation:\n\n" + objEvent.message);
    };

    entity.getEntityList = function(ruleName,objJSXClick){
		 var objService = service.getServer().loadResource(ruleName);
		 objService.start=me.getStart(objJSXClick);
		 objService.count = me.getPageControl().getShowRecordNumber();
		 objService.setOperation("OPERATION");
         objService.subscribe(jsx3.net.Service.ON_SUCCESS, entity.onGetEntityListSuccess);
         objService.subscribe(jsx3.net.Service.ON_ERROR, entity.onGetEntityListError);
         objService.subscribe(jsx3.net.Service.ON_INVALID, entity.onGetEntityListInvalid);
		 objService.compile();
         objService.doCall();
		
	};
	entity.onGetEntityListSuccess = function(objEvent){
		me.getEntityListObjJSX().repaintData();
		me.getPageControl().setTotalPage();
		//objEvent.target.getServer().alert("Success","The service call was successful.");
		
		
	};
	entity.onGetEntityListError = function(objEvent){};
	entity.onGetEntityListInvalid = function(objEvent){};
	entity.prototype.getStart = function(objJSXClick){
		var firstId = me.getEntityListObjJSX().getStartId();
		var startId;
		
		if (objJSXClick==me.getPageControl().nextImg)
		{
			alert("if");
		      startId = firstId+me.getPageControl().getShowRecordNumber()-1;
		}
		else if(objJSXClick==me.getPageControl().previousImg){
			alert("else");
			 startId = firstId-me.getPageControl().getShowRecordNumber()-1;
		}
		else {
			startId=0;		
		}
		alert(startId);
      return startId;
	};
	entity.prototype.generateSelDate = function(sourceXMLName,transformXSLUrl,cacheId){
		var SourceXML = service.getServer().getCache().getDocument(sourceXMLName);
	    var transformXSL = new jsx3.xml.Document().load(service.getServer().resolveURI(transformXSLUrl));
	    var transformedDoc = SourceXML.transformNode(transformXSL);
        var newDoc = new jsx3.xml.Document().loadXML(transformedDoc); 
	    service.getServer().getCache().setDocument(cacheId,newDoc);
	    //shop.getJSXByName("selGoodsType").repaint();
    };
	entity.updateEntity = function(id,ruleName){
	  alert("update");
	  var objService = service.getServer().loadResource(ruleName);
      objService.setOperation("OPERATION");
	  objService.subscribe(jsx3.net.Service.ON_SUCCESS, entity.onOPERATIONSuccess);
	  objService.subscribe(jsx3.net.Service.ON_ERROR, entity.onOPERATIONError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, entity.onOPERATIONInvalid);
	  objService.doCall();	
	};
	entity.deleteEntity = function(id,deleteRuleName,getRuleName){
	 var objService = shop.loadResource(deleteRuleName);
      objService.setOperation("OPERATION");     
	  objService.deleteId = id;
	  entity.getRuleName = getRuleName;
	  alert(objService.deleteId);
      objService.subscribe(jsx3.net.Service.ON_SUCCESS, entity.ondeleteEntitySuccess);
      objService.subscribe(jsx3.net.Service.ON_ERROR, entity.onOPERATIONError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, entity.onOPERATIONInvalid);
      objService.doCall();
	};
	entity.ondeleteEntitySuccess = function(objEvent){
		alert(entity.getRuleName);
		entity.getEntityList(entity.getRuleName);
	};

	



});