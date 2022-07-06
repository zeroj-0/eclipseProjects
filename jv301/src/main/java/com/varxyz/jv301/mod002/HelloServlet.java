package com.varxyz.jv301.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	// GET방식으로 호출할때 실행되는 메소드
	// 요청정보 캡슐화(=클래스 형식으로 만든다)				응답정보를 캡슐화
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {
		   String pageTitle = "Hello World";
		   response.setContentType("text/html; charset=UTF-8");
		   PrintWriter out = response.getWriter();
		   out.println("<html>"); 
		   out.println("<head><title>"+pageTitle+"</title></head>");
		   out.println("<body>");
		   out.println("<h3>Welcome to 서블릿 프로그램</h3>");
		   out.println(" </body></html>");
		   out.close();
		   }
}
