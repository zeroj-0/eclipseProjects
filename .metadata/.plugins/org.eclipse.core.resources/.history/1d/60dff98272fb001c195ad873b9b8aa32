<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./fixmethod.css">
</head>
<%
	List<String> error = new ArrayList<String>();
	for(String s : (List<String>)request.getAttribute("error")){
		error.add(s);
	}
%>
<body>
<div class="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : 자바 빈즈\", \"UTF-8\") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h3>다음과 같은 에러가 발생했습니다.</h3>
			<ul>
<%
				@SuppressWarnings("unchecked")
				List<String> errorMsgs = (List<String>)request.getAttribute("error");
				for(String errorMsg : errorMsgs) {
%>
					<li><%=errorMsg %></li>
<%
				}
%>
			</ul>
		</div>
	<div>실패하셨습니다.</div>
	<div>
		<% for(String str : error) {
		%>
			<p><%= str %></p>
		<% } %>
	</div>
	<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
</div>
</body>
</html>