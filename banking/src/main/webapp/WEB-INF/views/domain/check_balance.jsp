<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잔고확인</title>
</head>
<body>
<form action="check_balance" method="post">
	<select name="accountNum">
		<c:forEach var="account" items="${list}">
			<option>${account.getAccountNum()}</option>
			</c:forEach>
	</select>
	<input type="submit" value="확인하기"/>
</form>
${accountNum } 의 잔액은 ${balance }
<a href="/banking/domain/menuList" class="in-btn">목록</a>
</body>
</html>