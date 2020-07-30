package com.globallogic.bootcampgl.junitTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public int sum(int num1, int num2) {
    	return num1 + num2;
    }
    
    public boolean ejer7(int limit) {
    	for (int i = 0; i < limit; i++) {
			if(i == 3)
				return true;
		}
    	return false;
    }
}
