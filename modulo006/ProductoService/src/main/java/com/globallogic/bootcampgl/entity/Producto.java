package com.globallogic.bootcampgl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.dto.ProductoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Producto {
	@Id
	private Long id;
	private String nombre;
	
	@JsonIgnore
	public static Producto fromDto(ProductoDTO dto) {
		return Producto.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
				.build();
	}
}
