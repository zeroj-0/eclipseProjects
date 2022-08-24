<%@ page language="java" contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>
<%-- 
<%@ page import="" session="" errorPage="" isErrorPage="" contentType="" pageEncoding="" %>
 --%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>아 뭐요</title>
  <link rel="stylesheet" href="./style2.css">
  <link rel="stylesheet" href="./fixmethod.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value="mod007 : Java Bean and include" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<div class="container">
			    <h3>회원가입</h3>
			    <form class="" action="add_user.do" method="post">
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
			        <button type="submit">확인</button>
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