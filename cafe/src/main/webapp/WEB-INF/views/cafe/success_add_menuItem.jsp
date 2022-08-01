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
		<form:input path="name" placeholder="상품명"/><br>
		<form:input path="cost" placeholder="가격"/><br>
		<input type="file" name="imgURL"/><br>
		<input type="submit" value="등록하기"/>
	</form:form>
</body>
</html>