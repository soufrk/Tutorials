package learn.tutorials.commanddesignpattern;

public class ContentClient {

	public static void main(String[] args) {
		Config config = new Config();
		DTO dto = new DTO();
		String taskType = "EssenceUpload";
		if(taskType.equalsIgnoreCase("EssenceUpload"))
			new ContentUploadAction(config, dto).execute();
		else
			new MigrateEssenceAction().execute();
	}

}
