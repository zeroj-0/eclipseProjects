<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잔고확인</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />
</head>
<header>
	<%@ include file="../incl/header.jsp" %>
</header>
<body>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">잔고 확인</h3>
			</div>
			<div class="content-wrapper">
				<div class="content account balance_check">
					<form action="check_balance" method="post" class="add_user">
						<div class="add">
							<select name="accountNum" class="account_selec">
								<c:forEach var="account" items="${list}">
									<option>${account.getAccountNum()}</option>
									</c:forEach>
							</select>
						</div>
						<div class="i-btn account">
							<input type="submit" value="확인하기" class="in-btn"/>
						</div>
					</form>
					<div class="content balance_check">
						<div class="text-wrap">
							${accountNum }${str }<span>${balance }</span>
						</div>					
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>