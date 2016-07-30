package learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern;

/**
 * Concrete Decorators – Extending the base decorator functionality and
 * modifying the component behaviour accordingly.
 * 
 * @author KD
 *
 */
public class ConcreteAction4 extends ActionDecorator {

	public ConcreteAction4(Action action) {
		super(action);
	}
	
	public void execute(){
		super.execute();
		System.out.println("ConcreteAction4.execute()");
	}

}
