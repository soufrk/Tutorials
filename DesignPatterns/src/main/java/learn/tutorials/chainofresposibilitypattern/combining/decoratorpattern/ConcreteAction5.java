package learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern;

/**
 * Concrete Decorators – Extending the base decorator functionality and
 * modifying the component behaviour accordingly.
 * 
 * @author KD
 *
 */
public class ConcreteAction5 extends ActionDecorator {

	public ConcreteAction5(Action action) {
		super(action);
	}
	
	public void execute(){
		super.execute();
		System.out.println("ConcreteAction5.execute()");
	}

}
