package com.globallogic;

import com.globallogic.model.Gato;

/**
 * 
 * @author jmpaniego
 *
 */
public class Encapsulamiento {

	public static void main(String[] args) {
		Gato gato = new Gato();
		
		gato.setNombre("michi");
		gato.setPatas(4);
		
		System.out.println("Nombre: " + gato.getNombre());
		System.out.println("Patas: " + gato.getPatas());
	}

}
