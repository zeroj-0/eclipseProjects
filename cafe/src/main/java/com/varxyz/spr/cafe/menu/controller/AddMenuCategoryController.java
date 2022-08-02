package com.varxyz.spr.cafe.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.spr.cafe.menu.container.CategoryContainer;
import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuCategoryCommand;
import com.varxyz.spr.cafe.menu.service.MenuCategoryService;

@Controller("menu.controller.addMenuCategoryController")
public class AddMenuCategoryController {
	
	@Autowired
	private MenuCategoryService menuCategoryService;
	@Autowired
	private CategoryContainer categoryContainer;
	
	@GetMapping("/add_category")
	public String addCategoryForm(Model model) {
		model.addAttribute("menuCategory", new MenuCategoryCommand());
		return "cafe/add_category";
	}
	
	@PostMapping("/add_category")
	public String addCategory(HttpSession session, HttpServletResponse response, Model model, @ModelAttribute("menuCategory")MenuCategoryCommand menuCategory) {
		List<String> err = new ArrayList<String>();
		if(menuCategory.getMainTitle() == null || menuCategory.getMainTitle().length() == 0) {
			err.add("대분류를 입력하지 않으셨습니다.");
		}
		if (menuCategory.getSubTitle() == null || menuCategory.getSubTitle().length() == 0) {
			err.add("소분류를 입력하지 않으셨습니다.");
		}
		
		if(err.size() > 0) {
			model.addAttribute("error", err);
			return "error/category";
		}
		
		menuCategoryService.addCategory(menuCategory);
		categoryContainer.setCategoryList(menuCategoryService.getMenuCategory());
//		List<MenuCategory> categoryList = menuCategoryService.getMenuCategory();
		session.setAttribute("categoryList", categoryContainer.getCategoryList());
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>alert('정상처리 되었습니다.');location.href='/cafe/';</script>"); // 경고창 띄우기
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/";
	}
}
