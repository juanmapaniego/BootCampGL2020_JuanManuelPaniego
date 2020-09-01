package com.globallogic.bootcampgl;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

import com.globallogic.bootcampgl.entity.Orden;
import com.globallogic.bootcampgl.entity.Producto;
import com.globallogic.bootcampgl.repository.OrdenRepository;

@SpringBootApplication
@EnableCircuitBreaker
public class OrdenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(OrdenRepository ordenRepository) {
		return args -> {
			Producto producto = Producto.builder().idProducto(1L).cantidad(10L).build();
			Orden orden = Orden.builder().idSucursal(1L).build();
			orden.setProductos(Arrays.asList(producto));
			ordenRepository.save(orden);
		};
	}

}
