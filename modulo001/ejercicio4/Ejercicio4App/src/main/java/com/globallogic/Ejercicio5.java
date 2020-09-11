package com.globallogic;

/**
 * 
 * @author jmpaniego
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		Integer contador = 0;
		for (int i = 0; i < 10000; i++) {
			if(i % 20 == 0)
				contador++;
		}
		System.out.println("Valor final contador: " + contador);
	}

}
