package com.globallogic.bootcampgl.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.model.Vehiculo;
import com.globallogic.bootcampgl.repositories.VehiculoRepository;
import com.globallogic.bootcampgl.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public void createVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}
	
	@Override
	public List<Vehiculo> getVehiculos() {
		return (List<Vehiculo>) vehiculoRepository.findAll();
	}
	
	@Override
	public Vehiculo getVehiculo(Long codigo) {
		return vehiculoRepository.findById(codigo).orElse(null);
	}
	
	@Override
	public void updateVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
	}
	
	@Override
	public void removeVehiculo(Long codigo) {
		vehiculoRepository.deleteById(codigo);
	}
}
