package com.globallogic.bootcampgl.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDTO {
	private Long id;
	private String nombre;
	private String ubicacion;
	private List<ProductoSucursalDTO> productos;
}
