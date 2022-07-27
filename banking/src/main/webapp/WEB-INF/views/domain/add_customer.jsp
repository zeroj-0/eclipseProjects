<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/button.css'/>"/>
</head>
<body>
<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">회원가입</h3>
			</div>
			<div id="content-wrapper">
					<form class="add_user" action="add_customer" method="post">
						<div class="add">
							<input type="text" name="userId" placeholder="아이디">
						</div>
						<div class="add">
							<input type="password" name="passwd" placeholder="비밀번호">
						</div>
						<div class="add">
							<input type="text" name="name" placeholder="이름">
						</div>
						<div class="add">
							<input type="text" name="ssn" placeholder="주민번호">
						</div>
						<div class="add phone">
							 <input type="text" name="phoneNum" placeholder="휴대폰번호"
								minlength="13"> <span class="phone">* 010부터 '-'까지 같이
								적어주세요</span>
						</div>
						<div class="btn-group">
							<div class="i-btn">
								<div class="btn">
									<button type="submit" class="btn-inner">확인</button>
								</div>
								<div class="btn">
									<a href="/banking/domain/login" class="in-btn">취소</a>
								</div>
							</div>
						</div>
					</form>
			</div>
		</div>
	</section>
</body>
</html>