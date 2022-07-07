package com.varxyz.jv301.mod009;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	DataSource dataSource = null;
	
	public UserDao() {
		NamingService namingService = NamingService.getInstance();
		dataSource = (DataSource)namingService.getAttribute("dataSource");
	}
	
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM User";
		List<User> userList = new ArrayList<User>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					User user = new User();
					user.setUserId(rs.getString("id"));
					user.setUserName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
					
					userList.add(user);
				}
			} finally {
				dataSource.close(rs, pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public void addUser(User user) {
		String sql = "INSERT INTO User(id,passwd,name,email,addr) VALUES (?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddr());
			
			pstmt.executeUpdate();
			dataSource.close(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
