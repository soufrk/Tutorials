package learn.tutorials.chainofresposibilitypattern;

@JobType(jobHandlerType = JobHandlerType.TYPE2)
public class ConcreteHandler2 extends AbstractHandler {

	@Override
	public void handleRequest(){
		System.out.println("ConcreteHandler2.handleRequest()");
	}
}
