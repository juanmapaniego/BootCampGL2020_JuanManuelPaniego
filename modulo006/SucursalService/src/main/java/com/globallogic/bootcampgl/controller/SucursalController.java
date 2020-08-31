package com.globallogic.bootcampgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dto.ProductoCantidadDTO;
import com.globallogic.bootcampgl.dto.SucursalDTO;
import com.globallogic.bootcampgl.service.SucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;

	@GetMapping
	public ResponseEntity<List<SucursalDTO>> getAll() {
		return ResponseEntity.ok(sucursalService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<SucursalDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(sucursalService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody SucursalDTO dto) {
		sucursalService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody SucursalDTO dto) {
		sucursalService.update(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		sucursalService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping("/{idSucursal}/{idProducto}")
	public ResponseEntity<Void> patchCantidad(@PathVariable("idSucursal") Long idSucursal,
			@PathVariable("idProducto") Long idProducto, @RequestBody ProductoCantidadDTO productoCantidadDTO) {
		sucursalService.patchCantidad(idSucursal, idProducto, productoCantidadDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
