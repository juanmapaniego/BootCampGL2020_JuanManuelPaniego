package com.globallogic.bootcampgl.service;

import java.util.List;

import com.globallogic.bootcampgl.dto.LibroDTO;

public interface LibroService {
	List<LibroDTO> getAll();
	LibroDTO getById(Long id);
	LibroDTO create(LibroDTO dto);
	LibroDTO update(Long id, LibroDTO dto);
	boolean remove(Long id);
}
