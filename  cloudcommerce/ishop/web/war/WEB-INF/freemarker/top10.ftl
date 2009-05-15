	<div class="title-div">
		<img src="images/top10.gif" alt="Top 10" width="158" height="39" />
	</div>
	<div class="content-div">
    	<ul class="top-list">
        	<#if topList??>
        	<#assign index=1>
        	<#list topList as top>
        	
        	<li><img src="images/top_${index}.gif" width="12" height="11" alt="top" />
        	<a href="dispatch.do?page=goods&id=${top.goods.id}" title="">${top.goodsName}</a>
        	</li>
        	<#assign index=index+1>
        	</#list>
        	</#if>
      	</ul>
	</div>
		