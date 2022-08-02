package com.varxyz.spr.cafe.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;
import com.varxyz.spr.cafe.menu.repository.MenuItemRepository;

@Service("menu.service.menuService")
public class MenuService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	public void addMenuItem(MenuItemCommand menuItem) {
		menuItemRepository.addMenuItem(menuItem);
	}
}
