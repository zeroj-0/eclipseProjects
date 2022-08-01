package com.varxyz.spr.cafe.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("menu.controller.addMenuCategoryController")
public class AddMenuCategoryController {
	
	@GetMapping("/add_menuCategory")
	public String addCategoryForm(Model model) {
		model.addAttribute("menuCategory", new MenuCategoryCommand());
		return "cafe/add_menuCategory";
	}
}
