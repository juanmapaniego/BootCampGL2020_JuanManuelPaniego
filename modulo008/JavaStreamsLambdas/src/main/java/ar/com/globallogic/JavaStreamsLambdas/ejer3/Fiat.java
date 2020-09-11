package ar.com.globallogic.JavaStreamsLambdas.ejer3;

public class Fiat implements Car {
    @Override
    public String getModel() {
	return getClass().getName();
    }

    @Override
    public int getDoors() {
	return 5;
    }
}
