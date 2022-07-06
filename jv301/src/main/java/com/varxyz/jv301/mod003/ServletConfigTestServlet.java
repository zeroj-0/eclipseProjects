package com.varxyz.jv301.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet {
	
	private static final String DEFAULT_SEASONS = "Spring, Summer, Fall, Winter";
	private String[] seasons;
	
	/*
	 * @Override public void init(ServletConfig config) throws ServletException {
	 * String season_list = config.getInitParameter("season-list"); if(season_list
	 * == null) { season_list = DEFAULT_SEASONS; } seasons =
	 * season_list.split(", "); }
	 */
	@Override
	public void init() throws ServletException {
		String season_list = getInitParameter("season-list");
		if(season_list == null) {
			season_list = DEFAULT_SEASONS;
		}
		seasons = season_list.split(", ");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>ServletConfig Test</h3>");
		for (String season : seasons) {
			out.print(season+"&nbsp&nbsp");
		}
		out.println("</body></html>");
		out.close();
	}
}
