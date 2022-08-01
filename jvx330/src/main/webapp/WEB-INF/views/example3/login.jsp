<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="login" method="post">
		<label>아이디</label><input type="text" name="userId"/>
		<label>비밀번호</label><input type="password" name="passwd"/>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>