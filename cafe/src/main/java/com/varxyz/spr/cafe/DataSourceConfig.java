package com.varxyz.spr.cafe;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul");
		ds.setUsername("jvx330");
		ds.setPassword("jvx330");
		
		// pool과 관련된 작업
		ds.setInitialSize(2);		// connection pool 초기화시 생성할 초기 connection 갯수 (default 10)
		ds.setMaxActive(10); 	// pool에서 가져올 수 있는 최대 connection 갯수 (default 100)
		ds.setMaxIdle(10);		// pool에 유지할 수 있는 최대 connection 수 (default maxActive와 동일)
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		// java spring에서 지원해주는 jdbc 템플릿
		return new JdbcTemplate(dataSource());
	}
	
}
