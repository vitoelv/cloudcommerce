<#include "header.ftl">

<table border="0" width="100%" id="table6">
	<tr>
		<td width="170" valign="top">
<#include "login.ftl">
<#include "categorylist.ftl">
<#include "top10.ftl">

		<div class="title-div">
			<img src="images/order_query.gif" alt="" width="158" height="39"></div>
		<div class="content-div" style="text-align: center;">
			<form name="ecsOrderQuery">
				<input name="order_sn" type="text"><br>
				<input value="查询该订单号" onclick="orderQuery()" type="button">
			</form>
		</div>
		<p>　</td>
		<td width="771">
		<div class="title-div">
			<img src="images/best_products.gif" alt="best products" width="158" height="39"></div>
		<div class="content-div">
			<#list bestSold as goods>
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
				</#if>
			</#list>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=best">
				more...</a></div>
		</div>
		<div class="title-div">
			<img src="images/new_products.gif" alt="New products" width="158" height="39"></div>
		<div class="content-div">
			<#list newGoods as goods>
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
				</#if>
			</#list>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=new">
				more...</a></div>
		</div>
		<div class="title-div">
			<img src="images/hot_products.gif" alt="Hot products" width="158" height="39"></div>
		<div class="content-div">
			<#list hotSold as goods>
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
				</#if>
			</#list>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=hot">
				more..</a></div>
		</div>
		<p>　</td>
		<td valign="top">
		
<#include "brandinfo.ftl">

		<div class="title-div">
			<img src="images/sales.gif" alt="promotion products" width="158" height="39"></div>
		<div class="content-div">
			<table class="goods-table" style="float: left;" border="0" cellpadding="3" cellspacing="1" id="table16">
				<tr>
					<td align="center">
					<a href="goods.php?id=18">
					<img src="images/no_picture.gif" alt="NOKIA K450" class="thumb" border="0"></a></td>
				</tr>
				<tr>
					<td>
					<a title="NOKIA K450" href="goods.php?id=18">
					NOKIA K450</a><br>
					促销价格：<span class="goods-price">￥1099.00元</span></td>
				</tr>
			</table>
			<br>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=promotion">
				more...</a></div>
		</div>
		
<#include "cartinfo.ftl">
		
		<div class="title-div">
			<img src="images/subscription.gif" alt="subscription" width="158" height="39"></div>
		<div class="content-div" style="text-align: center;">
			<input id="user_email" type="text" name="T1" size="20">
			<br /><input type="button"  value="订阅" onclick="" /> <input type="button"  value="退订" onclick="" />
			</div>
		<p>　</td>
	</tr>
</table>

<#include "footer.ftl">