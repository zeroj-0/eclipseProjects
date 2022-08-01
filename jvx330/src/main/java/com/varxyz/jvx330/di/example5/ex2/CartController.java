package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	@Autowired
	// 내가 원하는 타입 지정
	@Qualifier("sessionCartService")
	private CartService service;
	
	@Autowired
	// 내가 원하는 타입 지정
	@Qualifier("cookieCartService")
	private CartService service2;
	
	public CartController() {
		System.out.println("CartController 생성");
	}
	
	public void processResult() {
		service.addItem();
		service2.addItem();
	}
}
