package com.globallogic.bootcampgl.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.dto.OrdenDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long idSucursal;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Producto> productos;

	@JsonIgnore
	public static Orden fromDto(OrdenDTO dto) {
		return Orden.builder().id(dto.getId()).idSucursal(dto.getIdSucursal())
				.productos(Producto.fromDtos(dto.getProductos())).build();
	}
}
