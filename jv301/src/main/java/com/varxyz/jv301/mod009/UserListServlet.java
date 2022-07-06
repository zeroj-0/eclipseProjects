package com.varxyz.jv301.mod009;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/user_list.do")
public class UserListServlet extends HttpServlet {
	private UserService userService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userService = UserService.getInstance();
		List<User> userList = userService.getAllUsers();
		request.setAttribute("user", userList);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}

}
