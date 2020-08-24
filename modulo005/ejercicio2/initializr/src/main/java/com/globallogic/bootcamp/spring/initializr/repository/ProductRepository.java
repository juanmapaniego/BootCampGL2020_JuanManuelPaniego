package com.globallogic.bootcamp.spring.initializr.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.bootcamp.spring.initializr.model.Product;

@Repository
public class ProductRepository {

	public Product getById(String id) {
		return Product.builder()
				.id(id)
				.name("Clavos")
				.build();
	}

}
