package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQl을 전달하기 위해 작성함
 * @author Administrator
 *
 */

public class JDBCTryProblem {
	public static void main(String[] args) {
		// MySQL driver (DB마다 다름)
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// DB 접속하기  = URL작성 (DB마다 다름)
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		
		//접근하기
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---->" + driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String sql = "SELECT * FROM Customer WHERE name = '유비' ";
		
		try {
			
			// Connection은 static
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---->" + url);
			
//			String sql = "SELECT * FROM Customer";
			
			// SQL을 driver를 통해 DB에 전해줌
			Statement stmt = con.createStatement();
			// SQL을 실행
			stmt.executeQuery(sql);
			
			// 쿼리 실행 후 테이블 결과 받아옴
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				// while문을 통해 여러개의 결과를 받아옴
				// data type에 맞게 받아와야함
				long cid = rs.getLong("cid");
				String customerId = rs.getString("CustomerId");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				System.out.println("customer name : " + name);
				System.out.println("customerId : " + customerId);
				System.out.println("----------------------------------------------------------");
			}
			
			
			// Connection관련된 것(Network)은 다 쓰고나서 Close해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
