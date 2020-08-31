package com.globallogic.bootcampgl.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.dto.SucursalDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sucursal {
	@Id
	private Long id;
	private String nombre;
	private String ubicacion;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Producto> productos;

	@JsonIgnore
	public static Sucursal fromDto(SucursalDTO dto) {
		return Sucursal.builder().id(dto.getId()).nombre(dto.getNombre())
				.productos(Producto.fromDtos(dto.getProductos())).ubicacion(dto.getUbicacion()).build();
	}
}
