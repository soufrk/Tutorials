package learn.tutorials.jaxrs.messenger.exceptions;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -20001645156185600L;

	public DataNotFoundException(){
		super();
	}
	
	public DataNotFoundException(String message) {
		super(message);
	}
	
}
