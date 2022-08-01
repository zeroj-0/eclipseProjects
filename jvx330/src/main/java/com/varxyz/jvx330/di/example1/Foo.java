package com.varxyz.jvx330.di.example1;

public class Foo {
	private Bar bar;
	
	public Foo() {
		System.out.println("Foo() constructor is called");
	}
	public Foo(Bar bar) {
		this.bar = bar;
		System.out.println("Foo(bar) constructor is called");
	}

	// 정의 되어있는 약속 property
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar() is called");
	}
	
	public String toString() {
		return "[Foo : " + hashCode() + "]";
	}
}
