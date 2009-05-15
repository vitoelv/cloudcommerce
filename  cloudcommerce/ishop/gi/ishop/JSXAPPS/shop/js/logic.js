
/* place JavaScript code here */
jsx3.lang.Class.defineClass("service", null, null, function (service, sercice_prototype) {
	service.tempID;
	service.changButtonCSS = function (objJSX) {
		objJSX.setDynamicProperty("jsxstyleoverride", "@Btn Temp CSS");
		objJSX.repaint();
		setTimeout(function () {
			objJSX.setDynamicProperty("jsxstyleoverride", "@Btn CSS");
			objJSX.repaint();
		}, 200);
	};
	service.getServer = function () {
		return shop;
	};
	service.changeTabBgImg = function (tabUnseleted, tabSeleted) {
		service.getServer().getJSXByName(tabUnseleted).setDynamicProperty("jsxstyleoverride", "@Tab Unselecte CSS");
		service.getServer().getJSXByName(tabUnseleted).repaint();
		service.getServer().getJSXByName(tabSeleted).setDynamicProperty("jsxstyleoverride", "@Tab Selected CSS");
		service.getServer().getJSXByName(tabSeleted).repaint();
	};
	service.onTabMenuClick = function () {
		service.changeTabBgImg("tabHelp", "tabMenu");
		service.getServer().getJSXByName("blkMenu").setDisplay(jsx3.gui.Block.DISPLAYBLOCK, true);
		service.getServer().getJSXByName("blkHelp").setDisplay(jsx3.gui.Block.DISPLAYNONE, true);
	};
	service.onTabHelpClick = function () {
		service.changeTabBgImg("tabMenu", "tabHelp");
		service.getServer().getJSXByName("blkMenu").setDisplay(jsx3.gui.Block.DISPLAYNONE, true);
		service.getServer().getJSXByName("blkHelp").setDisplay(jsx3.gui.Block.DISPLAYBLOCK, true);
	};
	service.onMouseOver = function (name) {
		var objJSX = service.getServer().getJSXByName(name);
		objJSX.setColor("#ffffff", true);
	};
	service.onMouseOut = function (name) {
		var objJSX = service.getServer().getJSXByName(name);
		objJSX.setColor("#BDE0EA", true);
	};
	service.onNavigationBarLabelClick = function (objJSX, page) {
		var arryLabel = service.getServer().getJSXByName("statusBar").getChildren();
		for (var i = 0; i < arryLabel.length; i++) {
			arryLabel[i].setBackground();
			arryLabel[i].setColor("#BDE0EA");
			arryLabel[i].repaint();
		}
		objJSX.setColor("#F9DB6D");
		objJSX.setBackground("background-image:url(/ecshop/JSXAPPS/shop/image/navigationCaret.gif); background-repeat:no-repeat;background-position: 0px 3px;");
		objJSX.repaint();
		service.loadPage(page, null);
	};
	service.loadPage = function (page) {
		service.getServer().getJSXByName("detailPage").removeChildren();
		service.getServer().getJSXByName("detailPage").load(page);
	};
	service.onMenuClick = function (id) {
		service.getServer().getJSXByName("treeMenu").executeRecord(id);
		if(service.tempID==null){
			service.tempID = id;
		}
		else{
			var firstRecord = service.getServer().getJSXByName("treeMenu").getRecordNode(service.tempID);
			firstRecord.setAttribute("jsximg","images/menuunseleted.gif");
			firstRecord.setAttribute("jsxselected",0);
			service.getServer().getJSXByName("treeMenu").redrawRecord(service.tempID,jsx3.xml.CDF.INSERT);
		 }
		 var record = service.getServer().getJSXByName("treeMenu").getRecordNode(id);
		 record.setAttribute("jsximg","images/menuseleted.gif");
		 record.setAttribute("jsxselected",1);
		 service.getServer().getJSXByName("treeMenu").redrawRecord(id,jsx3.xml.CDF.INSERT);
		 service.tempID = id;
	};
	service.doBrowse = function (HTMLDomId, objTextbox) {
		document.getElementById(HTMLDomId).click();
		var path = document.getElementById(HTMLDomId).value;
		service.getServer().getJSXByName(objTextbox).setValue(path);
	};
	service.onDetailPageDropOn = function (id) {
		service.onMenuClick(id);
	};
	service.getDetaiPage = function () {
		return service.getServer().getJSXByName("detailPage");
	};
	service.spyMatrixRecord = function (matrixName, strRECORDID, objCOLUMN) {
		service.getServer().getJSXByName(matrixName).getXML().selectSingleNode("//record[@jsxid = '" + strRECORDID + "']");
		var path = objCOLUMN.getPath();
		var text = "\u70b9\u51fb\u4fee\u6539\u5185\u5bb9";
		if (path == "checked" || path == "imageon" || path == "imagenew" || path == "imagenice" || path == "imagehot") {
			text = "\u70b9\u51fb\u4fee\u6539\u7c7b\u522b";
		}
		if (path == "goodsname") {
			return "<div style='font-family:arial;width:100px;word-break:break-all;word-wrap:break-word;white-space:-moz-pre-wrap;overflow:hidden;' >" + text + "</div>";
		}
	};
	service.loadNote = function () {
		service.getServer().getJSXByName("detailPage").load("components/note.xml");
	};
	service.formatCommaToNewline = function (inputString) {
		if(inputString==null)
			return "";
		else
		{
			var reg = new RegExp(",", "g");
			var outputString = inputString.replace(reg, "\n");
			return outputString;
		}
		
	};
	service.formatNewLineToComma = function (inputString) {
		var reg = new RegExp("\r\n", "g");
		var outputString = inputString.replace(reg, ",");
	//var length = outputString.length;
	//outputString = outputString.slice(0,length-1);
		return outputString;
	};
	service.splitString = function (string) {
		return string.split(",");
	};
	service.setAddSucessPage = function(){
		
	};
	service.setUpdateSucessPage = function(){};
});

