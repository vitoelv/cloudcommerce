<#include "header.ftl">

    <div id="container2">
            
      <div class="title-div" align="left"><img src="images/cart_goods.gif" alt="goods" width="158" height="39" /></div>
      <form id="formCart" name="formCart" method="post" action="flow.php">
        <table width="100%" border="0" cellpadding="4" cellspacing="1">
          <tr>
            <th ><front size="12px">商品名称</front></th>
            <th><front size="12px">商品属性</front></th>
            <th><front size="12px">市场价</front></th>
            <th><front size="12px">本店价</front></th>
            <th><front size="12px">购买数量</front></th>
            <th><front size="12px">小计</front></th>
            <th><front size="12px">操作</front></th>
          </tr>
          <#assign total=0>
          <#assign marketTotal=0>
          <#list carts as cart>
	          <tr>
	            <td align="center"><a href="dispatch.do?page=goods&id=${cart.goods.id}" target="_blank">${cart.goodsName}</a></td>
	            <td></td>
	            <td align="center">￥${cart.marketPrice}元</td>
	            <td align="center">￥${cart.goodsPrice}元</td>
	            <td align="center"><input type="text" name="goods_number[3]" id="goods_number_3" value="${cart.goodsNumber}" size="4" style="text-align:right " /></td>
	            <td align="center">￥${cart.goodsPrice * cart.goodsNumber}元</td>
	            <td align="center">
	              <a href="javascript:if (confirm('您确实要把该商品移出购物车吗？')) location.href='dispatch.do?page=cart&id=${cart.id}&action=delete'; ">删除</a>
	            </td>
	          </tr>
	          
	          <#assign total=total +  cart.goodsPrice * cart.goodsNumber>
	          <#assign marketTotal=marketTotal +  cart.marketPrice * cart.goodsNumber>
	       </#list> 
        </table>
        <table width="100%" border="0" style="border-top:1px dotted #DADADA;">

          <tr>
            <td>购物金额小计 ￥${total}元，比市场价 ￥${marketTotal}元 节省了 ￥${marketTotal - total}元            </td>
            <td align="right"><span style="border-top:1px dotted #DADADA;">
              <input type="button" value="清空购物车" onclick="location.href='dispatch.do?page=cart&action=clear'" />
              <input name="submit" type="button" value="更新购物车"onclick="location.href='dispatch.do?page=cart'" />
            </span></td>
          </tr>

        </table>
        <input type="hidden" name="step" value="update_cart" />
      </form>
      <br />
      <table width="100%" border="0">
        <tr>
          <td><a href="dispatch.do?page=home"><img src="images/continue.gif" alt="continue" width="130" height="30" border="0" /></a></td>
          <td align="right"><a href="dispatch.do?page=cart_login"><img src="images/checkout.gif" alt="checkout" width="130" height="30" border="0" /></a></td>
        </tr>
      </table>
                
</div>

<#include "footer.ftl">