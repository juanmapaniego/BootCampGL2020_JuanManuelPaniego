package com.globallogic.bootcampgl.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dto.ProductDTO;
import com.globallogic.bootcampgl.service.ProductService;
import com.globallogic.bootcampgl.service.impl.ProductServiceImpl;

/**
 * Product Service Controller
 */
@RestController
public class ProductServiceController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Collection<ProductDTO>> getProducts(){
		return ResponseEntity.ok(productService.getProducts());
	}
	
	@PostMapping(value = "/products")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		productService.createProduct(productDTO);
		return new ResponseEntity<>("Product created succesfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable String id, 
			@RequestBody ProductDTO productDTO){
		productService.updateProduct(id, productDTO);
		return new ResponseEntity<>("Product updated succesfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id){
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product deleted succesfully", HttpStatus.OK);
	}
	
}
