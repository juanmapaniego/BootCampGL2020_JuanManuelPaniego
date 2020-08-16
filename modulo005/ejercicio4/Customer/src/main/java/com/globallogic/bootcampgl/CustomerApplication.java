package com.globallogic.bootcampgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.globallogic.bootcampgl.model.Customer;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Autowired
	private Customer customer;
	
	@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println(
					customer
					);
		};
	}
}
