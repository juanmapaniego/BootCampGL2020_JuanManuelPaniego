package com.globallogic.bootcampgl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.dto.OrdenDTO;
import com.globallogic.bootcampgl.entity.Orden;
import com.globallogic.bootcampgl.repository.OrdenRepository;
import com.globallogic.bootcampgl.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;

	@Override
	public List<OrdenDTO> getAll() {
		return ordenRepository.findAll().stream().map(l -> OrdenDTO.fromEntity(l)).collect(Collectors.toList());
	}

	@Override
	public OrdenDTO getById(Long id) {
		Orden orden = ordenRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		return OrdenDTO.fromEntity(orden);
	}

	@Override
	public OrdenDTO create(OrdenDTO dto) {
		Orden crear = Orden.fromDto(dto);
		crear = ordenRepository.save(crear);
		return OrdenDTO.fromEntity(crear);
	}

	@Override
	public OrdenDTO update(Long id, OrdenDTO dto) {
		Orden orden = ordenRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		dto.setId(id);
		orden = ordenRepository.save(Orden.fromDto(dto));
		return OrdenDTO.fromEntity(orden);
	}

	@Override
	public boolean remove(Long id) {
		ordenRepository.deleteById(id);
		return true;
	}

	@Override
	public List<OrdenDTO> getBySucursalId(Long sucursal) {
		return ordenRepository.findByIdSucursal(sucursal).stream().map(OrdenDTO::fromEntity)
				.collect(Collectors.toList());
	}
}
