package learn.tutorials.strategydesginpattern;

public class Pause implements SecondaryAction {

	@Override
	public void executeSecondaryAction(String msg) {
		System.out.println("Pausing a job");
		System.out.println(msg);
		System.out.println("Job Paused Successfully");
	}
}
