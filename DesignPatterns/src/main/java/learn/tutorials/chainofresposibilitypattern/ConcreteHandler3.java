package learn.tutorials.chainofresposibilitypattern;

@JobType(jobHandlerType = JobHandlerType.TYPE3)
public class ConcreteHandler3 extends AbstractHandler {
	@Override
	public void handleRequest() {
		System.out.println("ConcreteHandler3.handleRequest()");
	}
}
