package com.globallogic;

/**
 * 
 * @author jmpaniego
 *
 */
public class MiExcepcion extends Exception {
	private String mensaje;

	public MiExcepcion(String msj) {
		super(msj);
		this.mensaje = msj;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	

}
