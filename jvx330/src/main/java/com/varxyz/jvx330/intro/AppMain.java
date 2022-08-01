package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		// 위치정보 알려주기
		String config="com/varxyz/jvx330/intro/beans.xml";
		
		// 읽어드리기
		// bean 사용하기 위해서 spring container 얻어오기 !_!!_!_!_!_!!!!___!!!
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		// getBean의 return 타입이 Object
		// getBean( bean에 등록한 name 작성, casting할 클래스이름.class)
		Hello hello = context.getBean("helloBean", Hello.class);
		System.out.println(hello.sayHello("Spring"));
		context.close();
		
//		Hello hi = new HelloBeanEn();
//		System.out.println(hi.sayHello("spring"));
	}
}
