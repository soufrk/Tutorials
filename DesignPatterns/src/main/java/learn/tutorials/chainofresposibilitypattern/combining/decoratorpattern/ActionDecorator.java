package learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern;

/**
 * Decorator – Decorator class implements the component interface and it has a
 * HAS-A relationship with the component interface. The component variable
 * should be accessible to the child decorator classes, so we will make this
 * variable protected.
 * 
 * @author KD
 *
 */
public class ActionDecorator implements Action {

	protected Action action;

	public ActionDecorator(Action action) {
		this.action = action;
	}

	@Override
	public void execute() {
		this.action.execute();
	}

}
