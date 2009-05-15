<%@ page pageEncoding="UTF-8"%>

		<div class="title-div">
			<img src="images/category.gif" alt="Category" width="158" height="39"></div>
		<div id="cat-div" style="padding: 5px 10px;">
			<ul>
				<li>
					<c:forEach var="cat" items="${categories}">
					  <span class="parent-cat">
				    <a href="category.php?id=${cat.id}">${cat.name}</a></span><br>
				    <c:forEach var="chd" items="${cat.children}">
				      <span style="white-space: nowrap;">
				      <a href="category.php?id=${chd.id}">${chd.name}</a></span>
				    </c:forEach>
				  </c:forEach>
         </li>
			</ul>
		</div>
