package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public interface Persona {
	String hablar();
	String dormir();
	
	default void come() {
		System.out.println("Se ejecuta metodo de la clase hombre.");
	}
}
