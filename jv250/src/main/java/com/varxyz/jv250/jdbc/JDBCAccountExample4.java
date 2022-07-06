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

public class JDBCAccountExample4 {
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
			
			// Connection은 static
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---->" + url);
			
			String sql = "DELETE FROM Account WHERE aid>=311 and aid<=314";
			
			// SQL을 driver를 통해 DB에 전해주면서 SQL실행
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// 쿼리 실행 후 테이블 결과 받아옴
			stmt.executeUpdate();
			
			
			stmt.close();
			con.close();
			
			// Connection관련된 것(Network)은 다 쓰고나서 Close해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
