package com.varxyz.jvx330.di.example6;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

/**
 * 신규 MenuItem 등록
 * 등록된 모든 메뉴 조회
 * 메뉴이름으로 메뉴 검색
 * @author Administrator
 *
 */
public class MenuController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	public void addMenuItem(String name, double price) {
		menuItemService.addMenuItem(name, price);
	}
	
	public List<MenuItem> getMenuList() {
		return menuItemService.getMenuList();
	}
	
	public MenuItem findMenuItemByMenuName(String name) {
		return menuItemService.findMenuItemByMenuName(name);
	}
}
