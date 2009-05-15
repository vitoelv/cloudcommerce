jsx3.Class.defineClass(
"com.tibco.ishop.GoodEditBlock", 
jsx3.gui.Block,
null,
function(edit){
	edit.prototype.init = function(){
		this.generalTabButton = service.getServer().getJSXByName("tabGeneralInfomation");
		this.detailTabButton = service.getServer().getJSXByName("tabDetailInfomation");
		this.otherTabButton = service.getServer().getJSXByName("tabOtherInfomation");
		this.attributeTabButton = service.getServer().getJSXByName("tabGoodsAttribute");
		this.pthtoTabButton = service.getServer().getJSXByName("tabGoodsPhoto");
		this.relateGoodsTabButton = service.getServer().getJSXByName("tabRelatedGoods");
		this.goodArchmentTabButton = service.getServer().getJSXByName("tabGoodsAchments");
		this.relatedArticleTabButton = service.getServer().getJSXByName("tabRelatedArticles");
	};
	edit.prototype.onTabButtonClick = function(tabButtonClick,tabPane,page){
			this.reSetTabButton();
			this.reSetTabPane();
			tabButtonClick.setDynamicProperty("jsxstyleoverride","@Tab Selected CSS");
			tabButtonClick.repaint();
			this.setTabPane(tabPane,page);
	};
	edit.prototype.reSetTabButton = function(){
		this.generalTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.detailTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.otherTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.attributeTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.pthtoTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.relateGoodsTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.goodArchmentTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
		this.relatedArticleTabButton.setDynamicProperty("jsxstyleoverride","@Tab Unselecte CSS").repaint();
	};
	edit.prototype.setTabPane = function(tabPane,page){
		service.getServer().getJSXByName(tabPane).setDisplay(jsx3.gui.Block.DISPLAYBLOCK,true);
		service.getServer().getJSXByName(tabPane).removeChildren();
		service.getServer().getJSXByName(tabPane).load(page);		
	}; 
	edit.prototype.reSetTabPane =function(){
		service.getServer().getJSXByName("generalinfomation").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("otherinfomation").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("goodsattribute").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("relatedgoods").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("relatedarticles").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("goodsattachments").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("goodsphoto").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
		service.getServer().getJSXByName("detailinfomation").setDisplay(jsx3.gui.Block.DISPLAYNONE ,true);
	};
	edit.prototype.onExtendCategoryButtonClick = function(){
		
	};
	edit.onAddButtonClick = function(paneName){
		service.getServer().getJSXByName(paneName).setDisplay(jsx3.gui.Block.DISPLAYBLOCK,true).repaint();
	};
	edit.onHideButtonClick = function(paneName){
		service.getServer().getJSXByName(paneName).setDisplay(jsx3.gui.Block.DISPLAYNONE,true).repaint();
	};
	edit.onAddEntityButtonClick = function(ruleName){
		var objService = service.getServer().loadResource(ruleName);
        objService.setOperation("OPERATION");     
	    objService.subscribe(jsx3.net.Service.ON_SUCCESS, edit.onAddBrandSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, edit.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, edit.onOperationInvalid);
        objService.doCall();
	};
	edit.onAddBrandSuccess = function(){alert("sucess");};
	edit.onOperationError = function(){};
	edit.onOperationInvalid = function(){};
	edit.prototype.getParentCategory = function(){
		return service.getServer().getJSXByName("selParentName").getValue();
	};
	edit.prototype.getGoodsBrand = function(){
		return service.getServer().getJSXByName("selGoodBrand").getValue();
	};
	edit.prototype.onPromotedClick = function(){
		var status = service.getServer().getJSXByName("promote").getChecked();
		if(status=="1"){
			service.getServer().getJSXByName("txtPromotePrice").setEnabled(1,true);
			service.getServer().getJSXByName("promoteStartDate").setEnabled(1,true);
			service.getServer().getJSXByName("promoteEndDate").setEnabled(1,true);
		}
		else{
			service.getServer().getJSXByName("txtPromotePrice").setEnabled(0,true);
			service.getServer().getJSXByName("promoteStartDate").setEnabled(0,true);
			service.getServer().getJSXByName("promoteEndDate").setEnabled(0,true);
		}
	};
	edit.prototype.getPromoted = function(){
		if(service.getServer().getJSXByName("promote").getChecked()=="1")
			return true;
		return false;
	};
	edit.prototype.getPromotedStartDate = function(){
		return service.getServer().getJSXByName("promoteStartDate").getValue();
	};
	edit.prototype.getPromotedEndDate = function(){
		return service.getServer().getJSXByName("promoteEndDate").getValue();
	};
	edit.prototype.onOkButtonClick = function(){
		
	};
	edit.prototype.getWeight = function(){
		var mesureUnit = service.getServer().getJSXByName("selWeight").getValue();
		if(mesureUnit=="1")
			return service.getServer().getJSXByName("txtWeight").getValue();
		else
			return (service.getServer().getJSXByName("txtWeight").getValue()/1000);
	};
	edit.prototype.getBest = function(){
		if(service.getServer().getJSXByName("chkBest").getChecked()=="1")
			return true;
		return false;
	};
	edit.prototype.getNew = function(){
		if(service.getServer().getJSXByName("chkNew").getChecked()=="1")
			return true;
		return false;
	};
	edit.prototype.getHot = function(){
		if(service.getServer().getJSXByName("chkHot").getChecked()=="1")
			return true;
		return false;
	};
	edit.prototype.getOnSale = function(){
		if(service.getServer().getJSXByName("chkOnSale").getChecked()=="1")
			return true;
		return false;
	};
	edit.prototype.getAloneSale = function(){
		if(service.getServer().getJSXByName("chkAloneSale").getChecked()=="1")
			return true;
		return false;
	};
	edit.prototype.getType = function(){
		return service.getServer().getJSXByName("selGoodsType").getValue();
	};
});