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
}
