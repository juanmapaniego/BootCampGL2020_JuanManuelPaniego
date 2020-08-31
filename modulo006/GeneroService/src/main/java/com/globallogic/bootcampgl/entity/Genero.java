package com.globallogic.bootcampgl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.dto.GeneroDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Genero {
	@Id
	private Long id;
	private String nombre;
	
	@JsonIgnore
	public static Genero fromDTO(GeneroDTO dto) {
		return Genero.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
				.build();
	}
}
