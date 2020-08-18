package com.globallogic.bootcampgl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Vehiculo;
import com.globallogic.bootcampgl.repositories.VehiculoRepository;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	public void createVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}
	
	public List<Vehiculo> getVehiculos() {
		return (List<Vehiculo>) vehiculoRepository.findAll();
	}
	
	public Vehiculo getVehiculo(Long codigo) {
		return vehiculoRepository.findById(codigo).orElse(null);
	}
	
	public void updateVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}
	
	public void removeVehiculo(Long codigo) {
		vehiculoRepository.deleteById(codigo);
	}
	
	
}
