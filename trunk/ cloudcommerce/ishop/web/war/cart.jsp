<%@ page pageEncoding="UTF-8"%>

<%@ include file="/taglibs.jsp"%>

<%@ include file="/header.jsp"%>

    <div id="container2">
            
      <div class="title-div"><img src="themes/default/images/cart_goods.gif" alt="goods" width="158" height="39" /></div>
      <form id="formCart" name="formCart" method="post" action="flow.php">
        <table width="100%" border="0" cellpadding="4" cellspacing="1">
          <tr>
            <th>商品名称</th>
            <th>商品属性</th>
            <th>市场价</th>
            <th>本店价</th>
            <th>购买数量</th>
            <th>小计</th>
            <th>操作</th>
          </tr>
          <c:set var="total" value="0"/>
          <c:set var="marketTotal" value="0"/>
          <c:forEach var="cart" items="${carts}">
	          <tr>
	            <td><a href="dispatch.do?page=goods&id=${cart.goods.id}" target="_blank">${cart.goodsName}</a></td>
	            <td></td>
	            <td align="right">￥${cart.marketPrice}元</td>
	            <td align="right">￥${cart.goodsPrice}元</td>
	            <td align="right"><input type="text" name="goods_number[3]" id="goods_number_3" value="${cart.goodsNumber}" size="4" style="text-align:right " /></td>
	            <td align="right">￥${cart.goodsPrice * cart.goodsNumber}元</td>
	            <td align="center">
	              <a href="javascript:if (confirm('您确实要把该商品移出购物车吗？')) location.href='dispatch.do?page=cart&id=${cart.goods.id}&action=delete'; ">删除</a>
	            </td>
	          </tr>
	          
	          <c:set var="total" value="${total +  cart.goodsPrice * cart.goodsNumber}"/>
	          <c:set var="marketTotal" value="${marketTotal +  cart.marketPrice * cart.goodsNumber}"/>
	       </c:forEach> 
        </table>
        <table width="100%" border="0" style="border-top:1px dotted #DADADA;">

          <tr>
            <td>购物金额小计 ￥<c:out value="${total}"/>元，比市场价 ￥<c:out value="${marketTotal}"/>元 节省了 ￥<c:out value="${marketTotal - total}"/>元            </td>
            <td align="right"><span style="border-top:1px dotted #DADADA;">
              <input type="button" value="清空购物车" onclick="location.href='dispatch.do?page=cart&action=clear'" />
              <input name="submit" type="submit" value="更新购物车" />
            </span></td>
          </tr>

        </table>
        <input type="hidden" name="step" value="update_cart" />
      </form>
      <br />
      <table width="100%" border="0">
        <tr>
          <td><a href="./"><img src="images/continue.gif" alt="continue" width="130" height="30" border="0" /></a></td>
          <td align="right"><a href="flow.php?step=checkout"><img src="images/checkout.gif" alt="checkout" width="130" height="30" border="0" /></a></td>
        </tr>

      </table>
                
</div>

<%@ include file="/footer.jsp"%>                            