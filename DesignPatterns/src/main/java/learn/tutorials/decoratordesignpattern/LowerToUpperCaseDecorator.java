package learn.tutorials.decoratordesignpattern;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Decorator class that converts all the incoming string input's character to lowercase 
 * @author KD
 *
 */
public class LowerToUpperCaseDecorator extends FilterInputStream{

	//constructor passing imput stream to super class
	protected LowerToUpperCaseDecorator(InputStream in) {
		super(in);
	}
	
	//overriding the read method of super class to convert the character to lower case after reading it 
	@Override
	public int read() throws IOException{
		int character = super.read();
		return((character == -1)? character : Character.toLowerCase((char)character));
	}

	//overriding the read method of super class to convert the character to lower case after reading it
	@Override
	public int read(byte b[],int offset,int len) throws IOException {
		int read = super.read(b, offset, len);
		for(int i = 0; i<offset+read;i++){
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
        return read;
    }
	
}
