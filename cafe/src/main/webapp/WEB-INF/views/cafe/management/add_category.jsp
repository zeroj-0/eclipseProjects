<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<section class="subPage">
	<div class = "container main-container sub-manage">
		<div class="subtitle-wrap">
			<h3 class="sub-title">카테고리 등록</h3>
		</div>
		<div class="form-wrap">
			<form:form method="post" modelAttribute="menuCategory">
				<div class="content">
					<form:input path="mainTitle" placeholder="대분류"/><br>
				</div>
				<div class="content">
					<form:input path="subTitle" placeholder="소분류"/><br>
				</div>
				<div class="btn-group">
					<div class="subpage-btn-wrap">
						<input type="submit" value="등록하기"/>
						<a href="/cafe/management" class="btn">돌아가기</a>
					</div>
				</div>
			</form:form>
			<div class="table-wrap">
				<table>
					<tr>
						<th>대분류</th>
						<th>소분류</th>
					</tr>
					<c:forEach var="category" items="${menuCategoryList}">
						<tr>
							<td>
								${category.mainTitle}	
							</td>
							<td>
								${category.subTitle }
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</section>
</body>
</html>