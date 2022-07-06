package com.varxyz.jv250.jdbc.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDao {
	private static final String JDBC_DRIVER= "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWORD = "jv250";
	
	public CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ---->" + JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<Customer>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Customer c= new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("customerId"));
					customerList.add(c);
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	/**
	 * 주민번호 고객 조회
	 * @param ssn
	 * @return
	 */
	public Customer findCustomerBySSn(String ssn) {
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("customerId"));
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 신규 고객 등록
	 * @param customer			등록할 고객정보
	 */
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone, customerId, passwr) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getCustomerId());
			pstmt.setString(5, customer.getPasswd());
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			System.out.println("-----------------------INSERTED-----------------------");
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
