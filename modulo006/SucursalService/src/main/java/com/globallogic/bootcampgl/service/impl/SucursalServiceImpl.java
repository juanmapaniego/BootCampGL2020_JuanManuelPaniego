package com.globallogic.bootcampgl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.dto.ProductoCantidadDTO;
import com.globallogic.bootcampgl.dto.SucursalDTO;
import com.globallogic.bootcampgl.entity.Producto;
import com.globallogic.bootcampgl.entity.Sucursal;
import com.globallogic.bootcampgl.repository.ProductoRepository;
import com.globallogic.bootcampgl.repository.SucursalRepository;
import com.globallogic.bootcampgl.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

	private final SucursalRepository sucursalRepository;
	private final ProductoRepository productoRepository;

	@Autowired
	public SucursalServiceImpl(SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
		super();
		this.sucursalRepository = sucursalRepository;
		this.productoRepository = productoRepository;
	}

	@Override
	public List<SucursalDTO> getAll() {
		return sucursalRepository.findAll().stream().map(l -> SucursalDTO.fromEntity(l)).collect(Collectors.toList());
	}

	@Override
	public SucursalDTO getById(Long id) {
		Sucursal orden = sucursalRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		return SucursalDTO.fromEntity(orden);
	}

	@Override
	public SucursalDTO create(SucursalDTO dto) {
		Sucursal crear = Sucursal.fromDto(dto);
		crear = sucursalRepository.save(crear);
		return SucursalDTO.fromEntity(crear);
	}

	@Override
	public SucursalDTO update(Long id, SucursalDTO dto) {
		Sucursal orden = sucursalRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		dto.setId(id);
		orden = sucursalRepository.save(Sucursal.fromDto(dto));
		return SucursalDTO.fromEntity(orden);
	}

	@Override
	public boolean remove(Long id) {
		sucursalRepository.deleteById(id);
		return true;
	}

	@Override
	public void patchCantidad(Long sucursal, Long producto, ProductoCantidadDTO productoCantidadDTO) {
		Sucursal sucFromDB = sucursalRepository.findById(sucursal).orElseThrow(() -> new IllegalArgumentException());
		if (!sucFromDB.getProductos().contains(Producto.builder().id(producto).build()))
			throw new IllegalArgumentException();
		if (productoCantidadDTO.getCantidad() < 0)
			throw new IllegalArgumentException();
		Producto prodFromDb = productoRepository.findById(producto).orElseThrow(() -> new IllegalArgumentException());
		prodFromDb.setCantidad(productoCantidadDTO.getCantidad());
		productoRepository.save(prodFromDb);
	}
}
