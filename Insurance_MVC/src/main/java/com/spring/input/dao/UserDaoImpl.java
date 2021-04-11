package com.spring.input.dao;

import java.util.ArrayList;

import com.spring.input.logic.User;

public class UserDaoImpl implements UserDao {

	public ArrayList<User> userList = new ArrayList<User>();

	public void create(User user) {
//		this.user.setAddress(user.getAddress());
//		this.user.setBirthDay(user.getBirthDay());
//		this.user.setEmail(user.getEmail());
//		this.user.setJob(user.getJob());
//		this.user.setPassword(user.getPassword());
//		this.user.setPostCode(user.getPostCode());
//		this.user.setUserId(user.getUserId());
		user.setUserId(user.getUserId());
//		this.user.setUserName(user.getUserName());
		
		userList.add(user);
	}
	
	public User getUser(String userId) {
		for(int i=0;i<this.userList.size();i++) {
			if (userList.get(i).getUserId() == userId)
				return userList.get(i);
		}
		
		return null;
			
	}
	
	public ArrayList<User> findAll() {
		return userList;
	}

	public User findByUserId(String userId) {
		User user = new User();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(userId)) {
				user = userList.get(i);
				break;
			}
		}
		return user;
	}
}
