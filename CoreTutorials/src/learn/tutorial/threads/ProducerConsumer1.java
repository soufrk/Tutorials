package learn.tutorial.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The Producer/Consumer Problem This problem is one of the small collection of
 * standard, well-known problems in concurrent programming: a finite-size buffer
 * and two classes of threads, producers and consumers, put items into the
 * buffer (producers) and take items out of the buffer (consumers).
 * 
 * A producer must wait until the buffer has space before it can put something
 * in, and a consumer must wait until something is in the buffer before it can
 * take something out.
 * 
 * Solution using ArrayBlocking Queue
 */
public class ProducerConsumer1 {

	private static BlockingQueue<Integer> productQueue = new ArrayBlockingQueue<>(
			10);

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				producer();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				consumer();
			}
		});

		t1.start();
		t2.start();

//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}

	private static void producer() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep(100);
				productQueue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void consumer() {
		Random random = new Random();
		int product = 0;
		while (true) {
			try {
				Thread.sleep(100);
				if (random.nextInt(10) == 0) {
					product = productQueue.take();
					System.out.println("Product consumed is: " + product);
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("Queue size is: " + productQueue.size());
		}
	}
}
