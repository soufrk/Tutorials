package learn.tutorials.chainofresposibilitypattern;

public abstract class AbstractHandler implements Handler {

	@Override
	public void handleRequest() {
		System.out.println("AbstractHandler.handleRequest()");
	}
}
