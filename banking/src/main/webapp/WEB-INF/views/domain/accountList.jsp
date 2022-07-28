<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌목록</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<header>
	<%@ include file="../incl/header.jsp" %>
</header>
<body>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">계좌목록</h3>
			</div>
			<div class="content-wrapper">
				<div class="content">
					<h4>확인하기</h4>
					<form action="accountList" method="post" class="accountListCheck">
						<div class="i-btn check">
							<input type="submit" value="확인" class="in-btn check" >
						</div>
					</form>
				</div>
				<div class="content checkList">
					<table>
						<tr>
							<th>Customer</th>
							<th>AccountNumber</th>
							<th>Balance</th>
						</tr>
						<c:forEach var="account" items="${list}">
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
				</div>
			</div>
		</div>
	</section>
</body>
</html>