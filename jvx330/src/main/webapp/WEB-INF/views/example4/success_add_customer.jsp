<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 성공 ! 가입을 환영합니다</h1>
	<label>E-mail</label>${customerCommand.email }<br>
	<label>비밀번호</label>${customerCommand.passwd }<br>
	<label>이름</label>${customerCommand.name }<br>
	<label>주민번호</label>${customerCommand.ssn }<br>
	<label>연락처</label>${customerCommand.phone }<br>
</body>
</html>