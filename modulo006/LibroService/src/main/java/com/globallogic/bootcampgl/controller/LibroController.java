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

import com.globallogic.bootcampgl.dto.LibroDTO;
import com.globallogic.bootcampgl.service.LibroService;

@RestController
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<List<LibroDTO>> getAll(){
		return ResponseEntity.ok(libroService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LibroDTO> getById(@PathVariable Long id){
		return ResponseEntity.ok(libroService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody LibroDTO dto){
		libroService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody LibroDTO dto){
		libroService.update(id,dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		libroService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
