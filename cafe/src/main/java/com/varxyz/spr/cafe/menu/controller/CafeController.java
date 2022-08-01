package com.varxyz.spr.cafe.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("menu.controller.cafeController")
public class CafeController {
	
	@GetMapping("/")
	public String mainHomePage() {
		return "cafe/main";
	}
}
