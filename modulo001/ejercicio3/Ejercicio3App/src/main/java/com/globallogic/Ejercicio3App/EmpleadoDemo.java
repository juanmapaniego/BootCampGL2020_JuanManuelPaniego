package com.globallogic.Ejercicio3App;

/**
 * 
 * @author jmpaniego
 *
 */
public class EmpleadoDemo {

	public static void main(String[] args) {
		Empleado empleado = new Empleado("Alex",1000);
		System.out.println(empleado.getNombre() + 
				" tiene un salario promedio de "
				+ empleado.getSalario());
	}

}
