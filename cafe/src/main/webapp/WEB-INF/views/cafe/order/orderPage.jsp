<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "org.springframework.ui.Model"  %>
<%@ page import= "java.util.*"  %>
<%@ page import= "com.varxyz.spr.cafe.menu.domain.MenuCategory"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제로카페</title>
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
						<li><a href="/cafe/order/${category.mainTitle}/${category.subTitle}" class="category-txt">${category.subTitle}</a></li>
					</c:forEach>
					<c:forEach var="category" items="${category }">
						<li><a href="/cafe/order/${category.mainTitle}/${category.subTitle}" class="category-txt">${category.subTitle}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="menuItem-wrap">
			<div class="menuItem-box-wrap">
				<c:forEach var="item" items="${menuItemList}">
					<div class="memuItem-box">
						<a href="/cafe/order/${item.category.mainTitle}/${item.category.subTitle}/${item.mid}"><img alt="" src="<c:url value="/resources/img/${item.imgURL}"/>" class="img" /></a>
						<p>${item.name}</p>
						<p>${item.cost}</p>
						<p>${item.explanation}</p>
					</div>
				</c:forEach>
				<c:forEach var="item" items="${items}">
					<div class="memuItem-box">
						<a href="/cafe/order/${item.category.mainTitle}/${item.category.subTitle}/${item.mid}"><img alt="" src="<c:url value="/resources/img/${item.imgURL}"/>" class="img" /></a>
						<p>${item.name}</p>
						<p>${item.cost}</p>
						<p>${item.explanation}</p>
					</div>
				</c:forEach>
				<c:forEach var="item" items="${menuItemSub}">
					<div class="memuItem-box">
						<a href="/cafe/order/${item.category.mainTitle}/${item.category.subTitle}/${item.mid}"><img alt="" src="<c:url value="/resources/img/${item.imgURL}"/>" class="img" /></a>
						<p>${item.name}</p>
						<p>${item.cost}</p>
						<p>${item.explanation}</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="cart-wrap">
			<div class="cart-title">장바구니</div>
			<form action="/cafe/order/success" method="post">
				<table class="cart-table">
					<tr>
						<th><span class="e">상품명</span></th><th><span class="e">수량</span></th><th><span class="e">가격</span></th>
					</tr>
					<c:forEach var="lineItem" items="${lineItemList }">
						<tr>
							<td><span class="e"><input name="menuItemName" value="${lineItem.menuItem.name}" class="in"/>${lineItem.menuItem.name}</span></td>
							<td><span class="e"><input name="menuItemCount" value="${lineItem.count }" class="in"/>${lineItem.count }</span></td>
							<td><span class="e"><input name="menuItemPrice" value="${lineItem.eachPrice}" class="in"/>${lineItem.eachPrice}</span> </td>
							<td><span class="e"><a href="/cafe/order/${lineItem.menuItem.category.mainTitle}/${lineItem.menuItem.category.subTitle}/${lineItem.menuItem.mid}/${lineItem.menuItem.mid}">삭제</a></span></td>
						</tr>
					</c:forEach>
				</table>
				<div class="cart-wrap-btn">
					<input type="submit" value="주문하기"/>
				</div>
			</form>
		</div>
		<div class="home-btn-wrap">
			<a href="/cafe/" class="home-btn">홈</a>
		</div>
	</div>
</section>
<script type="text/javascript">
	let category = document.getElementsByClassName("category");

	let mainTitle = category[0].children;
	let subTitle = category[1].children;

	let nowLocation = decodeURI(document.location.href);
	nowLocation = nowLocation.split("/");

	if(nowLocation.length <= 6) {
		let nowLocationTitle = nowLocation[nowLocation.length-1];
		Array.prototype.forEach.call(mainTitle, (item, i) => {
			let aTag = item.children[0].getAttribute("href");
			aTag = aTag.split("/");
			aTag = aTag[aTag.length-1];

			if(nowLocationTitle == aTag) {
				item.classList.add('on');
			}
		});
	} else if (nowLocation.length > 7) {
		let cartwrap = document.getElementsByClassName("cart-wrap")[0];
		cartwrap.style.display = 'block';
	} else if(nowLocation.length > 6) {
		let nowLocationTitle = nowLocation[nowLocation.length-2];
		Array.prototype.forEach.call(mainTitle, (item, i) => {
			let aTag = item.children[0].getAttribute("href");
			aTag = aTag.split("/");
			aTag = aTag[aTag.length-1];

			if(nowLocationTitle == aTag) {
				item.classList.add('on');
			}
		});
		let subLocation = nowLocation[nowLocation.length-1];
		Array.prototype.forEach.call(subTitle, (item, i) => {
			let aTag = item.children[0].getAttribute("href");
			aTag = aTag.split("/");
			aTag = aTag[aTag.length-1];

			if(subLocation == aTag) {
				item.classList.add('on');
			}
		});
	}


	let tableLength = document.getElementsByClassName("cart-table")[0].children[0].children.length;

	if(tableLength == 1) {
		let cartwrap = document.getElementsByClassName("cart-wrap")[0];
		cartwrap.style.display = 'none';
	}

	let inputForm = document.getElementsByClassName("in");

	Array.prototype.forEach.call(inputForm, (item,i) => {
		item.style.display='none';
	});
	
	let cartTable = document.getElementsByClassName("cart-table")[0].children[0].children;
	console.log(cartTable);
	let cartTablel = cartTable.length-2;
	console.log(cartTablel);
	if(cartTable.length >= 2) {
		let i = document.createElement('input');
		i.setAttribute("name", "lineItemCount");
		i.setAttribute("value", cartTablel);
		i.setAttribute("class", "lineItemCount");
		
		let address = document.getElementsByClassName("cart-wrap-btn")[0];
		address.appendChild(i);
	}
	
	let a = document.getElementsByClassName("lineItemCount")[0];
	a.style.display = 'none';

</script>
</body>
</html>