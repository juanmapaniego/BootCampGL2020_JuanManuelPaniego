package com.globallogic;

/**
 * 
 * @author jmpaniego
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		String input = "Ab";
		
		if(Character.isUpperCase(input.charAt(0))) {
			System.out.println(input.charAt(0) + " es una letra mayuscula");
		}else {
			System.out.println(input.charAt(0) + " es una letra minuscula");
		}
		
		if(Character.isUpperCase(input.charAt(1))) {
			System.out.println(input.charAt(1) + " es una letra mayuscula");
		}else {
			System.out.println(input.charAt(1) + " es una letra minuscula");
		}
	}

}
