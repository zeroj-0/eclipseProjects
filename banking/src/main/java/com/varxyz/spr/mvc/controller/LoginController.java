package com.varxyz.spr.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.spr.mvc.service.BankingService;
import com.varxyz.spr.mvc.service.CustomerService;

@Controller("controller.loginController")
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/domain/login")
	public String loginForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 컨테이너를 유효하지 않는 것으로 표시
		session.invalidate();
		
		return "domain/login";
	}
	
	// 로그인
	@PostMapping("/domain/login")
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="userId", required = true) String id, @RequestParam String passwd) {
		if(id.length() == 0 || id == null) {
			if(passwd.length() == 0 || passwd == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer;
				try {
					writer = response.getWriter();
					writer.println("<script>alert('아이디와 비밀번호 입력해주세요'); location.href='/banking/domain/login';</script>"); // 경고창 띄우기
					writer.close(); 
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (!customerService.isValidUser(id, passwd)) {
			return "domain/login";
		}
		HttpSession session = request.getSession(true);
		long cid = customerService.getCidByUserId(id);
		session.setAttribute("cid", cid);
		session.setAttribute("userId", id);
		return "domain/menuList";
	}
	
	@GetMapping("/domain/menuList")
	public String menuList() {
		return "domain/menuList";
	}
}
