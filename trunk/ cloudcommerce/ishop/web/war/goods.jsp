<%@ page pageEncoding="UTF-8"%>

<%@ include file="/taglibs.jsp"%>

<%@ include file="/header.jsp"%>

    <div id="container">
      <div id="page-left"> 
      	
<%@ include file="/login.jsp"%>
<%@ include file="/categorylist.jsp"%>
<%@ include file="/cartinfo.jsp"%>

<div class="content-div">
  <ul class="history-list">
    <li><a href="goods.php?id=15" title="S900">S900</a></li><li><a href="goods.php?id=17" title="KG119">KG119</a></li><li><a href="goods.php?id=11" title="迪士尼经典米奇">迪士尼经典米奇</a></li><li><a href="goods.php?id=19" title="AA">AA</a></li>  </ul>
</div> </div>
      
      <div style="padding: 0px 1px; float: left; width: 628px;">
        <div style="border-top: 1px solid rgb(218, 218, 218); background: rgb(239, 239, 239) none repeat scroll 0% 0%; height: 5px; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial; font-size: 1px;"></div>
        <table style="background: rgb(255, 255, 255) none repeat scroll 0% 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;" border="0" width="100%">
          <tbody><tr>
            <td valign="top" width="165">              
              <div style="margin-left: 0px; position: relative; float: left;">
              <a href="javascript:;" onclick="window.open('gallery.php?id=15'); return false;">
				<c:choose>
			      <c:when test="${empty goods.thumb}">	
				    <img src="images/no_picture.gif" alt="${goods.name}" class="thumb" border="0">
				  </c:when>
	              <c:otherwise>
				    <img src="${goods.thumb}" alt="${goods.name}" class="thumb" border="0">
	              </c:otherwise>
				</c:choose>
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
                  <td>${goods.number}种</td>
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
                  <td>2680 积分</td>
                </tr>
                                
                <tr>
                  <td>购买数量:</td>
                  <td><input name="number" id="number" value="1" size="4" onblur="changePrice()" type="text"></td>
                </tr>
                <tr>
                  <td>商品总价:</td>
                  <td><span id="ECS_GOODS_AMOUNT" class="goods-price">￥2680.00元</span></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td align="right">
                    <a href="javascript:collect(15)"><img src="images/collect.gif" alt="collect" width="87" height="20"></a> 
                    <a href="javascript:this.form.submit();"><img src="images/add_cart.gif" alt="Add to cart" width="87" height="20"></a>   
                  </td>
                </tr>
              </tbody></table>
            </form></td>
          </tr>
        </tbody></table>
      </div>
      <div id="page-middle">
        <div class="title-div"><img src="images/properties.gif" alt="goods properties" width="158" height="39"></div>
        <div>
            <table align="center" border="0" width="98%">
                          </table>
        </div>
                
<div class="title-div"><img src="images/comments.gif" alt="comments" width="158" height="39"></div>
<div id="ECS_COMMENT" class="content"> <table cellpadding="0" cellspacing="0" width="100%">
    <tbody><tr>
    <td colspan="2" align="center">暂时还没有任何用户评论</td>
  </tr>
  </tbody></table>
<form action="javascript:;" onsubmit="submitComment(this)" method="post" name="commentForm" id="commentForm">
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
<div class="title-div"><img src="images/tags.gif" alt="" width="158" height="39"></div>
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

<%@ include file="/footer.jsp"%>