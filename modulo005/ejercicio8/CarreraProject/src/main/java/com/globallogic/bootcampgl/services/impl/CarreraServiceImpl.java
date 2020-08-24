package com.globallogic.bootcampgl.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Carrera;
import com.globallogic.bootcampgl.repositories.CarreraRepository;
import com.globallogic.bootcampgl.services.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService {

	private final CarreraRepository carreraRepository;
	
	@Autowired
	public CarreraServiceImpl(CarreraRepository carreraRepository) {
		this.carreraRepository = carreraRepository;
	}
	
	@Override
	public List<Carrera> getCarreras(){
		return (List<Carrera>) carreraRepository.findAll();
	}
	
	@Override
	public Carrera getCarrera(Long id){
		return carreraRepository.findById(id).orElse(null);
	}
	
	@Override
	public void createCarrera(Carrera carrera) {
		carreraRepository.save(carrera);
	}
	
	@Override
	public void updateCarrera(Carrera carrera) {
		carreraRepository.save(carrera);
	}
	
	@Override
	public void removeCarrera(Long id) {
		carreraRepository.deleteById(id);
	}
}
