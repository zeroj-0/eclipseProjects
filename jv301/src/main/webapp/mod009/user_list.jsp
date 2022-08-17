<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./fixmethod.css">
<link rel="stylesheet" href="./style.css">
</head>
<body>
<div id="wrapper">
	<div id="header">
		<%@ include file="/incl/menu.jsp" %>
	</div>
<h3 class="title">회원 리스트</h3>
	<div class="container">
				<table>			
					<c:forEach var="user" items="${user}">
						<tr>
							<td>
								${user.getUserName()}
							</td>
							<td>
								${user.getUserId()}
							</td>
							<td>
								${user.getEmail()}
							</td>
						</tr>
					</c:forEach>
				</table>
	</div>
</div>
</body>
</html>