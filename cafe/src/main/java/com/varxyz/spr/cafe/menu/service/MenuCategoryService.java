package com.varxyz.spr.cafe.menu.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.varxyz.spr.cafe.menu.container.CategoryContainer;
import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuCategoryCommand;
import com.varxyz.spr.cafe.menu.repository.MenuCategoryRepository;

@Service("menu.service.menuCategoryService")
public class MenuCategoryService {
	
	@Autowired
	private MenuCategoryRepository menuCategoryRepository;
	@Autowired
	private CategoryContainer categoryContainer;
	@Autowired
	private CategoryCashService categoryCashService;
	
	public void addCategory(MenuCategoryCommand menuCategory) {
		menuCategoryRepository.addCategory(menuCategory);
		categoryCashService.checkList(menuCategory);
	}
	
	public List<MenuCategory> getMenuCategory() {
		return categoryCashService.getCategories();
	}
	public List<MenuCategory> getMenuCategoryMainTitle() {
		return menuCategoryRepository.getMenuCategoryMainTitle();
	}

	public MenuCategory getCidByMainTitleSubTitle(String mainTitle, String subTitle) {
		List<MenuCategory> categoryList = categoryCashService.getCategories();
		for(MenuCategory category : categoryList) {
			if(category.getMainTitle().equals(mainTitle) && category.getSubTitle().equals(subTitle)) {
				return category;
			}
		}
		return null;
	}
}
