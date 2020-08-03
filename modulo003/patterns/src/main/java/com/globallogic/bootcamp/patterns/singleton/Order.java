package com.globallogic.bootcamp.patterns.singleton;

public class Order {
	private String description;
	private Integer count;
	private Currency currency;
	
	public Order(String description, Integer count) {
		this.currency = Currency.getInstance();		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	
}
