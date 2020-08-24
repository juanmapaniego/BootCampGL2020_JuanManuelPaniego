package com.globallogic.bootcampgl.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Product;

@Repository
public class ProductRepository {

	public Product getById(String id) {
		return Product.builder()
				.id(id)
				.name("Clavos")
				.build();
	}
}
