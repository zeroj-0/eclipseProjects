package com.varxyz.jvx330.di.example7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//패키지안에있는 모든것을 선택해 알아서 만들어라
@ComponentScan( basePackages =  {"com.varxyz.jvx330.di.example7"})
public class AppConfig {
	
}
