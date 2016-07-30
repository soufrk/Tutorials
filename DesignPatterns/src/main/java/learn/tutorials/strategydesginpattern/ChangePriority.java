package learn.tutorials.strategydesginpattern;

public class ChangePriority implements SecondaryAction{

	@Override
	public void executeSecondaryAction(String msg) {
		System.out.println("Changing the priority");
		System.out.println(msg);
		System.out.println("Priority Changed Successfully");
	}

}
