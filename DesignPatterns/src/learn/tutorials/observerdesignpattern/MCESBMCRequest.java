package learn.tutorials.observerdesignpattern;

import learn.tutorials.strategydesginpattern.Aspera;
import learn.tutorials.strategydesginpattern.SubmitJob;
import learn.tutorials.strategydesginpattern.SubmitJobRequest;
import learn.tutorials.strategydesginpattern.TransferEngine;

public class MCESBMCRequest {
	public static void main(String[] args){
		TransferEngine engine = new Aspera();
		SubmitJobRequest sjr = new SubmitJobRequest();
		sjr.setJobXML("Job Number one");
		engine.setPrimaryAction(new SubmitJob(sjr));
		engine.executePrimaryAction();
		
		Scheduler scheduler = new Scheduler();
		scheduler.addObserver(new MCESBMCResponse());
		
		scheduler.addJob(engine);
		engine.getProgress();
	}
}
