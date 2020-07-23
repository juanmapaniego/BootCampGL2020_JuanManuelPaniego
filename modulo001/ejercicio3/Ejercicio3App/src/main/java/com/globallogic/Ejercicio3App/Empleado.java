package com.globallogic.Ejercicio3App;

/**
 * 
 * @author jmpaniego
 *
 */
public class Empleado {
	static double salario;
	static String nombre;
	
	public Empleado(double salario) {
		nombre = "Alex";
		this.salario = salario;
	}

	public static double getSalario() {
		return salario;
	}

	public static String getNombre() {
		return nombre;
	}
	
}
