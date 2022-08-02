package com.varxyz.spr.cafe.menu.repository;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;

@Repository("menu.repository.menuItemRepository")
public class MenuItemRepository {
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuItemRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addMenuItem(MenuItemCommand menuItem) {
		String sql = "INSERT INTO MenuItem (cid, name, cost, imgURL, explanation) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, menuItem.getMenucategory().getCid(), menuItem.getName(), menuItem.getCost(), menuItem.getImgURL(), menuItem.getExplanation());
	}
	
	
}
