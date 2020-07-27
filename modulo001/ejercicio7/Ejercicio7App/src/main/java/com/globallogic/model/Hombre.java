package com.globallogic.model;
/**
 * 
 * @author jmpaniego
 *
 */
public class Hombre implements Animal,Persona{

	@Override
	public String hablar() {
		return "Las personas hablan mucho";
	}

	@Override
	public String dormir() {
		return "El hombre duerme muchas horas";
	}

	@Override
	public String sonidoAnimal() {
		return "El hombre no hace sonidos de animal";
	}
	
	public static void main( String[] args ) {
		Hombre hombre = new Hombre();
		
		System.out.println(hombre.dormir());
		System.out.println(hombre.hablar());
		System.out.println(hombre.sonidoAnimal());
		hombre.come();
	}
	
}
