<%@ page pageEncoding="UTF-8"%>

<%@ include file="/taglibs.jsp"%>

<%@ include file="/header.jsp"%>

<table border="0" width="100%" id="table6">
	<tr>
		<td width="170" valign="top">

<%@ include file="/login.jsp"%>
<%@ include file="/categorylist.jsp"%>
<%@ include file="/top10.jsp"%>

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
			<c:forEach var="goods" items="${bestSold}" varStatus="status">
				<c:if test="${status.count < 3}">	
					<table class="goods-table" style="float: left;" border="1" cellpadding="3" cellspacing="1" id="table7" width="189">
						<tr>
							<td align="center">
							<a href="dispatch.do?page=goods&id=${goods.id}">
							<c:choose>
						      <c:when test="${empty goods.thumb}">	
							    <img src="images/no_picture.gif" alt="${goods.name}" class="thumb" border="0">
							  </c:when>
				              <c:otherwise>
							    <img src="${goods.thumb}" alt="${goods.name}" class="thumb" border="0">
				              </c:otherwise>
							</c:choose>
							</a></td>
						</tr>
						<tr>
							<td>
							<a title="${goods.name}" href="dispatch.do?page=goods&id=${goods.id}">${goods.name}</a><br>
							本店售价：<span class="goods-price">￥${goods.shopPrice}元</span>
		          </td>
						</tr>
					</table>
				</c:if>
			</c:forEach>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=best">
				more...</a></div>
		</div>
		<div class="title-div">
			<img src="images/new_products.gif" alt="New products" width="158" height="39"></div>
		<div class="content-div">
			<table class="goods-table" style="float: left;" border="0" cellpadding="3" cellspacing="1" id="table10" width="189">
				<tr>
					<td align="center">
					<a href="http://localhost:6666/ecshop/goods.php?id=17">
					<img src="http://localhost:6666/ecshop/images/200609/22100.jpg" alt="KG119" class="thumb" border="0"></a></td>
				</tr>
				<tr>
					<td>
					<a title="KG119" href="http://localhost:6666/ecshop/goods.php?id=17">
					KG119</a><br>
					本店售价：<span class="goods-price">￥5666.00元</span>
              		</td>
				</tr>
			</table>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=new">
				more...</a></div>
		</div>
		<div class="title-div">
			<img src="images/hot_products.gif" alt="Hot products" width="158" height="39"></div>
		<div class="content-div">
			<table class="goods-table" style="float: left;" border="0" cellpadding="3" cellspacing="1" id="table13" width="189">
				<tr>
					<td align="center">
					<a href="goods.php?id=14">
					<img src="images/200609/41192.jpg" alt="3250" class="thumb" border="0"></a></td>
				</tr>
				<tr>
					<td>
					<a title="3250" href="goods.php?id=14">
					3250</a><br>
					本店售价：<span class="goods-price">￥2880.00元</span>
              		</td>
				</tr>
			</table>
			<br style="clear: both;">
　<div style="text-align: right;">
				<a href="search.php?intro=hot">
				more..</a></div>
		</div>
		<p>　</td>
		<td valign="top">
		<div class="title-div">
			<img src="images/brands.gif" alt="" width="158" height="39"></div>
		<div class="content-div">
			<div style="list-style-type: none; list-style-image: none; list-style-position: outside; margin: 10px; padding: 0pt">
				<div>
					<img src="images/cat_arrow.gif" alt="arrow">
					<a href="brand.php?id=4">索尼爱立信 
					(2)</a></div>
			</div>
		</div>
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
		
<%@ include file="/cartinfo.jsp"%>
		
		<div class="title-div">
			<img src="images/subscription.gif" alt="subscription" width="158" height="39"></div>
		<div class="content-div" style="text-align: center;">
			<input id="user_email" type="text" name="T1" size="20"></div>
		<p>　</td>
	</tr>
</table>

<%@ include file="/footer.jsp"%>