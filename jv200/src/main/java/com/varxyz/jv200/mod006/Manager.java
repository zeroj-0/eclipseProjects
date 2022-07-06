package com.varxyz.jv200.mod006;

public class Manager extends Empolyee {
	public String department;
	
	// Method Overriding
	public String getDetails() {
		return super.getDetails() + "\nDepartment: "+ department;
	}
}
