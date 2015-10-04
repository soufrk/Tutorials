package learn.tutorial.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Demerits of synchronized method and merits of synchronized block on different
 * lock objects
 */
public class ThreadTutorial4 {

	Object lock1 = new Object();
	Object lock2 = new Object();
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public void state1() {
		try {
			synchronized (lock1) {
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}

	public synchronized void state2() {
		try {
			synchronized (lock2) {
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			state1();
			state2();
		}
	}

	public static void main(String[] args) {
		final ThreadTutorial4 tut4 = new ThreadTutorial4();
		long start = System.currentTimeMillis();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				tut4.process();
			}

		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				tut4.process();
			}

		});
		t.start();
		t2.start();
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Total Time : " + (end - start));
		System.out.println("List1.size() : " + tut4.list1.size()
				+ " List2.size() : " + tut4.list2.size());
	}

}
