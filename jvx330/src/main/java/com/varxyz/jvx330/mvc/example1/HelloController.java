package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Controller역할을 하는 servlet이라 생각하기
@Controller
public class HelloController {
	
	// 외부에서 요청을 부르기 위한 어노테이션
	// 아무것도 안써주면 get방식(method 얘기하는거임)
	@RequestMapping("/example1/sayHello")
	public ModelAndView sayHello() {
		String greeting = "Hello! 스프링 MVC";
		
		// Model : 사용자한테 보여질 것 (=setAttribute) 속성이름과 속성값 같이 넘겨줌
		// View : 보낸 것이 보여질 jsp
		ModelAndView mav = new ModelAndView();
		
		// registry.jsp("/WEB-INF/views/", ".jsp") <- "example1/hello"앞뒤로 생략된거 !!!!!!! 이것이 configureViewResolvers()에서 해줌
		mav.setViewName("example1/hello");
		mav.addObject("greeting", greeting);
		
		return mav;
	}
}
