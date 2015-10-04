package learn.tutorial.threads;

public class ThreadTutorial1 {

	/**
	 * A thread can be created by two ways
	 * 
	 * 1. Implementing Runnable interface
	 * 
	 * 2. Extending Thread class
	 * 
	 * 3. We can create a thread using an anonymous class as well
	 */
	public static void main(String[] args) {
		// Runner implements Runnable interface and thus it gives the instance
		// of type Runnable
		Runner runner1 = new Runner();
		// RoadRunner extends Thread class and thus give an instance of type
		// Thread
		RoadRunner roadRunner = new RoadRunner("Thread 2");
		// Since runner1 is of type Runnable we need create a new thread and
		// pass runner1 to its constructor
		Thread t1 = new Thread(runner1, "Thread 1");
		// Since roadRunner is of type Thread we can directly invoke the start
		// method
		roadRunner.start();
		// Call start method of thread class
		t1.start();

		// We can also create a thread using an anonymous class where we just
		// need to create an instance of Runnable and write the logic in the
		// overloaded method run()
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello " + this.getClass().getName());
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();
	}

}
