<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>ISHOP</title>
<link href="styles/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="globalWrapper">
  <div style="float:left;"><img src="images/page_left.gif" alt="" /></div>

  <div id="wrapper">
<div id="append_parent"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="3" id="page-header">
  <tr>
    <td id="cell-logo"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td rowspan="2"><a href="index.php" name="top"><img src="images/logo.gif" alt="shopping mall name" width="130" height="56" border="0" /></a></td>
          <td align="right" valign="top" style="padding: 5px 10px">
	          <a href="dispatch.do?page=cart" >查看购物车</a>
	            | <a href="dispatch.do?page=user" >用户中心</a>
	            | <a href="pick_out.php" >选购中心</a>
	            | <a href="group_buy.php" >团购商品</a>
	            | <a href="snatch.php" >夺宝奇兵</a>
	            | <a href="tag_cloud.php" >标签云</a>
	            | <a href="activity.php" >优惠活动</a>
          </td>
        </tr>
        <tr>
          <td align="center"></td>
        </tr>
      </table></td>
  </tr>

  <tr>
    <td id="cell-nav"><ul>
        <li><a href="dispatch.do?page=home">首页</a></li>
              </ul></td>
  </tr>
</table>
<div id="ECS_CATALOG" class="catalog-div" style="display:none"
onMouseOver="if (this.style.display != 'block') this.style.display='block';"
onMouseOut="if (this.style.display != 'none') this.style.display = 'none';">
  <ul>
                  <li class="top-cate"><a href="category.php?id=1" title="">手机</a></li>

          </ul>
</div>
<div id="search-bar" style="text-align: left;">
      <div id="search-left">
<div style="padding:3px 15px 0px 15px;">当前位置: <a href="dispatch.do?page=home">首页</a></div></div>
      <div id="search-right">
<div style="padding:0px 15px;">
  <form id="searchForm" name="searchForm" method="post" action="dispatch.do?page=search" >
    <img src="images/icon_search.gif" alt="search" />
    <select name="category" id="category" style="vertical-align:middle;">
      <option value="0">所有分类</option>
	  <#list categories as cat>
	   <option value="${cat.id}" >${cat.name}</option>
	   <#list cat.children as chd>
	    <option value="${chd.id}" >&nbsp;&nbsp;${chd.name}</option>
	   </#list>
	  </#list>
    </select>
    <input name="keywords" class="textbox" type="text" id="keyword" value="" />
    <input type="image" name="imageField" src="images/btn_go.gif" />
    <a href="dispatch.do?page=advanced_search" act=advanced_search">高级搜索</a>
  </form>
</div>
<script type="text/javascript">
<!--
function checkSearchForm()
{
    if(document.getElementById('keyword').value)
    {
        return true;
    }
    else
    {
        return false;
    }
}
-->
</script>
</div>
    </div>
