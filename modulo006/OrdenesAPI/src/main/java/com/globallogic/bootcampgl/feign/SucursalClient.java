package com.globallogic.bootcampgl.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.globallogic.bootcampgl.dtos.ProductoCantidadDTO;
import com.globallogic.bootcampgl.dtos.SucursalDTO;

@FeignClient("SucursalService")
public interface SucursalClient {
	@GetMapping("/sucursales")
	List<SucursalDTO> getAll();

	@GetMapping("/sucursales/{id}")
	SucursalDTO getById(@PathVariable Long id);

	@PatchMapping("/sucursales/{idSucursal}/{idProducto}")
	void patchCantidad(@PathVariable("idSucursal") Long idSucursal, @PathVariable("idProducto") Long idProducto,
			@RequestBody ProductoCantidadDTO productoCantidadDTO);

}
