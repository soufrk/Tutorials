package learn.tutorial.xml.parser.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import learn.tutorial.xml.Catalog;

/**
 * <ul>
 * <li>Java SAX Parser provides API to parse XML documents. SAX Parsers are
 * different than DOM parser because it doesn’t load complete XML into memory
 * and read xml document sequentially. It’s an event based parser and we need to
 * implement our Handler class with callback methods to parse XML file. It’s
 * more efficient than DOM Parser for large XML files in terms of time and
 * memory usage.</li>
 * <li>Usage :</li>
 * <ol>
 * <li>Read XML</li>
 * </ol>
 * </ul>
 * 
 * @author KD
 *
 */
public class SAXdemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		/*
		 * 1) Get new instance of sex parser factory.
		 */
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		/*
		 * 2) Create new instance of handler created by you.
		 */
		SAXEventHandler saxEventHandler = new SAXEventHandler();
		/*
		 * 3) Get new instance of SaxParser from sax parser factory.
		 */
		SAXParser saxParser = saxParserFactory.newSAXParser();
		/*
		 * 4) Call the parse method of sax parser and pass the xml as input
		 * stream along with the instance of the handler created.
		 */
		saxParser.parse(SAXdemo.class.getClassLoader().getResourceAsStream("catalog.xml"), saxEventHandler);
		/*
		 * 5) Get the outer most tag class variable containing the complete xml
		 * parsed in your handler.
		 */
		Catalog catalog = saxEventHandler.catalog;
		System.out.println(catalog);

	}
}
