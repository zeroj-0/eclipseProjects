package com.varxyz.jv200.mod004;

public class NoteBook extends Product {
	
	private boolean samsung = false;
	
	public NoteBook(String name) {
		super(name);
		if(getName().contains("Samsung")) {
			samsung = true;
		}
	}
	
	public double getPrice() {
		return 25000.0;
	}
	
	public String createCompany() {
		if(samsung) {
			String create = "samsung";
			return create;
		} else {
			String create = "LG";
			return create;
		}
	}
}
