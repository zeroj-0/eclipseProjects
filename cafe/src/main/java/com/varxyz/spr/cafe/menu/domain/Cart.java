package com.varxyz.spr.cafe.menu.domain;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	private List<LineItem> lineItemList;
	private int totalPrice;
	
	public Cart() {
		lineItemList = new ArrayList<>();
	}
	
}
