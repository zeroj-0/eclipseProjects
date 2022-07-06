package com.varxyz.jv200.mod001;

public class RandomVariable {

	public static void main(String[] args) {
		
		StringBuffer stringbuffer = new StringBuffer();
		for(int i = 0; i<3; i++) {
			int num = (int) (Math.random()*10);
			stringbuffer.append(num);			
		}
		stringbuffer.append("-");
		for(int i = 0; i<2; i++) {
			int num = (int) (Math.random()*10);
			stringbuffer.append(num);			
		}
		stringbuffer.append("-");
		for(int i = 0; i<4; i++) {
			int num = (int) (Math.random()*10);
			stringbuffer.append(num);			
		}
		
		System.out.println(stringbuffer.toString());
	}

}
