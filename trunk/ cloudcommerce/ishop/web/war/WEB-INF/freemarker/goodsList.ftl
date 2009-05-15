<style type="text/css">
<!--
#gridmodel{
display:none;
}
#textmodel{
display:none;
}
-->
</style>
<script type="Text/Javascript" src="js/display.js" language="JavaScript"></script>
<div class="title-div"><img src="images/${imageName}.gif" alt="Goods List" width="158" height="39" align="left" />
  <form method="GET" class="sort" name="listform">
    <a href="javascript:;" onClick="javascript:display_mode('list');"><img src="images/display_mode_list.gif" alt=""></a> <a href="javascript:;" onClick="javascript:display_mode('grid');"><img src="images/display_mode_grid.gif" alt=""></a> <a href="javascript:;" onClick="javascript:display_mode('text');"><img src="images/display_mode_text.gif" alt=""></a>&nbsp;&nbsp;
    <select name="sort">
      
      <option value="goods_id" selected>按上架时间排序</option><option value="shop_price">按价格排序</option><option value="last_update">更新时间</option>    
    </select>
    <select name="order">      
      <option value="DESC" selected>倒序</option><option value="ASC">正序</option>    
    </select>
    <input type="image" name="imageField" src="images/btn_go.gif" alt="go" />
    <input type="hidden" name="category" value="0" />
    <input type="hidden" name="display" value="list" id="display" />
    <input type="hidden" name="brand" value="5" />
    <input type="hidden" name="price_min" value="" />
    <input type="hidden" name="price_max" value="" />

    <input type="hidden" name="filter_attr" value="" />
    <input type="hidden" name="page" value="1" />
  </form>
</div>

<div id="listmodel" class="content-div">
  <#if goodsInCondition??>
  <#list goodsInCondition as goodsIn>
    <table border="0" cellpadding="5" cellspacing="1" class="goods-list">
      <tr>
        <td width="35%" align="center">
          <a href="dispatch.do?page=goods&id=${goodsIn.id}" style="position:relative;display:block;">     
                  <#if goodsIn.thumb??>	
							    <img src="${goodsIn.thumb}" alt="${goodsIn.name}"  border="0">							    
							<#else>				            
							    <img src="images/no_picture.gif" alt="${goodsIn.name}" border="0">
				      </#if>
            <span style="position:absolute;right:10px;top:-3px;">
                                                                                                              </span>
          </a>
        </td>
        <td><a href="dispatch.do?page=goods&id=${goodsIn.id}"><strong>
                    ${goodsIn.name}                    </strong></a> 
                    <br />
                    市场价格：<span class="market-price">￥${goodsIn.marketPrice}元</span>
                    本店售价：<span class="goods-price">￥${goodsIn.shopPrice}元</span>
                    <div class="addto_cart"> <span style="float:right"> 
                    <a href="javascript:collect(11);">
                    <img src="images/collect.gif" alt="加入收藏夹" width="87" height="20" /></a> 
                    <a href="dispatch.do?page=cart&id=${goodsIn.id}">
                    <img src="images/add_cart.gif" alt="加入购物车" width="87" height="20" /></a>
                    </span> <img src="images/arrow_compare.gif" alt="比较" /> 
                    <a href="javascript:;" id="compareLink" onClick="Compare.add(11,'${goodsIn.name}','')">比较</a> 
                    </div>
                    </td>
      </tr>
    </table>
    </#list>
    </#if>
 </div>
 
 
 <div id="gridmodel" class="content-div" >
          <#if goodsInCondition??>
          <table border="0" cellpadding="5" cellspacing="1" class="goods-list">
      <tr>
          <#list goodsInCondition as goodsIn>
          <#if (goodsIn_index%2)==0>
          	<td width="50%" align="center">
            <div style=" margin-left:30px; position:relative;float:left;">
             <a href="dispatch.do?page=goods&id=${goodsIn.id}"> 
             <#if goodsIn.thumb??>	
				<img src="${goodsIn.thumb}" alt="${goodsIn.name}"  border="0">							    
			 <#else>				            
				<img src="images/no_picture.gif" alt="${goodsIn.name}" border="0">
		     </#if>
		    </a>
             <div style="position:absolute;right:0px; bottom:1px;">
              <img src="images/watermark_best_small.png" alt="" />
             </div>
            </div>
            <a href="dispatch.do?page=goods&id=${goodsIn.id}"><strong>${goodsIn.name}</strong></a> 
            <div style="text-align:middle">
            <span class="market-price">￥${goodsIn.marketPrice}元</span>
            <br />
            <span class="goods-price">￥${goodsIn.shopPrice}元</span>
            </div>
            <a href="javascript:;" onClick="Compare.add(15,'S900')">比较</a> <br />
            <div class="addto_cart"> <a href="javascript:collect(15);">
            <img src="images/collect.gif" alt="加入收藏夹" width="87" height="20" /></a>
            <a href="dispatch.do?page=cart&id=${goodsIn.id}">
            <img src="images/add_cart.gif" alt="加入购物车" width="87" height="20" /></a>
            </div>
            </td>
          <#else>
            <td width="50%" align="center">
            <div style=" margin-left:30px; position:relative;float:left;">
            <a href="dispach.do?page=goods&id=${goodsIn.id}">
            <#if goodsIn.thumb??>	
				<img src="${goodsIn.thumb}" alt="${goodsIn.name}"  border="0">							    
			 <#else>				            
				<img src="images/no_picture.gif" alt="${goodsIn.name}" border="0">
		     </#if>
		     </a>
            <div style="position:absolute;right:0px; bottom:1px;">
            <img src="images/watermark_best_small.png" alt="" />
            </div>
            </div>
            <a href="dispatch.do?page=goods&id=${goodsIn.id}"><strong>${goodsIn.name}</strong></a> 
            <div style="text-align:middle">
            <span class="market-price">￥${goodsIn.marketPrice}元</span>
            <br />
            <span class="goods-price">￥${goodsIn.shopPrice}元</span>
            </div>
            <a href="javascript:;" onClick="Compare.add(14,'3250')">比较</a> <br />
            <div class="addto_cart"> <a href="javascript:collect(14);">
            <img src="images/collect.gif" alt="加入收藏夹" width="87" height="20" /></a> 
            <a href="dispatch.do?page=cart&id=${goodsIn.id}">
            <img src="images/add_cart.gif" alt="加入购物车" width="87" height="20" /></a> 
            </div>
            </td>
            </tr>
            <tr>
          </#if>
          </#list>
      </tr>
          </table>
          </#if>
 </div>


