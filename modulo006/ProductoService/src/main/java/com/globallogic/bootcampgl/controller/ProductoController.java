package com.globallogic.bootcampgl.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dto.ProductoDTO;
import com.globallogic.bootcampgl.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	public ResponseEntity<List<ProductoDTO>> getAll(@RequestParam(name = "nombre", required = false) String nombre) {
		if (Objects.isNull(nombre))
			return ResponseEntity.ok(productoService.getAll());
		return ResponseEntity.ok(productoService.getAllByNombre(nombre));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(productoService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ProductoDTO dto) {
		productoService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductoDTO dto) {
		productoService.update(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		productoService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
