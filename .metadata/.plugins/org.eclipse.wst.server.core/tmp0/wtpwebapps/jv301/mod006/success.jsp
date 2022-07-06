<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String userId = (String)request.getAttribute("userId");
	String userName = (String)request.getAttribute("userName");
	String userSsn = (String)request.getAttribute("ssn");
	String userAddr = (String)request.getAttribute("addr1")+" "+(String)request.getAttribute("addr2");
	String userEmail = (String)request.getAttribute("email1")+"@"+(String)request.getAttribute("email2");
%>
<body>
	<div>성공하셨습니다.</div>
	<div>회원 이름 : 
		<%= userName %>
	</div>
	<div>회원 아이디 : 
		<%= userId %>
	</div>
	<div>회원 이메일 : 
		<%= userEmail %>
	</div>
</body>
</html>