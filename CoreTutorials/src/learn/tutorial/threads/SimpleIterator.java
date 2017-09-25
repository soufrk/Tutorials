package demo.files.list.basic.itr;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SimpleIterator {
	public static List<String> fileList = new ArrayList<>();

	public static void main(String[] args) {
		Path dirPath = Paths.get("D:\\threadDemo");
		int fileCount = -1;
		fileCount = getRecursiveFileCount(dirPath.toFile());
		System.out.println("Total No of files: " + fileCount + " and the file names are:");
		for (String s : fileList) {
			System.out.print(s + "\t");
		}
	}

	private static int getRecursiveFileCount(File dir) {
		int fileCount = 0;
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				fileCount += getRecursiveFileCount(file);
			else {
				fileCount++;
				fileList.add(file.getName());
			}
		}
		return fileCount;
	}

}
