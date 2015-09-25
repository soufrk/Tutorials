package learn.tutorials.singletondesignpattern;

public class SingletonClass {
	private static SingletonClass object = new SingletonClass();
	private String message;
	
	private SingletonClass(){};
	
	public static SingletonClass getInstance(){
		return object;
	}
	
	public void ShowMessage(){
		System.out.println(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
