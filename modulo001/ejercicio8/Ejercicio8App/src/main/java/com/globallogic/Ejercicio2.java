package com.globallogic;

/**
 * 
 * @author jmpaniego
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
	    try {
			Object object = null;
			object.toString();
		} catch (NullPointerException e) {
			System.out.println("Se produjo una excepcion: null");
		}finally {
			System.out.println("Esto se ejecuta sin importar si se presentan errores");
		}
	}

}
