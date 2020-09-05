package com.globallogic.bootcampgl.service;

import java.util.List;

import com.globallogic.bootcampgl.dto.ProductoCantidadDTO;
import com.globallogic.bootcampgl.dto.SucursalDTO;

public interface SucursalService {
	List<SucursalDTO> getAll();

	SucursalDTO getById(Long id);

	SucursalDTO create(SucursalDTO dto);

	SucursalDTO update(Long id, SucursalDTO dto);

	boolean remove(Long id);

	void patchCantidad(Long sucursal, Long producto, ProductoCantidadDTO productoCantidadDTO);
}
