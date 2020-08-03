package com.globallogic.bootcamp.patterns.singleton;

public class Product {
	private static Product instance = new Product();
	private String name;
	
	
	
	public static Product getInstance() {
		return instance;
	}

	public Product() {
		this.name = "clavos";
	}
}
