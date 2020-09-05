package com.globallogic.bootcampgl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.dto.ProductoDTO;
import com.globallogic.bootcampgl.entity.Producto;
import com.globallogic.bootcampgl.repository.ProductoRepository;
import com.globallogic.bootcampgl.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<ProductoDTO> getAll() {
		return productoRepository.findAll().stream().map(l -> ProductoDTO.fromEntity(l)).collect(Collectors.toList());
	}

	@Override
	public ProductoDTO getById(Long id) {
		Producto orden = productoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		return ProductoDTO.fromEntity(orden);
	}

	@Override
	public ProductoDTO create(ProductoDTO dto) {
		Producto crear = Producto.fromDto(dto);
		crear = productoRepository.save(crear);
		return ProductoDTO.fromEntity(crear);
	}

	@Override
	public ProductoDTO update(Long id, ProductoDTO dto) {
		Producto orden = productoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		dto.setId(id);
		orden = productoRepository.save(Producto.fromDto(dto));
		return ProductoDTO.fromEntity(orden);
	}

	@Override
	public boolean remove(Long id) {
		productoRepository.deleteById(id);
		return true;
	}

	@Override
	public List<ProductoDTO> getAllByNombre(String nombre) {
		return productoRepository.findByNombre(nombre).stream().map(ProductoDTO::fromEntity)
				.collect(Collectors.toList());
	}
}
