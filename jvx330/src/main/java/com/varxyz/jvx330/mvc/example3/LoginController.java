package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController")
public class LoginController {
	
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
//	@PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest request) {
		// form으로 보낸 아이디와 비밀번호 받기 위함
		// 아규먼트로 선언해주면 스프링에서 알아서 의존시켜줌
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		
		// 메소드 실행 시 나타나는 jsp 경로
		mav.setViewName("example3/login_result");
		
		return mav;
	}
	
	@PostMapping("/example3/login")
	// request의 파라메터를 뒤에 변수에다가 넣어줌
	// value="" 뭘 들고올것인지 required = true:반드시들어와야한다/false:반드시 필요없을수도있다 (default = true)
	public ModelAndView login(@RequestParam(value="userId", required = true) String id, @RequestParam String passwd) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("passwd", passwd);
		
		// 메소드 실행 시 나타나는 jsp 경로
		mav.setViewName("example3/login_result");
		
		return mav;
	}
}
