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
		<div class="btn-wrap manag">
			<a href="/cafe/management/add_category" class="manag-btn">카테고리 등록하기</a>
		</div>
		<div class="btn-wrap manag">
			<a href="/cafe/management/add_menuItem" class="manag-btn">상품 등록하기</a>
		</div>
		<div class="btn-wrap manag">
			<a href="/cafe/management/add_menuItem" class="manag-btn">상품 수정하기</a>
		</div>
		<div class="management-btn-wrap left">
			<a href="/cafe/" class="managementPage"> <<<< 메인화면 </a>
		</div>
	</div>
</section>
</body>
</html>