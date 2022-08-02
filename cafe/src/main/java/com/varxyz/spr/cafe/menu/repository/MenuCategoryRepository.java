package com.varxyz.spr.cafe.menu.repository;

import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuCategoryCommand;

@Repository("menu.repository.menuCategoryRepository")
public class MenuCategoryRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuCategoryRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addCategory(MenuCategoryCommand menuCategory) {
		String sql = "INSERT INTO Category (mainTitle, subTitle) VALUES (?,?)";
		jdbcTemplate.update(sql, menuCategory.getMainTitle(), menuCategory.getSubTitle());
	}
	
	public List<MenuCategory> getMenuCategory() {
		String sql = "SELECT cid, mainTitle, subTitle FROM Category ORDER BY mainTitle DESC";
		return jdbcTemplate.query(sql, new MenuCategoryRowMapper());
	}
	
	public List<MenuCategory> getMenuCategoryMainTitle() {
		String sql = "SELECT cid, mainTitle, subTitle FROM Category GROUP BY mainTitle";
		return jdbcTemplate.query(sql, new MenuCategoryRowMapper());
	}

}
