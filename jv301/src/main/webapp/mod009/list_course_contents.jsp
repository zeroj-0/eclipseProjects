<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.tab {
			margin-left: 15px;
		}
	</style>
</head>
<body>
	<form action="list_course_contents.do" method="get">
		<h3>문서확인하기</h3>
		<button type="submit" id="btn">확인</button>
	</form>
	<div id="content">
	<ul>
		<c:forEach var="content" items="${textLine}">
			<li>
				${content }
			</li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>