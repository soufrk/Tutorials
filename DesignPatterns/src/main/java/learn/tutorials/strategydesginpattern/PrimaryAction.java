package learn.tutorials.strategydesginpattern;

public interface PrimaryAction {
	public void executePrimaryAction();
	
	public void setSubmitRequest(SubmitJobRequest request);
	
	public SubmitJobRequest getSubmitRequest();
}
