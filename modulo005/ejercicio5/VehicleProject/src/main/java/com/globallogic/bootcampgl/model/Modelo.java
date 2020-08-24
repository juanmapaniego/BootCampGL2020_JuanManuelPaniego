package com.globallogic.bootcampgl.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Modelo {
	@Id
	private Long codigo;
	private String Marca;
	private String nombre;
}
