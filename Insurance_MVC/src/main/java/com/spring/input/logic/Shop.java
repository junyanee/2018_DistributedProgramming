package com.spring.input.logic;

import java.util.ArrayList;

public interface Shop {
	
	void entryItem (Item item);
	void entryUser (User user);

	ArrayList<Item> getItemList();
	ArrayList<User> getUserList();

	Item getItemByItemId(String itemId);
	Item getItemByItemName(String itemName);
	User getUserByUserId(String userId);
}