package learn.tutorial.threads;

public class RoadRunner extends Thread {

	public RoadRunner() {
	}

	public RoadRunner(String msg) {
		super(msg);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i + "\t" + this.getClass().getName());
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
