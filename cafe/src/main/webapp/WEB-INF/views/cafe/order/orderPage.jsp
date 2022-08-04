<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "org.springframework.ui.Model"  %>
<%@ page import= "java.util.*"  %>
<%@ page import= "com.varxyz.spr.cafe.menu.domain.MenuCategory"  %>
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
		<div class= "category-wrap">
			<div class="maincategory-wrap">
				<ul class="category">
					<c:forEach var="categoryMain" items="${categoryMainTitleList }">
						<li><a href="/cafe/order/${categoryMain.mainTitle }" class="category-txt">${categoryMain.mainTitle}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="subcategory-wrap">
				<ul class="category">
					<c:forEach var="category" items="${categorySubTitleList }">
						<li><a href="/cafe/order/${maintitle}/${category.subTitle}" class="category-txt">${category.subTitle}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="menuItem-wrap">
			<div class="menuItem-box-wrap">
				<c:forEach var="item" items="${items}">
					<div class="memuItem-box">
						<a><img alt="" src="<c:url value="/resources/img/${item.imgURL}"/>" class="img" /></a>
						<p>${item.name}</p>
						<p>${item.cost}</p>
						<p>${item.explanation}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	let category = document.getElementsByClassName("category");

	let mainTitle = category[0].children;
	let subTitle = category[1].children;

	let nowLocation = decodeURI(document.location.href);
	nowLocation = nowLocation.split("/");
	nowLocation = nowLocation[nowLocation.length-2];
	let subLocation = decodeURI(document.location.href);
	subLocation = nowLocation.split("/");
	subLocation = nowLocation[nowLocation.length-1];
	
	Array.prototype.forEach.call(mainTitle, (item, i) => {
		let aTag = item.children[0].getAttribute("href");
		aTag = aTag.split("/");
		aTag = aTag[aTag.length-2];
		let subaTag = item.children[0].getAttribute("href");
		subaTag = aTag.split("/");
		subaTag = aTag[aTag.length-1];
		
		if(nowLocation == aTag) {
			item.classList.add('on');
		}
		if(subLocation == subaTag) {
			item.classList.add('on');
		}
	});
	
	Array.prototype.forEach.call(mainTitle, (item, i) => {
		let aTag = item.children[0].getAttribute("href");
		aTag = aTag.split("/");
		aTag = aTag[aTag.length-1];
		
		if(nowLocation == aTag) {
			item.classList.add('on');
		}
	});
	
	
</script>
</body>
</html>