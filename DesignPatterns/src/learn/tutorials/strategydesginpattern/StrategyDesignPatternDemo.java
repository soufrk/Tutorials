package learn.tutorials.strategydesginpattern;

/**
 * 
 * @author KD
 *
 */
public class StrategyDesignPatternDemo {
	
	public static void main(String[] args) {
		TransferEngine transferEngine1 = new Aspera();
		SubmitJobRequest request = new SubmitJobRequest();
		request.setJobXML("JOB XML");
		transferEngine1.setPrimaryAction(new SubmitJob(request));
		transferEngine1.executePrimaryAction();
		transferEngine1.setSecondaryAction(new Pause());
		transferEngine1
				.executeSecondaryAction("Aspera secondary Action : Pause");
		transferEngine1.getProgress();
		transferEngine1.setTransferType("Essence");
		transferEngine1.evaluateTransferType();
		
		TransferEngine transferEngine2 = new Signiant(transferEngine1);
		System.out.println(transferEngine2.getPrimaryAction().getSubmitRequest().getJobXML());
		transferEngine2.executePrimaryAction();
		transferEngine2.evaluateTransferType();
		
		TransferEngine transferEngine3 = new Aspera(transferEngine2);
		System.out.println(transferEngine3.getPrimaryAction().getSubmitRequest().getJobXML());

		/*TransferEngine transferEngine2 = new Signiant();
		transferEngine2.setPrimaryAction(new SubmitJob());
		transferEngine2.executePrimaryAction();
		transferEngine2.setSecondaryAction(new ChangePriority());
		transferEngine2
				.executeSecondaryAction("Signiant secondary Action : ChangePriority");
		transferEngine2.getProgress();*/
	}
}
