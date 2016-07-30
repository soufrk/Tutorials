package learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern;

/**
 * Concrete Decorators – Extending the base decorator functionality and
 * modifying the component behaviour accordingly.
 * 
 * @author KD
 *
 */
public class ConcreteAction3 extends ActionDecorator {

	public ConcreteAction3(Action action) {
		super(action);
	}
	
	public void execute(){
		super.execute();
		System.out.println("ConcreteAction3.execute()");
	}

}
