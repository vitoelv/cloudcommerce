<#include "header.ftl">

<table border="0" width="100%" id="table6">
	<tr>
		<td width="170" valign="top">
<#include "cartinfo.ftl">	
<#include "top10.ftl">		
		<p>　</td>
		<td width="630">
		<div id="page-right" style="float:left;width:628px;padding:0px 1px;">
		
	<div class="title-div"><img src="images/search_advanced.gif" alt="search" width="158" height="39" /></div>
        <div class="content-div">
          <form action="dispatch.do?page=advanced_search" method="get" name="advancedSearchForm" id="advancedSearchForm">
            <table border="0" align="center" cellpadding="3">
              <tr>
                <td valign="top">关键字:</td>
                <td>

                  <input name="keywords" id="keywords" type="text" size="40" maxlength="120" value="" />
                  <label for="sc_ds"><input type="checkbox" name="sc_ds" value="1" id="sc_ds"  />搜索简介</label>
                  <br />匹配多个关键字全部，可用 "+" 或 "AND" 连接。如 win32 AND unix<br />匹配多个关键字其中部分，可用空格或 "OR" 连接。如 win32 OR unix                </td>
              </tr>
              <tr>
                <td>分类:</td>
                <td>
                <select name="category" id="category" style="vertical-align:middle;">
     			 <option value="0">所有分类</option>
	  			 <#list categories as cat>
	  			 <option value="${cat.id}" >${cat.name}</option>
	  			 <#list cat.children as chd>
	  			 <option value="${chd.id}" >&nbsp;&nbsp;${chd.name}</option>
	  			 </#list>
	  			 </#list>
  				</select>
                </td>
              </tr>
              <tr>
                <td>品牌:</td>
                <td><select name="brand" id="brand">

                    <option value="0">所有品牌</option>
                    <#list brands as brand>
                    <option value="${brand.id}">${brand.name}</option>
                    </#list>
                    </select>
                </td>
              </tr>

              <tr>
                <td>价格:</td>
                <td><input name="min_price" type="text" id="min_price" value="" size="10" maxlength="8" />
                  -
                  <input name="max_price" type="text" id="max_price" value="" size="10" maxlength="8" />
                </td>
              </tr>
                            
                            <tr>
                <td>&nbsp;</td>

                <td><label for="outstock"><input type="checkbox" name="outstock" value="1" id="outstock" /> 隐藏已脱销的商品</label>
                </td>
              </tr>
              
              <tr>
                <td colspan="4" align="center"><input type="hidden" name="action" value="form" />
                  <input type="submit" name="Submit" value="立即搜索" /></td>
              </tr>
            </table>

          </form>
        </div>
		
 <#if searchResult??>
    <div class="title-div"><img src="images/search_result.gif" alt="Goods List" width="158" height="39" align="left" />
    <form method="GET" class="sort" name="listform">
    <a href="javascript:;" onClick="javascript:display_mode('list')"><img src="images/display_mode_list_act.gif" alt=""></a> <a href="javascript:;" onClick="javascript:display_mode('grid')"><img src="images/display_mode_grid.gif" alt=""></a> <a href="javascript:;" onClick="javascript:display_mode('text')"><img src="images/display_mode_text.gif" alt=""></a>&nbsp;&nbsp;
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
<div class="content-div"> 
  <#list searchResult as goodsIn>
    <table border="0" cellpadding="5" cellspacing="1" class="goods-list">
      <tr>
        <td width="35%" align="center">
          <a href="dispach.do?page=goods&id=${goodsIn.id}" style="position:relative;display:block;">     
                  <#if goodsIn.thumb??>	
							    <img src="${goodsIn.thumb}" alt="${goodsIn.name}"  border="0">							    
							<#else>				            
							    <img src="images/no_picture.gif" alt="${goodsIn.name}" border="0">
				      </#if>
            <span style="position:absolute;right:10px;top:-3px;">
                                                                                                              </span>
          </a>
        </td>
        <td><a href="dispach.do?page=goods&id=${goodsIn.id}"><strong>
                    ${goodsIn.name}                    </strong></a> 
                    <br />
                    市场价格：<span class="market-price">￥${goodsIn.marketPrice}元</span>
                    本店售价：<span class="goods-price">￥${goodsIn.shopPrice}元</span>
                    <div class="addto_cart"> <span style="float:right"> <a href="javascript:collect(11);"><img src="images/collect.gif" alt="加入收藏夹" width="87" height="20" /></a> <a href="dispatch.do?page=cart&id=${goodsIn.id}"><img src="images/add_cart.gif" alt="加入购物车" width="87" height="20" /></a></span> <img src="images/arrow_compare.gif" alt="比较" /> <a href="javascript:;" id="compareLink" onClick="Compare.add(11,'${goodsIn.name}','')">比较</a> </div></td>
      </tr>
    </table>
    </#list>
    
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
</#if>
</div>
	<p>	</td>
	</tr>
</table>

<#include "footer.ftl">