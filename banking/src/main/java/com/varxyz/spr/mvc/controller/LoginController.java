package com.varxyz.spr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
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
	public String loginForm() {
		return "domain/login";
	}
	
	// 로그인
	@PostMapping("/domain/login")
	public String login(HttpServletRequest request, @RequestParam(value="userId", required = true) String id, @RequestParam String passwd) {
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
