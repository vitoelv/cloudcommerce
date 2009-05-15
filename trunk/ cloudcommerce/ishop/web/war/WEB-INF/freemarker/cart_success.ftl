<#include "header.ftl">

<div id="container2">

      
                        
      <div style="padding: 10px; border-top: 1px solid #DADADA; text-align: center;" >
        <p style="font-size: 14px;">感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <strong style="color:red">${orderSN}</strong>。 </p>
        <table width="80%" border="0" align="center">
          <tr>
            <td align="left">您选定的配送方式为: <strong>${shippingName}</strong>，您选定的支付方式为: <strong>${paymentName}</strong>。您的应付款金额为: <strong>￥${total}元</strong></td>

          </tr>
          <tr>
            <td align="left">${paymentDescription}</td>
          </tr>
          <tr>
            <td align="center"><div style="text-align:center">
            ${paymentURL}</div></td>
          </tr>
                  </table>
                <p>您可以 <a href="dispatch.do?page=home">返回首页</a> 或去 <a href="dispatch.do?page=user">用户中心</a>。</p>

      </div>
                </div>

<#include "footer.ftl">