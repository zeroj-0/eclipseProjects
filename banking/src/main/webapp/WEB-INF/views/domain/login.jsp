<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<section>
    <div class="container">
      <div class="title-wrap">
        <h3 class="title">로그인</h3>
      </div>
      <div class="form-wrap">
        <form action="login" method="post" class="login">
          <div class="content">
            <input type="text" name="userId" placeholder="아이디" /><br>
          </div>
          <div class="content">
            <input type="password" name="passwd" placeholder="비밀번호" /><br>
          </div>
          <div class="btn-group">
            <div class="i-btn">
              <input type="submit" value="로그인" class="in-btn" />
              <a href="/banking/domain/add_customer" class="in-btn">회원가입</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </section>
</body>
</html>