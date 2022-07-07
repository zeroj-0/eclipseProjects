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
  	.btn {
  		width: 100px;
  	}
  	button.btn-inner {
  		width: 100px;
  	}
  </style>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<%@ include file="/incl/menu.jsp" %>
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value="mod010 : Java Bean and include" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<div class="container">
			    <h3>회원가입</h3>
			      <div class="d">
			        <input type="text" name="userId" placeholder="아이디">
			      </div>
			      <div class="d">
			        <input type="password" name="password" placeholder="비밀번호">
			      </div>
			      <div class="d">
			        <input type="text" name="userName" placeholder="이름">
			      </div>
			      <div class="d">
			        <input type="text" name="ssn" placeholder="주민번호앞자리">
			      </div>
			      <div class="d">
			        <input type="text" name="email1" placeholder="이메일">
			        <span class="email">@</span>
			        <select class="" name="email2">
			          <option value="gmail.com">gmail.com</option>
			          <option value="naver.com">naver.com</option>
			          <option value="nate.com">nate.com</option>
			          <option value="daum.com">daum.net</option>
			        </select>
			      </div>
			      <div class="d">
			      	<input type="text" name="addr1" placeholder="주소" class="address1">
			      	<input type="text" name="addr2" placeholder="상세주소">
			      </div>
			      <div class="btn">
			        <button type="submit" class="btn-inner">수정하기</button>
			      </div>
			  </div>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>