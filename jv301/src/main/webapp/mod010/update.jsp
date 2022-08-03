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
  	.email {
  		width: 40%;
  	}
  	.address {
  		width: 40%;
  	}
  	span.id {
  		font-size: 13px;
  		color: red;
  		margin-left: 15px;
  	}
  </style>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<%@ include file="/incl/menu.jsp" %>
		</div>
		<div id="content-wrapper">
			<div class="container">
			    <h3>회원 수정</h3>
			    <form action="update_user.do" method="post">
			      <div class="d">
			        <input type="text" name="userId" placeholder="아이디"  value="${findUser.getUserId()}" readonly>
			        <span class="id">* 아이디는 수정이 되지 않습니다.</span>
			      </div>
			      <div class="d">
			        <input type="password" name="password" placeholder="비밀번호" value="${findUser.getPasswd() }">
			      </div>
			      <div class="d">
			        <input type="text" name="userName" placeholder="이름" value="${findUser.getUserName() }">
			      </div>
			      <div class="d">
			        <input type="text" name="ssn" placeholder="주민번호앞자리" value="${findUser.getSsn() }">
			      </div>
			      <div class="d">
			        <input type="text" name="email" placeholder="이메일"  class="email" value="${findUser.getEmail() }">
			      </div>
			      <div class="d">
			      	<input type="text" name="addr" placeholder="주소" class="address" value="${findUser.getAddr() }">
			      </div>
			      <div class="btn">
			        <button type="submit" class="btn-inner">수정하기</button>
			      </div>
			    </form>
			  </div>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>