package com.varxyz.jv301.mod009;

import java.util.*;

public class UserService {
	private static final UserService service = new UserService();
	
	private UserDao userDao = new UserDao() ;
	
	List<User> userList = new ArrayList<User>();
	
	public static UserService getInstance() {
		return service;
	}
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}
}