<#if createComment??>
  <#if createComment=="success">
     <script>alert('您的评论已成功发表, 请等待管理员的审核!');</script>
  <#else>
     <script>alert('您的评论信息不完整，请重新填写!');</script>
  </#if>
</#if>  
                
<#include "header.ftl">

    <div id="container">
      <div id="page-left" align="left"> 

<#include "login.ftl">
<#include "categorylist.ftl">
<#include "cartinfo.ftl">      	
<div class="content-div">
  <ul class="history-list">
    <li><!-- 历史浏览--></li>  </ul>
</div> </div>
      
      <div style="padding: 0px 1px; float: left; width: 628px;">
        <div style="border-top: 1px solid rgb(218, 218, 218); background: rgb(239, 239, 239) none repeat scroll 0% 0%; height: 5px; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial; font-size: 1px;"></div>
        <table style="background: rgb(255, 255, 255) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" border="0" width="100%">
          <tbody><tr>
            <td valign="top" width="165">              
              <div style="margin-left: 0px; position: relative; float: left;">
              <a href="javascript:;" onclick="window.open('gallery.php?id=15'); return false;">
				<#if goods.thumb??>	
				    <img src="${goods.thumb}" alt="${goods.name}" class="thumb" border="0">
				<#else>
				    <img src="images/no_picture.gif" alt="${goods.name}" class="thumb" border="0">
				</#if>
              </a>
               <div style="position: absolute; right: 0px; bottom: 1px;">
                <span class="waterMark"><img src="images/watermark_best.png" alt=""></span>
               </div>
              </div>
              </td>
            <td align="center" valign="top"><form action="dispatch.do?page=cart&id=${goods.id}" method="post" name="ECS_FORMBUY" id="ECS_FORMBUY"><table style="text-align: left;" border="0">
                <tbody><tr>
                  <td colspan="2"><span style="font-size: 14px; font-weight: bold; color: rgb(35, 89, 177);">${goods.name}</span></td>
                </tr>
                                
                <tr>
                  <td>商品货号：</td>
                  <td>${goods.SN}</td>
                </tr>
                                                
                <tr>
                  <td>商品品牌：</td>
                  <td><a href="dispatch.do?page=brand&id=${goods.brand.id}">${goods.brand.name}</a></td>
                </tr>
                
                <tr>
                  <td>商品重量：</td>
                  <td>${goods.weight}克</td>
                </tr>
                
                <tr>
                  <td>商品库存：</td>
                  <td>${goods.number}个</td>
                </tr>
                
                <tr>
                  <td>上架时间：</td>
                  <td>${goods.addTime}</td>
                </tr>
                
                <tr>
                  <td>商品点击数:</td>
                  <td>${goods.clickCount}</td>
                </tr>
                
				<tr>
                  <td>市场价格：</td>
                  <td><span class="market-price">￥${goods.marketPrice}元</span></td>
                </tr>
                
                <tr>
                  <td>本店售价：</td>
                  <td><span class="goods-price" id="ECS_SHOPPRICE">￥${goods.shopPrice}元</span></td>
                </tr>
                
                <tr>
                  <td>用户评价：</td>
                  <td><span class="goods-price"><img src="images/stars5.gif" alt="comment rank 5" width="64" height="12"></span></td>
                </tr>
                
                <tr>
                  <td>购买此商品可使用：</td>
                  <td>${goods.integral} 积分</td>
                </tr>
                                
                <tr>
                  <td>购买数量:</td>
                  <td><input name="number" id="number" value="1" size="4" onblur="changePrice()" type="text"></td>
                </tr>
                <tr>
                  <td>商品总价:</td>                  
                  <td><span id="ECS_GOODS_AMOUNT" class="goods-price">￥${goods.shopPrice}元</span></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td align="right">
                    <a href="javascript:collect(15)"><img src="images/collect.gif" alt="collect" width="87" height="20"></a> 
                    <a href="javascript:location.href('dispatch.do?page=cart&id=${goods.id}&number='+document.all.number.value);"><img src="images/add_cart.gif" alt="Add to cart" width="87" height="20"/></a>   
                  
                  </td>
                </tr>
              </tbody></table>
            </form></td>
          </tr>
        </tbody></table>
      </div>
      <div id="page-middle">
        <div class="title-div" align="left"><img src="images/properties.gif" alt="goods properties" width="158" height="39"></div>
        <div>
            <table align="center" border="0" width="98%">
                          </table>
        </div>
                
