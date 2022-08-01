package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		/**
		 * xml에서 쓰는 방식
		 * 
			String config = "com/varxyz/jvx330/di/example3/beans.xml";
			GenericApplicationContext context = new GenericXmlApplicationContext(config);
			MemberService service = context.getBean("memberService", MemberService.class);
			
			System.out.println(service.getAllMemebers());
			
			context.close();
		 */
		
		/**
		 * class로 관리하는 방식
		 */
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// getBean("@Bean으로 선언한 메소드 이름 들고오기", 클래스이름.class)
		MemberService service = context.getBean("memberService", MemberService.class);
		/**
		 * 	List<Member> list = service.getAllMembers();
		 * 	for(Member member : list) {
		 * 		System.out.println(member);
		 * 	}
		 * 
		 * 	아래와 같은 코드
		 * 	아래는 람다식 이용
		 */
		service.getAllMemebers().forEach(member -> System.out.println(member));
		context.close();
	}
}
