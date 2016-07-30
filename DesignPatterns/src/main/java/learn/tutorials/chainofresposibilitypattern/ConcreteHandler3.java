package learn.tutorials.chainofresposibilitypattern;

import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.Action;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.BaseAction;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction3;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction4;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction5;

@JobType(jobHandlerType = JobHandlerType.TYPE3)
public class ConcreteHandler3 implements Handler {
	@Override
	public void handleRequest() {
		System.out.println("ConcreteHandler3.handleRequest()");
		Action action = new ConcreteAction5(new ConcreteAction4(new ConcreteAction3(new BaseAction())));
		action.execute();
	}
}
