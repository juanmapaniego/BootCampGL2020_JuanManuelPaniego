package ar.com.globallogic.JavaStreamsLambdas.ejer3;

public class App {

    public static void main(String[] args) {
	Car lamborghini = new Lamborghini();
	Car fiat = new Fiat();

	System.out.println(lamborghini.getModel());
	System.out.println(lamborghini.getDoors());

	System.out.println(fiat.getModel());
	System.out.println(fiat.getDoors());
    }

}
