package com.globallogic;

import java.util.ArrayList;
import java.util.List;

import com.globallogic.model.Cafetera;
import com.globallogic.model.Electrodomestico;
import com.globallogic.model.Heladera;
import com.globallogic.model.Televisor;

/**
 * 
 * @author jmpaniego
 *
 */
public class Polimorfimo {
	public static void main( String[] args )
    {
		List<Electrodomestico> lista = new ArrayList<Electrodomestico>();
		lista.add(new Heladera());
		lista.add(new Televisor());
		lista.add(new Cafetera());
		
		for (Electrodomestico electrodomestico : lista) {
			electrodomestico.encender();
		}
    }
}
