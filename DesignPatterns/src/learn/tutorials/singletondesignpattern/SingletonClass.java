package learn.tutorials.singletondesignpattern;


public class SingletonClass implements Cloneable{
	// private static SingletonClass object = new SingletonClass();
	private static SingletonClass object;
	private String message;

	private SingletonClass() {
	};

	public static SingletonClass getInstance() {
		if (object == null) {
			synchronized (SingletonClass.class) {
				if (object == null)
					object = new SingletonClass();
			}
		}
		return object;
	}

	public void ShowMessage() {
		System.out.println(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
