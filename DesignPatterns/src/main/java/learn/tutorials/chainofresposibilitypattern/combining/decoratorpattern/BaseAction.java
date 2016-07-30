package learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern;

/**
 * Component Implementation – The basic implementation of the component
 * interface.
 * 
 * @author KD
 *
 */
public class BaseAction implements Action {

	@Override
	public void execute() {
		System.out.println("BaseAction.execute()");
	}

}
