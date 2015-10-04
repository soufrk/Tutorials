package learn.tutorial.threads;

public class ThreadTutorial3 {
	public static int count = 0;

	/**
	 * use of synchronized keyword to make one thread wait while other is inside it
	 */
	public static synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++)
					increment();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++)
					increment();
			}
		});

		t1.start();
		t2.start();

		// thread.join() waits for a thread to die before proceeding further
		// without this line the value of count will not be proper as it is
		// incremented in a different thread
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count is : " + count);
	}

}
