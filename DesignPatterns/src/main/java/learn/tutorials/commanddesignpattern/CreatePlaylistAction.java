package learn.tutorials.commanddesignpattern;

import java.io.File;
import java.util.List;

public class CreatePlaylistAction implements UtilityActionCommand {

	public List<File> fileList;
	public String destination;
	public String key;

	public CreatePlaylistAction(List<File> fileList, String destination, String key) {
		this.fileList = fileList;
		this.destination = destination;
		this.key = key;
	}

	@Override
	public void execute() {
		System.out.println("Generating playlist");
		System.out.println("Creating Playlist");
		new FileActionInvoker("Source", null, "Create", "playlist");
		System.out.println("Creating key");
		new FileActionInvoker("Source", null, "Create", "key").execute();
	}

}
