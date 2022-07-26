package com.varxyz.spr.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/domain/main")
	public ModelAndView myMain() {
		String str = "안녕하세요!";
		String str2 = "JAVA SPRING";
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("domain/main");
		mav.addObject("str", str);
		mav.addObject("str2", str2);
		
		return mav;
	}
}
