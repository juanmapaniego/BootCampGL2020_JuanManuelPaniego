package com.globallogic.bootcampgl.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
	@Id
	private Long id;
	private String fecha;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Competidor> competidores;
}
