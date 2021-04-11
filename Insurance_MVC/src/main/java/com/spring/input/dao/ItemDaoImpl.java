package com.spring.input.dao;

import java.util.ArrayList;

import com.spring.input.logic.Item;

public class ItemDaoImpl implements ItemDao {

	public ArrayList<Item> itemList = new ArrayList<Item>();

	public void create(Item item) {
//	userµî·Ï	this.user.setUserName(user.getUserName());
		itemList.add(item);
	}
	
	public void delete(Item item) {
		itemList.clear();
	}
	
	public Item getItem(String itemId) {
		for(int i=0;i<this.itemList.size();i++) {
			if (itemList.get(i).getItemId() == itemId)
				return itemList.get(i);
		}
		
		return null;
			
	}

	@Override
	public ArrayList<Item> findAll() {
		return itemList;
	}

	@Override
	public Item findByItemId(String itemId) {
		Item item = new Item();
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemId().equals(itemId)) {
				item = itemList.get(i);
				break;
			}
		}
		return item;
	}
	public Item findByItemName(String itemName) {
		Item item = new Item();
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemName().equals(itemName)) {
				item = itemList.get(i);
				break;
			}
		}
		return item;
	}
}
