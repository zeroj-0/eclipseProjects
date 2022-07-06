<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./fixmethod.css">
</head>
<body>
<div class="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value='<%=URLEncoder.encode("mod007 : 자바 빈즈", "UTF-8") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<c:if test="${not empty error }">
				<h3>다음과 같은 에러가 발생했습니다.</h3>
				<ul>
					<c:forEach var ="errorMsg" items="${error}">
						<li>${errorMsg}</li>
					</c:forEach>
				</ul>
			</c:if>
			<h3>다음과 같은 에러가 발생했습니다.</h3>
			<div>
				<c:forEach var="message" items="${error}">
					${message}
				</c:forEach>
			</div>
		</div>
	<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
</div>
</body>
</html>