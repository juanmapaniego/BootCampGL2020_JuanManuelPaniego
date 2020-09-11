package com.globallogic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.globallogic.model.Electrodomestico;
import com.globallogic.model.Heladera;

/**
 * 
 * @author jmpaniego
 *
 */
public class Herencia 
{
    public static void main( String[] args )
    {
    	Electrodomestico electrodomestico = new Electrodomestico();
    	Heladera heladera = new Heladera();
    	
    	System.out.println("Electrodomestico");
    	System.out.println("\tMetodos:");
    	for (Method m : electrodomestico.getClass().getMethods()) {
			System.out.println("\t\t" + m.getName());
		}
    	System.out.println("\tAtributos:");
    	for( Field f: electrodomestico.getClass().getDeclaredFields()){
    		System.out.println("\t\t" + f.getName());
    	}
    	
    	System.out.println();
    	System.out.println("Heladera");
    	System.out.println("\tMetodos:");
    	for (Method m : heladera.getClass().getMethods()) {
			System.out.println("\t\t" + m.getName());
		}
    	System.out.println("\tAtributos:");
    	for( Field f: heladera.getClass().getDeclaredFields()){
    		System.out.println("\t\t" + f.getName());
    	}
    }
}
