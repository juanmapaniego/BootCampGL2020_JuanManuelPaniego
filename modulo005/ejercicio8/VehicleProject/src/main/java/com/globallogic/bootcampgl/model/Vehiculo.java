package com.globallogic.bootcampgl.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Vehiculo {
	@Id
	private Long codigo;
	private String identificacion;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Tipo tipo;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Modelo modelo;
	private String fechaProduccion;
}
