package com.globallogic.bootcampgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.bootcampgl.factory.OrderFactory;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

	@Autowired
	OrderFactory orderFactory;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(orderFactory.getNewOrder());
	}
}
