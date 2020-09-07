package ar.com.globallogic.JavaStreamsLambdas;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class Ejer2 {
    public static void main(String[] args) {
	final int[] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };

	IntStream stream = Arrays.stream(values);
	Arrays.stream(values).forEach(System.out::println);

	System.out.println("Tiene " + Arrays.stream(values).count() + " elementos");

	Arrays.stream(values).min().ifPresent(min -> System.out.println("El minimo es " + min));
	Arrays.stream(values).max().ifPresent(max -> System.out.println("El maximo es " + max));
	Arrays.stream(values).average().ifPresent(avg -> System.out.println("El promedio es " + avg));
    }
}
