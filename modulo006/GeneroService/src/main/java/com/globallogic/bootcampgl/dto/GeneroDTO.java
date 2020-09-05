package com.globallogic.bootcampgl.dto;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.entity.Genero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class GeneroDTO {
	private Long id;
	private String nombre;
	
	@JsonIgnore
	public static GeneroDTO fromEntity(Genero genero) {
		return GeneroDTO.builder()
				.id(genero.getId())
				.nombre(genero.getNombre())
				.build();
	}
}
