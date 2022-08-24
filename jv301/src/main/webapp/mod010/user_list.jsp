<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./fixmethod.css">
<link rel="stylesheet" href="./style.css">
<style>
	table {
		border: 1px solid #333;
		width: 100%;
		margin: 0 auto;
		border-collapse: collapse;
	}
	table tr {
		height: 40px;
	}
	table td {
		border: 1px solid #333;
		width: 100px;
		text-align: center;
	}
	table th {
		border: 1px solid #333;
		border-bottom: 2px solid #333;
	}
	.search-area {
		width: 100%;
		height: 50px;
		display: flex;
		margin-top: 30px;
	}
	.search-area form {
		display: flex;
		justify-content: center;
	}
	.search-area input {
		width: 45%;
		padding-left: 10px;
	}
	.search-area button {
		width: 10%;
		margin-left: 20px;
		background: #324ff4;
		color: white;
		font-weight: 500;
		font-size: 15px;
		border-radius: 8px;
		cursor: pointer;
	}
</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<%@ include file="/incl/menu.jsp" %>
	</div>
<h3 class="title">회원 리스트</h3>
	<div class="container">
				<table>			
					<tr>
						<th>이름</th><th>생년월일</th><th>아이디</th><th>이메일</th>
					</tr>
					<c:forEach var="user" items="${user}">
						<tr>
							<td>
								${user.getUserName()}
							</td>
							<td>
								${user.getSsn()}
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
				<div class="search-area">
					<form action="user_list.do" method="post">
						<input type="text" name="searchId" placeholder="아이디 입력"/>
						<button type="submit">검색</button>
					</form>
				</div>
	</div>
</div>
</body>
</html>