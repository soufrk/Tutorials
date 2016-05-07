package learn.tutorial.xml.parser.stax;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import learn.tutorial.xml.Catalog;
import learn.tutorial.xml.parser.stax.cursor.StAXCursorAPI;
import learn.tutorial.xml.parser.stax.cursor.StAXCursorWriteAPI;
import learn.tutorial.xml.parser.stax.iterator.StAXIteratorAPI;
import learn.tutorial.xml.parser.stax.iterator.StAXIteratorWriteApi;

/**
 * Java Streaming API for XML (Java StAX) provides implementation for processing
 * XML in java. StAX consists of two sets of API – cursor based API and iterator
 * based API.
 * 
 * @author KD
 *
 */
public class StAXDemo {

	public static void main(String[] args) throws XMLStreamException {
		/*
		 * StAX iterator API (READ)
		 */
		InputStream inputStream = StAXDemo.class.getClassLoader().getResourceAsStream("catalog.xml");
		Catalog catalogFromIteratorApi = StAXIteratorAPI.parseXML(inputStream);
		System.out.println(catalogFromIteratorApi);
		/*
		 * StAX iterator API (WRITE)
		 */ 
		String rootElement = "Employee";
		Map<String, String> elements = new HashMap<String,String>();
		elements.put("name", "Saurabh");
		elements.put("id", "1234");
		elements.put("age", "26");
		elements.put("role", "Java Developer");
		elements.put("gender", "Male");
		
		StAXIteratorWriteApi.writeXML(rootElement, elements);
		/*
		 * StAX cursor API (READ)
		 */
		inputStream = StAXDemo.class.getClassLoader().getResourceAsStream("catalog.xml");
		Catalog catalogFromCursorApi = StAXCursorAPI.parseXML(inputStream);
		System.out.println(catalogFromCursorApi);
		/*
		 * StAX cursor API (WRITE)
		 */
		StAXCursorWriteAPI.writeXML(rootElement, elements);
	}

}
