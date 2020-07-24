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
			throw new Exception("Esto es una Excepcion");
		} catch (Exception e) {
			System.out.println("Se produjo ua excepcion: " + e.getMessage());
		}finally {
			System.out.println("Esto se ejecuta sin importar si se presentan errores");
		}
    	
    }
}
