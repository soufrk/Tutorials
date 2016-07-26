package learn.tutorials.commanddesignpattern;

import java.io.File;
import java.util.ArrayList;

public class ContentUploadAction implements ContentActionCommand {
	
	public Config config;
	public DTO dto;
	
	public ContentUploadAction(Config config, DTO dto){
		this.config = config;
		this.dto = dto;
	}
	
	@Override
	public void execute() {
		System.out.println("Inside Essence Upload");
		System.out.println("Forming source and destination");
		new FileActionInvoker("Source", "Destination", "Move", null).execute();
		System.out.println("Creating Encrypted File");
		String key = "key";
		new EncryptFileAction(config,dto, key).execute(); 
		System.out.println("Creating Playlist File");
		System.out.println("Creating File List and Getting the location");
		new CreatePlaylistAction(new ArrayList<File>(), "destination", key).execute();
	}

}
