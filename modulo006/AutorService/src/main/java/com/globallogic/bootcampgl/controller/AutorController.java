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

import com.globallogic.bootcampgl.dto.AutorDTO;
import com.globallogic.bootcampgl.service.AutorService;

@RestController
public class AutorController {
	@Autowired
	private AutorService autorService;

	@GetMapping
	public ResponseEntity<List<AutorDTO>> getAll() {
		return ResponseEntity.ok(autorService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(autorService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody AutorDTO dto) {
		autorService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AutorDTO dto) {
		autorService.update(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		autorService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
