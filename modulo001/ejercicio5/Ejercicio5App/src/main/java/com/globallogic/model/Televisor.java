package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public class Televisor extends Electrodomestico {
	private Double pulgadas;
	private String resolucion;
	
	public Televisor() {
		super();
	}

	public Double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(Double pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	
	public void cambiarCanal() {
		System.out.println("Cambiando canal");
	}

	@Override
	public void encender() {
		System.out.println("Encendiendo televisor");
	}
	
	
}
