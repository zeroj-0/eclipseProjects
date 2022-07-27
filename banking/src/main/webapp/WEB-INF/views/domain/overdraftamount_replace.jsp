<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출한도수정</title>
</head>
<body>
<form action="overdraftamount_replace" method="post">
	<select name="accountNum">
		<c:forEach var="account" items="${list}">
			<c:if test="${account.getAccType() == 'C'.charAt(0) }">
				<option>${account.getAccountNum()}</option>
			</c:if>
		</c:forEach>
	</select>
	<input type="text" name="overdraftAmount" placeholder="변경할 대출한도금액" />
	<input type="submit" value="변경"/>
</form>
</body>
</html>