package ar.com.globallogic.JavaStreamsLambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Ejer1 {
    public static void main(String[] args) {
	final List<String> cities = Arrays.asList("Quito", "Barcelona", "Madrid", "La Habana", "Paris", "New York",
		"Bogotá", "Rio de Janeiro", "Lima", "Buenos Aires");

	System.out.println("--Ciudades en mayuscula--");
	cities.stream().map(String::toUpperCase).forEach(System.out::println);
	System.out.println();

	System.out.println("--Ordenadas alfabeticamente--");
	cities.stream().sorted().forEach(System.out::println);
	System.out.println();

	System.out.println("--Primeras 3--");
	cities.stream().limit(3).sorted(Comparator.reverseOrder()).forEach(System.out::println);
	System.out.println();

	System.out.println("--Menos Lima--");
	cities.stream().filter(c -> !c.equals("Lima")).forEach(System.out::println);
	
    }
}
