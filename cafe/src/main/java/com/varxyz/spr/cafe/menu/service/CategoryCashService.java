package com.varxyz.spr.cafe.menu.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuCategoryCommand;
import com.varxyz.spr.cafe.menu.repository.MenuCategoryRepository;

@Component("categoryCashService")
public class CategoryCashService {
	// 카테고리 리스트 받아오기
	@Autowired
	private MenuCategoryRepository menuCategoryRepository;
	private List<MenuCategory> menuCategoryList;
	
	
	// @Postconstruct : 빈이 만들어지고 불러오는거
	// initialize()가지고 db에서 카테고리 불러옴
	@PostConstruct
	public void initialize() {
		menuCategoryList = menuCategoryRepository.getMenuCategory();
	}
	
	public void checkList(MenuCategoryCommand menuCategory) {
		for(MenuCategory category : menuCategoryList) {
			if(!category.getMainTitle().equals(menuCategory.getMainTitle())) {
				menuCategoryList = menuCategoryRepository.getMenuCategory();				
			}
			if(!category.getSubTitle().equals(menuCategory.getSubTitle())) {
				menuCategoryList = menuCategoryRepository.getMenuCategory();				
			}
		}
	}
	
	// 리스트.contains로 카테고리 있는지 확인 반복!
	// 없으면 db에서 다시 불러오기
	public List<MenuCategory> getCategories() {
		return menuCategoryList;
	}
}
