package learn.tutorials.chainofresposibilitypattern;

@JobType(jobHandlerType = JobHandlerType.TYPE3)
public class ConcreteHandler3 implements Handler {
	@Override
	public void handleRequest() {
		System.out.println("ConcreteHandler3.handleRequest()");
	}
}
