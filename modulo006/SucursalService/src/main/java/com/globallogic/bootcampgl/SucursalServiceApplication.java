package com.globallogic.bootcampgl;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.globallogic.bootcampgl.entity.Producto;
import com.globallogic.bootcampgl.entity.Sucursal;
import com.globallogic.bootcampgl.repository.SucursalRepository;

@SpringBootApplication
public class SucursalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SucursalServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(SucursalRepository sucursalRepository) {
		return args -> {

			Producto producto = Producto.builder().id(1L).idProducto(1L).cantidad(10L).build();
			Sucursal sucursal = Sucursal.builder().id(1L).nombre("California").ubicacion("Sgo del estero").build();
			sucursal.setProductos(Arrays.asList(producto));
			sucursalRepository.save(sucursal);

			/*
			 * Producto producto =
			 * Producto.builder().id(1L).idProducto(2L).cantidad(10L).build(); Sucursal
			 * sucursal =
			 * Sucursal.builder().id(1L).nombre("California2").ubicacion("Sgo del estero").
			 * build(); sucursal.setProductos(Arrays.asList(producto));
			 * sucursalRepository.save(sucursal);
			 */
		};
	}
}
