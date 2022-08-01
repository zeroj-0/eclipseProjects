package com.varxyz.jvx330.lifecycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;


public class Dog implements InitializingBean, DisposableBean{
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void destroy() throws Exception {
		// 빈이 제거되고 난 후에 불려지는 메소드
		System.out.println("destroy 호출");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// property가 설정되고 난 후에 불려지는 메소드
		System.out.println("afterPropertiesSet 호출");
		if(name == null) {
			System.out.println("Property name must be set");
		} else {
			System.out.println(name);
		}
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dog's final name : " + dog.getName());
		
		context.close();
	}

}
