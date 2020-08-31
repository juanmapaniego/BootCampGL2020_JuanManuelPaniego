package com.globallogic.bootcampgl.service;

import java.util.List;

import com.globallogic.bootcampgl.dto.OrdenDTO;

public interface OrdenService {
	List<OrdenDTO> getAll();

	OrdenDTO getById(Long id);

	OrdenDTO create(OrdenDTO dto);

	OrdenDTO update(Long id, OrdenDTO dto);

	boolean remove(Long id);

	List<OrdenDTO> getBySucursalId(Long sucursal);
}
