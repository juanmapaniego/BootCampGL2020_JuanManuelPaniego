package com.globallogic.Ejercicio3App;

/**
 * 
 * @author jmpaniego
 *
 */
public class Empleado {
	static double salario;
	static String nombre;
	
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
	}

	public static double getSalario() {
		return salario;
	}

	public static String getNombre() {
		return nombre;
	}
	
}
