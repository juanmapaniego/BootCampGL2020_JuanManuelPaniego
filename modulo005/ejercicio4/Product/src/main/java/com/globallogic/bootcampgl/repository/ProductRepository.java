package com.globallogic.bootcampgl.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.model.Product;

@Repository
public class ProductRepository {
	@Value("${in.id}")
	private String idA;
	@Value("${in.name}")
	private String name;
	
	public Product getById(String id) {
		return Product.builder()
				.id(idA)
				.name(name)
				.build();
	}

}
