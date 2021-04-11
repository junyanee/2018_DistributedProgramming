package com.spring.input.logic;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	private String itemId; //���� id	
	private String itemClass; // ���� ����
	private String itemName; // ���� �̸�
	private String description; // ���� ����	
	private String frequency; // ���� �ֱ�
	private String term; // ���� �Ⱓ	
	private String money; // ����ݾ�

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}	
	public String getDescription() {
		return this.description;
	}	
	public void setDescription(String description) {
		this.description = description;
	}	
	public String getItemId() {
		return this.itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getItemClass() {
		return itemClass;
	}
	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}
}