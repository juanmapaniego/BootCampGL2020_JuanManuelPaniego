package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public class Cafetera extends Electrodomestico {
	private Double litros;
	
	public Cafetera() {
		super();
	}

	public Double getLitros() {
		return litros;
	}

	public void setLitros(Double litros) {
		this.litros = litros;
	}
	
	public void elegirSabor(String sabor) {
		System.out.println("Sabbor elegido: " + sabor);
	}
	
	@Override
	public void encender() {
		System.out.println("Encendiendo cafetera");
	}
}
