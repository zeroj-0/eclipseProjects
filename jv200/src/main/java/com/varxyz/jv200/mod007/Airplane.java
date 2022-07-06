package com.varxyz.jv200.mod007;

public class Airplane implements Flyer, Vehicle {

	public void fly() {
		System.out.println("비행기 : 날개");
	}

	public void takeOff() {
		System.out.println("비행기 : 이륙하기");
	}

	public void land() {
		System.out.println("비행기 : 착륙하기");		
	}
	
	public void boradCast() {
		System.out.println("탑승하세요");
	}
	
}
