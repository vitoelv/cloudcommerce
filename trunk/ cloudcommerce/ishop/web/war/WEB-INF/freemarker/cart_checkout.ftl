<#include "header.ftl">


<div id="container2">
      <form action="dispatch.do?page=cart_success" method="post" name="theForm" id="theForm">
        <div class="title-div" align="left"><span class="modify"><!--
         是否允许修改购物车 --><a href="flow.php"><img src="images/modify.gif" alt="修改" /></a><!--
         --></span><img src="images/cart_goods.gif" alt="goods" width="158" height="39" /></div>
        <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
          <tr>
            <th>商品名称</th>
            <th>商品属性</th>
            <th>市场价</th>
            <th>本店价</th>
            <th>购买数量</th>
            <th>小计</th>
          </tr>
          <#assign total=0>
          <#assign marketTotal=0>
          <#if carts??>
          	<#list carts as cart>
	          	<tr>
	            	<td align="center"><a href="dispatch.do?page=goods&id=${cart.goods.id}" target="_blank">${cart.goodsName}</a></td>
	            	<td></td>
	            	<td align="center">￥${cart.marketPrice}元</td>
	            	<td align="center">￥${cart.goodsPrice}元</td>
	            	<td align="center"><input type="text" name="goods_number[3]" id="goods_number_3" value="${cart.goodsNumber}" size="4" style="text-align:right " /></td>
	            	<td align="center">￥${cart.goodsPrice * cart.goodsNumber}元</td>	            
	          	</tr>	          
	          	<#assign total=total +  cart.goodsPrice * cart.goodsNumber>
	          	<#assign marketTotal=marketTotal +  cart.marketPrice * cart.goodsNumber>
	      	 </#list>
	       <#else>
	             <script language="javascript" type="text/javascript"> 
	                   alert("购物车中没有商品！");
                        location.href='dispatch.do?page=home'; 
                 </script>	
	       </#if>
          </table>          
                  <div align="left">   购物金额小计 ￥${total}元，比市场价 ￥${marketTotal}元 节省了 ￥${marketTotal - total}元 </div>
         <div class="title-div" align="left"><span class="modify"><a href="flow.php?step=consignee"><img src="images/modify.gif" alt="修改" /></a></span><img src="images/consignee.gif" alt="goods" width="158" height="39" /></div>
        <table width="100%" border="0" align="center" cellspacing="3">
          <tr>

            <td>收货人姓名:</td>
            <td>${consignee}</td>
            <td>电子邮件地址:</td>
            <td>${email}</td>
          </tr>
                    <tr>
            <td>详细地址:</td>
            <td>${address}</td>
            <td>邮政编码:</td>
            <td>${zipcode}</td>
          </tr>
                    <tr>
            <td>电话:</td>
            <td>${tel}</td>

            <td>手机:</td>
            <td>${mobile}</td>
          </tr>
                     <tr>
            <td>标志建筑:</td>
            <td>${sign_building}</td>
            <td>最佳送货时间:</td>

            <td>${best_time}</td>
          </tr>
                  </table>
                <div class="title-div" align="left"><img src="images/shipping.gif" alt="shipping" width="158" height="39" /></div>
        <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" id="shippingTable">
          <tr>
            <th width="5%">&nbsp;</th>
            <th width="25%">名称</th>
            <th>描述</th>
            <th width="15%">费用</th>
            <th width="15%">免费额度</th>
            <th width="15%">保价费用</th>
          </tr>
          <#if shipping??>
         	 <#list shipping as ship>
                    <tr>
            			<td valign="top"><input name="shipping" type="radio" value="${ship.id}" <#if ship.supportCod> supportCod="1"<#else>supportCod="1"</#if> insure="${ship.insure}" />
           				</td>
            			<td valign="top"><strong>${ship.name}</strong></td>
            			<td valign="top">${ship.description}</td>
            			<td align="right" valign="top">￥20.00元</td>
            			<td align="right" valign="top">￥0.00元</td>
            			<#if ship.insure!="0">
            			<td align="right" valign="top">${ship.insure}</td>
            			<#else>
            			<td align="right" valign="top">不支持保价</td>
            			</#if>
         			</tr>          
             </#list>             
          </#if>
                    <tr>
            <td colspan="6" align="right"><label for="ECS_NEEDINSURE">
              <input name="need_insure" id="ECS_NEEDINSURE" type="checkbox" value="1"  disabled="true"  />
              配送是否需要保价 </label></td>
          </tr>
        </table>
                <div class="title-div" align="left"><img src="images/payment.gif" alt="payment" width="158" height="39" /></div>
        <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" id="paymentTable">
          <tr>
            <th width="5%">&nbsp;</th>
            <th width="20%">名称</th>
            <th>描述</th>

            <th width="15%">支付费用</th>
          </tr>
           <#if payments??>
           <#list payments as payment>         
          	<tr>
            	<td valign="top"><input type="radio" name="payment" value="${payment.id}"  isCod="payment.cod"/></td>
            	<td valign="top"><strong>${payment.name}</strong></td>
            	<td valign="top">${payment.description}</td>
            	<td align="right" valign="top"><span id="ECS_CODFEE">￥${payment.fee}元</span></td>
          	</tr>
           </#list>
           </#if>
          
                  </table>

                        <div class="title-div" align="left"><img src="images/order_others.gif" alt="" width="158" height="39" /></div>
        <table width="100%" border="0" align="center" cellspacing="3">
                                        <tr>
            <td><strong>使用红包:</strong></td>
            <td>
              选择已有红包              <select name="bonus" id="ECS_BONUS">
                <option value="0" selected>请选择</option>

                              </select>

              或者输入红包序列号              <input name="bonus_sn" type="text" size="15" />
              <input name="validate_bonus" type="button" value="验证红包" />
            </td>
          </tr>
                              <tr>
            <td valign="top"><strong>订单附言:</strong></td>

            <td><textarea name="postscript" cols="80" rows="3" id="postscript"></textarea></td>
          </tr>
                  </table>
        <div class="title-div" align="left"><img src="images/order_total.gif" alt="total" width="158" height="39" /></div>
        <div id="ECS_ORDERTOTAL"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="2">
    <tr>
    <td align="right">

      商品总价: ￥${total}元         </td>
  </tr>
    <tr>
    <td align="right" style="border-top: 1px dotted #DADADA"> 应付款金额: ￥${total}元  </td>
  </tr>
</table></div>
        <div style="border-top: 1px solid #DADADA; padding-top: 20px; text-align:center; margin-top: 5px;">
          <input type="image" src="images/order_submit.gif" alt="submit" width="130" height="30" />
          <input type="hidden" name="step" value="done" />
        </div>
      </form>
                      </div>


<#include "footer.ftl">