package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beas.xml";
		
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		// hashcode가 같다는 것은 객체가 같다는 것
		
		// 첫번째 빈(생성자 아규먼트 있는) 만들어져서 생성자 호출
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
		
		// 두번째 빈 만들어지면서 객체를 생성하는거라 생성자 호출되고 property 선언해줌으로서 setBar 사용
		Foo foo2 = context.getBean("foo2", Foo.class);
		System.out.println(foo2);
		
		context.close();
	}

}
