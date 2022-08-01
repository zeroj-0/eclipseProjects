package com.varxyz.jvx330.di.example6;

import java.util.*;

public class MenuItemService {
	
	private List<MenuItem> menuItemList = new ArrayList<>();
	
	public void addMenuItem(String name, double price) {
		MenuItem item = new MenuItem(name, price);
		menuItemList.add(item);
	}

	public List<MenuItem> getMenuList() {
		return menuItemList;
	}

	public MenuItem findMenuItemByMenuName(String name) {
		for(MenuItem item : menuItemList) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
}
