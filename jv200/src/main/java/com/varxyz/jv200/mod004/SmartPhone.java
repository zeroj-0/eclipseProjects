package com.varxyz.jv200.mod004;

public class SmartPhone extends Product {
	
	private boolean apple = false;
	
	public SmartPhone(String name) {
		super(name);
		if(getName().startsWith("Apple")) {
			apple = true;
		}
	}
	
	public double getPrice() {
		if(apple) {
			return 30000.0;
		} else {			
			return 1500.0;
		}
	}

	public String getPlatform() {
		if(apple) {
			return "Android";
		} else {
			return "Apple";
		}
	}
	
	public String createCompany() {
		if(apple) {
			String create = "apple";
			return create;
		} else {
			String create = "samsung";
			return create;
		}
	}
}
