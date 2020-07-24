package com.globallogic;

import java.util.Scanner;

/**
 * 
 * @author jmpaniego
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingrese gasto: ");
		Double gasto = input.nextDouble();
		Double descuento = 0.0;
		if(gasto > 300) {
			if(gasto > 350) {
				descuento = gasto * 0.25;
			}else {
				descuento = gasto * 0.2;
			}
		}
		
		if(descuento > 0) {
			System.out.println("El descuento es de: "+ descuento + 
					", total es: " + (gasto - descuento));
		}else {
			System.out.println("Sin descuento, el total es: "+ gasto);
		}
			
	}

}
