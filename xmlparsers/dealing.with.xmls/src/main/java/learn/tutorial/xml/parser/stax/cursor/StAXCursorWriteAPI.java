package learn.tutorial.xml.parser.stax.cursor;

import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StAXCursorWriteAPI {

	public static void writeXML(String rootElement, Map<String, String> elements) throws XMLStreamException {
		/*
		 * Create XML Stream writer and
		 */
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
		XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(System.out);
		/*
		 * Start writing xml document
		 */
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeCharacters("\n");
		xmlStreamWriter.writeStartElement(rootElement);
		/*
		 * Write id as attribute
		 */
		xmlStreamWriter.writeAttribute("id", elements.get("id"));
		/*
		 * Write other elements
		 */
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("name");
		xmlStreamWriter.writeCharacters(elements.get("name"));
		xmlStreamWriter.writeEndElement();

		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("age");
		xmlStreamWriter.writeCharacters(elements.get("age"));
		xmlStreamWriter.writeEndElement();

		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("gender");
		xmlStreamWriter.writeCharacters(elements.get("gender"));
		xmlStreamWriter.writeEndElement();

		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("role");
		xmlStreamWriter.writeCharacters(elements.get("role"));
		xmlStreamWriter.writeEndElement();
		// write end tag of Employee element
		xmlStreamWriter.writeCharacters("\n");
		xmlStreamWriter.writeEndElement();

		// write end document
		xmlStreamWriter.writeEndDocument();

		// flush data to file and close writer
		xmlStreamWriter.flush();
		xmlStreamWriter.close();
	}

}
