package learn.tutorials.strategydesginpattern;

// The class Aspera simulates the behavior of Aspera Transfer Engine
public class Aspera extends AbstractTransferEngine implements TransferEngine {

	public Aspera() {
	}

	public Aspera(TransferEngine transferEngine) {
		this.primaryAction = transferEngine.getPrimaryAction();
		this.secondaryAction = transferEngine.getSecondaryAction();
		this.transferType = transferEngine.getTransferType();
	}

	@Override
	public void getProgress() {
		System.out
				.println("Implementing Aspera's business logic to get its progress");
		int progress = 0;
		while (progress <= 10) {
			System.out.println("Aspera progress : " + progress);
			try {
				Thread.sleep(500);
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
				.println((transferType.equals("Essence") ? "transfer type unsupported in Aspera"
						: "transfer type supported in Aspera"));
	}

}
