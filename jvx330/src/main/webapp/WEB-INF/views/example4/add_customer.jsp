<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>회원가입</h3>
	<form action="add_customer" method="post">
		<label>E-mail</label><input type="text" name="email"/>
		<label>비밀번호</label><input type="password" name="passwd"/>
		<label>이름</label><input type="text" name="name"/>
		<label>주민번호</label><input type="text" name="ssn"/>
		<label>연락처</label><input type="text" name="phone"/>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>