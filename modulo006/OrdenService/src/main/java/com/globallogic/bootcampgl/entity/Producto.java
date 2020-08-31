package com.globallogic.bootcampgl.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long idProducto;
	private Long cantidad;

	@JsonIgnore
	public static Producto fromDto(ProductoDTO dto) {
		return Producto.builder().id(dto.getId()).idProducto(dto.getIdProducto()).cantidad(dto.getCantidad()).build();
	}

	@JsonIgnore
	public static List<Producto> fromDtos(List<ProductoDTO> dtos) {
		return dtos.stream().map(Producto::fromDto).collect(Collectors.toList());
	}
}
