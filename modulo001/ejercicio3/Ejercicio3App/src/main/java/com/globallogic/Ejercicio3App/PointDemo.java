package com.globallogic.Ejercicio3App;

/**
 * 
 * @author jmpaniego
 *
 */
public class PointDemo {

	public static void main(String[] args) {
		VariableInstancia vl = new VariableInstancia();
		vl.setEngPoints(50);
		vl.setMathsPoints(80);
		System.out.println("EngPoints " + vl.getEngPoints() +
				" MathsPoints " + vl.getMathsPoints());
	}

}
