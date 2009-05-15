jsx3.Class.defineClass( 
"com.tibco.ishop.Goods", 
 jsx3.gui.Block,
 null,
function(goods){
	goods.totalRecord;
	goods.init = function(){
		this.goodsList = service.getServer().getJSXByName("GoodsList");
		this.pageControl = service.getServer().getJSXByName("blkPagation");
		this.pageControl.init();
	};
	goods.getGoodsList = function(){
		return this.goodsList;
	};
	goods.getPageControl = function(){
		return this.pageControl;
	};
	goods.setCriteria = function(){
		var mainCategory = shop.getJSXByName("selParentName").getValue();
	};
	goods.getStart = function(objJSXClick,targetPage){
		var start=0;
		var presentPage = goods.getPageControl().getPresentPage();		
		if (objJSXClick==goods.getPageControl().nextImg)
		{
			start =presentPage*goods.getPageControl().getShowRecordNumber()+1;
			goods.getPageControl().setPresentPage(++presentPage);
		}
		else if(objJSXClick==goods.getPageControl().previousImg){
			start = goods.getPageControl().getShowRecordNumber()*(presentPage-2)+1;
			goods.getPageControl().setPresentPage(--presentPage);
		}
		if(targetPage!=null){
			goods.getPageControl().setPresentPage(targetPage);
			start = goods.getPageControl().getShowRecordNumber()*(--targetPage);
		}
		return start;
	};
	goods.getGoods = function(objJSXClick,targetPage){
		var objService = service.getServer().loadResource("getGoods_xml");
		objService.start=goods.getStart(objJSXClick,targetPage);
		objService.count = goods.getPageControl().getShowRecordNumber();
		objService.setOperation("OPERATION");
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, goods.onGetGoodsSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, goods.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, goods.onOperationInvalid);
		objService.doCall();
	};
	goods.onGetGoodsSuccess = function(){
		goods.getGoodsList().repaintData();
		goods.getPageControl().setTotalRecord(goods.totalRecord);
		goods.getPageControl().setTotalPage();
	};
	 goods.onOperationError = function(){};
	 goods.onOperationInvalid = function(){};
	
});