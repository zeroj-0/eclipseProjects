<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	List<String> error = new ArrayList<String>();
	for(String s : (List<String>)request.getAttribute("error")){
		error.add(s);
	}
%>
<body>
	<div>실패하셨습니다.</div>
	<div>
		<% for(String str : error) {
		%>
			<p><%= str %></p>
		<% } %>
	</div>
</body>
</html>