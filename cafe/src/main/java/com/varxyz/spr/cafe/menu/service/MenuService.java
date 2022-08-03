package com.varxyz.spr.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.cafe.menu.domain.MenuItem;
import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;
import com.varxyz.spr.cafe.menu.repository.MenuItemRepository;

@Service("menu.service.menuService")
public class MenuService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	public void addMenuItem(MenuItemCommand menuItem) {
		menuItemRepository.addMenuItem(menuItem);
	}

	public List<MenuItem> getMenuItems() {
		
		return menuItemRepository.getMenuItems();
	}
}
