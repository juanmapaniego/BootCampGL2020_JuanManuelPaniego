package ar.com.globallogic.JavaStreamsLambdas.ejer3;

public interface Car {
    String getModel();

    default int getDoors() {
	return 4;
    }
}
