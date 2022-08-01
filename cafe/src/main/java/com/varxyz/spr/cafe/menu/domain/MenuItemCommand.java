package com.varxyz.spr.cafe.menu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private String name;
	private double cost;
	private String imgURL;
}
