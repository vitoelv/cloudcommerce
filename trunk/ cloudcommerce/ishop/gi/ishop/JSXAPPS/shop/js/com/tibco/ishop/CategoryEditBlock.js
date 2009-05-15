jsx3.Class.defineClass(
"com.tibco.ishop.CategoryEditBlock",
jsx3.gui.Block,
null,
function(edit){
	
    edit.prototype.init = function(){
		this.nameObjJSX = service.getServer().getJSXByName("txtGoodsCategoryName");
		this.parentObjJSX = service.getServer().getJSXByName("selParentName");
		this.unitObjJSX = service.getServer().getJSXByName("txtUnit");
		this.orderObjJSX = service.getServer().getJSXByName("txtOrder");
		this.showObjJSX = service.getServer().getJSXByName("radshow");
		this.showNotObjJSX = service.getServer().getJSXByName("radNot");
		this.navigationShowObjJSX = service.getServer().getJSXByName("radNavigatinShow");
		this.navigationShowNotObjJSX = service.getServer().getJSXByName("radNavigatinNo");
		this.typeObjJSX = service.getServer().getJSXByName("selGoodsType");
		this.attributeObjJSX = service.getServer().getJSXByName("selAttribute");
		this.gradeObjJSX = service.getServer().getJSXByName("txtGrade");
		this.styleObjJSX = service.getServer().getJSXByName("txtStyle");
		this.keyWordObjJSX = service.getServer().getJSXByName("txtKeyWord");
		this.descrptionObjJSX = service.getServer().getJSXByName("txtDescription");

		this.parentObjJSX.setValue("0");
		this.typeObjJSX.setValue("a");
		this.categoryId = null;
	};

	edit.prototype.getCategoryId = function(){
	    return this.categoryId;
	};
	edit.prototype.rSetEditArea = function(){
		this.nameObjJSX.setValue("");
	
	};
	edit.prototype.clearEditArea = function(){
		this.nameObjJSX.setValue("");
		this.unitObjJSX.setValue("");
		this.orderObjJSX.setValue("");
		this.showObjJSX.setSelected(1).repaint();
		this.navigationShowObjJSX.setSelected(1).repaint();
		this.gradeObjJSX.setValue("");
		this.styleObjJSX.setValue("");
		this.keyWordObjJSX.setValue("");
		this.descrptionObjJSX.setValue("");
	};
	edit.prototype.onResetButtonClick =function(){
		if(this.getCategoryId()==null)
			this.clearEditArea();
		else{
		
		}
	};
	edit.prototype.getParentCategory = function(){
		return this.parentObjJSX.getValue();
	};
	edit.prototype.setParentCategory = function(parent){
		this.parentObjJSX.setValue(parent);
	};
	edit.prototype.getShow = function(){
		if(this.showObjJSX.getSelected()=="1")
			return 1;
		return 0;
	};
	edit.prototype.setShow = function(show){
		if(show=="true"){
			this.showObjJSX.setSelected(1).repaint();
		}
			
		else {
			this.showNotObjJSX.setSelected(1).repaint();
		}
	};
	edit.prototype.getNavigationShow = function(){
		if(this.showObjJSX.getSelected()=="1")
			return 1;
		return 0;
	};
	edit.prototype.setNavigationShow = function(navigationShow){
		if(navigationShow=="true"){
			this.navigationShowObjJSX.setSelected(1).repaint();
		}
		else {
			this.navigationShowNotObjJSX.setSelected(1).repaint();
		}
			
	};
    edit.prototype.getFilterAttribute = function(){
		return this.attributeObjJSX.getValue();
	};
	edit.prototype.setFilterAttribute = function(filterAttribute){
		this.attributeObjJSX.setValue(filterAttribute);
	};
	edit.prototype.onOkButtonClick = function(){
		if(this.getCategoryId()==null){
			alert("add");
			//com.tibco.ishop.Category.addCategory("addCategory_xml");
			com.tibco.ishop.Category.updateCategoryList(null,"insert")
		}
		else{
			alert("update");
			//com.tibco.ishop.Category.updateCategory("updateCategoryOnDetail_xml",this.getCategoryId());
			com.tibco.ishop.Category.updateCategoryList(this.getCategoryId(),"update")
		}
		
	};
	edit.prototype.setEditArea = function(id,name,navigationShow,show,parent,keyWords,description,style,order,measureUnit,grade,filterAttribute){
		this.categoryId = id;
		this.nameObjJSX.setValue(name);
		this.setNavigationShow(navigationShow);
		this.setShow(show);
		this.setParentCategory(parent);
		this.keyWordObjJSX.setValue(keyWords);
		this.descrptionObjJSX.setValue(description);
		this.styleObjJSX.setValue(style);
		this.orderObjJSX .setValue(order);
		this.unitObjJSX.setValue(measureUnit);
		this.gradeObjJSX.setValue(grade);
		this.setFilterAttribute(filterAttribute);
	};
	

});