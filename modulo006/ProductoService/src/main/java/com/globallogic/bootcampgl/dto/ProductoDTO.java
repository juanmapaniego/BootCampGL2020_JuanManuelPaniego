package com.globallogic.bootcampgl.dto;


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
	private String nombre;
	
	@JsonIgnore
	public static ProductoDTO fromEntity(Producto sucursal) {
		return ProductoDTO.builder()
				.id(sucursal.getId())
				.nombre(sucursal.getNombre())
				.build();
	}
}
