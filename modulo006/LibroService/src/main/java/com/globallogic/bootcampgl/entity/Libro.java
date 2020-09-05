package com.globallogic.bootcampgl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.dto.LibroDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Libro {
	@Id
	private Long isbn;
	private String titulo;
	private Long idAutor;
	private Long idGenero;
	
	@JsonIgnore
	public static Libro fromDto(LibroDTO dto) {
		return Libro.builder()
				.isbn(dto.getIsbn())
				.titulo(dto.getTitulo())
				.idAutor(dto.getIdAutor())
				.idGenero(dto.getIdGenero())
				.build();
	}
}
