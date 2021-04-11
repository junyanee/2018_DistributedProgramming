package com.spring.input.logic;

import java.util.ArrayList;

public interface UserCatalog {

	void entryUser (User user);
	User getUserByUserId (String userId);
	ArrayList<User> getUserList();

}