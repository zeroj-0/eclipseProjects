package com.varxyz.jv301.mod010;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod010/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
	public void init() {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session이 있을때만 연결
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId");
		if (userId == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		// 쿠키는 Map같이 생김
		Cookie[] cookies = request.getCookies();
		// 동일사용자인지 확인할때 sessionId로 쿠키사용
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName()+ " : "+cookie.getValue());
			if(cookie.getName().equals("lastAccessTime")) {
				// 방문시간 알려주기. 
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
		// 쿠키 사용하려면 response사용. 쿠키 업데이트
		response.addCookie(lastAccessTime());
		
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
	
	private Cookie lastAccessTime() {
		// 사람이 볼 수 있는 형태로 바꿔주기 위한 SimpleDateFormat
		// 아규먼트로들어가는 형태로 문자로 바꿔주는 것
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date());
		
		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8"));
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// setMaxAge(초 * 분 * 시간 * 일)
		cookie.setMaxAge(60 * 60 * 24 * 30);
		// 사이트전체에 쿠키를 심겠다는 뜻 /=context root 그밑으로 다 가능
		cookie.setPath("/");
		
		return cookie;
	}
}