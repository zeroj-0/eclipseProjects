package com.varxyz.spr.cafe.menu.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuItem;
import com.varxyz.spr.cafe.menu.service.MenuCategoryService;
import com.varxyz.spr.cafe.menu.service.MenuService;

@Controller("menu.controller.cafeController")
public class CafeController {
	
	private static final String SAVE_DIR = "C:/JAVA_lgm/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/cafe/resources/img/";
	
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
		model.addAttribute("imgPath", SAVE_DIR);
		
		return "cafe/order/orderPage";
	}
	
	@GetMapping("/order/{mainTitle}")
	public String orderPageMainTitleSelect(@PathVariable String  mainTitle,  Model model) {
		List<MenuCategory> menuCategory = menuCategoryService.getMenuCategory();
		List<MenuCategory> categoryMainTitleList = menuCategoryService.getMenuCategoryMainTitle();
		List<MenuItem> menuItemList = menuService.getMenuItems();
		
		List<MenuCategory> categorySubTitleList =  new ArrayList<>();
		List<MenuItem> menuItem = new ArrayList<>();
		
		for(MenuItem item : menuItemList) {
			if(item.getCategory().getMainTitle().equals(mainTitle)) {
				menuItem.add(item);
			}
		}
		
		for(MenuCategory category : menuCategory) {
			if(category.getMainTitle().equals(mainTitle)) {
				categorySubTitleList.add(category);
			}
		}
		
		model.addAttribute("maintitle", mainTitle);
		model.addAttribute("items", menuItem);
		model.addAttribute("category", menuCategory);
		model.addAttribute("categoryMainTitleList", categoryMainTitleList);
		model.addAttribute("categorySubTitleList", categorySubTitleList);

		model.addAttribute("imgPath", SAVE_DIR);
		return "cafe/order/orderPage";
	}
	
	@GetMapping("/order/{mainTitle}/{subTitle}")
	public String orderPageSubTitleSelect(@PathVariable String mainTitle, @PathVariable String subTitle, Model model) {
		List<MenuCategory> menuCategory = menuCategoryService.getMenuCategory();
		List<MenuCategory> categoryMainTitleList = menuCategoryService.getMenuCategoryMainTitle();
		List<MenuItem> menuItemList = menuService.getMenuItems();
		
		List<MenuCategory> categorySubTitleList =  new ArrayList<>();
		List<MenuItem> menuItem = new ArrayList<>();
		
		for(MenuItem item : menuItemList) {
			if(item.getCategory().getMainTitle().equals(mainTitle)) {
				menuItem.add(item);
			}
		}
		
		for(MenuCategory category : menuCategory) {
			if(category.getMainTitle().equals(mainTitle)) {
				categorySubTitleList.add(category);
			}
		}
		
		model.addAttribute("maintitle", mainTitle);
		model.addAttribute("items", menuItem);
		model.addAttribute("category", menuCategory);
		model.addAttribute("categoryMainTitleList", categoryMainTitleList);
		model.addAttribute("categorySubTitleList", categorySubTitleList);

		model.addAttribute("imgPath", SAVE_DIR);
		return "cafe/order/orderPage";
	}
}
