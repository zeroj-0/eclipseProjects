<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌이체</title>
</head>
<body>
<form action="transfer_account" method="post">
	<select name="myAccountNum">
		<c:forEach var="account" items="${list}">
			<option>${account.getAccountNum()}</option>
			</c:forEach>
	</select>
	<input type="text" name="otherAccountNum" placeholder="상대 계좌"/>
	<input type="text" name="amount" placeholder="이체하실 금액"/>
	<input type="submit" value="이체"/>
</form>
<a href="/banking/domain/menuList" class="in-btn">목록</a>
</body>
</html>