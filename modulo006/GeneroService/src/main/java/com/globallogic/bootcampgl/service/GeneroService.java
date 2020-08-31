package com.globallogic.bootcampgl.service;

import java.util.List;

import com.globallogic.bootcampgl.dto.GeneroDTO;

public interface GeneroService {
	List<GeneroDTO> getAll();
	GeneroDTO getById(Long id);
	GeneroDTO create(GeneroDTO dto);
	GeneroDTO update(Long id, GeneroDTO dto);
	boolean remove(Long id);
}
