package com.globallogic;

import java.security.AllPermission;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.globallogic.model.Empleado;

/**
 * 
 * @author jmpaniego
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int maximosEmpleados = 20;
    	Empleado[] arrayEmpleado = new Empleado[maximosEmpleados];
    	
    	Scanner input = new Scanner(System.in);
    	System.out.println("Ingrese numero de empleados a leer");
    	int aLeer = input.nextInt();
    	if(aLeer > 20) {
    		System.out.println("No se puede leer mas de 20 empleados");
    		aLeer = 20;
    	}
    	input.nextLine();//flush
    	Empleado empleado;
    	for(int i=0;i<aLeer;i++) {
    		empleado = new Empleado();
    		System.out.println("Ingrese DNI: ");
    		empleado.setDNI(input.nextLine());
    		System.out.println("Ingrese Nombre: ");
    		empleado.setNombre(input.nextLine());
    		System.out.println("Ingrese Sueldo base: ");
    		empleado.setSueldoBase(input.nextDouble());
    		System.out.println("Ingrese horas extra: ");
    		empleado.setHorasExtra(input.nextDouble());
    		System.out.println("Ingrese tipo IRPF: ");
    		empleado.setTipoIRPF(input.nextDouble());
    		System.out.println("Es casado [Y/n]: ");
    		
    		input.nextLine();//flush
    		String casado = input.nextLine().trim(); 
    		empleado.setCasado(
    			casado.equals("Y") ? true : false
    		);
    		System.out.println("Ingrese numero de hijos: ");
    		empleado.setNumeroHijos(input.nextInt());
    		input.nextLine();//flush
    		
    		//seteamos al empleado en el arreglo
    		arrayEmpleado[i] = empleado;
    	}
    	
    	//leemos la el importe ylo seteamos a la clase
    	System.out.println("Ingrese importe de horas extra: ");
    	Empleado.setImporteHoraExtra(
    		input.nextDouble()
    	);
    	input.close();
    	
    	// Arrays.sort(array, from, to, comparator)
    	Arrays.sort(arrayEmpleado, 0, aLeer, Comparator.comparingDouble(Empleado::getSueldoBase).reversed());
    	System.out.println("El empleado que mas cobra es: ");
    	System.out.println(arrayEmpleado[0]);
    	System.out.println("El empleado que menos cobra es: ");
    	System.out.println(arrayEmpleado[aLeer - 1]);
    	
    	Arrays.sort(arrayEmpleado, 0, aLeer, Comparator.comparingDouble(Empleado::getHorasExtra).reversed());
    	System.out.println("El empleado que mas horas extra hizo es: ");
    	System.out.println(arrayEmpleado[0]);
    	System.out.println("El empleado que menos horas extra hizo es: ");
    	System.out.println(arrayEmpleado[aLeer - 1]);
    	
    	
    	Arrays.sort(arrayEmpleado, 0, aLeer, Comparator.comparingDouble(Empleado::sueldoBruto));
    	System.out.println("Lista empleados ordenadas por sueldo: ");
    	System.out.println();
    	for (int i = 0; i < aLeer; i++) {
			System.out.println(arrayEmpleado[i]);
		}
    }
}
