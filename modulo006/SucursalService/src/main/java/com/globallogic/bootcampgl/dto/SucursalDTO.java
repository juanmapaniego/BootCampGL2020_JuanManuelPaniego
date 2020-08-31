package com.globallogic.bootcampgl.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.entity.Sucursal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SucursalDTO {
	private Long id;
	private String nombre;
	private String ubicacion;
	private List<ProductoDTO> productos;

	@JsonIgnore
	public static SucursalDTO fromEntity(Sucursal sucursal) {
		return SucursalDTO.builder().id(sucursal.getId()).nombre(sucursal.getNombre())
				.productos(ProductoDTO.fromEntities(sucursal.getProductos())).ubicacion(sucursal.getUbicacion())
				.build();
	}
}
