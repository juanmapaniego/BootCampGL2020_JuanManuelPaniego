package com.globallogic.bootcampgl.feings;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globallogic.bootcampgl.dtos.OrdenDTO;

@FeignClient(name = "ordenService", url = "localhost:8280")
public interface OrdenClient {

	@GetMapping
	List<OrdenDTO> getAll(@RequestParam(name = "sucursal", required = false) Long sucursal);
}
