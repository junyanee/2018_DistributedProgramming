package com.spring.input.dao;

import java.util.ArrayList;

import com.spring.input.logic.Item;

public interface ItemDao {

	void create(Item item);
	void delete(Item item);
	
	ArrayList<Item> findAll();
	
	Item findByItemId (String itemId);
	Item findByItemName(String itemName);
}