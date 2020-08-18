package com.globallogic.bootcampgl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Carrera;
import com.globallogic.bootcampgl.repositories.CarreraRepository;

@Service
public class CarreraService {

	private final CarreraRepository carreraRepository;
	
	@Autowired
	public CarreraService(CarreraRepository carreraRepository) {
		this.carreraRepository = carreraRepository;
	}
	
	public List<Carrera> getCarreras(){
		return (List<Carrera>) carreraRepository.findAll();
	}
	
	public Carrera getCarrera(Long id){
		return carreraRepository.findById(id).orElse(null);
	}
	
	public void createCarrera(Carrera carrera) {
		carreraRepository.save(carrera);
	}
	
	public void updateCarrera(Carrera carrera) {
		carreraRepository.save(carrera);
	}
	
	public void removeCarrera(Long id) {
		carreraRepository.deleteById(id);
	}
}
