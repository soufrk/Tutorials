package demo.files.list.thread.itr;

import java.io.File;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FileCounter {

    public static Queue<String> fileNames = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
	String startDirPath = "D:\\threadDemo";
	ThreadCounter tc = new ThreadCounter();
	tc.dirPath = startDirPath;
	tc.start();
	tc.join();
	System.out.println("Total No of files: " + fileNames.size() + " and the file names are:");
	for (String s : fileNames)
	    System.out.println(s + "\t");

    }

}

class ThreadCounter extends Thread {

    public String dirPath = "";

    @Override
    public void run() {
	File[] files = Paths.get(dirPath).toFile().listFiles();
	for (File file : files) {
	    if (file.isDirectory()) {
		ThreadCounter tc = new ThreadCounter();
		tc.dirPath = file.getAbsolutePath();
		tc.start();
		try {
		    tc.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    } else {
		FileCounter.fileNames.add(file.getName());
	    }
	}
    }
}
