package com.globallogic.bootcampgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dto.GeneroDTO;
import com.globallogic.bootcampgl.service.GeneroService;

@RestController
public class GeneroController {
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public ResponseEntity<List<GeneroDTO>> getAll(){
		return ResponseEntity.ok(generoService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneroDTO> getById(@PathVariable Long id){
		return ResponseEntity.ok(generoService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody GeneroDTO dto){
		generoService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody GeneroDTO dto){
		generoService.update(id,dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		generoService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
