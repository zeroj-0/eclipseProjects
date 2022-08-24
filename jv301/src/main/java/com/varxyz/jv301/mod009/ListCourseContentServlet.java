package com.varxyz.jv301.mod009;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/list_course_contents.do")
public class ListCourseContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> textLine = new ArrayList<String>();

	public void init(ServletConfig config) throws ServletException {
		// InitializeCourseListener에서 contentList 담은 context를 가져오기
		ServletContext context = config.getServletContext();
		List<String[]> contentList = (List<String[]>)context.getAttribute("contentList");
		textLine = tapToSpace(contentList);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setAttribute("textLine", textLine);
		 request.getRequestDispatcher("list_course_contents.jsp").forward(request, response);
	}
	
	private List<String> tapToSpace(List<String[]> contentList) {
		List<String> lineList = new ArrayList<>();
		if(contentList.size() > 0) {
			for(String[] contents : contentList) {
				if(isEmptyLine(contents)) {
					continue;
				}
				for (int i = 0; i< contents.length; i++) {
					if(contents[i].length() == 0) {
						contents[i] = "<span class=\"tab\">";
						contents[contents.length-1] = contents[contents.length-1]+"</span>";
					}
				}
			}
		} else {
			lineList.add("-No Data-");
		}
		String line="";
		for(String[] contents : contentList) {
			for(String s : contents) {
				line += s;
			}
			lineList.add(line);
			line="";
		}
		return lineList;
		/*if(contentList != null) {
			contentList.remove(0);
			for ( String[] contents : contentList ) {
				for(int i = 0; i < contents.length; i++) {
					// tap일 경우를 가리킴
					if(contents[i].length()==0 && contents.length == 1) {
						contents[i] = "<br>";
					} else if(contents[i].length() == 0) {
						contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;";
					}
				}
			}
		} else {
			String[] str = "-No Data-";
			ArrayList<String[]> list = new ArrayList<>();
			list.add(str);
			contentList = list;
		}
		return contentList;*/
	}
	
	private boolean isEmptyLine (String[] line) {
		for(int i=0;i<line.length;i++) {
			if(line[i].length() == 0 && line.length == 1) {
				return true;
			} // 영정이는 지금 예민해
		}
		return false;
	}

}