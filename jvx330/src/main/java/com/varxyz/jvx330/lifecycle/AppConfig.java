package com.varxyz.jvx330.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifecycle.example1.Dog;
import com.varxyz.jvx330.lifecycle.example2.Eagle;
import com.varxyz.jvx330.lifecycle.example3.Goat;

@Configuration
public class AppConfig {
	
	/**
	 * * xml로 적었을 때*
	 * <bean name="dog" class="com.varxyz.jvx330.lifecycle.example1.Dog">
	 * 	<constructor-arg index="0" type="java.lang.String" value="플루토"/>
	 * 	<property name="name" value="볼트"/>
	 * </bean>
	 * @return
	 */
	
	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
	}
	
	@Bean(initMethod = "attachWings", destroyMethod = "detachWings")
	public Eagle eagle() {
		Eagle eagle = new Eagle();
		eagle.setName("에디");
		return eagle;
	}
	
	@Bean
	public Goat goat() {
		return new Goat();
	}
	
	@Bean
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
}
