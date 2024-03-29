package com.varxyz.jv301.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/add_user.do")
public class AddUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserService userService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
	     //1. 폼 파라메터 열기
	      String userId = request.getParameter("userId");
	      String passwd = request.getParameter("password");
	      String userName = request.getParameter("userName");
	      String ssn = request.getParameter("ssn");
	      String email1 = request.getParameter("email1");
	      String email2 = request.getParameter("email2");
	      String addr1 = request.getParameter("addr1");
	      String addr2 = request.getParameter("addr2");
	      
	      //2. 유효성 검증 및 변환
	      List<String> err = new ArrayList<String>();
	      if(userId == null || userId.length() == 0) {
	    	  err.add("id는 필수입력 정보입니다.");
	      }
	      if (passwd == null || passwd.length() == 0) {
	    	  err.add("Passwd 필수입력정보입니다.");
	      }
	      
//	      request.setAttribute("error", err);
	      /**
	       * 
	       * 값 보관	setAttribute(String name, Object obj)
	       * 값 받아옴	getAttribute(String name)
	       * 
	       * -- 서블릿
	       * request.setAttribute("userName", userName);
	       * RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
	       * dispatcher.forward(request, response);
	       * 
	       * response.sendRedirect("success.jsp"); 주소변화, request scope 종료
	       * 
	       * -- JSP
	       * String userName = (String)request.getAttribute("userName");
	       */
	      
	      RequestDispatcher dispatcher = null;
	      if(err.size() > 0) {
	    	  // 에러메세지 받아서 넘겨줌
	    	  request.setAttribute("error", err);
	    	  dispatcher = request.getRequestDispatcher("/error/error.jsp");
	    	  dispatcher.forward(request, response);
	    	  return ;
	      }
	      User user = new User();
	      user.setUserId(userId);
	      user.setPasswd(passwd);
	      user.setUserName(userName);
	      user.setSsn(ssn);
	      user.setEmail(email1 + "@" + email2);
	      user.setAddr(addr1 + " " + addr2);
	      
	      // 3. 비즈니스 서비스 호출
	      userService = UserService.getInstance();
	      userService.addUser(user);
	      // JSP에서 가져가는 객체 user를 던져줌
	      request.setAttribute("user", user);
	      
	      //4. nextPage
			/*
			 * dispatcher = request.getRequestDispatcher("success.jsp");
			 * dispatcher.forward(request, response);
			 */
	      
			/*
			 * request.setAttribute("userId", userId); request.setAttribute("userName",
			 * userName); request.setAttribute("ssn", ssn);
			 * request.setAttribute("addr1",addr1); request.setAttribute("addr2",addr2);
			 * request.setAttribute("email1", email1); request.setAttribute("email2",
			 * email2);
			 */
//	      List<User> userList = userService.getAllUsers();
//	      request.setAttribute("user", userList);
	      
	      dispatcher = request.getRequestDispatcher("success.jsp");
	      
	      // 다음페이지로 책임을 넘기는 것
	      // 다음페이지로 넘기면 url은 호출자의 주소가 찍혀있음. 결과무관
	      dispatcher.forward(request, response);
	      
	}

}
