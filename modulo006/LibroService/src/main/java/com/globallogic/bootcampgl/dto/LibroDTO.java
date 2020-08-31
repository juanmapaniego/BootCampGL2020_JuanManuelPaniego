package com.globallogic.bootcampgl.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.bootcampgl.entity.Libro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {
	private Long isbn;
	private String titulo;
	private Long idAutor;
	private Long idGenero;
	
	@JsonIgnore
	public static LibroDTO fromEntity(Libro libro) {
		return LibroDTO.builder()
				.isbn(libro.getIsbn())
				.titulo(libro.getTitulo())
				.idAutor(libro.getIdAutor())
				.idGenero(libro.getIdGenero())
				.build();
	}
}
