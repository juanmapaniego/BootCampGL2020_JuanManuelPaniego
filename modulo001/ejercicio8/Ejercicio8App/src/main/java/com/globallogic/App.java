package com.globallogic;

/**
 * 
 * @author jmpaniego
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			Object[] array = new Object[1];
			array[2].toString();
		} catch (ArrayIndexOutOfBoundsException e) {			
			System.out.println("Execpcion: indice de array fuera de limites");
		}
    	
    }
}
