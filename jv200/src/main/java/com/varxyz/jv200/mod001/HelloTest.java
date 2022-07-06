package com.varxyz.jv200.mod001;

public class HelloTest {
	public static void main(String[] args) {
//		System.out.println(h.sayHello());
		
		Hello h = new Hello("유빈");
		Hello h1 = new Hello("유빈");
		
		boolean isTrue = h.equals(h1);
		System.out.println(isTrue); // false
		System.out.println(h == h1); // false
		// false 나오는 이유: 객체는 heap에다가 저장되고 reference값으로 비교하기 때문임
		
		String he = "유빈";
		String he1 = "유빈";
		
		boolean isTrue2 = he.equals(he1);
		
		System.out.println(isTrue2); // true
		System.out.println(he == he1); // true
		// true 나오는 이유: primitive type으로 저장되어서 stringpool에 저장됨 그래서 같은 값을 가리키고 있기 때문에 같다고 나오는 것임.
		
		/**
		 * 참고자료 : https://doohong.github.io/2018/03/04/java-string-pool/
		 */
	}
}