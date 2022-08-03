<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="categoryMain" items="${categoryMainTitleList }">
	${categoryMain.mainTitle}
</c:forEach>
<c:forEach var="category" items="${category }">
	${category.subTitle}
</c:forEach>
<c:forEach var="menuItem" items="${menuItemList}">
	${menuItem.name}
	${menuItem.cost}
	${menuItem.explanation}
</c:forEach>
</body>
</html>