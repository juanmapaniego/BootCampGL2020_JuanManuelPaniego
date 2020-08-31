package com.globallogic.bootcampgl.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.globallogic.bootcampgl.dtos.OrdenDTO;
import com.globallogic.bootcampgl.dtos.ProductoDTO;
import com.globallogic.bootcampgl.dtos.ProductoSucursalDTO;
import com.globallogic.bootcampgl.dtos.SucursalDTO;

@RestController
public class RestTemplateController {
	@Value("${url_orden_service}")
	private String url_orden_service;
	@Value("${orden_resource}")
	private String orden_resource;

	@Value("${url_sucursal_service}")
	private String url_sucursal_service;
	@Value("${sucursal_resource}")
	private String sucursal_resource;

	@Value("${url_producto_service}")
	private String url_producto_service;
	@Value("${producto_resource}")
	private String producto_resource;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/productos/{nombre}")
	public ResponseEntity<?> getAllProductosByName(@PathVariable(name = "nombre") String nombre) {
		String url = url_producto_service + producto_resource;
		ResponseEntity<ProductoDTO[]> response = restTemplate.getForEntity(url, ProductoDTO[].class);
		if (response.getStatusCode() == HttpStatus.OK) {
			List<ProductoDTO> products = this.filterProducts(nombre, response.getBody());
			return ResponseEntity.ok(products);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	private List<ProductoDTO> filterProducts(String nombre, ProductoDTO[] products) {
		return Arrays.stream(products).filter(p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
	}

	@GetMapping("/sucursales/{nombre}")
	public ResponseEntity<?> getAllSucursalesByProductoName(@PathVariable String nombre) {
		String url = url_sucursal_service + sucursal_resource;
		ResponseEntity<SucursalDTO[]> responseSucursales = restTemplate.getForEntity(url, SucursalDTO[].class);

		url = url_producto_service + producto_resource;
		ResponseEntity<ProductoDTO[]> responseProductos = restTemplate.getForEntity(url, ProductoDTO[].class);

		if ((responseSucursales.getStatusCode() == HttpStatus.OK)
				&& (responseProductos.getStatusCode() == HttpStatus.OK)) {

			List<ProductoSucursalDTO> productosSucursalDTOs = this.filterProducts(nombre, responseProductos.getBody())
					.stream().map(p -> ProductoSucursalDTO.builder().idProducto(p.getId()).build())
					.collect(Collectors.toList());

			List<SucursalDTO> sucursales = Arrays.stream(responseSucursales.getBody())
					.filter(suc -> CollectionUtils.containsAny(suc.getProductos(), productosSucursalDTOs))
					.collect(Collectors.toList());
			return ResponseEntity.ok(sucursales);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/ordenes/{sucursal}")
	public ResponseEntity<?> getAllOrdenesBySucursalId(@PathVariable Long sucursal) {
		String url = url_orden_service + orden_resource + "?sucursal=" + sucursal;
		ResponseEntity<OrdenDTO[]> responseOrden = restTemplate.getForEntity(url, OrdenDTO[].class);

		if (responseOrden.getStatusCode() == HttpStatus.OK)
			return responseOrden;
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
