package com.globallogic.bootcampgl.service;

import java.util.List;

import com.globallogic.bootcampgl.dto.AutorDTO;

public interface AutorService {
	List<AutorDTO> getAll();
	AutorDTO getById(Long id);
	AutorDTO create(AutorDTO dto);
	AutorDTO update(Long id, AutorDTO dto);
	boolean remove(Long id);
}
