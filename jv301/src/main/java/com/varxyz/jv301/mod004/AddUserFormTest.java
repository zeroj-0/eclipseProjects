package com.varxyz.jv301.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/add_user.do")
public class AddUserFormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userSsn = request.getParameter("ssn");
		String userEmail = request.getParameter("email") + "@" +request.getParameter("email2");
		String favorite[] = request.getParameterValues("favorite");
		
		String pageTitle = "회원정보";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>"+pageTitle+"</title></head>");
		out.println("<body>");
		out.println("<div>아이디 : "+userId+"</div>");
		out.println("<div>이름 : "+userName+"</div>");
		out.println("<div>생년월일 : "+userSsn+"</div>");
		out.println("<div>이메일 : "+userEmail+"</div>");
		out.println("<div>관심분야 : ");
		for(String str : favorite) {
			out.print(str+"&nbsp&nbsp");
		}
		out.println("</div>");
		out.println("</body></html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setChracterEncoding() 메소드는 doPost에 쓸때마다 제일 첫째줄에 적어줘야함. 하지만 실제로는 이렇게 잘 안씀!
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
