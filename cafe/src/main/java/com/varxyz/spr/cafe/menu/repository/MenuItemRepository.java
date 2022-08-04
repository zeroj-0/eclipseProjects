package com.varxyz.spr.cafe.menu.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.spr.cafe.menu.domain.MenuItem;
import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;

@Repository("menu.repository.menuItemRepository")
public class MenuItemRepository {
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuItemRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addMenuItem(MenuItemCommand menuItem) {
		String sql = "INSERT INTO MenuItem (cid, mainTitle, subTitle, name, cost, imgURL, explanation) VALUES (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, menuItem.getMenucategory().getCid(), menuItem.getMainTitle(), menuItem.getSubTitle(), menuItem.getName(), menuItem.getCost(), menuItem.getImgURL(), menuItem.getExplanation());
	}

	public List<MenuItem> getMenuItems() {
		String sql = "SELECT mid, cid, name, cost, imgURL, explanation FROM MenuItem ORDER BY mainTitle DESC";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
	
}
