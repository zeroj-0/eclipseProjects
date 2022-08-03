<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제로카페</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<section class="main">
	<div class="container main-container">
		<div class="title-wrap">
			<h3 class="title">ZERO CAFE</h3>
		</div>
		<div class="btn-wrap">
			<a href="/cafe/order" class="order-btn">주문하기</a>
		</div>
		<div class="management-btn-wrap">
			<a href="/cafe/management" class="managementPage">관리자페이지 >>></a>
		</div>
	</div>
</section>
</body>
</html>