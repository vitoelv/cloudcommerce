
<script>
//cookie的相关函数
function getCookieVal (offset) {
var endstr = document.cookie.indexOf (";", offset);
if (endstr == -1) endstr = document.cookie.length;
    return unescape(document.cookie.substring(offset, endstr));
}
     
function getCookie (name) {
         var arg = name + "=";
         var alen = arg.length;
         var clen = document.cookie.length;
         var i = 0;
         while (i < clen) {
             var j = i + alen;
             if (document.cookie.substring(i, j) == arg) return getCookieVal (j);
             i = document.cookie.indexOf(" ", i) + 1;
             if (i == 0) break;
         }
      return null;
}
function setCookie (name, value) {
       var exp = new Date();
       exp.setTime (exp.getTime()+3600000000);
       document.cookie = name + "=" + value + "; expires=" + exp.toGMTString();
}

/////////////////////////

function glog(evt)
{
evt=evt?evt:window.event;
var srcElem=(evt.target)?evt.target:evt.srcElement;
try
{
while(srcElem.parentNode&&srcElem!=srcElem.parentNode)
{
if(srcElem.tagName&&srcElem.tagName.toUpperCase()=="A")
{
linkname=srcElem.innerHTML;
address=srcElem.href+"_www.achome.cn_";
wlink=linkname+"+"+address;
old_info=getCookie("history_info");
var insert=true;
////////////////////////

if(old_info==null)          //判断cookie是否为空
{
insert=true;
}
else
{
var old_link=old_info.split("_www.achome.cn_");
for(var j=0;j<=5;j++)
{
if(old_link[j].indexOf(linkname)!=-1)
insert=false;
if(old_link[j]=="null")
break;
}
}


/////////////////////////////
if(insert)                //如果符合条件则重新写入数据
{
wlink+=getCookie("history_info");
setCookie("history_info",wlink);
history_show().reload();
break;
}

}
srcElem = srcElem.parentNode;
}
}
catch(e){}
return true;
}

document.onclick=glog;


////////////////////////////////////////////////////////////////////////////////


function history_show()
{  
var history_info=getCookie("history_info");
var content="";
if(history_info!=null)
{
history_arg=history_info.split("_www.achome.cn_");
var i;
for(i=0;i<=4;i++)
{
if(history_arg[i]!="null")
{
    var wlink=history_arg[i].split("+");
   content+=("<font color='#ff000'>↑</font>"+"<a href='"+wlink[1]+"' target='_blank'>"+wlink[0]+"</a><br>");
   }
   document.getElementById("history").innerHTML=content;
   }
}
else
{document.getElementById("history").innerHTML="暂无任何浏览纪录";}
}

<div class="title-div">
<img src="images/history.gif" alt="History" width="158" height="39" /></div>
<div class="content-div">
  <ul class="history-list">
    <li><a href="goods.php?id=18" title="香皂">香皂</a></li>
    <li><a href="goods.php?id=15" title="S900">S900</a></li>
    <li><a href="goods.php?id=16" title="LGKG99">LGKG99</a></li>
    <li><a href="goods.php?id=11" title="迪士尼经典米奇">迪士尼经典米奇</a></li>
    <li><a href="goods.php?id=3" title="A1200">A1200</a></li>  
  </ul>
</div></div>