<div class="title-div" align="left"><img src="images/comments.gif" alt="comments" width="158" height="39"></div>
<div id="ECS_COMMENT" class="content"> <table cellpadding="0" cellspacing="0" width="100%">
 <#if commentList??>
 <#list commentList as comment>
 <tr>
    <td colspan="2" style="background: #F0F0F0;padding:5px;">${comment.content}</td>
  </tr>
  <tr>
    <td colspan="2" align="right" style="font-size:0px;"><img src="images/comment_bottom.gif" width="200" height="9" alt="comment" /></td>
  </tr>
  <tr>
    <td><img src="images/stars${comment.commentRank}.gif" width="64" height="12" alt="" /></td>
    <td align="right">${comment.userName}&nbsp;&nbsp;&nbsp;&nbsp;${comment.addTime}</td>
  </tr>
  	<#if replyList??>
	  <#list replyList as reply>	      
			  <#if reply.parent.id==comment.id>
			  <tr>
				<td colspan="2" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
						  <td colspan="2" style="background:#F0F0F0;padding:5px;">${reply.content}</td>
						</tr>
						<tr>
						  <td colspan="2" align="right" style="font-size:0px;"><img src="images/comment_bottom.gif" width="200" height="9" alt="comment" /> </td>
						</tr>
						<tr>
						  <td colspan="2" align="right">${reply.addTime}&nbsp;&nbsp;管理员回复</td>
						</tr>
					</table>
				  </td>
			  </tr>
			  <#else>			    
			  </#if>
		  </#list>
	  </#if>
  </#list>
  <#else>
  <tbody><tr>
    <td colspan="2" align="center">暂时还没有任何用户评论</td>
  </tr>
  </tbody>
  </#if>  
  </table>
  <script type="text/javascript">
  function   commentSubmit(){ 
              form.submit(); 
              window.location.reload();   
    
  }
  </script>
<form action="" onsubmit="commentSubmit()" method="post" name="commentForm" id="commentForm">
  <table style="border-top: 1px solid rgb(218, 218, 218);" border="0" cellspacing="1" width="100%">
    <tbody><tr>
      <td>用户名</td>
      <td>匿名用户</td>
    </tr>
    <tr>
      <td>电子邮件地址</td>
      <td><input name="email" id="email" size="30" maxlength="100" value="" type="text"></td>
    </tr>
    <tr>
      <td>评价等级</td>
      <td><input name="comment_rank" value="1" type="radio">
        1
        <input name="comment_rank" value="2" type="radio">
        2
        <input name="comment_rank" value="3" type="radio">
        3
        <input name="comment_rank" value="4" type="radio">
        4
        <input name="comment_rank" value="5" checked="checked" type="radio">
        5 </td>
    </tr>
        <tr>
      <td valign="top">评论内容</td>
      <td><textarea name="content" cols="45" rows="5" id="content"></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input name="cmt_type" value="0" type="hidden">
        <input name="id" value="15" type="hidden">
        <input name="Submit" value="提交评论" type="submit">
        <input name="Submit2" value="重置表单" type="reset">
      </td>
    </tr>
  </tbody></table>
</form>
</div>
<div class="title-div" align="left"><img src="images/tags.gif" alt="" width="158" height="39"></div>
<form name="tagForm" onsubmit="return submitTag(this)" style="padding: 5px;">
  <div id="ECS_TAGS">
      </div>
  <div>
    <input name="tag" id="tag" type="text">
    <input value="添加我的标记" type="submit">
    <input name="goods_id" value="15" type="hidden">
  </div>
</form>
  <div id="tag_box">
</div>
 </div>
      
      <div id="page-right"> 
<div class="cell-title">
  <div class="title-div"><img src="images/gallery.gif" alt="" width="158" height="39"></div>
  <div class="content-div">
        <table style="float: left; text-align: center;" bgcolor="#dadada" cellspacing="1" width="140">
      <tbody><tr>
        <td bgcolor="#ffffff"><a href="gallery.php?id=15&amp;img=16" target="_blank"><img src="images/2155.jpg" alt="S900" class="thumb" border="0"></a><br>
          </td>
      </tr>
    </tbody></table>
        <br style="clear: both;">
  </div>
</div>
 </div>
      
      <div class="clear"></div>
    </div>

<#include "footer.ftl">