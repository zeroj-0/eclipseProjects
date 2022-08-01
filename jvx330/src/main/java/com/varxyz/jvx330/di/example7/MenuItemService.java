package com.varxyz.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	/**
	 * 신규아이템 등록
	 * @param item
	 */
	 void addMenuItem(MenuItem item);
	 
	 /**
	  * 전체 메뉴 목록 가져오기
	  * @return
	  */
	 List<MenuItem> getAllMenuItemList();
	 
	 /**
	  * 메뉴이름 검색해 메뉴리턴
	  * @param name
	  * @return
	  */
	 MenuItem getMenuItem(String name);
	
}
