jsx3.lang.Class.defineClass(
"com.tibco.ishop.Pagation",
jsx3.gui.Block,
null,
function(pagation){

	pagation.prototype.init = function(){
		this.totalRecord = service.getServer().getJSXByName("lblTotalRecord");
		this.presentPage = service.getServer().getJSXByName("lblNowPage");
		this.showRecord = service.getServer().getJSXByName("txtShowNumber");
		this.previousImg = service.getServer().getJSXByName("imgPrevious");
		this.targetPage = service.getServer().getJSXByName("txtShowPage");
		this.totalPage = service.getServer().getJSXByName("lblTotalPage");
		this.nextImg = service.getServer().getJSXByName("imgNext");
		this.setPresentPage(1);
		this.setTotalRecord("0");
	};

	pagation.prototype.getShowRecordNumber = function(){
		var sShowNumber = this.showRecord.getValue();
		return new Number(sShowNumber);
	};

	pagation.prototype.getTotalRecord = function(){
		var sTotalRecord = this.totalRecord.getText();
		return new Number(sTotalRecord);
	};
	pagation.prototype.setTotalRecord = function(totalNumber){
		 this.totalRecord.setText(totalNumber,true);
		// this.totalRecord.repaint();
	};
	pagation.prototype.setTotalPage = function(){
		var showNumber = this.getShowRecordNumber();
		var totalRecord = this.getTotalRecord();
		var total = Math.ceil(totalRecord/showNumber);
		this.totalPage.setText(total,true);
	};
	pagation.prototype.getPresentPage = function(){
		var sPresentPage = this.presentPage.getText();
		return new Number(sPresentPage);
	};
	pagation.prototype.setPresentPage = function(pageNumber){
		this.presentPage.setText(pageNumber,true);
	};
	pagation.prototype.getTargetPage = function(){
		var sTargetPage = this.targetPage.getValue();
		return new Number(sTargetPage);
	
	};




});