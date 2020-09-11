package mockito.example.exceptions;

public class ZeroDivisionException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ZeroDivisionException() {
		super();
	}
	
	public ZeroDivisionException(String msg) {
		super(msg);
		this.message = msg;
	}
}
