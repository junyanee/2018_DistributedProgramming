package com.spring.input.logic;

import java.util.ArrayList;

import com.spring.input.dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog {

	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void entryItem(Item item) {
		this.itemDao.create(item);
	}
	
	public void deleteItem(Item item) {
		this.itemDao.delete(item);
	}
	
	public ArrayList<Item> getItemList() {
		return this.itemDao.findAll();
	}
	
	public Item getItemByItemId(String itemId) {
	      return this.itemDao.findByItemId(itemId);
	   }
	
	public Item getItemByItemName(String itemName) {
	      return this.itemDao.findByItemName(itemName);
	   }

}