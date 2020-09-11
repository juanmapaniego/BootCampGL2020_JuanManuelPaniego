package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public class Electrodomestico {
	private String marca;
	private Double peso;
	private Character consumo;
	private String color;
	
	public Electrodomestico() {
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Character getConsumo() {
		return consumo;
	}

	public void setConsumo(Character consumo) {
		this.consumo = consumo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void encender() {
		System.out.println("Encendiendo electrodomestico");
	}
	
	public void apagar() {
		System.out.println("Apagando electrodomestico");
	}
}
