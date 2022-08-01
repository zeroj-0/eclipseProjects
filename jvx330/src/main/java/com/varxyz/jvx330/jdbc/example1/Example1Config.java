package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.varxyz.jvx330.jdbc.DataSourceConfig;

/**
 * 이 example에 필요한 것들만 관리하겠다
 * @author Administrator
 */
@Configuration
@Import(DataSourceConfig.class)
public class Example1Config {

	
}
