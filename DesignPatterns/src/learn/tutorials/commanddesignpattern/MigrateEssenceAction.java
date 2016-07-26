package learn.tutorials.commanddesignpattern;

public class MigrateEssenceAction implements ContentActionCommand {

	@Override
	public void execute() {
		System.out.println("Inside Migrate Essence Action");
	}

}
