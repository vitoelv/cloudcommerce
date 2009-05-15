		<div class="title-div">
			<img src="images/category.gif" alt="Category" width="158" height="39"></div>
		<div id="cat-div" style="background-color: #FFFFFF;  background-image: url(images/cat_bg.jpg);  background-repeat: repeat-x;  padding: 10px;  margin: 3px;">
			<ul style="padding: 2px;  margin: 0;  list-style-type: none;">
				<#list categories as cat>
				<li style="padding-left: 15px;  background-image: url(images/cat_arrow.gif);  background-repeat: no-repeat;  background-position: 0px 5px;  line-height: 180%;">
				  
					  <span class="parent-cat">					 
				    <a href="dispatch.do?page=category&id=${cat.id}">${cat.name}</a></span><br>
				    <#list cat.children as chd>
				      <span style="white-space: nowrap;">
				      <a href="dispatch.do?page=category&id=${chd.id}">${chd.name}</a></span>
				    </#list>				 
               </li>
                </#list>
			</ul>
		</div>
