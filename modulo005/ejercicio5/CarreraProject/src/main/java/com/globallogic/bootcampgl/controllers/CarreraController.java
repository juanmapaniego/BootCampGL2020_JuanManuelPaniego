package com.globallogic.bootcampgl.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globallogic.bootcampgl.model.Carrera;
import com.globallogic.bootcampgl.services.CarreraService;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	private final CarreraService carreraService;
	
	public CarreraController(CarreraService carreraService) {
		this.carreraService = carreraService;
	}
	
	@GetMapping
	public ResponseEntity<List<Carrera>> getCarreras(){
		return ResponseEntity.ok(carreraService.getCarreras());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrera> getCarrera(@PathVariable Long id){
		return ResponseEntity.ok(carreraService.getCarrera(id));
	}
	
	@PostMapping
	public ResponseEntity<String> createCarrera(@RequestBody Carrera carrera) {
		carreraService.createCarrera(carrera);
		return new ResponseEntity<>("Objeto carrera creado!", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCarrera(@PathVariable Long id, @RequestBody Carrera carrera) {
		carrera.setId(id);
		carreraService.updateCarrera(carrera);
		return ResponseEntity.ok("Objeto carrera actualizado");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeCarrera(@PathVariable Long id) {
		carreraService.removeCarrera(id);
		return ResponseEntity.ok("Objeto carrera borrado");
	}
}
