package learn.tutorials.commanddesignpattern;

public class EncryptFileAction implements UtilityActionCommand {

	public Config config;
	public DTO dto;
	public String key;
	
	public EncryptFileAction(Config config, DTO dto, String key) {
		this.config = config;
		this.dto = dto;
		this.key = key;
	}

	@Override
	public void execute() {
		System.out.println("Getting encrypted file location and source file loaction");
		System.out.println("Create Encrypted File");
		System.out.println("Creating Key file");
		new FileActionInvoker("Source", null, "Create", key);
	}

}
