jsx3.lang.Class.defineClass(
"com.tibco.ishop.UpdateOperationSucess",
jsx3.gui.Block,
null,
function(page){
	page.prototype.init = function(type){
		this.map = new Map();
		this.Type = type;
		this.targetType = service.getServer().getJSXByName("lbTargetType");
		this.listLink = service.getServer().getJSXByName("lbListLink");
		this.setListLinkText();
		this.setTargetTypeText();
	};
	page.prototype.getMap = function(){
		return this.map;
	};
	page.prototype.setListLinkText = function(){
		var text = this.getMap().getListLinkTextByType(this.Type);
		this.listLink.setText(text).repaint();
	};
	page.prototype.setTargetTypeText = function(){
		var text = this.getMap().getTargetTypeByType(this.Type);
		this.targetType.setText(text).repaint();
	};
	page.prototype.onListLinkClick = function(){
		var targetPage = this.getMap().getListPageByType(this.Type);
		var id = this.getMap().getMenuIdByType(this.Type);
		service.onMenuClick(id);
	};
	
});