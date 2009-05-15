<#include "header.ftl">
<div id="container2">      
    <div class="title-div" align="left"><img src="images/forget.gif" width="158" height="39"  alt="" /></div>
    <div class="content-div">
      <form action="dispatch.do?page=getpwd_prompted" method="post" name="getPassword">
        <br />
        <table width="70%" border="0" align="center">
          <tr>

            <td colspan="2" align="center"><strong>请输入您注册的用户名和注册时填写的电子邮件地址。</strong></td>
          </tr>
          <tr>
            <td width="39%" align="right">用户名:</td>
            <td width="61%"><input name="user_name" type="text" size="30" /></td>
          </tr>
          <tr>
            <td align="right">电子邮件地址:</td>

            <td><input name="email" type="text" size="30" /></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input type="hidden" name="act" value="send_pwd_email" />
              <input type="submit" name="submit" value="　确 定　" />
              <input name="button" type="button" onclick="history.back()" value="返回上一页" />   </td>
          </tr>
        </table>
        <br />
      </form>
    </div>
          </div>
<#include "footer.ftl">