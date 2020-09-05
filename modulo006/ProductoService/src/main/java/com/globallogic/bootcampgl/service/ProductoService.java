package com.globallogic.bootcampgl.service;

import java.util.List;

import com.globallogic.bootcampgl.dto.ProductoDTO;

public interface ProductoService {
	List<ProductoDTO> getAll();

	ProductoDTO getById(Long id);

	ProductoDTO create(ProductoDTO dto);

	ProductoDTO update(Long id, ProductoDTO dto);

	boolean remove(Long id);

	List<ProductoDTO> getAllByNombre(String nombre);
}
