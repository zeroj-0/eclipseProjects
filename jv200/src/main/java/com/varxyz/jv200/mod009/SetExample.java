package com.varxyz.jv200.mod009;

import java.util.*;

public class SetExample {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add("second");
		set.add(new Integer(4)); // Integer안에 equals메소드가 자동으로 오버라이딩되어있는 것. 
		// 숫자 그 자체가 중요하다 !! -> Wrapper클래스들의 특징 
		// Wrapper클래스에 같은 값을 넣는다면 같은 객체가 아니더라도 같은 값으로 나옴
		
		System.out.println(set);
	}

}
