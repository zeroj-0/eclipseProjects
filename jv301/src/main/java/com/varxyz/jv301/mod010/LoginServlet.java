package com.varxyz.jv301.mod010;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod010/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지로 들어와서 login페이지로 보냄
		request.getRequestDispatcher("login.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		// 사용자 확인
		if(!userService.isValidUser(userId, passwd)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		// 사용자 확인이 됐을때
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		
		// 로그인 성공 후 next page
		response.sendRedirect("mypage");
	}

}
