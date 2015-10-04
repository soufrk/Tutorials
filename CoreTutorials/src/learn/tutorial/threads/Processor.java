package learn.tutorial.threads;

import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable{
	int id;
	CountDownLatch latch = null;
	public Processor(int id){
		this.id = id;
	}
	public Processor(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println("Starting Processor " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completing Processor " + id);
		if(latch != null)
			latch.countDown();
	}
}
