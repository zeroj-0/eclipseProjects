package com.varxyz.jv301.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet2", urlPatterns = {"/mod005/hello.view"})
public class HelloServlet extends HttpServlet {
	private static String DEFAULT_NAME = "World";
	
	/**
	 * 서비스메소드 오버라이딩한 것이 JSP가 되는것
	 * 서블릿의 doGet메소드안에 JSP내용 들어가 있음
	 */
	// GET방식으로 호출할때 실행되는 메소드
	// 요청정보 캡슐화(=클래스 형식으로 만든다)				응답정보를 캡슐화
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {
		   String pageTitle = "Hello World";
		   // getParameterValues를 사용하여 배열로 받을 수 있음
		   String name = request.getParameter("userName");
			if(name == null || name.length() == 0) {
				name = DEFAULT_NAME;
			}
		   response.setContentType("text/html; charset=UTF-8");
		   PrintWriter out = response.getWriter();
		   out.println("<html>"); 
		   out.println("<head><title>"+pageTitle+"</title></head>");
		   out.println("<body>");
		   out.println("<h3> Hello, "+name+ "</h3>");
		   out.println(" </body></html>");
		   out.close();
		   }
}