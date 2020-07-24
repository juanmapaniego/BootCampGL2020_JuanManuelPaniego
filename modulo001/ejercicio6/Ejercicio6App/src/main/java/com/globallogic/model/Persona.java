package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public abstract class Persona {
	private String DNI;
	private String nombre;
	
	public Persona() {}
	
	public Persona(String DNI) {
		this.setDNI(DNI);
	}
	
	public String getDNI() {
		return this.DNI;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.getDNI() + " " + this.nombre;
	}
	
	
}
