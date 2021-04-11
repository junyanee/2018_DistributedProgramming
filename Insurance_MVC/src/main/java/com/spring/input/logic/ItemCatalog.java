package com.spring.input.logic;

import java.util.ArrayList;

public interface ItemCatalog {

	void entryItem (Item item);
	Item getItemByItemId (String itemId);
	ArrayList<Item> getItemList();
	Item getItemByItemName(String itemName);
}