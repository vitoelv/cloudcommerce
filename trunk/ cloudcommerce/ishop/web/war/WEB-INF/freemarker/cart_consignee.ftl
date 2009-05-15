<#include "header.ftl">


<div id="container2">
  <div class="title-div" align="left"><img src="images/consignee.gif" alt="Consignee" width="158" height="39" /></div>
  <form action="dispatch.do?page=cart_checkout" method="post" name="theForm" id="theForm"><table align="center" width="80%" style="margin: 1em auto;">
  <tr>
    <td>配送区域:</td>
    <td colspan="3"><select name="country" id="selCountries_0">
        <option value="0">请选择国家</option>
                <option value="1" selected>中国</option>
              </select>
      <select name="province" id="selProvinces_0" onchange="javascript:location.href('dispatch.do?page=cart_consignee&province='+this.value);">
        <option value="0">请选择省</option>                
                <#list provinces as province>
                <option value="${province.id}" <#if selectedProvince?? && province.id+""=selectedProvince>selected</#if>>${province.name}</option>
                </#list>                
              </select>
			
      <select name="city" id="selCities_0" onchange="go_url(this.value)">
        <option value="0">请选择市</option>
              <#if cities??>
              <#list cities as city>
                <option value="${city.id}" <#if selectedCity?? && city.id+""=selectedCity>selected</#if>>${city.name}</option>
                </#list>
                </#if>
      </select>
      
          <script type="text/javascript">          
          function go_url(city){
	          if(window.location.href.indexOf("city=")==-1){
	          var url=location.href+"&city="+city;
			  window.location=url;
			  }
			  else{
			   var str=window.location.href; 
               var es=/city=/; 
               es.exec(str); 
               var left=RegExp.leftContext;
               var url=left+"city="+city;
               window.location=url;
			  }	
          }
          </script>
          
      <select name="district" id="selDistricts_0" style="display:none">
        <option value="0">请选择区</option>
      </select>
      (必填) </td>
  </tr>
    <tr>
    <td>收货人姓名:</td>
    <td><input name="consignee" type="text" id="consignee_0" value="" />
      (必填) </td>

    <td>电子邮件地址:</td>
    <td><input name="email" type="text" id="email_0" value="" />
      (必填) </td>
  </tr>
    
  <tr>
    <td>详细地址:</td>
    <td><input name="address" type="text" id="address_0" value="" />
      (必填)</td>
    <td>邮政编码:</td>
    <td><input name="zipcode" type="text" id="zipcode_0" value="" /></td>
  </tr>
    <tr>
    <td>电话:</td>
    <td><input name="tel" type="text" id="tel_0" value="" />

      (必填)</td>
    <td>手机:</td>
    <td><input name="mobile" type="text" id="mobile_0" value="" /></td>
  </tr>
    
  <tr>
    <td>标志建筑:</td>
    <td><input name="sign_building" type="text" id="sign_building_0" value="" /></td>

    <td>最佳送货时间:</td>
    <td><input name="best_time" type="text" id="best_time_0" value="" /></td>
  </tr>
    <tr>
    <td colspan="4" align="center"><input type="submit" name="Submit" value="配送至这个地址" />
            <input type="hidden" name="step" value="consignee" />
      <input type="hidden" name="act" value="checkout" />
      <input name="address_id" type="hidden" value="" /></td>

  </tr>
</table>
</form>  
 </div>

<#include "footer.ftl">