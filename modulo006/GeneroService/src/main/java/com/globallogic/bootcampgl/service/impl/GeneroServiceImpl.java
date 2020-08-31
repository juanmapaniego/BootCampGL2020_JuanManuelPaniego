package com.globallogic.bootcampgl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.dto.GeneroDTO;
import com.globallogic.bootcampgl.entity.Genero;
import com.globallogic.bootcampgl.repository.GeneroRepository;
import com.globallogic.bootcampgl.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public List<GeneroDTO> getAll() {
		return generoRepository.findAll()
				.stream()
				.map(g -> GeneroDTO.fromEntity(g))
				.collect(Collectors.toList());
	}
	
	@Override
	public GeneroDTO getById(Long id) {
		Genero genero =  generoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("id de genero no encontrado"));
		return GeneroDTO.fromEntity(genero);
	}
	
	@Override
	public GeneroDTO create(GeneroDTO dto) {
		Genero created = generoRepository
				.save(Genero.fromDTO(dto));
		return GeneroDTO.fromEntity(created);
	}
	
	@Override
	public GeneroDTO update(Long id, GeneroDTO dto) {
		Genero update =  generoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("id de genero no encontrado"));
		dto.setId(update.getId());
		update = generoRepository.save(Genero.fromDTO(dto));
		return GeneroDTO.fromEntity(update);
	}
	
	@Override
	public boolean remove(Long id) {
		generoRepository.deleteById(id);
		return true;
	}
}
