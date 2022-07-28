<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<section>
    <div class="container">
      <div class="title-wrap">
        <h3 class="title">영정&nbsp;뱅킹</h3>
      </div>
      <div class="user"><span class="userId">${userId}</span>님! 반갑습니다</div>
      <div class="form-wrap">
          <div class="btn-group btnmenulist" style="flex-wrap : wrap;">
            <div class="i-btn btnmenuwrap">
              <a href="/banking/domain/create_account"  class="in-btn menulist">계좌등록</a>
            </div>
            <div class="i-btn btnmenuwrap">
              <a href="/banking/domain/transfer_account" class="in-btn menulist">계좌이체</a>
            </div>
            <div class="i-btn btnmenuwrap">
              <a href="/banking/domain/accountList" class="in-btn menulist">계좌목록</a>
            </div>
            <div class="i-btn btnmenuwrap">
              <a href="/banking/domain/check_balance" class="in-btn menulist">잔고확인</a>
          </div>
            <div class="i-btn btnmenuwrap">
              <a href="/banking/domain/overdraftamount_replace" class="in-btn menulist">대출한도변경</a>
          </div>
            <div class="i-btn btnmenuwrap">
              <a href="/banking/domain/login" class="in-btn menulist">로그아웃</a>
          </div>
          </div>
      </div>
    </div>
  </section>
</body>
</html>