package com.globallogic.bootcampgl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.dto.AutorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Autor {
	@Id
	private Long id;
	private String nombre;
	private String nacionalidad;
	
	@JsonIgnore
	public static Autor fromDTO(AutorDTO dto) {
		return Autor.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
				.nacionalidad(dto.getNacionalidad())
				.build();
	}
}
