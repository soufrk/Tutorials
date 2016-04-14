package learn.tutorials.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import learn.tutorials.strategydesginpattern.TransferEngine;

public class Scheduler extends Observable{
	private final List<TransferEngine> transfersList = new ArrayList<>();
	
	public void addJob(TransferEngine engine){
		transfersList.add(engine);
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public List<TransferEngine> getTransferList(){
		return this.transfersList;
	}
}
