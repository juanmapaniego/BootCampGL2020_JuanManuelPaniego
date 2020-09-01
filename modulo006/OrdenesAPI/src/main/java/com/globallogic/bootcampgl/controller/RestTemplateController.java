package com.globallogic.bootcampgl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dtos.OrdenDTO;
import com.globallogic.bootcampgl.dtos.ProductoCantidadDTO;
import com.globallogic.bootcampgl.dtos.ProductoOrdenDTO;
import com.globallogic.bootcampgl.dtos.ProductoSucursalDTO;
import com.globallogic.bootcampgl.dtos.SucursalDTO;
import com.globallogic.bootcampgl.feign.OrdenClient;
import com.globallogic.bootcampgl.feign.SucursalClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RestTemplateController {
	@Autowired
	private SucursalClient sucursalClient;
	@Autowired
	private OrdenClient ordenClient;

	@HystrixCommand(fallbackMethod = "defaultCreate")
	@PostMapping("/ordenes/{idSucursal}")
	ResponseEntity<?> getOne(@PathVariable Long idSucursal, @RequestBody List<ProductoOrdenDTO> productosOrden) {
		SucursalDTO sucursal = sucursalClient.getById(idSucursal);

		List<ProductoSucursalDTO> productoSucursalDTO = productosOrden.stream()
				.map(p -> ProductoSucursalDTO.builder().idProducto(p.getIdProducto()).cantidad(p.getCantidad()).build())
				.collect(Collectors.toList());
		boolean haveAllProducts = sucursal.getProductos().containsAll(productoSucursalDTO);
		boolean existStock = true;
		for (ProductoSucursalDTO p : sucursal.getProductos()) {
			int index = productoSucursalDTO.indexOf(p);
			existStock &= (productoSucursalDTO.get(index).getCantidad() <= p.getCantidad());
		}
		if ((haveAllProducts) && (existStock)) {
			List<ProductoOrdenDTO> listaNuevaOrden = new ArrayList<>();
			sucursal.getProductos().forEach(p -> {
				int index = productoSucursalDTO.indexOf(p);
				long newCant = p.getCantidad() - productoSucursalDTO.get(index).getCantidad();
				sucursalClient.patchCantidad(idSucursal, p.getIdProducto(),
						ProductoCantidadDTO.builder().cantidad(newCant).build());
				listaNuevaOrden.add(ProductoOrdenDTO.builder().idProducto(p.getIdProducto())
						.cantidad(productoSucursalDTO.get(index).getCantidad()).build());
			});
			OrdenDTO orden = OrdenDTO.builder().idSucursal(idSucursal).productos(listaNuevaOrden).build();
			System.out.println(orden);
			ordenClient.create(orden);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<?> defaultCreate(Long idSucursal, List<ProductoOrdenDTO> productos) {
		return new ResponseEntity<String>("En mantenimiento", HttpStatus.LOCKED);
	}
}
