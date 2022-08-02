<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="menuItem">
		<div class="category">
			<c:forEach var="categoryMaintitle" items="${categoryMainTitleList}">
				<label class="categoryLa">
					<input type="radio" value="${ categoryMaintitle.mainTitle}" name="mainTitle" class="main"/>
					${categoryMaintitle.mainTitle}
				</label>
			</c:forEach>
		</div>
		<div class="category">
			<c:forEach var="category" items="${categoryList}">
				<label class="categoryLa">
					<input type="radio" value="${category.subTitle}" name="subTitle" class="sub"/>
					${category.subTitle}
				</label>
			</c:forEach>
		</div>
		
		<form:input path="name" placeholder="상품명"/><br>
		<form:input path="cost" placeholder="가격"/><br>
		<form:input path="explanation" placeholder="제품설명"/><br>
		<input type="file" name="imgURL"/><br>
		<input type="submit" value="등록하기"/>
		<a href="/cafe/">되돌아가기</a>
	</form:form>
	<script type="text/javascript">
		let categoryArray = document.getElementsByClassName("category");
		
		let category1 = categoryArray[0].children[0];
		let category2 = categoryArray[1].children[0];
		
		category1.children[0].checked = true;
		category2.children[0].checked = true;
	</script>
</body>
</html>