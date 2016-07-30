package learn.tutorials.strategydesginpattern;

// Denotes the general tasks of various transfer engines available
public interface TransferEngine {

	// Transfer Engine has a primary action
	public void executePrimaryAction();

	// Get the progress of an ongoing job
	public void getProgress();

	// Execute a secondary action on an ongoing job
	public void executeSecondaryAction(String msg);

	// Transfer Type - Video/Audio/Essence
	public void setTransferType(String type);
	
	//get transfer type
	public String getTransferType();

	//set primary action type
	public void setPrimaryAction(PrimaryAction action);

	//set secondary action type
	public void setSecondaryAction(SecondaryAction action);

	//get primary action type
	public PrimaryAction getPrimaryAction();

	//get secondary action type
	public SecondaryAction getSecondaryAction();
	
	//evaluate the given transferType
	public void evaluateTransferType();
}
