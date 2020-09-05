package com.globallogic.bootcampgl.feings;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globallogic.bootcampgl.dtos.ProductoDTO;

@FeignClient("ProductoService")
public interface ProductoClient {

	@GetMapping("/productos")
	List<ProductoDTO> getAll(@RequestParam(name = "nombre", required = false) String nombre);
}
