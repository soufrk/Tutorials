package learn.tutorial.xml.parser.stax.iterator;

import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXIteratorWriteApi {

	public static void writeXML(String rootElement, Map<String, String> elements) throws XMLStreamException {
		/*
		 * Create XML Stream writer and
		 */
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
		XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(System.out);

		/*
		 * Create XML Event Factory and add Start Document and end event to it.
		 */
		XMLEventFactory xmlEventFactory = XMLEventFactory.newFactory();
		XMLEvent end = xmlEventFactory.createDTD("\n");
		StartDocument startDocument = xmlEventFactory.createStartDocument();
		xmlEventWriter.add(startDocument);
		xmlEventWriter.add(end);
		/*
		 * Configure Start Element
		 */
		StartElement configStartElement = xmlEventFactory.createStartElement("", "", rootElement);
		xmlEventWriter.add(configStartElement);
		xmlEventWriter.add(end);
		/*
		 * Add element nodes
		 */
		Set<String> elementNodes = elements.keySet();
		for (String element : elementNodes) {
			createNode(xmlEventWriter, element, elements.get(element));
		}
		xmlEventWriter.add(xmlEventFactory.createEndElement("", "", rootElement));
		xmlEventWriter.add(end);
		xmlEventWriter.add(xmlEventFactory.createEndDocument());
		xmlEventWriter.close();
	}

	private static void createNode(XMLEventWriter xmlEventWriter, String element, String value)
			throws XMLStreamException {
		XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
		XMLEvent end = xmlEventFactory.createDTD("\n");
		XMLEvent tab = xmlEventFactory.createDTD("\t");
		// Create start node
		StartElement sElement = xmlEventFactory.createStartElement("", "", element);
		xmlEventWriter.add(tab);
		xmlEventWriter.add(sElement);
		// Create content
		Characters characters = xmlEventFactory.createCharacters(value);
		xmlEventWriter.add(characters);
		// Create end node
		EndElement eElement = xmlEventFactory.createEndElement("", "", element);
		xmlEventWriter.add(eElement);
		xmlEventWriter.add(end);
	}

}
