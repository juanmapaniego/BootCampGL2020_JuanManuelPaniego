package com.globallogic.bootcampgl.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoOrdenDTO {
	private Long id;
	private Long idProducto;
	private Long cantidad;
}
