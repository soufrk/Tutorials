package learn.tutorials.decoratordesignpattern;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

/**
 * Convert the given String to Lower case using decorator pattern and java.io package
 * @author KD
 *
 */
public class IOClassDecoratorImplementation {
	
	public static void main(String[] args){
		//Input string
		String string = "I know The DECORATOR Pattern Therefore I RULE";
		//Reading string as input stream
		InputStream inputStream = new StringBufferInputStream(string);
		//passing the stream to our decorator
		inputStream = new LowerToUpperCaseDecorator(inputStream);
		try {
			int c = 0;
			//while stream has character i.e. inputstream.read() != -1
			while((c = inputStream.read()) > 0){
				//print out the character to console
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
