package com.varxyz.spr.cafe.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;

@Controller("menu.controller.addMenuItemController")
public class AddMenuItemController {
	
	@GetMapping("/add_menuItem")
	public String addMenuItemForm(Model model) {
		model.addAttribute("menuItem", new MenuItemCommand());
		return "cafe/add_menuItem";
	}
	
	@PostMapping("/add_menuItem")
	public void addMenuItem(@ModelAttribute("menuItem")MenuItemCommand menuItem, Model model, @RequestParam(value="imgURL") String url) {
		model.addAttribute("menuItem", menuItem);
		menuItem.setImgURL(url);
	}

}
