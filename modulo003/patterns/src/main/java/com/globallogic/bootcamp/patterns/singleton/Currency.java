package com.globallogic.bootcamp.patterns.singleton;

public class Currency {

	private static Currency instance = new Currency();
	private String name;
	
	private Currency() {
		this.name = "ARS";
	}

	public static Currency getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
}
