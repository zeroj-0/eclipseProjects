<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<section class="subPage">
    <div class="container main-container sub-order">
        <div class="success-title-wrap">
        	<div class="title">
	            주문이 완료되었습니다!
        	</div>
        	<div class="item-wrap">
        		<div class="item">상품명 : <span class="itemName">${ItemName}</span></div>
        	</div>
           <div class="item-wrap">
           		<div class="item">외 <span class="itemName">${lineItemCount}</span>개의 상품이 주문되었습니다.</div>
           </div>
        </div>
        <div class="home-btn-wrap">
			<a href="/cafe/" class="home-btn">홈</a>
		</div>
    </div>
</section>
</body>
</html>
