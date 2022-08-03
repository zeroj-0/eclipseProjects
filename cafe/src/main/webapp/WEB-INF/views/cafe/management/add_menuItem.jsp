<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<div class="container main-container sub-manage">
			<div class="subtitle-wrap">
				<h3 class="sub-title">상품 등록</h3>
			</div>
			<div class="form-wrap">
				<form action="add_menuItem" method="post" enctype="multipart/form-data">
					<div class="content menuItem">
						<span class="subsub-title">대분류 :</span>
						<c:forEach var="categoryMaintitle" items="${categoryMainTitleList}">
							<label class="categoryLa"> 
								<input type="radio" value="${ categoryMaintitle.mainTitle}" name="mainTitle" class="main" />
								 ${categoryMaintitle.mainTitle}
							</label>
						</c:forEach>
					</div>
					<div class="content menuItem">
						<span class="subsub-title">소분류 :</span>
						<c:forEach var="category" items="${categoryList}">
							<label class="categoryLa"> 
								<input type="radio" value="${category.subTitle}" name="subTitle" class="sub" />
								${category.subTitle}
							</label>
						</c:forEach>
					</div>
					<div class="content">
						<input type="text" name="name" placeholder="상품명" />
					</div>
					<div class="content">
						<input type="text" name="cost" placeholder="가격" />
					</div>
					<div class="content">
						 <input type="text" name="explanation" placeholder="제품설명" />
					</div>
					<div class="content">
						<input type="file" name="imgURL" />
					</div>
					<div class="btn-group">
						<div class="subpage-btn-wrap">
							 <input type="submit" value="등록하기" />
							  <a href="/cafe/management" class="btn">되돌아가기</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		let categoryArray = document.getElementsByClassName("menuItem");
		
		let category1 = categoryArray[0].children[1];
		let category2 = categoryArray[1].children[1];
		
		category1.children[0].checked = true;
		category2.children[0].checked = true;
	</script>
</body>
</html>