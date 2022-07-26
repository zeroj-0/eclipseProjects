<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통장개설</title>
</head>
<body>
	<form action="/banking/account" method="post">
		<select class="" name="accType">
			<option value="CheckingAccount">CheckingAccount</option>
			<option value="SavingAccount">SavingAccount</option>
		</select>
		<input type="text" name="balance" placeholder="잔액">
		<input type="text" name="userId" placeholder="아이디">
		<input type="submit" value="생성">
	</form>
</body>
</html>