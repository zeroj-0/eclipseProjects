package com.varxyz.jv200.mod007;

public class FlyerTest {

	public static void main(String[] args) {
		Flyer f = new Airplane();
		f.takeOff();
		
		Flyer f2 = new Bird();
		f2.takeOff();
		
		Airplane air = new KoreanAirplane();
		air.boradCast();
	}

}
