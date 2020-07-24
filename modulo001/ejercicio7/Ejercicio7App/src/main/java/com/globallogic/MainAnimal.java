package com.globallogic;

import com.globallogic.model.Animal;
import com.globallogic.model.Perro;

/**
 * 
 * @author jmpaniego
 *
 */
public class MainAnimal 
{
    public static void main( String[] args )
    {
    	Animal dog = new Perro();
    	System.out.println(dog.sonidoAnimal());
    	System.out.println(dog.dormir());
    }
}
