package learn.tutorials.singletondesignpattern;


public class SingletonClass2 implements Cloneable{
	// private static SingletonClass object = new SingletonClass();
	private static SingletonClass2 object;
	private String message;

	private SingletonClass2() {
	};

	public static SingletonClass2 getInstance() {
		if (object == null) {
			synchronized (SingletonClass2.class) {
				if (object == null)
					object = new SingletonClass2();
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
