package com.varxyz.jv301.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><style>");
		out.print("p { display:flex;}");
		out.print("span {width: 100px; margin-right: 15px; text-align: center;}");
		out.print("</style></head>");
		out.print("<body>");
		for (int i=1; i<10; i++) {
			out.print("<p>");
			for (int j=2; j<10; j++) {
				out.print("<span>");
				out.print(j+" * "+i+" = "+i*j);
				out.print("</span>");
			}
			out.print("</p>");
		}
		out.print("</body></html>");
		out.close();
	}
}
