package com.globallogic.bootcampgl.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.entity.Orden;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenDTO {
	private Long id;
	private Long idSucursal;
	private List<ProductoDTO> productos;

	@JsonIgnore
	public static OrdenDTO fromEntity(Orden orden) {
		return OrdenDTO.builder().id(orden.getId()).idSucursal(orden.getIdSucursal())
				.productos(ProductoDTO.fromEntities(orden.getProductos())).build();
	}
}
