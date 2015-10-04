package learn.tutorial.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTutorial5n6 {

	/**
	 * Thread Pool (Executor Service & CountDown Latch)
	 */
	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(2);
		for(int i = 0; i<5 ; i++){
			executors.submit(new Processor(i));
		}
		executors.shutdown();
		System.out.println("All tasks submitted");
		try {
			executors.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executors2 = Executors.newFixedThreadPool(3);
		for(int i = 0; i<3 ; i++){
			executors2.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executors2.shutdown();
		System.out.println("Completed");
	}

}
