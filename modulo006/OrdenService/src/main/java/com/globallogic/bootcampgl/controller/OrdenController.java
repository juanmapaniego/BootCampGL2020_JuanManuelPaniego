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

import com.globallogic.bootcampgl.dto.OrdenDTO;
import com.globallogic.bootcampgl.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

	@Autowired
	private OrdenService ordenService;

	@GetMapping
	public ResponseEntity<List<OrdenDTO>> getAll(@RequestParam(name = "sucursal", required = false) Long sucursal) {
		if (Objects.isNull(sucursal))
			return ResponseEntity.ok(ordenService.getAll());
		return ResponseEntity.ok(ordenService.getBySucursalId(sucursal));
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdenDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ordenService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody OrdenDTO dto) {
		ordenService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody OrdenDTO dto) {
		ordenService.update(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		ordenService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
