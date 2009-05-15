<#include "header.ftl">

    <div id="container2">

      <div class="title-div" align="left">
        <img src="images/blue_arrow.gif" alt="arrow" width="37" height="37" style="vertical-align:middle;" />
        <strong style="vertical-align:middle;">${article.title} </strong>
      </div>
      <div style="padding:5px;">
                    <#if article.content??>
                    <div style="padding:10px 20px;">${article.content}</div>
                    </#if>
                </div>
    </div>

<#include "footer.ftl">