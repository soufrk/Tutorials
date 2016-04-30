package learn.tutorial.xml.parser.stax;

import java.io.InputStream;

import learn.tutorial.xml.Catalog;
import learn.tutorial.xml.parser.stax.iterator.StAXIteratorAPI;

/**
 * Java Streaming API for XML (Java StAX) provides implementation for processing
 * XML in java. StAX consists of two sets of API – cursor based API and iterator
 * based API.
 * 
 * @author KD
 *
 */
public class StAXDemo {

	public static void main(String[] args) {
		InputStream inputStream = StAXDemo.class.getClassLoader().getResourceAsStream("catalog.xml");
		Catalog catalogFromIteratorApi = StAXIteratorAPI.parseXML(inputStream);
		System.out.println(catalogFromIteratorApi);

	}

}
