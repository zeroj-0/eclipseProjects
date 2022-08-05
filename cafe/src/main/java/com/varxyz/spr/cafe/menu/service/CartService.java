package com.varxyz.spr.cafe.menu.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.cafe.menu.domain.Cart;
import com.varxyz.spr.cafe.menu.domain.LineItem;
import com.varxyz.spr.cafe.menu.domain.MenuItem;

@Service("menu.service.cartService")
public class CartService {

	@Autowired
	private Cart cart;
	
	public void addMenuItem(MenuItem menuItem) {
		boolean flag = true;
		
		for(LineItem lineitem : cart.getLineItemList()) {
			if(lineitem.getMenuItem().getName().equals(menuItem.getName())) {
				//같은 이름이 존재할때 처리.
				//수량증가
				lineitem.setCount(lineitem.getCount()+1);
				flag = false;
			}
		}
		
		if(flag == true) {
			addMenuItemObject(menuItem);	
		}
		
	}
	
	public void addMenuItemObject(MenuItem menuItem) {
		LineItem cartItem = new LineItem();
		cartItem.setMenuItem(menuItem);
		
		cart.getLineItemList().add(cartItem);
	}
	
	public List<LineItem> getLinItems() {
		return cart.getLineItemList();
	}

	public void deleteLineItem(long id) {
		LineItem i = new LineItem();
		for(LineItem lineitem : cart.getLineItemList()) {
			if(lineitem.getMenuItem().getMid() == id) {
				i = lineitem;
			}
		}
		cart.getLineItemList().remove(i);
	}
	

}
