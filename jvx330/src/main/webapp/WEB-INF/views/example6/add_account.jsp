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
	<h3>계좌 생성</h3>
	<form:form method="post" modelAttribute="account">
		<label>계좌번호</label>
		<form:input path="accountNum"/><br>
		<label>초기금액</label>
		<form:input path="balance" placeholder="초기금액"/><br>
		<label>계좌 타입</label>
		<form:radiobuttons path="accType" itemLabel="accountCode" itemValue="accountHost" items="${accountTypeList}"/>
		<br>
		<label>이름</label>
		<form:input path="customerCommand.name"/><br>
		<label>이메일</label>
		<form:input path="customerCommand.email"/>
		<input type="submit" value="확인"/>
	</form:form>
</body>
</html>