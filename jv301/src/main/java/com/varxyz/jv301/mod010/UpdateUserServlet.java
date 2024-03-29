package com.varxyz.jv301.mod010;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod010/update_user.do")
public class UpdateUserServlet extends HttpServlet {
	private UserService userService;
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		userService = UserService.getInstance();

		String userId = request.getParameter("userId");
		String passwd = request.getParameter("password");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		RequestDispatcher dispatcher = null;
		
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setSsn(ssn);
		user.setEmail(email);
		user.setAddr(addr);
		
		userService.updateUser(user);
		
		dispatcher = request.getRequestDispatcher("success_update.jsp");
		dispatcher.forward(request, response);
	}

}
