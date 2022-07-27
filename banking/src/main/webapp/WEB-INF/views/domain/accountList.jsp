<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌목록</title>
</head>
<body>
	<h3>계좌목록보기</h3>
	<form action="accountList" method="post">
		<input type="submit" value="확인">
	</form>
	<table>
		<c:forEach var="account" items="${list}">
			<tr>
				<th>Customer</th>
				<th>AccountNumber</th>
				<th>Balance</th>
			</tr>
			<tr>
				<td>
					${account.getCustomerId()}
				</td>
				<td>
					${account.getAccountNum()}
				</td>
				<td>
					${account.getBalance()}
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/banking/domain/menuList" class="in-btn">목록</a>
</body>
</html>