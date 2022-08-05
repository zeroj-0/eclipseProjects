package com.varxyz.spr.cafe.menu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
	private MenuItem menuItem;
	private int count=1;
	private int eachPrice;
	
	public LineItem() {
	}
	public LineItem(MenuItem menuItem, int count, int eachPrice) {
		super();
		this.menuItem = menuItem;
		this.count = count;
		this.eachPrice = eachPrice;
	}
	
	public int getEachPrice() {
		eachPrice = (int) (menuItem.getCost() * count) ;
		return eachPrice;
	}
	
}
