package com.globallogic.bootcampgl.services;

import java.util.List;

import com.globallogic.bootcampgl.model.Vehiculo;

public interface VehiculoService {
	public void createVehiculo(Vehiculo vehiculo);
	public List<Vehiculo> getVehiculos();
	public Vehiculo getVehiculo(Long codigo);
	public void updateVehiculo(Vehiculo vehiculo);
	public void removeVehiculo(Long codigo);
}
