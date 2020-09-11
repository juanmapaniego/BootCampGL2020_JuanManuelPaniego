package coverage.example;

import java.util.logging.Logger;

import coverage.example.model.Galaxy;
import coverage.example.model.Star;

public class Application {

	public static void main(String[] args) {
		
		System.out.println("Esto es una prueba");
		System.out.println("mostrando la galaxia:"+ new Galaxy("ViaLactea").name);
	}
}
