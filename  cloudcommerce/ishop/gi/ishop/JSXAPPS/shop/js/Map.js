jsx3.lang.Class.defineClass(
"Map",
jsx3.util.List,
null,
function(map){
	map.prototype.init = function(){
		this.jsxsuper();
		this.add({Type:"Brand",addPage:"components/goods/addNewBrand.xml",listPage:"components/goods/goodsBrandList.xml",targetType:"品牌",addPageText:"继续添加新品牌!",listPageText:"返回品牌列表",menuId:"a5"});
		this.add({Type:"GoodsType",addPage:"components/goods/addNewGoodsType.xml",listPage:"components/goods/goodsType.xml",targetType:"类型",addPageText:"继续添加商品类型!",listPageText:"返回商品类型列表",menuId:"a6"});
		this.add({Type:"Attribute",addPage:"components/goods/addAttribute.xml",listPage:"components/goods/attributeList.xml",targetType:"属性",addPageText:"继续添加属性！",listPageText:"返回属性列表",menuId:"a21"});
		//this.add({Type:"Attribute",addPage:"components/goods/addAttribute.xml",listPage:"components/goods/attributeList.xml",targetType:"属性",addPageText:"继续添加属性!",listPageText:"返回属性列表",menuId:"21"});
		this.add({Type:"Category",addPage:"components/goods/addGoodsCategory.xml",listPage:"components/goods/goodsCategory.xml",targetType:"分类",addPageText:"继续添加商品分类!",listPageText:"返回商品分类列表",menuId:"a3"});
	//	this.add({Type:"Attribute",addPage:"components/goods/addAttribute.xml",listPage:"components/goods/attributeList.xml",targetType:"属性",addPageText:"继续添加属性!",listPageText:"返回属性列表",menuId:"21"});
	};
	map.prototype.getAddPageByType = function(type){
		alert(type);
		for(var i=0;i<this.size();i++){
			var obj = this.get(i);
			if(obj.Type==type)
				return obj.addPage;
		}
	};
	map.prototype.getListPageByType = function(type){
		for(var i=0;i<this.size();i++){
			var obj = this.get(i);
			if(obj.Type==type)
				return obj.listPage;
		}
	};
	map.prototype.getTargetTypeByType = function(type){
		for(var i=0;i<this.size();i++){
			var obj = this.get(i);
			if(obj.Type==type)
				return obj.targetType;
		}
	};
	map.prototype.getAddLinkTextByType = function(type){
		for(var i=0;i<this.size();i++){
			var obj = this.get(i);
			if(obj.Type==type)
				return obj.addPageText;
		}
	};
	map.prototype.getListLinkTextByType = function(type){
		for(var i=0;i<this.size();i++){
			var obj = this.get(i);
			if(obj.Type==type)
				return obj.listPageText;
		}
	};
	map.prototype.getMenuIdByType = function(type){
		for(var i=0;i<this.size();i++){
			var obj = this.get(i);
			if(obj.Type==type)
				return obj.menuId;
		}
	};
});