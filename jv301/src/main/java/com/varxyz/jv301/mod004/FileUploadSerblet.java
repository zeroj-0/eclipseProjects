package com.varxyz.jv301.mod004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024  * 2, 						//2MB
		maxFileSize = 1024* 1024 * 10,									//10MB
		maxRequestSize = 1024* 1024* 50)							//50MB
public class FileUploadSerblet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "C:/temp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---------------------");
		
		// file 저장위치
		// 톰캣안에서 저장가능 || 톰캣밖에 저장가능
		File saveDir = new File(SAVE_DIR); 
		
		// 파일 존재여부 확인
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		for(Part part : request.getParts()) {
			System.out.println(saveDir.getPath() + File.separator + extractfileName(part));
			// c:\temp\eclipse.ini											extractfileName == eclipse.ini
			part.write(saveDir.getPath() + File.separator + extractfileName(part));
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3> Upload has been done successfully. </h3>");
		out.println("</body></html>");
		out.close();
		
		// 요청하는 파일(=http 프로토콜)안에 header값을 보여주기 위함
		/*
		 * Enumeration<String> e = request.getHeaderNames(); while (e.hasMoreElements())
		 * { String header = e.nextElement(); System.out.println(header + " = " +
		 * request.getHeader(header)); }
		 */
	}
	
	private String extractfileName(Part part) {
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("Content-Disposition = "+contentDisp);
		for ( String s : contentDisp.split(";") ) {
			if(s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", "");
			} else {
	            if(s.contains("filename=")) {
	                return s.substring("filename=".length() + 1).replace("\"", "");
	             }
	          }
	       }
	       return "";
	}

}
