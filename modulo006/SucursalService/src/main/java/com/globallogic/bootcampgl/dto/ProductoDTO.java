package com.globallogic.bootcampgl.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.entity.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
	private Long id;
	private Long idProducto;
	private Long cantidad;

	@JsonIgnore
	public static ProductoDTO fromEntity(Producto producto) {
		return ProductoDTO.builder().id(producto.getId()).idProducto(producto.getIdProducto())
				.cantidad(producto.getCantidad()).build();
	}

	@JsonIgnore
	public static List<ProductoDTO> fromEntities(List<Producto> productos) {
		return productos.stream().map(ProductoDTO::fromEntity).collect(Collectors.toList());
	}
}
