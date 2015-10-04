package learn.tutorial.threads;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {

	int count = 0;
	ReentrantLock lock1 = new ReentrantLock();
	ReentrantLock lock2 = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		final DeadlockDemo lockDemo = new DeadlockDemo();
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
		lock1.lock();
		Thread.sleep(1000);
		lock2.lock();
		try {
			for (int i = 0; i < 2000; i++)
				increment();
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void consumer() {
		lock2.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock1.lock();
		try{
			for (int i = 0; i < 2000; i++)
				increment();
		} finally {
			lock2.unlock();
			lock1.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}

}
