package com.spring.input.logic;

import java.util.ArrayList;

public class ShopImpl implements Shop {

	private ItemCatalog itemCatalog;
	private UserCatalog userCatalog;

	//item
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	public void entryItem(Item item) {
		this.itemCatalog.entryItem(item);
	}

	public ArrayList<Item> getItemList() {
		return this.itemCatalog.getItemList();
	}

	public Item getItemByItemId(String itemId) {
		return this.itemCatalog.getItemByItemId(itemId);
	}

	public Item getItemByItemName(String itemName) {
		return this.itemCatalog.getItemByItemName(itemName);
	}
	
	//user
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public void entryUser(User user) {
		this.userCatalog.entryUser(user);
	}

	public ArrayList<User> getUserList() {
		return this.userCatalog.getUserList();
	}

	public User getUserByUserId(String userId) {
		return this.userCatalog.getUserByUserId(userId);
	}

}