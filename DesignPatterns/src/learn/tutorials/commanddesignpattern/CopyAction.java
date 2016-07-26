package learn.tutorials.commanddesignpattern;

public class CopyAction implements UtilityActionCommand{

	public String src;
	public String dest;
	
	public CopyAction(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	@Override
	public void execute() {
		System.out.println("Copying file from source to destination");
	}

}
