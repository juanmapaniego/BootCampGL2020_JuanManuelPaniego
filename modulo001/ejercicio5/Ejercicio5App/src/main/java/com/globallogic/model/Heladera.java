package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public class Heladera extends Electrodomestico {
	private Double capacidad;
	private boolean tieneFreezer;
	private Double capacidadFreezer;
	
	public Heladera() {
		super();
	}

	public Double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isTieneFreezer() {
		return tieneFreezer;
	}

	public void setTieneFreezer(boolean tieneFreezer) {
		this.tieneFreezer = tieneFreezer;
	}

	public Double getCapacidadFreezer() {
		return capacidadFreezer;
	}

	public void setCapacidadFreezer(Double capacidadFreezer) {
		this.capacidadFreezer = capacidadFreezer;
	}
	
	public void guardarElemento(String elemento) {
		System.out.println("Guardando " + elemento);
	}
	
	public void extraerElemento(String elemento) {
		System.out.println("Extrayendo " + elemento);
	}
}
