package com.varxyz.jv200.mod005;

public class Libary {
	
	private static Libary lb = new Libary(); 
	private Book[] books = new Book[100];
	
//	private Libary() {};

// 모든 학과(부)에서 산 책들은 모두 하나의 도서관에 저장된다 => static
//	static메소드 안에서 인스턴스변수 못씀. 그래서 변수에다가 static붙여줘야함
	public static Libary getInstance() {
//		원래는 return this.lb;
		return lb;
	}

	public void addBook(Book book) {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = book;
				break;
			} 
			if (i == 99) {
				Book[] books2 = new Book[200];
				System.arraycopy(books, 0, books2, 0, books.length);
				books = books2;
			}
		}
	}
	
	public void check() {
		for(int i = 0; i < books.length; i++) {
			System.out.println(books[i].getSerial());
		}
	}

	public void getBook(int serial) {
		for (int i = 0; i < books.length; i++) {			
			if (books[i] != null) {
				if(books[i].getSerial()  == serial) {				
					System.out.println("대출하였습니다.");
				}
			} else {
				System.out.println("대출불가");
			};
		};
		if (serial > 200) {
			System.out.println("해당 책은 존재하지 않습니다.");
		}
	}

}
