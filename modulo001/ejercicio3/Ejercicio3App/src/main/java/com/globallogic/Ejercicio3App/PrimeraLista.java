package com.globallogic.Ejercicio3App;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jmpaniego
 *
 */
public class PrimeraLista {

	public static void main(String[] args) {
		List<String> letters = new ArrayList<>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		System.out.println(letters);
		
		letters.add(0,"X");
		System.out.println(letters);
	}

}
