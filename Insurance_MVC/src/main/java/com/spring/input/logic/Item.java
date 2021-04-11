package com.spring.input.logic;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	private String itemId; //보험 id	
	private String itemClass; // 보험 종류
	private String itemName; // 보험 이름
	private String description; // 보험 설명	
	private String frequency; // 납입 주기
	private String term; // 납입 기간	
	private String money; // 보상금액

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