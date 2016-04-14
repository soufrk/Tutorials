package learn.tutorials.strategydesginpattern;

public class Resume implements SecondaryAction{

	@Override
	public void executeSecondaryAction(String msg) {
		System.out.println("Resuming a job");
		System.out.println(msg);
		System.out.println("Job resumed Successfully");
	}

}
