jsx3.require("com.tibco.ishop.Attribute");
jsx3.lang.Class.defineClass(
"com.tibco.ishop.AttributeEditBlock",
jsx3.gui.Block,
null,
function(edit){
	
	edit.prototype.init = function(){
		this.nameObjJSX = service.getServer().getJSXByName("txtAttributeName");
		this.goodsTypeObjJSX = service.getServer().getJSXByName("selGoodsType");
		this.groupObjJSX = service.getServer().getJSXByName("selAttributeGroup");
		this.searchNoObjJSX = service.getServer().getJSXByName("radNoSearch");
		this.searchKeyObjJSX = service.getServer().getJSXByName("radKeySearch");
		this.searchRangeObjJSX = service.getServer().getJSXByName("radRangeSearch");
		this.linkObjJSX = service.getServer().getJSXByName("radLinked");
		this.linkNoObjJSX = service.getServer().getJSXByName("radNotLinked");
		this.selectObjJSX = service.getServer().getJSXByName("radCanSelected");
		this.selectNoObjJSX = service.getServer().getJSXByName("radNotSelected");
		this.handInputObjJSX  = service.getServer().getJSXByName("radHand");
		this.chooseInputObjJSX  = service.getServer().getJSXByName("radChooseList");
		this.textInputObjJSX  = service.getServer().getJSXByName("radTextbox");
		this.valueObjJSX  = service.getServer().getJSXByName("txtAttributeListVlue");
		this.attributeId;
	};
	edit.prototype.getAttributeId = function(){
		return this.attributeId;
	};
	edit.prototype.getGoodsType = function(){
		alert(this.goodsTypeObjJSX.getValue());
		return this.goodsTypeObjJSX.getValue();
	};
	edit.prototype.getGroup = function(){
		alert(this.groupObjJSX.getValue());
		return this.groupObjJSX.getValue();
	};
	edit.prototype.getIndex= function(){
		if(this.searchNoObjJSX.getSelected()=="1")
			return 0;
		else if(this.searchKeyObjJSX.getSelected()=="1")
			return 1;
		return 2;
	};
	edit.prototype.getLink = function(){
		if(this.linkObjJSX.getSelected()=="1")
			return 1;
		return 0;
	};
	edit.prototype.getType = function(){
		if(this.selectObjJSX.getSelected()=="1")
			return 1;
		return 0;
	};
	edit.prototype.getInputType = function(){
		if(this.handInputObjJSX.getSelected()=="1")
			return 0;
		else if(this.chooseInputObjJSX.getSelected()=="1")
			return 1;
		return 2;
	};
	edit.prototype.getValueList = function(){
		var valueList = this.groupObjJSX.getValue();
		return service.formatNewLineToComma(valueList);
	};
	edit.prototype.generatetypeSel = function(){

	
	};
	edit.prototype.onOkButtonClick = function(){
		if(this.getAttributeId()==null){
			alert("add");
			com.tibco.ishop.Attribute.updateAttributeList(null,"insert");
		}
		else {
			alert("update");
			com.tibco.ishop.Attribute.updateAttributeList(this.getAttributeId(),"update");		
		}
	};
	edit.prototype.setEditArea = function(id,name,goodsType,type,index,linked,group,inputType,valueList){
		this.attributeId = id;
		this.nameObjJSX.setValue(name);
		this.goodsTypeObjJSX.setValue(goodsType);
		this.setAttributeGroup(goodsType,group);
		this.setSearchType(index);
		this.setLinked(linked);
		this.setSelectetype(type);
		this.setInputType(inputType);
	};
	edit.prototype.setAttributeGroup  =function(goodsTypeId,group){
		com.tibco.ishop.SelectData.generateAttributeGroup(this.goodsTypeObjJSX,goodsTypeId);
		this.groupObjJSX.setValue(group);
	};
	edit.prototype.setSearchType = function(index){
		if(index=="0"){
			this.searchNoObjJSX.setSelected(1).repaint();
		}
		else if (index=="1")
		{
			this.searchKeyObjJSX.setSelected(1).repaint();
		}
		else {
			this.searchRangeObjJSX.setSelected(1).repaint();
		}
	};
	edit.prototype.setLinked = function(linked){
		if (linked=="true")
		{
			this.linkObjJSX.setSelected(1).repaint();
		}
		else{
			this.linkNoObjJSX.setSelected(1).repaint();
		}
	};
	edit.prototype.setSelectetype = function(type){
		if (type=="1")
		{
			this.selectObjJSX.setSelected(1).repaint();
		}
		else{
			this.selectNoObjJSX.setSelected(1).repaint();
		}		
	};
	edit.prototype.setInputType = function(inputtype){
		if (inputtype=="0")
		{
			this.handInputObjJSX.setSelected(1).repaint();
		}
		else if(inputtype=="1")
		{
			this.chooseInputObjJSX.setSelected(1).repaint();
		}
		else{
			this.textInputObjJSX.setSelected(1).repaint();
		}
	};
	edit.prototype.setValueList = function(valueList){
		this.valueObjJSX.setValue(valueList);
	};
	





});