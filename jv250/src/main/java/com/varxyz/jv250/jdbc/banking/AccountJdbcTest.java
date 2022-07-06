package com.varxyz.jv250.jdbc.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountJdbcTest {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		
		String id = "jv250";
		String passwd = "jv250";
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---->" + driver);
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---->" + url);
			
//			select(con);
//			insert(con);
			select(con);
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void select(Connection con) {
		String sql = "SELECT * FROM Account";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// while문을 통해 여러개의 결과를 받아옴
				// data type에 맞게 받아와야함
				long aid = rs.getLong("aid");
				String AccountNum = rs.getString("accountNum");
				String customerId = rs.getString("customerId");
				double balance = rs.getDouble("balance");
				char accountType = rs.getString("accountType").charAt(0);
				System.out.println("aid : " + aid);
				System.out.println("customerId : " + customerId);
				System.out.println("balance : " + balance);
				if (accountType == 'S') {
					System.out.println("accountType : SavingsAccount");
				} else {
					System.out.println("accountType : CheckingAccount");
				}
			}
			pstmt.close();
			System.out.println("Select Compeleted----------------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(Connection con) {
		String sql = "INSERT INTO Account (accountNum, balance, overdraft, accountType, customerId) Values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "333-51-9982");
			pstmt.setDouble(2, 29000);
			pstmt.setDouble(3, 100000);
			pstmt.setString(4, String.valueOf('S'));
			pstmt.setInt(5, 101);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("New Account Inserted----------------------------------\n");
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
