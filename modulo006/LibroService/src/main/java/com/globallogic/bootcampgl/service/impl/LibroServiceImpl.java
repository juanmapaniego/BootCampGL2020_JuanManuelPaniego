package com.globallogic.bootcampgl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.dto.LibroDTO;
import com.globallogic.bootcampgl.entity.Libro;
import com.globallogic.bootcampgl.repository.LibroRepository;
import com.globallogic.bootcampgl.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<LibroDTO> getAll() {
		return libroRepository.findAll().stream().map(l -> LibroDTO.fromEntity(l)).collect(Collectors.toList());
	}

	@Override
	public LibroDTO getById(Long id) {
		Libro libro = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		return LibroDTO.fromEntity(libro);
	}

	@Override
	public LibroDTO create(LibroDTO dto) {
		Libro crear = Libro.fromDto(dto);
		crear = libroRepository.save(crear);
		return LibroDTO.fromEntity(crear);
	}

	@Override
	public LibroDTO update(Long id, LibroDTO dto) {
		Libro libro = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no encontrado"));
		dto.setIsbn(id);
		libro = libroRepository.save(Libro.fromDto(dto));
		return LibroDTO.fromEntity(libro);
	}

	@Override
	public boolean remove(Long id) {
		libroRepository.deleteById(id);
		return true;
	}
}
