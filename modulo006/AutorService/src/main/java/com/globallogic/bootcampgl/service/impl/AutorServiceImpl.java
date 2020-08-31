package com.globallogic.bootcampgl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.dto.AutorDTO;
import com.globallogic.bootcampgl.entity.Autor;
import com.globallogic.bootcampgl.repository.AutorRepository;
import com.globallogic.bootcampgl.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<AutorDTO> getAll() {
		return autorRepository.findAll().stream().map(a -> AutorDTO.fromEntity(a)).collect(Collectors.toList());
	}

	@Override
	public AutorDTO getById(Long id) {
		return AutorDTO.fromEntity(
				autorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no econtrado")));
	}
	
	@Override
	public AutorDTO create(AutorDTO dto) {
		Autor created = autorRepository.save(Autor.fromDTO(dto));
		
		return AutorDTO.fromEntity(created);
	}
	
	@Override
	public AutorDTO update(Long id, AutorDTO dto) {
		Autor update = autorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no econtrado"));
		dto.setId(update.getId());
		update = autorRepository.save(Autor.fromDTO(dto));
		return AutorDTO.fromEntity(update);
	}
	
	@Override
	public boolean remove(Long id) {
		autorRepository.deleteById(id);
		return true;
	}
}
