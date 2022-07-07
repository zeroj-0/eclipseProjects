<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="./fixmethod.css">
	<link rel="stylesheet" href="./style.css">
</head>
<style>
	h3.success {
		text-align: center;
	}
</style>
<body>
<div id="wrapper">
		<div id="header">
			<%@ include file="/incl/menu.jsp" %>
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : 자바 빈즈\", \"UTF-8\") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<div class="container">
				<h3 class="success">회원가입 되었습니다.</h3>
			</div>
			<%-- User클래스에서의 던져준 객체의 프로퍼티를 가져오는 것 --%>
			<%--
			<jsp:useBean id="user" class="com.varxyz.jv301.mod009.User" scope="request"/>
			아이디 : <jsp:getProperty property="userId" name="user"/><br>
			이름 : <jsp:getProperty property="userName" name="user"/><br>
			이메일 : <jsp:getProperty property="email" name="user"/><br>
			생년월일 : <jsp:getProperty property="ssn" name="user"/><br>
			주소 : <jsp:getProperty property="addr" name="user"/><br>
			 --%>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>