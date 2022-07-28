<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통장개설</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/default.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />
</head>
<header>
	<%@ include file="../incl/header.jsp"%>
</header>
<body>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">계좌 등록</h3>
			</div>
			<div class="content-wrapper">
				<div class="content account">
					<form action="create_result" method="post" class="add_user">
						<div class="add">
							<select class="account_selec" name="accType">
								<option value="CheckingAccount">CheckingAccount</option>
								<option value="SavingAccount">SavingAccount</option>
							</select> 
						</div>
						<div class="add">
							<input type="text" name="balance" placeholder="초기잔액"> 
						</div>
						<div class="add">
							<input type="text" name="userId" placeholder="아이디">
						</div>
						<div class="i-btn account">
							<input type="submit" value="생성" class="in-btn">
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>