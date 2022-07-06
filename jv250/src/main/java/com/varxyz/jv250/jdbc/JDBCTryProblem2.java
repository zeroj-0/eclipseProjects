package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQl을 전달하기 위해 작성함
 * @author Administrator
 *
 */

public class JDBCTryProblem2 {
	public static void main(String[] args) {
		// MySQL driver (DB마다 다름)
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// DB 접속하기  = URL작성 (DB마다 다름)
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		
		//접근하기
		String id = "jv250";
		String passwd = "jv250";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			try {
				Class.forName(driver);
				System.out.println("LOADED DRIVER ---->" + driver);
				
				// Connection은 static
				con = DriverManager.getConnection(url, id, passwd);
				System.out.println("CONNECTED TO ---->" + url);
				
//			String sql = "SELECT * FROM Customer";
				String sql = "SELECT * FROM Account";
				
				// SQL을 driver를 통해 DB에 전해주면서 SQL실행
				stmt = con.prepareStatement(sql);
				
				// 쿼리 실행 후 테이블 결과 받아옴
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					// while문을 통해 여러개의 결과를 받아옴
					// data type에 맞게 받아와야함
					long aid = rs.getLong("aid");
					String AccountNum = rs.getString("AccountNum");
					String customerId = rs.getString("CustomerId");
					double balance = rs.getDouble("balance");
					String accountType = rs.getString("accountType");
					System.out.println("aid : " + aid);
					System.out.println("customerId : " + customerId);
					System.out.println("balance : " + balance);
					if (accountType .equals("S")) {
						System.out.println("accountType : SavingsAccount");
					} else {
						System.out.println("accountType : CheckingAccount");
					}
					System.out.println("----------------------------------------------------------");
				}
			} finally {
				rs.close();
				stmt.close();
				con.close();
			}
			// Connection관련된 것(Network)은 다 쓰고나서 Close해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
