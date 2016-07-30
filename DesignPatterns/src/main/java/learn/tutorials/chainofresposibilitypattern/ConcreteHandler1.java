package learn.tutorials.chainofresposibilitypattern;

@JobType(jobHandlerType = JobHandlerType.TYPE1)
public class ConcreteHandler1 implements Handler {
	
	@Override
	public void handleRequest(){
		System.out.println("ConcreteHandler1.handleRequest()");
	}
}
