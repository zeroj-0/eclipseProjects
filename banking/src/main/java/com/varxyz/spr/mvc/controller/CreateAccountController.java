package com.varxyz.spr.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("controller.createAccountController")
public class CreateAccountController {
	
	@PostMapping("/account/")
	public String createAccountForm() {
		return "account/create_account";
	}
}
