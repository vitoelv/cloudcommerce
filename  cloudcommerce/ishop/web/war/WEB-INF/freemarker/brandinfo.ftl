<div class="title-div">
			<img src="images/brands.gif" alt="" width="158" height="39"></div>
		<div class="content-div">
			<div style="list-style-type: none; list-style-image: none; list-style-position: outside; margin: 10px; padding: 0pt">
				<div>				
								
				  <#list brandinfoList as bra >
				    <img src="images/cat_arrow.gif" alt="arrow">		
				    <a href="dispatch.do?page=brand&id=${bra.brand.id}">${bra.brand.name}(${bra.number})</a><br/>		    
				  </#list>					
				</div>
			</div>
		</div>