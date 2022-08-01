package com.varxyz.jvx330.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Horse implements InitializingBean, DisposableBean {
	
	private static int count;
	
	public Horse() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	/**
	 * prototype 은 override해도 찍히지 않음
	 * singleton만 !
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("horse destroy 호출");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("horse afterpropertiesset 호출");
	}
	
	/**
	 * 1. InitializingBean, DisposableBean 인터페이스를 이용해서 초기화하는 방법
	 * 
	 * 2. 빈생성 클래스에서 초기화하는방법
	 * 
	 * 3. 클래스내에서 처리하는 방법
	 * 		@PostConstruct 붙여서 초기화
	 * 			public void initMenuData() {}
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		
		System.out.println("Horse's final count : "+Horse.getCount());
		
		context.close();
	}

}
