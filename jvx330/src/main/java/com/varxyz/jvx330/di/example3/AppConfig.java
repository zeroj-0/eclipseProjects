package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정관련 클래스라고 선언하는 것
@Configuration
public class AppConfig {
	
	// xml에서 <Bean>태그 대신하는 @Bean
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
