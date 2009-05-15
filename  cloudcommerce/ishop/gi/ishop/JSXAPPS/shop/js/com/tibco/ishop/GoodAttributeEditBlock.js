jsx3.Class.defineClass(
"com.tibco.ishop.GoodAttributeEditBlock", 
jsx3.gui.Block,
null,
function(edit){
	var addTotal = 0;
	edit.init = function(){
		//handInputEditPane = service.getServer().getJSXByName("blkHandInputEdit");
		//selectValuesEditPane = service.getServer().getJSXByName("blkSelectValuesEdit"); 
		//textAreaEditPane = service.getServer().getJSXByName("blkTextAreaEdit"); 
		editPane = service.getServer().getJSXByName("blkAttributeEdit"); 
	};
	edit.generalTypeSelect = function(){
		var objService = service.getServer().loadResource("getType_xml");
		objService.count = 0;
		objService.start = 0;
		objService.setOperation("OPERATION");
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, edit.onGetTypeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, edit.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, edit.onOperationInvalid);
	    objService.doCall();
	};
	edit.onGetTypeSuccess = function(){
		var SourceXML = service.getServer().getCache().getDocument("typelist");
		var transformDoc = new jsx3.xml.Document().load(service.getServer().resolveURI("xsl/GoodTypeSelect.xsl"));
		var transformXSL = jsx3.xml.XslDocument.wrap(transformDoc);
		transformXSL.setParam("firstNode","");
		var resultDoc = transformXSL.transformToObject(SourceXML);
		service.getServer().getCache().setDocument("typeselectdata",resultDoc);
		edit.setTypeSelect(resultDoc);
	};
	edit.setTypeSelect = function(doc){
		var first = doc.getFirstChild();
		var value = first.getAttribute("jsxid");
		service.getServer().getJSXByName("selGoodsType").setValue(value).repaint();
		edit.getTypeAttribute("17");
	};
	edit.getTypeAttribute = function(id){
		var objService = service.getServer().loadResource("getAttribute_xml");
		objService.setOperation("OPERATION");
		objService.count = 10;
		objService.start = 0;
		objService.id = id;
		objService.subscribe(jsx3.net.Service.ON_SUCCESS, edit.onGetTypeAttributeSuccess);
        objService.subscribe(jsx3.net.Service.ON_ERROR, edit.onOperationError);
        objService.subscribe(jsx3.net.Service.ON_INVALID, edit.onOperationInvalid);
		objService.doCall();
	};
	edit.setPage = function(){
		editPane.removeChildren();
		var doc = service.getServer().getCache().getDocument("attributelist");
		var i = doc.getChildIterator();
		var childrenOrder=0;
		while(i.hasNext()){
			var record = i.next();
			var inputType = record.getAttribute("inputtype");
			var type = record.getAttribute("type");
			var name = record.getAttribute("name");
			alert("name="+name);
			if(inputType=="0"&&type=="0"){
				alert("1");
				editPane.load("components/goods/handInputEdit.xml");
				editPane.getChild(childrenOrder).setName("blk"+name);
				editPane.getChild(childrenOrder).getDescendantOfName("lblAttributeName").setText(name).repaint();
				
			}
			else if(inputType=="0"&&type=="1"){
				alert("2");
				editPane.load("components/goods/handInputEdit_Plus.xml");
				editPane.getChild(childrenOrder).setName("blk"+name);
				editPane.getChild(childrenOrder).getDescendantOfName("lblAttributeName").setText(name).repaint();
						
			}
			else if(inputType=="1"&&type=="0"){
				alert("3");
				editPane.load("components/goods/selectValuesEdit.xml");
				editPane.getChild(childrenOrder).setName("blk"+name);
				editPane.getChild(childrenOrder).getDescendantOfName("lblAttributeName").setText(name).repaint();
				
			}
			else if(inputType=="1"&&type=="1"){
				alert("4");
				editPane.load("components/goods/selectValuesEdit_Plus.xml");
				editPane.getChild(childrenOrder).setName("blk"+name);
				editPane.getChild(childrenOrder).getDescendantOfName("lblAttributeName").setText(name).repaint();
			}
			else if(inputType=="2"&&type=="0"){
				alert("5");
				editPane.load("components/goods/textAreaEdit.xml");
				editPane.getChild(childrenOrder).setName("blk"+name);
				editPane.getChild(childrenOrder).getDescendantOfName("lblAttributeName").setText(name).repaint();
			}
			else {
				alert("6");
				editPane.load("components/goods/textAreaEdit_plus.xml");
				editPane.getChild(childrenOrder).setName("blk"+name);
				editPane.getChild(childrenOrder).getDescendantOfName("lblAttributeName").setText(name).repaint();
			}
			childrenOrder++;
		}
	};
	edit.onGetTypeAttributeSuccess = function(){
		alert("sucess");
		edit.setPage();
	};
	edit.generalAttributeValueSelect = function(){
		
	};
	edit.onOperationError = function(){};
	edit.onOperationInvalid = function(){};
	edit.onLabelAddClick = function(objClick,loadPage){
		//editPane.load(loadPage);
		//var name = objClick.getNextSibling().getText();
		//objClick.getParent().getParent().getParent().getNextSibling().getDescendantOfName("lblAttributeName").setText(name).repaint();
		alert(objClick.getParent().getParent().getParent());
		objClick.getParent().getParent().getParent().doClone();
		var newDom = editPane.getLastChild();
		//newDom.getDescendantOfName("lblAdd").setDisplay(jsx3.gui.Block.DISPLAYNONE,true);
		newDom.getDescendantOfName("lblAdd").setDisplay(jsx3.gui.Block.DISPLAYNONE);
		//newDom.getDescendantOfName("lblMinus").setDisplay(jsx3.gui.Block.DISPLAYBlock,true);
		newDom.getDescendantOfName("lblMinus").setDisplay(jsx3.gui.Block.DISPLAYBlock);
		var precedeChild = objClick.getParent().getParent().getParent().getNextSibling();
		editPane.insertBefore(newDom,precedeChild,true);
		//objClick.getParent().getParent().getParent().getNextSibling().getDescendantOfName("lblAdd").setDisplay(jsx3.gui.Block.DISPLAYNONE,true);
		//objClick.getParent().getParent().getParent().getNextSibling().getDescendantOfName("lblMinus").setDisplay(jsx3.gui.Block.DISPLAYBlock,true);
		//editPane.repaint();
	};
	edit.onLabelMinusClick = function(objClick){
		alert("minus");
		editPane.removeChild(objClick.getParent().getParent().getParent());
	};
	edit.prototype.getAttributesInput = function(){
		var doc = service.getServer().getCache().getDocument("attributelist");
		var attributeParentNode = this.getDescendantOfName("blkAttributeEdit");
		var attributeNodes = attributeParentNode.getChildren();
		var inputValue;
		var price;
		for(var i=0;i<attributeNodes.length;i++){
			var attributeName = attributeNodes[i].getDescendantOfName("lblAttributeName").getText();
			var attributeRecord = doc.selectSingleNode("//record[@name='"+attributeName+"']");
			var id = attributeRecord.getAttribute("id");
			if(attributeNodes[i].getDescendantOfName("txtPrice")!=null)
				price = attributeNodes[i].getDescendantOfName("txtPrice").getValue();
			if(attributeNodes[i].getDescendantOfName("txtAttributeValue")!=null)
				inputValue = attributeNodes[i].getDescendantOfName("txtAttributeValue").getValue();
			else if(attributeNodes[i].getDescendantOfName("selValue")!=null)
				inputValue = attributeNodes[i].getDescendantOfName("selValue").getText();
		}
	};

});