<div id="textmodel" class="content-div">
     <#if goodsInCondition??>
     <#list goodsInCondition as goodsIn>
     <table border="0" cellpadding="5" cellspacing="1" class="goods-list">
      <tr>
        <td><a href="dispatch.do?page=goods&id=${goodsIn.id}"><strong>${goodsIn.name}</strong></a>
                    <br />
                    市场价格：<span class="market-price">￥${goodsIn.marketPrice}元</span>
                    本店售价：<span class="goods-price">￥${goodsIn.shopPrice}元</span>
          <div class="addto_cart" align="right">
          <a href="javascript:;" onClick="addToCookie(10,'P990c')">比较</a>  
          <a href="javascript:collect(10);">
          <img src="images/collect.gif" alt="加入收藏夹" width="87" height="20" /></a> 
          <a href="dispatch.do?page=cart&id=${goodsIn.id}">
          <img src="images/add_cart.gif" alt="加入购物车" width="87" height="20" /></a> 
          </div>
          </td>
      </tr>
     </table>
     </#list>
     </#if>
</div>



<form name="selectPageForm" action="/ecshop/upload/brand.php" method="get">
  <div id="pager"> 总计 1 个记录，共 1 页。 <span> <a href="brand.php?id=5&amp;page=1&amp;sort=goods_id&amp;order=DESC">第一页</a> <a href="brand.php?id=5&amp;page=1&amp;sort=goods_id&amp;order=DESC">上一页</a> <a href="brand.php?id=5&amp;page=1&amp;sort=goods_id&amp;order=DESC">下一页</a> <a href="brand.php?id=5&amp;page=1&amp;sort=goods_id&amp;order=DESC">最末页</a> </span>

        <input type="hidden" name="category" value="0" />
        <input type="hidden" name="keywords" value="" />
        <input type="hidden" name="sort" value="goods_id" />
        <input type="hidden" name="order" value="DESC" />
        <input type="hidden" name="cat" value="0" />
        <input type="hidden" name="brand" value="5" />
        <input type="hidden" name="price_min" value="0" />
        <input type="hidden" name="price_max" value="0" />
        <input type="hidden" name="filter_attr" value="" />

        <input type="hidden" name="display" value="list" />
        <select name="page" id="page" onchange="selectPage(this)">
    <option value="1" selected>1</option>    </select>
  </div>
</form>
<script type="Text/Javascript" language="JavaScript">
<!--
function selectPage(sel)
{
  sel.form.submit();
}
//-->
</script>
</div>