package com.varxyz.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.jvx330.jdbc.Customer;

public class AddCustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public AddCustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 1. jdbcTemplate 쓰는 방법 중 첫번째
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone) VALUES (?,?,?,?,?)";
		
		// jdbc template에서 connection없이 preparedStatement를 만ㄴ들어주는 메소드가 존재
		// 나머지는 알아서해주지만 pstmt의 역할만 우리가 해줘야함
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			// preparedStatementCreator는 인터페이스라 이것의 메소드를 재정의해서 사용해 객체로 사용하는 것을 말한다
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				
				return pstmt;
			}
		});
	}
	
	// 2. jdbcTemplate 쓰는 방법 중 두번째
	public void addCustomer2(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(), customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	public long addCustomer3(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone) VALUES (?,?,?,?,?)";
		
		// keyholder에다가 cid넣음
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"cid"});
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getSsn());
			pstmt.setString(5, customer.getPhone());
			return pstmt;
		};
//		keyholder값을 다시 넣어주는것
		jdbcTemplate.update(creator, keyHolder);
		return keyHolder.getKey().longValue();
	}
}
