package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowireTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MemberController controller = context.getBean("memberControllor", MemberController.class);
		controller.processRequest();
		
		context.close();
	}
}
