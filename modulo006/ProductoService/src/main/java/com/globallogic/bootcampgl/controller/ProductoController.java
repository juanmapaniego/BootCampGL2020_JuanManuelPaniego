package com.globallogic.bootcampgl.controller;

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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@HystrixCommand(fallbackMethod = "defaultGetAll")
	@GetMapping
	public ResponseEntity<Object> getAll(@RequestParam(name = "nombre", required = false) String nombre) {
		if (Objects.isNull(nombre))
			return ResponseEntity.ok(productoService.getAll());
		return ResponseEntity.ok(productoService.getAllByNombre(nombre));
	}

	@HystrixCommand(fallbackMethod = "defaultGetById")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		return ResponseEntity.ok(productoService.getById(id));
	}

	@HystrixCommand(fallbackMethod = "defaultCreate")
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody ProductoDTO dto) {
		productoService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@HystrixCommand(fallbackMethod = "defaultUpdate")
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ProductoDTO dto) {
		productoService.update(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@HystrixCommand(fallbackMethod = "defaultRemove")
	@DeleteMapping("/{id")
	public ResponseEntity<Object> remove(@PathVariable Long id) {
		productoService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<Object> defaultCreate(ProductoDTO producto) {
		return new ResponseEntity<Object>("En mantenimiento", HttpStatus.LOCKED);
	}

	public ResponseEntity<Object> defaultUpdate(Long id, ProductoDTO producto) {
		return new ResponseEntity<Object>("En mantenimiento", HttpStatus.LOCKED);
	}

	public ResponseEntity<Object> defaultRemove(Long id) {
		return new ResponseEntity<Object>("En mantenimiento", HttpStatus.LOCKED);
	}

	public ResponseEntity<Object> defaultGetAll(String nombre) {
		return new ResponseEntity<Object>("En mantenimiento", HttpStatus.LOCKED);
	}

	public ResponseEntity<Object> defaultGetById(Long id) {
		return new ResponseEntity<Object>("En mantenimiento", HttpStatus.LOCKED);
	}
}
