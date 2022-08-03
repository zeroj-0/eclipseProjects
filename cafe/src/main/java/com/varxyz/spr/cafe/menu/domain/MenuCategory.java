package com.varxyz.spr.cafe.menu.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuCategory {
	private long cid;
	private String mainTitle;
	private String subTitle;
	private Date regDate;
	
	public MenuCategory() {};
	public MenuCategory(String mainTitle, String subTitle) {
		super();
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
	}
	public MenuCategory(long cid, String mainTitle, String subTitle) {
		super();
		this.cid = cid;
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
	}
	public MenuCategory(long cid) {
		super();
		this.cid = cid;
	}
}
