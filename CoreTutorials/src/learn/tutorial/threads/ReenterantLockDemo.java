package learn.tutorial.threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLockDemo {

	int count = 0;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		final ReenterantLockDemo lockDemo = new ReenterantLockDemo();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					lockDemo.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				lockDemo.consumer();
			}
		});
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		lockDemo.finished();
	}

	public void increment() {
		count++;
	}

	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting...");
		condition.await();
		System.out.println("Woken Up");
		try {
			for (int i = 0; i < 2000; i++)
				increment();
		} finally {
			lock.unlock();
		}
	}

	public void consumer() {
		lock.lock();
		System.out.println("Press return to resume");
		try (Scanner in = new Scanner(System.in)) {
			in.nextLine();
			System.out.println("Resumed");
			condition.signal();
			for (int i = 0; i < 2000; i++)
				increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}

}
