package ar.com.globallogic.Java11;

/**
 * Hello world!
 *
 */
public class App {

    private static void repeat(String r, int times) {
	System.out.println(r.repeat(times));
    }

    public static void main(String[] args) {
	String test = "";
	System.out.println(test.isBlank());
	test = " ";
	System.out.println(test.isBlank());
	test = "	a	";
	System.out.println(test.isBlank());
	test = "	";
	System.out.println(test.isBlank());

	/* REPEAT */
	App.repeat("Test", 4);

	/* STRIP */
	test = " 	Test Strip	";
	System.out.println(test.strip());
	System.out.println(test.stripLeading());
	System.out.println(test.stripTrailing());
    }
}
