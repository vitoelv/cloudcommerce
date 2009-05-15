<#include "header.ftl">


<div id="container2">

      
       <script type="text/javascript" src="js/utils.js"></script>      <script type="text/javascript">
              var username_not_null = "请您输入用户名。";
              var username_invalid = "您输入了一个无效的用户名。";
              var password_not_null = "请您输入密码。";
              var email_not_null = "请您输入电子邮件。";
              var email_invalid = "您输入的电子邮件不正确。";
              var password_not_same = "您输入的密码和确认密码不一致。";
              var password_lt_six = "密码不能小于6个字符。";
      
      
      function checkLoginForm(frm) {
        if (Utils.isEmpty(frm.elements['username'].value)) {
          alert(username_not_null);
          return false;
        }

        if (Utils.isEmpty(frm.elements['password'].value)) {
          alert(password_not_null);
          return false;
        }

        return true;
      }

      function checkSignupForm(frm) {
        if (Utils.isEmpty(frm.elements['username'].value)) {
          alert(username_not_null);
          return false;
        }

        if (Utils.trim(frm.elements['username'].value).match(/^\s*$|^c:\\con\\con$|[%,\'\*\"\s\t\<\>\&\\]/))
        {
          alert(username_invalid);
          return false;
        }

        if (Utils.isEmpty(frm.elements['email'].value)) {
          alert(email_not_null);
          return false;
        }

        if (!Utils.isEmail(frm.elements['email'].value)) {
          alert(email_invalid);
          return false;
        }

        if (Utils.isEmpty(frm.elements['password'].value)) {
          alert(password_not_null);
          return false;
        }

        if (frm.elements['password'].value.length < 6) {
          alert(password_lt_six);
          return false;
        }

        if (frm.elements['password'].value != frm.elements['confirm_password'].value) {
          alert(password_not_same);
          return false;
        }
        return true;
      }
      
      </script>
      
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="50%" valign="top"><form action="flow.php?step=login" method="post" name="loginForm" id="loginForm" onsubmit="return checkLoginForm(this)">
              <div class="title-div"><img src="images/sign_in.gif" alt="sign in" width="158" height="39" /></div>
              <br />
              <table width="90%"  border="0" align="center" cellpadding="1" cellspacing="3">

                <tr>
                  <td><div align="right"><strong>用户名</strong></div></td>
                  <td><input name="username" type="text" id="username" /></td>
                </tr>
                <tr>
                  <td><div align="right"><strong>密码</strong></div></td>
                  <td><input name="password" type="password" id="password" /></td>
                </tr>

                                <tr>
                  <td colspan="2"><div align="center"><a href="user.php?act=get_password">您忘记密码了吗？</a></div></td>
                </tr>
                <tr>
                  <td colspan="2"><div align="center">
                      <input type="submit" name="login" value="登录" />
                                            <input type="button" value="不打算登录，直接购买" onclick="location.href='dispatch.do?page=cart_consignee'" />
                                            <input name="act" type="hidden" value="signin" />

                    </div></td>
                </tr>
              </table>
            </form></td>
          <td valign="top" style="border-left: 1px solid #DADADA;"><form action="flow.php?step=login" method="post" name="registerForm" id="registerForm" onsubmit="return checkSignupForm(this)">
              <div class="title-div"><img src="images/register.gif" alt="sign up" width="158" height="39" /></div>
              <br />
              <table width="90%"  border="0" align="center" cellpadding="1" cellspacing="3">
                <tr>

                  <td><div align="right"><strong>用户名</strong></div></td>
                  <td><input name="username" type="text" id="username" /></td>
                </tr>
                <tr>
                  <td><div align="right"><strong>电子邮件地址</strong></div></td>
                  <td><input name="email" type="text" id="email" /></td>
                </tr>
                <tr>

                  <td><div align="right"><strong>密码</strong></div></td>
                  <td><input name="password" type="password" id="password" /></td>
                </tr>
                <tr>
                  <td><div align="right"><strong>确认密码</strong></div></td>
                  <td><input name="confirm_password" type="password" id="confirm_password" /></td>
                </tr>
                                <tr>

                  <td colspan="2"><div align="center">
                      <input type="submit" name="register" value="注册新用户" />
                      <input name="act" type="hidden" value="signup" />
                    </div></td>
                </tr>
              </table>
            </form></td>
        </tr>
              </table>      
          </div>

<#include "footer.ftl">