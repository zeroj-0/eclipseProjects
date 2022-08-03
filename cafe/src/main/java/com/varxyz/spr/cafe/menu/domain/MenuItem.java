package com.varxyz.spr.cafe.menu.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {
	private long mid;
	private String name;
	private double cost;
	private String imgURL;
	private String explanation;
	private MenuCategory category;
	private Date regDate;
	
	public MenuItem() {}

	public MenuItem(long mid, String name, double cost, String imgURL, String explanation, MenuCategory category) {
		super();
		this.mid = mid;
		this.name = name;
		this.cost = cost;
		this.imgURL = imgURL;
		this.explanation = explanation;
		this.category = category;
	};
	
}
