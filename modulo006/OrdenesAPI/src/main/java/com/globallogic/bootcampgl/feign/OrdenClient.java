package com.globallogic.bootcampgl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.globallogic.bootcampgl.dtos.OrdenDTO;

@FeignClient("OrdenService")
public interface OrdenClient {

	@PostMapping("/ordenes")
	void create(@RequestBody OrdenDTO dto);
}
