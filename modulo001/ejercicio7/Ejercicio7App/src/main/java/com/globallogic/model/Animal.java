package com.globallogic.model;
/**
 * 
 * @author jmpaniego
 *
 */
public interface Animal {
	String dormir();
	
	String sonidoAnimal();
	
	default void come(String s) {
		System.out.println("El " + s + " se alimenta.");
	}
	
	static void camina(String s) {
		System.out.println("El " + s + " camina.");
	}
}
