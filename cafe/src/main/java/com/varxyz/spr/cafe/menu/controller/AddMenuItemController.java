package com.varxyz.spr.cafe.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;
import com.varxyz.spr.cafe.menu.service.MenuCategoryService;
import com.varxyz.spr.cafe.menu.service.MenuService;

@Controller("menu.controller.addMenuItemController")
public class AddMenuItemController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuCategoryService menuCategoryService;
	
	@GetMapping("/add_menuItem")
	public String addMenuItemForm(Model model) {
		model.addAttribute("menuItem", new MenuItemCommand());
		List<MenuCategory> categoryList = menuCategoryService.getMenuCategory();
		List<MenuCategory> categoryMainTitleList = menuCategoryService.getMenuCategoryMainTitle();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryMainTitleList", categoryMainTitleList);
		
		return "cafe/add_menuItem";
	}
	
	@PostMapping("/add_menuItem")
	public String addMenuItem(HttpServletResponse response, @ModelAttribute("menuItem")MenuItemCommand menuItem, Model model, @RequestParam(value="imgURL") String url,
			@RequestParam(value="mainTitle") String mainTitle, @RequestParam(value="subTitle") String subTitle) {
		model.addAttribute("menuItem", menuItem);
		menuItem.setImgURL(url);
		MenuCategory category = menuCategoryService.getCidByMainTitleSubTitle(mainTitle, subTitle);
		menuItem.setMenucategory(category);
		
		List<String> err = new ArrayList<String>();
		if(menuItem.getMainTitle() == null || menuItem.getMainTitle().length() == 0) {
			err.add("대분류를 입력하지 않으셨습니다.");
		}
		if (menuItem.getSubTitle() == null || menuItem.getSubTitle().length() == 0) {
			err.add("소분류를 입력하지 않으셨습니다.");
		}
		if (menuItem.getName() == null || menuItem.getName().length() == 0) {
			err.add("상품명을 입력하지 않으셨습니다.");
		}
		if (menuItem.getImgURL() == null || menuItem.getImgURL().length() == 0) {
			err.add("사진 선택하지 않으셨습니다.");
		}
		
		if(err.size() > 0) {
			model.addAttribute("error", err);
			return "error/category";
		}
		
		menuService.addMenuItem(menuItem);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>alert('정상처리 되었습니다.');location.href='/cafe/add_menuItem';</script>"); // 경고창 띄우기
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/cafe/menuItem";
	}

}
