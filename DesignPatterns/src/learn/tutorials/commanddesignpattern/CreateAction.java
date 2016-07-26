package learn.tutorials.commanddesignpattern;

public class CreateAction implements UtilityActionCommand{

	public String src;
	public String content;
	
	public CreateAction(String src, String content) {
		this.src = src;
		this.content = content;
	}

	@Override
	public void execute() {
		System.out.println("Creating file in given source with given content");
	}

}
