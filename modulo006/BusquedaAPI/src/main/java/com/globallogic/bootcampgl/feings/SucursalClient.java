package com.globallogic.bootcampgl.feings;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.globallogic.bootcampgl.dtos.SucursalDTO;

@FeignClient(name = "sucursalService", url = "localhost:8270")
public interface SucursalClient {

	@GetMapping("/sucursales")
	List<SucursalDTO> getAll();
}
