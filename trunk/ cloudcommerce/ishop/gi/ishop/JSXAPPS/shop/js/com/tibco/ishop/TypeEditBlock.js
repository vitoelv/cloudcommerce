jsx3.require("com.tibco.ishop.Type");
jsx3.lang.Class.defineClass(
"com.tibco.ishop.TypeEditBlock",
jsx3.gui.Block,
null,
function(edit){
	edit.prototype.init = function(){
		this.nameObjJSX = service.getServer().getJSXByName("txtGoodsTypeName");
		this.groupObjJSX = service.getServer().getJSXByName("txtAttributeGroups");	
		this.typeId=null
	};
	edit.prototype.setEditArea = function(id,name,attributeGroup){
		this.typeId = id;
		this.nameObjJSX.setValue(name);
		this.groupObjJSX.setValue(service.formatCommaToNewline(attributeGroup));		
	};
	edit.prototype.rSetEditArea = function(id,name,attributeGroup){
		this.typeId = id;
		this.nameObjJSX.setValue("");
		this.groupObjJSX.setValue("");
	};
	edit.prototype.getTypeId = function(){
		return this.typeId;
	};
	edit.prototype.getAttributeGroup = function(){
		var attributeGroup = this.groupObjJSX.getValue();
		return service.formatNewLineToComma(attributeGroup);
	};
	edit.prototype.onOkButtonClick = function(){
		if(this.getTypeId() ==null){
			com.tibco.ishop.Type.updateTypeList(null,"insert");
		}
		else {
			com.tibco.ishop.Type.updateTypeList(this.getTypeId(),"update");
		}
	};
});