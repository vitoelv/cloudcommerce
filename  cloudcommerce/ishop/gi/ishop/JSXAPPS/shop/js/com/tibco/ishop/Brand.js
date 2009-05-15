jsx3.Class.defineClass( 
"com.tibco.ishop.Brand", 
 jsx3.gui.Block,
 null,
function(brand){
	var updateRecord;
	brand.totalRecord;
	brand.init = function(){
		this.brandList = service.getServer().getJSXByName("brandList");
		this.pageControl = service.getServer().getJSXByName("blkPagation");
		this.pageControl.init();
		brand.brandId = null;
		brand.brandName = null;
		brand.brandDescription = null;
		brand.brandShow = null;
		brand.brandOrder = null;
		brand.brandLogo = null;
		brand.brandUrl = null;
		brand.firstTime=true;
    };
	brand.getBrandList = function(){
	    return this.brandList ;
	};
	brand.getPageControl = function(){
		return this.pageControl ;
	};
    brand.getRecord = function(){
		updateRecord =brand.getBrandList().getSelectedNodes().get(0);
		return updateRecord;
	 };
	 brand.getBrandName = function(){
		 var record = brand.getRecord();
		 return record.getAttribute("name");
	};	
	brand.getBrandShow = function(objJSX){
		 var record = brand.getRecord();
		 return record.getAttribute("show");
   	};
	brand.getBrandId = function(){
		 var record = brand.getRecord();
		 return record.getAttribute("id");
	};
	brand.getBrandDescription = function(){
		 var record = brand.getRecord();
		 return record.getAttribute("description");
	};
	brand.getBrandUrl = function(){
		var record = brand.getRecord();
		url = brand.getRecord().getAttribute("url");
	};
	brand.getBrandOrder = function(){
		var record = brand.getRecord();
		return record.getAttribute("order");
	};
	brand.onShowImageClick = function(){
		var show = brand.getBrandShow();
		if(show=="true")
			show=false;
		else 
			show = true
		//brand.getBrandList().getSelectedNodes().get(0).setAttribute("show",show);
		brand.getRecord().setAttribute("show",show);
		var column = service.getServer().getJSXByName("showornot");
		brand.getBrandList().redrawCell(brand.getBrandList().getSelectedIds()[0],column);
		brand.updateBrand("updateBrandOnMatrix_xml");
	};
	brand.onEditImgClick = function(){
		var id = brand.getBrandId();
		brand.getBrandDetail(id);
	};
	brand.onDeleteImgClick = function(){
		var id = brand.getBrandId();
		var name = brand.getBrandName();
		if(confirm("确认要删除品牌"+name+"吗?")){
			brand.deleteBrand(id);
		}
	};
	brand.getStart = function(objJSXClick,targetPage){
		var start=0;
		var presentPage = brand.getPageControl().getPresentPage();		
		if (objJSXClick==brand.getPageControl().nextImg)
		{     
		      start =presentPage*brand.getPageControl().getShowRecordNumber()+1;
			  brand.getPageControl().setPresentPage(++presentPage);
		}
		else if(objJSXClick==brand.getPageControl().previousImg){
			
			 start = brand.getPageControl().getShowRecordNumber()*(presentPage-2)+1;
			 brand.getPageControl().setPresentPage(--presentPage);
		}
		if(targetPage!=null){
			brand.getPageControl().setPresentPage(targetPage);
			start = brand.getPageControl().getShowRecordNumber()*(--targetPage);
		}
		return start;
	};
	brand.getBrandDetail = function(id){
		var objService = service.getServer().loadResource("getBrandDetail_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, brand.onGetBrandDetailSuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, brand.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, brand.onOperationInvalid);
		objService.doCall();
	};
	brand.getBrand = function(objJSXClick,targetPage){
		var objService = shop.loadResource("getBrand_xml");
        objService.setOperation("OPERATION");
		objService.count = brand.getPageControl().getShowRecordNumber();
		objService.start = brand.getStart(objJSXClick,targetPage);
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, brand.onGetBrandSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, brand.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, brand.onOperationInvalid);
        objService.doCall();
	};
	brand.deleteBrand = function(id){
	  var objService = service.getServer().loadResource("deleteBrand_xml");
      objService.setOperation("OPERATION");     
	  objService.deleteId = id;
	  objService.subscribe(jsx3.net.Service.ON_SUCCESS, brand.onDeleteBrandSuccess);
      objService.subscribe(jsx3.net.Service.ON_ERROR, brand.onOperationError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, brand.onOperationInvalid);
      objService.doCall();
	};
	brand.updateBrand = function(ruleName){
	  var objService = service.getServer().loadResource(ruleName);
      objService.setOperation("OPERATION");
	 // objService.subscribe(jsx3.net.Service.ON_SUCCESS, brand.onUpdateBrandSuccess);
      objService.subscribe(jsx3.net.Service.ON_ERROR, brand.onOperationError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, brand.onOperationInvalid);
      objService.doCall();
	};
	brand.updateBransList = function(id,commandType){
		var objService = service.getServer().loadResource("updateBrandList_xml");
		objService.setOperation("OPERATION");
		objService.id = id;
		objService.commandType = commandType;
		if(objService.commandType=="insert")
			brand.onUpdateBrandListSuccess = brand.onAddBrandSuccess;
		else
			brand.onUpdateBrandListSuccess = brand.onUpdateBrandSuccess;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, brand.onUpdateBrandListSuccess);
		objService.subscribe(jsx3.net.Service.ON_ERROR, brand.onOperationError);
		objService.subscribe(jsx3.net.Service.ON_INVALID, brand.onOperationInvalid);
		objService.doCall();
	};
	brand.addBrand = function(ruleName){
	  var objService = service.getServer().loadResource(ruleName);
      objService.setOperation("OPERATION");     
	  objService.subscribe(jsx3.net.Service.ON_SUCCESS, brand.onAddBrandSuccess);
      objService.subscribe(jsx3.net.Service.ON_ERROR, brand.onOperationError);
      objService.subscribe(jsx3.net.Service.ON_INVALID, brand.onOperationInvalid);
      objService.doCall();
	};
	 brand.onGetBrandDetailSuccess = function(){
		service.onMenuClick("a19");
		service.getServer().getJSXByName("blkEdit").setEditArea(brand.brandId,brand.brandName,brand.brandUrl,brand.brandDescription,brand.brandOrder,brand.brandShow);
	 };
	brand.onGetBrandSuccess = function(){
		brand.getPageControl().setTotalRecord(brand.totalRecord);
		brand.getPageControl().setTotalPage();
		if(brand.firstTime==true){
			brand.firstTime=false;
		}
		brand.getBrandList().repaintData();
	};
	brand.onAddBrandSuccess = function(){
		alert("addSucess");
		service.loadPage("components/addSucess.xml");
		//service.getServer().getJSXByName("blkAddSucess").setType("Brand");
		service.getServer().getJSXByName("blkAddSucess").init("Brand");
	};
	brand.onDeleteBrandSuccess = function(){
		brand.getBrand(null,"1");
	};
	brand.onUpdateBrandSuccess = function(){
		alert("updateSucess");
		service.loadPage("components/updateSucess.xml");
		service.getServer().getJSXByName("blkUpdateSucess").init("Brand");
	};
	brand.onDeleteBrandSuccess = function(){
		alert("deletesucess")
		brand.getBrand();
	};
	brand.onOperationError = function(){};
	brand.onOperationInvalid = function(){};
	
	


});