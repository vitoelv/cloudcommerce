<#include "header.ftl">

 <div id="container2"> 
    <script type="text/javascript" src="js/user.js"></script>
    <div class="title-div" align="left"><img src="images/register.gif" width="158" height="39"  alt="" /></div>
    <div class="content-div">
    <form action="dispatch.do?page=register_success" method="post" name="formUser">
      <br />
      <table width="70%"  border="0" align="center">
        <tr>
          <td width="43%" align="right"><strong>用户名:</strong></td>

          <td width="57%"><input name="username" type="text" id="username" onblur="is_registered(this.value);"/>
            <span id="username_notice" style="color:#FF0000"> *</span></td>
        </tr>
        <tr>
          <td align="right"><strong>email:</strong></td>
          <td><input name="email" type="text" id="email" onblur="checkEmail(this.value);"/>
            <span id="email_notice" style="color:#FF0000"> *</span></td>

        </tr>
        <tr>
          <td align="right"><strong>密码:</strong></td>
          <td><input name="password" type="password" id="password" onblur="check_password(this.value);" onkeyup="checkIntensity(this.value)" />
            <span style="color:#FF0000" id="password_notice"> *</span></td>
        </tr>
        <tr>

          <td align="right"><strong>密码强度:</strong></td>
          <td>
            <table width="145" border="0" cellspacing="0" cellpadding="1">
              <tr align="center">
                <td width="33%" id="pwd_lower">弱</td>
                <td width="33%" id="pwd_middle">中</td>
                <td width="33%" id="pwd_high">强</td>

              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td align="right"><strong>确认密码:</strong></td>
          <td><input name="confirm_password" type="password" id="conform_password" onblur="check_conform_password(this.value);" />
            <span style="color:#FF0000" id="conform_password_notice"> *</span></td>

        </tr>
        <tr>
          <td align="right"><strong>MSN:</strong></td>
          <td><input name="other[msn]" type="text" />
           </td>
        </tr>
        <tr>
          <td align="right"><strong>QQ:</strong></td>

          <td><input name="other[qq]" type="text"  />
           </td>
        </tr>
        <tr>
          <td align="right"><strong>办公电话:</strong></td>
          <td><input name="other[office_phone]" type="text"  />
           </td>
        </tr>

        <tr>
          <td align="right"><strong>家庭电话:</strong></td>
          <td><input name="other[home_phone]" type="text"  />
          </td>
        </tr>
        <tr>
          <td align="right"><strong>手机:</strong></td>
          <td><input name="other[mobile_phone]" type="text"  />

           </td>
        </tr>
              <tr>
          <td>&nbsp;</td>
          <td><label>
            <input name="agreement" type="checkbox" value="1" checked="checked" />
            <b>我已看过并接受《<a href="dispatch.do?page=article&cat_id=-1" style="color:blue" target="_blank">用户协议</a>》</b></label></td>

        </tr>
        <tr>
          <td colspan="2" align="center"><input name="act" type="hidden" value="act_register" >
            <input name="Submit" type="submit" value="确认注册"></td>
        </tr>
        <tr>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>

          <td>&nbsp;</td>
          <td><li style="border-bottom: 1px dashed #CECECE;width:150px;"> <a href="dispatch.do?page=user">我已有账号，我要登录</a></li>
            <li style="border-bottom: 1px dashed #CECECE;width:150px;"> <a href="dispatch.do?page=get_password">您忘记密码了吗？</a></li></td>
        </tr>
      </table>
      <br />
    </form></div>
          </div>

<#include "footer.ftl">