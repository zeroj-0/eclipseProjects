<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출한도수정</title>
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
				<h3 class="title">대출한도변경</h3>
			</div>
			<div class="content-wrapper">
				<div class="content account">
					<form action="overdraftamount_replace" method="post" class="add_user">
						<div class="add">
							<select name="accountNum" class="account_selec">
								<option>계좌선택</option>
								<c:forEach var="account" items="${list}">
									<c:if test="${account.getAccType() == 'C'.charAt(0) }">
										<option>${account.getAccountNum()}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<div class="add">
							<input type="text" name="overdraftAmount" placeholder="변경할 대출한도금액" />
						</div>
						<div class="i-btn account">
							<input type="submit" value="변경" class="in-btn"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>