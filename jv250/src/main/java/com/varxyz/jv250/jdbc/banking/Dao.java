package com.varxyz.jv250.jdbc.banking;

public class Dao {
	protected static final String JDBC_DRIVER= "com.mysql.cj.jdbc.Driver";
	protected static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	
	protected static final String JDBC_USER = "jv250";
	protected static final String JDBC_PASSWORD = "jv250";
	
	public Dao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ---->" + JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
