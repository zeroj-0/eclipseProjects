package com.varxyz.jvx330.di.example6;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MenuController controller = context.getBean("menuController", MenuController.class);
		controller.addMenuItem("아이스아메리카노",3500.0);
		controller.addMenuItem("아이스바닐라라떼",5000.0);
		controller.addMenuItem("아이스티",2500.0);
		
		controller.getMenuList().forEach(item -> System.out.println(item.getName() + " : " + item.getPrice()));
		
		System.out.println(controller.findMenuItemByMenuName("아이스아메리카노").getName());
		
		context.close();
	}

}
