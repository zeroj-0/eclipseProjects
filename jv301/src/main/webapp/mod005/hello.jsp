<%@ page language="java" contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>
<%--멤버변수 선언 --%>
<%! private static String DEFAULT_NAME = "World"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
<%-- 이것은 JSP 주석입니다 --%>
<%
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
%>
<%-- '%=' 출력모드 --%>
<h3>Hello, <%=name %></h3>
</body>
</html>