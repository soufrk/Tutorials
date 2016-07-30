package learn.tutorials.strategydesginpattern;

public abstract class AbstractTransferEngine implements TransferEngine {
	
	PrimaryAction primaryAction;
	SecondaryAction secondaryAction;
	String transferType;
	
	@Override
	public void executePrimaryAction() {
		primaryAction.executePrimaryAction();
	}

	@Override
	public abstract void getProgress();
	
	@Override
	public void executeSecondaryAction(String msg) {
		secondaryAction.executeSecondaryAction(msg);
	}

	@Override
	public void setTransferType(String type) {
		this.transferType = type;
	}
	
	@Override
	public abstract void evaluateTransferType();
	
	@Override
	public void setPrimaryAction(PrimaryAction action){
		this.primaryAction = action;
	}
	
	@Override
	public void setSecondaryAction(SecondaryAction action){
		this.secondaryAction = action;
	}

	@Override
	public PrimaryAction getPrimaryAction() {
		return this.primaryAction;		
	}

	@Override
	public SecondaryAction getSecondaryAction() {
		return this.secondaryAction;
	}

	@Override
	public String getTransferType() {
		return this.transferType;
	}
}
