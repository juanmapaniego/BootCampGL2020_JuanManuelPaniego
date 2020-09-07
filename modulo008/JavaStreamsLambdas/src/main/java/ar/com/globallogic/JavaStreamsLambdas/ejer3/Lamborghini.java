package ar.com.globallogic.JavaStreamsLambdas.ejer3;

public class Lamborghini implements Car {
    @Override
    public String getModel() {
	return getClass().getName();
    }
}
