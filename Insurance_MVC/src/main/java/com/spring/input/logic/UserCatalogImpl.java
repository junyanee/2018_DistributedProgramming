package com.spring.input.logic;

import java.util.ArrayList;

import com.spring.input.dao.UserDao;

public class UserCatalogImpl implements UserCatalog {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void entryUser(User user) {
		this.userDao.create(user);
	}
	
	public ArrayList<User> getUserList() {
		return this.userDao.findAll();
	}
	
	public User getUserByUserId(String userId) {
	      return this.userDao.findByUserId(userId);
	   }
}