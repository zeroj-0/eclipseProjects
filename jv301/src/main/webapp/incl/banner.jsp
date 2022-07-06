<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<div id="banner">
	<%-- <h4><%= request.getParameter("subtitle") %></h4> --%>
	<h4><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8")%></h4>
</div>