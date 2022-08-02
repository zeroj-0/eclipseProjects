package com.varxyz.spr.cafe.menu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;

public class MenuCategoryRowMapper implements RowMapper<MenuCategory> {

	@Override
	public MenuCategory mapRow(ResultSet rs,  int rowNum) throws SQLException {
		MenuCategory category = new MenuCategory(rs.getLong("cid"), rs.getString("mainTitle"), rs.getString("subTitle"));
		return category;
	}

}
