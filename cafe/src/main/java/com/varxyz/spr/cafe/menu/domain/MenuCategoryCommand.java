package com.varxyz.spr.cafe.menu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuCategoryCommand {
	private String mainTitle;
	private String subTitle;
	
	public MenuCategoryCommand() {};
	
	public MenuCategoryCommand(String mainTitle, String subTitle) {
		super();
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
	}
}
