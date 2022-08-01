<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td, th { border: 1px solid #000; text-align: center;}
	table { border-collapse: collapse;}
</style>
</head>
<body>
<h3>계좌생성 완료되었습니다.</h3>
<table>
	<tr>
		<th>이름</th>
		<th>이메일</th>
		<th>계좌번호</th>
		<th>계좌타입</th>
	</tr>
	<tr>
		<td>
			${account.customerCommand.name}			
		</td>
		<td>
			${account.customerCommand.email }			
		</td>
		<td>
			${account.accountNum }
		</td>
		<td>
			${account.accType}		
		</td>
	</tr>
</table>
</body>
</html>