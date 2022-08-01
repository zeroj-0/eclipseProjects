package com.varxyz.spr.cafe.menu.repository;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("menu.repository.menuRepository")
public class MenuRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
