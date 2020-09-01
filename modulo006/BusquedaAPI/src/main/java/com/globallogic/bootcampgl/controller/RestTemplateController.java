package com.globallogic.bootcampgl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dtos.ProductoDTO;
import com.globallogic.bootcampgl.dtos.ProductoSucursalDTO;
import com.globallogic.bootcampgl.dtos.SucursalDTO;
import com.globallogic.bootcampgl.feings.OrdenClient;
import com.globallogic.bootcampgl.feings.ProductoClient;
import com.globallogic.bootcampgl.feings.SucursalClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RestTemplateController {

	@Autowired
	private ProductoClient productoClient;
	@Autowired
	private SucursalClient sucursalClient;
	@Autowired
	private OrdenClient ordenClient;

	@HystrixCommand(fallbackMethod = "defaultProducts")
	@GetMapping("/productos/{nombre}")
	public ResponseEntity<?> getAllProductosByName(@PathVariable(name = "nombre") String nombre) {

		List<ProductoDTO> products = this.filterProducts(nombre, productoClient.getAll(null));
		return ResponseEntity.ok(products);

	}

	private List<ProductoDTO> filterProducts(String nombre, List<ProductoDTO> products) {
		return products.stream().filter(p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
	}

	@HystrixCommand(fallbackMethod = "defaultSucursales")
	@GetMapping("/sucursales/{nombre}")
	public ResponseEntity<?> getAllSucursalesByProductoName(@PathVariable String nombre) {

		List<SucursalDTO> sucursalesFeign = sucursalClient.getAll();

		List<ProductoDTO> productos = productoClient.getAll(null);

		List<ProductoSucursalDTO> productosSucursalDTOs = this.filterProducts(nombre, productos).stream()
				.map(p -> ProductoSucursalDTO.builder().idProducto(p.getId()).build()).collect(Collectors.toList());

		List<SucursalDTO> sucursales = sucursalesFeign.stream()
				.filter(suc -> CollectionUtils.containsAny(suc.getProductos(), productosSucursalDTOs))
				.collect(Collectors.toList());
		return ResponseEntity.ok(sucursales);

	}

	@HystrixCommand(fallbackMethod = "defaultOrdenes")
	@GetMapping("/ordenes/{sucursal}")
	public ResponseEntity<?> getAllOrdenesBySucursalId(@PathVariable Long sucursal) {

		return new ResponseEntity<>(ordenClient.getAll(sucursal), HttpStatus.OK);
	}

	public ResponseEntity<?> defaultProducts(String nombre) {
		return new ResponseEntity<String>("En mantenimiento", HttpStatus.LOCKED);
	}

	public ResponseEntity<?> defaultOrdenes(Long id) {
		return new ResponseEntity<String>("En mantenimiento", HttpStatus.LOCKED);
	}

	public ResponseEntity<?> defaultSucursales(String nombre) {
		return new ResponseEntity<String>("En mantenimiento", HttpStatus.LOCKED);
	}
}
