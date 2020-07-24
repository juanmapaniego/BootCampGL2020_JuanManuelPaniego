package com.globallogic;

/**
 * 
 * @author jmpaniego
 *
 */
public class PropiaClaseExcepcion {

	public static void main(String[] args) {
		try {
			throw new MiExcepcion("Mi excepcion");
		}catch (MiExcepcion e) {
			System.out.println(e.getMensaje());
		}

	}

}
