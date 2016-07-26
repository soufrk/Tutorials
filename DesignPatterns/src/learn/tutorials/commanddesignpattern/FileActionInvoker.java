package learn.tutorials.commanddesignpattern;

public class FileActionInvoker implements UtilityActionCommand {

	public String src;
	public String dest;
	public String action;
	public String content;
	
	public FileActionInvoker(String src, String dest, String action, String content){
		this.src = src;
		this.dest = dest;
		this.action = action;
		this.content = content;
	}
	
	@Override
	public void execute() {
		if(action.equalsIgnoreCase("move")){
			new MoveAction(src,dest).execute();
		} else if(action.equalsIgnoreCase("copy")){
			new CopyAction(src,dest).execute();
		} else if(action.equalsIgnoreCase("create")){
			new CreateAction(src, content).execute();
		}
	}

}
