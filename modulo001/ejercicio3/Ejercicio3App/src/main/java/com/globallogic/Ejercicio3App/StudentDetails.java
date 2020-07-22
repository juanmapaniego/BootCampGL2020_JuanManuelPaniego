package com.globallogic.Ejercicio3App;

/**
 * 
 * @author jmpaniego
 *
 */
public class StudentDetails {
	public static void main(String[] args) {
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.studentAge(10);
	}
	
	public void studentAge(int ageParameter) {
		int age = 0;
		age += 5;
		System.out.println("La edad del estudiante es: " + age);
		System.out.println("La edad por parametro del estudiante es: " + ageParameter);
	}
}
