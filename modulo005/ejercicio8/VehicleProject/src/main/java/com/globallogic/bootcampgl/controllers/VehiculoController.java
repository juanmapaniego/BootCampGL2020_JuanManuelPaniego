package com.globallogic.bootcampgl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.model.Vehiculo;
import com.globallogic.bootcampgl.services.VehiculoService;
import com.globallogic.bootcampgl.services.impl.VehiculoServiceImpl;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping
	public ResponseEntity<List<Vehiculo>> getAll(){
		return ResponseEntity.ok(vehiculoService.getVehiculos());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Vehiculo> getOne(@PathVariable Long codigo){
		return ResponseEntity.ok(vehiculoService.getVehiculo(codigo));
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody Vehiculo vehiculo){
		vehiculoService.createVehiculo(vehiculo);
		return new ResponseEntity("Vehiculo creado", HttpStatus.CREATED); 
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<String> update(@PathVariable Long codigo,@RequestBody Vehiculo vehiculo){
		vehiculo.setCodigo(codigo);
		vehiculoService.updateVehiculo(vehiculo);
		return ResponseEntity.ok("Vehiculo actualizado!");
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remove(@PathVariable Long codigo){
		vehiculoService.removeVehiculo(codigo);
		return ResponseEntity.ok("Vehiculo borrado!");
	}
	
	
}
