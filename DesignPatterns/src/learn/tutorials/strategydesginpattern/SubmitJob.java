package learn.tutorials.strategydesginpattern;

public class SubmitJob implements PrimaryAction {

	private SubmitJobRequest request;

	public SubmitJob(SubmitJobRequest request) {
		setSubmitRequest(request);
	}

	@Override
	public void executePrimaryAction() {
		System.out.println("Submitting a job");
	}

	public SubmitJobRequest getRequest() {
		return request;
	}

	public void setSubmitRequest(SubmitJobRequest request) {
		this.request = request;
	}

	@Override
	public SubmitJobRequest getSubmitRequest() {
		return this.request;
	}

}
