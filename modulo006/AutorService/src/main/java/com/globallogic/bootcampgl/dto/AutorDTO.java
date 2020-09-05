package com.globallogic.bootcampgl.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.entity.Autor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorDTO {
	private Long id;
	private String nombre;
	private String nacionalidad;
	
	@JsonIgnore
	public static AutorDTO fromEntity(Autor autor) {
		return AutorDTO.builder()
				.id(autor.getId())
				.nombre(autor.getNombre())
				.nacionalidad(autor.getNacionalidad())
				.build();
	}
}
