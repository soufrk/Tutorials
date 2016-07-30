package learn.tutorials.chainofresposibilitypattern;

import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.Action;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.BaseAction;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction2;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction4;
import learn.tutorials.chainofresposibilitypattern.combining.decoratorpattern.ConcreteAction5;

@JobType(jobHandlerType = JobHandlerType.TYPE2)
public class ConcreteHandler2 implements Handler {

	@Override
	public void handleRequest(){
		System.out.println("ConcreteHandler2.handleRequest()");
		Action action = new ConcreteAction5(
				new ConcreteAction4(new ConcreteAction2(new BaseAction())));
		action.execute();
	}
}
