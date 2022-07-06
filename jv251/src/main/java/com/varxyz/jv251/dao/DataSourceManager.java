package com.varxyz.jv251.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceManager {
	/**
	 * final 선언과 동시에 초기화해줘야한다. 유일하게 초기화 안해주려면 최소한 생성자에서(객체가 만들어지기전에 선언되어야한다)
	 * static은 클래스가 만들어지기전에 만들어줘서 static 과 final을 같이 붙여주면 생성자에다가 넣어도 의미없어진다.
	 * 생성자는 객체가만들어지면서 생성되기때문에
	 */
	private static final String JDBC_URL;
	private static final String JDBC_USER;
	private static final String JDBC_PASSWORD;
	
	/**
	 * static initializer(정적 초기자) -> static 과 final을 같이 붙여주면 생성자에다가 넣어도 의미없어지는 것을 보완
	 * 정보를 file에 저장
	 */
	static {
		// Properties -> Key=Value형식으로 파라미터 정보들을 저장하기 위한 파일 확장자
		Properties props = new Properties();
		try {
			// key와 value에 쌍으로 넣어줌
			props.load(new FileInputStream("jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(props.getProperty("JDBC_DRIVER"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 읽어들인것을 여기다 저장해라!
		JDBC_URL = props.getProperty("JDBC_URL");
		JDBC_USER = props.getProperty("JDBC_USER");
		JDBC_PASSWORD = props.getProperty("JDBC_PASSWORD");
		System.out.println("JDBC_URL = " + JDBC_URL);
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	/**
	 * Connection은 client한명을 바라보고 연결하기때문에 쓰고난뒤 close해줘야함
	 * @param rs
	 * @param pstmt
	 * @param con
	 * @throws SQLException
	 */
	public static void getConnectionClose(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		try {
			if ( rs != null ) {
				rs.close();				
			}
			if ( pstmt != null ) {				
				pstmt.close();
			}
			if ( con != null) {				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void getConnectionClose(PreparedStatement pstmt, Connection con) throws SQLException {
		getConnectionClose(null, pstmt, con);
	}
	
	public static void main(String[] args) {
		DataSourceManager manager = new DataSourceManager();
	}
}
