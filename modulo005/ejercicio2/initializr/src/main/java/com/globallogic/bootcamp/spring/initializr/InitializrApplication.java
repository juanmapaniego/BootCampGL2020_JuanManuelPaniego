package com.globallogic.bootcamp.spring.initializr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.bootcamp.spring.initializr.factory.OrderFactory;
import com.globallogic.bootcamp.spring.initializr.model.Product;
import com.globallogic.bootcamp.spring.initializr.repository.ProductRepository;

@SpringBootApplication
public class InitializrApplication implements CommandLineRunner{
	
	private final ProductRepository productRepository;
	private final OrderFactory orderFactory;
	
	@Autowired
	public InitializrApplication(ProductRepository productRepository, OrderFactory orderFactory) {
		super();
		this.productRepository = productRepository;
		this.orderFactory = orderFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(InitializrApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Order:");
		System.out.println(orderFactory.getNewOrder());
		
		
		System.out.println("Product: ");
		System.out.println(productRepository.getById("C-00221"));
	}

}
