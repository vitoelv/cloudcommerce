jsx3.require("com.tibco.ishop.Brand");
jsx3.lang.Class.defineClass(
"com.tibco.ishop.BrandEditBlock",
jsx3.gui.Block,
null,
function(edit){
	//var brandId;
    edit.prototype.init = function(){
		 //me = service.getServer().getJSXByName(name);
		this.nameObjJSX = service.getServer().getJSXByName("txtBrandName");
	    this.urlObjJSX = service.getServer().getJSXByName("txtBrandUrl");
		this.logoObjJSX = service.getServer().getJSXByName("txtBrandLogoPath");
		this.descriptionObjJSX = service.getServer().getJSXByName("txtBrandDescription");
		this.orderObjJSX = service.getServer().getJSXByName("txtOrder");
		this.showObjJSX = service.getServer().getJSXByName("radShow");
		this.showNotObjJSX = service.getServer().getJSXByName("radNotShow");
		this.brandId=null;
	};
    edit.prototype.getBrandId = function(){
		return this.brandId;
	};
	edit.prototype.setEditArea = function(id,name,url,description,order,show){
		this.brandId = id;
		this.nameObjJSX.setValue(name);
		this.urlObjJSX.setValue(url);
		this.descriptionObjJSX.setValue(description);
		this.orderObjJSX.setValue(order);
		this.setShow(show);
	};
	edit.prototype.setShow = function(show){
		if(show=="true")
			this.showObjJSX.setSelected(1).repaint();
		else 
			this.showNotObjJSX.setSelected(1).repaint();
	};
	edit.prototype.rSetEditArea = function(){
		this.nameObjJSX.setValue("");
		this.urlObjJSX.setValue("");
		this.logoObjJSX.setValue("");
		this.descriptionObjJSX.setValue("");
		this.orderObjJSX.setValue("");
		this.showObjJSX.setSelected(1).repaint();
	};
	edit.prototype.getShow = function(){
		if(this.showObjJSX.getSelected()=="1")
			return true;
		return false;
	};
	edit.prototype.onOkButtonClick = function(){
		if(this.getBrandId()==null){
			com.tibco.ishop.Brand.updateBransList(null,"insert");
		}
		else {
			alert("else");
			com.tibco.ishop.Brand.updateBransList(this.getBrandId(),"update");
			//this.getBrandId()=null;
		}
	};

	

	
});