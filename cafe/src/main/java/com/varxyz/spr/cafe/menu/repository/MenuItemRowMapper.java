package com.varxyz.spr.cafe.menu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuItem;

public class MenuItemRowMapper implements RowMapper<MenuItem> {

	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuCategory category = new MenuCategory(rs.getLong("cid"));
		MenuItem menuItem = new MenuItem(rs.getLong("mid"), rs.getString("name"), rs.getDouble("cost"), rs.getString("imgURL"), rs.getString("explanation"), category);
		return menuItem;
	}

}
