package com.varxyz.jv200.mod005;

public class LibaryTest {

	public static void main(String[] args) {
		
		Libary libary = Libary.getInstance();
		
		for(int i=1; i<201; i++) {
			libary.addBook(new Book(i));
		}
		
//		libary.check();
		
		libary.getBook(105);
		libary.getBook(202);
		libary.getBook(250);
		
	}

}
