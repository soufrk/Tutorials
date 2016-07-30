package learn.tutorials.chainofresposibilitypattern;

import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.Action;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.BaseAction;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction1;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction2;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction3;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction4;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction5;

@JobType(jobHandlerType = JobHandlerType.TYPE1)
public class ConcreteHandler1 implements Handler {

	@Override
	public void handleRequest() {
		System.out.println("ConcreteHandler1.handleRequest()");
		Action action = new ConcreteAction5(
				new ConcreteAction4(new ConcreteAction3(new ConcreteAction2(new ConcreteAction1(new BaseAction())))));
		action.execute();
	}
}
