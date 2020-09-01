package com.globallogic.bootcampgl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.globallogic.bootcampgl.entity.Producto;
import com.globallogic.bootcampgl.repository.ProductoRepository;

@SpringBootApplication
public class ProductoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ProductoRepository productoRepository) {
		return args -> {
			productoRepository.save(Producto.builder().id(1L).nombre("Jamon").build());
			productoRepository.save(Producto.builder().id(2L).nombre("Manteca").build());
		};
	}

}
