package learn.tutorials.strategydesginpattern;

//The class Signiant denotes the behavior of Signiant Transfer Engine
public class Signiant extends AbstractTransferEngine implements TransferEngine {

	public Signiant() {
	}

	public Signiant(TransferEngine transferEngine) {
		this.primaryAction = transferEngine.getPrimaryAction();
		this.secondaryAction = transferEngine.getSecondaryAction();
		this.transferType = transferEngine.getTransferType();
	}

	@Override
	public void getProgress() {
		System.out
				.println("Implementing Signiant's business logic to get its progress");
		int progress = 0;
		while (progress <= 10) {
			System.out.println("Signiant progress : " + progress);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progress++;
		}
		System.out.println("Job Complete");
	}

	@Override
	public void evaluateTransferType() {
		System.out
				.println((transferType.equals("Audio") ? "transfer type unsupported in Signiant"
						: "transfer type supported in Signiant"));
	}

}
