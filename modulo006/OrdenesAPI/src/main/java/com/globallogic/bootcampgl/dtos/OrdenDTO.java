package com.globallogic.bootcampgl.dtos;

import java.util.List;

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
	private List<ProductoOrdenDTO> productos;
}
