<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌이체</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<header>
	<%@ include file="../incl/header.jsp"%>
</header>
<body>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">계좌 이체</h3>
			</div>
			<div class="content-wrapper">
				<div class="content account  balance_check">
					<form action="transfer_account" method="post" class="add_user">
						<div class="add">
							<select name="myAccountNum" class="account_selec">
								<c:forEach var="account" items="${list}">
									<option>${account.getAccountNum()}</option>
									</c:forEach>
							</select>
						</div>
						<div class="add">
							<input type="text" name="otherAccountNum" placeholder="상대 계좌"/>
						</div>
						<div class="add">
							<input type="text" name="amount" placeholder="이체하실 금액"/>
						</div>
						<div class="add">
							<input type="password" name="passwd" placeholder="바밀번호"/>
						</div>
						<div class="i-btn account">
							<input type="submit" value="이체" class="in-btn"/>
						</div>
					</form>
					<div class="content balance_check">
						<div class="text-wrap">
							${str}<span >${balance}</span>
						</div>					
					</div>
				</div>
			</div>
		</div>
	</section>

<a href="/banking/domain/menuList" class="in-btn">목록</a>
</body>
</html>