package com.globallogic.bootcampgl.services;

import java.util.List;

import com.globallogic.bootcampgl.model.Carrera;

public interface CarreraService {
	List<Carrera> getCarreras();
	Carrera getCarrera(Long id);
	void createCarrera(Carrera carrera);
	void updateCarrera(Carrera carrera);
	void removeCarrera(Long id);
}
