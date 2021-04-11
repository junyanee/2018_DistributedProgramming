package com.spring.input.dao;

import java.util.ArrayList;

import com.spring.input.logic.User;

public interface UserDao {

	void create(User user);

	ArrayList<User> findAll();

	User findByUserId(String userId);
}