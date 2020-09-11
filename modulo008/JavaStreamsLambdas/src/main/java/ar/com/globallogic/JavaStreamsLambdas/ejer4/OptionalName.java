package ar.com.globallogic.JavaStreamsLambdas.ejer4;

import java.util.Optional;

public class OptionalName implements IOptional {
    @Override
    public String getName(String name) {
	return Optional.ofNullable(name).orElse("Nombre recibido como null");
    }

    public static void main(String[] args) {
	OptionalName on = new OptionalName();

	System.out.println(on.getName("Juanma"));
	System.out.println(on.getName(null));
    }
}
