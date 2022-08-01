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
<h3>회원가입</h3>
<!-- 이 폼의 값을 받을 command를 등록해주는것 = modelAttribute, 기본값은 command 
		하지만 명시적으로 정확하게 써주는 것이 좋음 ex) customerCommand -->
<form:form method="post" modelAttribute="customer">
	<label>e-mail</label>
	<!-- path : customerCommand의 custId의 property / name과 같은역할 -->
	<form:input path="email1"/>@
	<form:select path="email2">
		<option value="unknown">----선택----</option>
		<!-- 복수는 options / option을 돌면서 찍어라. itemLabel이 화면에 보여지는 것 -->
		<form:options itemValue="emailHost" itemLabel="emailCode" items="${emailProviderList }"/>
	</form:select><br>
	<label>비밀번호</label>
	<form:password path="passwd"/><br>
	<label>이름</label>
	<form:input path="name"/><br>
	<label>주민번호</label>
	<form:input path="ssn"/><br>
	<label>연락처</label>
	<form:select path="phone1">
		<option value="unknown">----선택----</option>
		<!-- 복수는 options / option을 돌면서 찍어라 -->
		<form:options items="${phoneProviderList }"/>
	</form:select>-
	<form:input path="phone2"/><br>
	<input type="submit" value="가입하기"/>
</form:form>
</body>
</html>