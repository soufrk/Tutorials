package learn.tutorial.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
 * Solution using wait(), notify() and synchronized block
 */
public class ProducerConsumer2 {

	private List<Integer> listOfIntegers = new LinkedList<>();
	private final int LIMIT = 10;
	private Object _lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (_lock) {
				while (listOfIntegers.size() == LIMIT) {
					_lock.wait();
				}
				System.out.println("Adding value to list");
				listOfIntegers.add(value++);
				_lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (_lock) {
				while (listOfIntegers.size() == 0) {
					_lock.wait();
				}
				int value = listOfIntegers.remove(0);
				System.out.println("Size Of List is: " + listOfIntegers.size()
						+ " & value removed is: " + value);
				_lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}
	}

	public static void main(String[] args) {
		final ProducerConsumer2 proCon = new ProducerConsumer2();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					proCon.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					proCon.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
