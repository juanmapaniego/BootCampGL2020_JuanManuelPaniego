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
			Object object = null;
			object.toString();
		} catch (Exception e) {
			System.out.println("Se produjo ua excepcion: " + e.getMessage());
		}
    	
    }
}
