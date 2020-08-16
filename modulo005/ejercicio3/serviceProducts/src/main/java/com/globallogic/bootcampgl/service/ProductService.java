package com.globallogic.bootcampgl.service;

import java.util.Collection;

import com.globallogic.bootcampgl.dto.ProductDTO;

/**
 * Product Service
 */
public interface ProductService {
	Collection<ProductDTO> getProducts();
	void createProduct(ProductDTO productDTO);
	void updateProduct(String id, ProductDTO productDTO);
	void deleteProduct(String id);
}
