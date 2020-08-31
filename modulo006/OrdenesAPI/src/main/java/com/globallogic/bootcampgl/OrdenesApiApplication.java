package com.globallogic.bootcampgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdenesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenesApiApplication.class, args);
	}
}
