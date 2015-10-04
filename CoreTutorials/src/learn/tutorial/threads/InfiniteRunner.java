package learn.tutorial.threads;

public class InfiniteRunner extends Thread{
	public volatile boolean running  = true;
	public InfiniteRunner() {
	}

	public InfiniteRunner(String msg) {
		super(msg);
	}

	public void run() {
		while (running) {
			System.out.println("Hello\t" + this.getClass().getName());
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}

}
