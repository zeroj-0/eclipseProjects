<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="./fixmethod.css">
</head>
<body>
<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : 자바 빈즈\", \"UTF-8\") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h3>회원가입 되었습니다.</h3>
			<%-- User클래스에서의 던져준 객체의 프로퍼티를 가져오는 것 --%>
			<jsp:useBean id="user" class="com.varxyz.jv301.mod008.User" scope="request"/>
			아이디 : <jsp:getProperty property="userId" name="user"/><br>
			이름 : <jsp:getProperty property="userName" name="user"/><br>
			이메일 : <jsp:getProperty property="email" name="user"/><br>
			생년월일 : <jsp:getProperty property="ssn" name="user"/><br>
			주소 : <jsp:getProperty property="addr" name="user"/><br>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>