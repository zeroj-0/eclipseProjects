package com.varxyz.spr.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.varxyz.spr.mvc.domain.Customer;

@Repository("repository.customerDao")
public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userId, passwd, name, ssn, phone) VALUES (?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, customer.getUserId());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				
				return pstmt;
			}
		});
	}

	public List<Map<String,String>> isValidCustomer(String userId, String passwd) {
		System.out.println(userId);
		System.out.println(passwd);
		String sql = "SELECT userId, passwd FROM Customer WHERE userId=?";
		Map<String,String> map = new HashMap<String, String>();
		return jdbcTemplate.query(sql, new RowMapper<Map<String,String>>() {

			@Override
			public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
				while(rs.next()) {	
//					map.put("userId", rs.getString("userId"));
//					map.put("passwd", rs.getString("passwd"));
				}
				return map;
			}
		}, userId);
	}

	public Customer getCidByUserId(String userId) {
		String sql = "SELECT cid FROM Customer WHERE userId=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"));
				return customer;
			}
			
		}, userId);
	}
}
