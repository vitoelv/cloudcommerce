<#include "header.ftl">

<table border="0" width="100%" id="table6">
	<tr>
		<td width="170" valign="top">
<#include "login.ftl">
<#include "categorylist.ftl">
<#include "top10.ftl">		
		<p>　</td>
		<td valign="top">
		
		<div id="page-middle">      
        <#if bestProducts??>
        <div class="title-div"><img src="images/best_products.gif" alt="best products" width="158" height="39" /></div>
<div class="content-div">
    <#list bestProducts as goods>
				<#if goods_index < 3>	
					<table class="goods-table" style="float: left;" border="1" cellpadding="3" cellspacing="1" id="table7" width="189">
						<tr>
							<td align="center">
							<a href="dispatch.do?page=goods&id=${goods.id}">
							<#if goods.thumb??>	
							    <img src="${goods.thumb}" alt="${goods.name}" class="thumb" border="0">							    
							<#else>				            
							    <img src="images/no_picture.gif" alt="${goods.name}" class="thumb" border="0">
				      </#if>
							</a></td>
						</tr>
						<tr>
							<td>
							<a title="${goods.name}" href="dispatch.do?page=goods&id=${goods.id}">${goods.name}</a><br>
							本店售价：<span class="goods-price">￥${goods.shopPrice}元</span>
		          </td>
						</tr>
					</table>
				<#else>
				</#if>
			</#list>
    <br style="clear:both"/>
  <div style="text-align:right"><A href="search.php?intro=best">more...</A></div>
</div>
</#if>
<#include "goodsList.ftl">
<p>　</td>
<td valign="top">
<div id="page-right">
<#include "cartinfo.ftl">		
</div>      
<div class="clear"></div></div>
		<p>　</td>
	</tr>
</table>

<#include "footer.ftl">