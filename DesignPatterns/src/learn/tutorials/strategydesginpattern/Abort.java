package learn.tutorials.strategydesginpattern;

public class Abort implements SecondaryAction {

	@Override
	public void executeSecondaryAction(String msg) {
		System.out.println("Aborting a job");
		System.out.println(msg);
		System.out.println("Job aborted Successfully");
	}

}
