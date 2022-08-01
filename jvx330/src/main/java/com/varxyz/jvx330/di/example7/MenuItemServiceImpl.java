package com.varxyz.jvx330.di.example7;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 빈이름으로 자기 자신을 소개(?)하는 것
@Component("menuItemService")
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	private MenuItemDao itemDao;
	
	@Override
	public void addMenuItem(MenuItem item) {
		itemDao.save(item);
	}
	
	@Override
	public List<MenuItem> getAllMenuItemList() {
		return itemDao.findAllMenuItemList();
	}
	
	@Override
	public MenuItem getMenuItem(String name) {
		return itemDao.findByName(name);
	}
}
