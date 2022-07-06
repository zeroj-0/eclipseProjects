package com.varxyz.jv200.mod007;

/**
 *  abstract메소드의 집합, 상수(public)
 *  인스턴스 생성 불가
 *  다중 상속 지원
 *  
 * @author Administrator
 *
 */
public interface Flyer {
	// interface안에서는 abstract이라는 keyword 생략가능. interface는 default가 abstract임
	public void fly();
	public void takeOff();
	public void land();
}
