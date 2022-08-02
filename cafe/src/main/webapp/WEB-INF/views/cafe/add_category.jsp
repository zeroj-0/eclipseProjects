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
<h3>카테고리 등록</h3>
<form:form method="post" modelAttribute="menuCategory">
		<form:input path="mainTitle" placeholder="대분류"/><br>
		<form:input path="subTitle" placeholder="소분류"/><br>
		<input type="submit" value="등록하기"/>
		<a href="/cafe/">돌아가기</a>
	</form:form>
</body>
</html>