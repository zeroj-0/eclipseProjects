package com.varxyz.jv200.mod008;

public class AddArguments {
	public static void main(String[] args) {
		int sum = 0;
		for (String arg : args) {
			sum += Integer.parseInt(arg);
		}
		System.out.println("Sum = " + sum);
	}
}
