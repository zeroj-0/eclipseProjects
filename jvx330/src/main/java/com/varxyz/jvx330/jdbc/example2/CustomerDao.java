package com.varxyz.jvx330.jdbc.example2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		
		// RowMapper는 인터페이스라 이것의 메소드를 재정의해서 사용해 객체로 사용하는 것을 말한다 (인터페이스는 객체를만들수없음)
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			// ResultSet가지고 골라내라
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
		});
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer WHERE DATE(regDate)=?";
		
		// 조건문을 통한 query() <- argument 3개 들어감
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		},  regDate);
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer WHERE email=?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), rs.getString("passwd"), rs.getString("name"), rs.getString("ssn"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		},  email);
	}
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
