<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>회원정보 입력</h3>
	<form action="step3" method="post">
		<label>Email</label><input type="text" name="email"/>
		<label>비밀번호</label><input type="password" name="passwd"/>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>