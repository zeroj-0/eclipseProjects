package com.varxyz.spr.cafe.menu.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuItem;
import com.varxyz.spr.cafe.menu.service.MenuCategoryService;
import com.varxyz.spr.cafe.menu.service.MenuService;

@Controller("menu.controller.cafeController")
public class CafeController {
	
	@Autowired
	private MenuCategoryService menuCategoryService;
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/")
	public String mainHomePage() {
		return "cafe/main";
	}
	
	@GetMapping("/management")
	public String managementPage() {
		return "cafe/management/managementPage";
	}
	
	@GetMapping("/order")
	public String orderPage(Model model) {
		List<MenuCategory> menuCategory = menuCategoryService.getMenuCategory();
		List<MenuCategory> categoryMainTitleList = menuCategoryService.getMenuCategoryMainTitle();
		List<MenuItem> menuItemList = menuService.getMenuItems();
		
		model.addAttribute("category", menuCategory);
		model.addAttribute("categoryMainTitleList", categoryMainTitleList);
		model.addAttribute("menuItemList", menuItemList);
		return "cafe/order/orderPage";
	}
}
