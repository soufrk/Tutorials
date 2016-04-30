package learn.tutorial.xml.parser.stax.iterator;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import learn.tutorial.xml.Catalog;

/**
 * The higher-level iterator-based API allows the application to process XML as
 * a series of event objects, each of which communicates a piece of the XML
 * structure to the application. All the application needs to do is determine
 * the type of the parsed event, cast it to the corresponding type, and use its
 * methods to get information related to the event.
 * 
 * @author KD
 *
 */
public class StAXIteratorAPI {

	public static Catalog parseXML(InputStream inputStream) {
		Catalog catalog = null;
		Catalog.Product product = null;
		Catalog.CatalogItem catalogItem = null;
		Catalog.Size size = null;
		Catalog.ColorSwatch colorSwatch = null;
		

		boolean itemNo = false;
		boolean price = false;
		boolean color = false;
		/*
		 * Create XMLInputFactory's new instance.
		 */
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		/*
		 * Get the XMLEventReader, check for each XMLEvent and set the value in
		 * appropriate object's property.
		 */
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
			/*
			 * While xmlEventReader has next event continue the loop
			 */
			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				/*
				 * if the xmlEvent is start element get the attribute, text and
				 * set it in respective objects.
				 */
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("catalog")) {
						if (catalog == null)
							catalog = new Catalog();
					} else if (startElement.getName().getLocalPart().equals("product")) {
						if (catalog.productList == null)
							catalog.productList = new ArrayList<>();
						if (product == null)
							product = catalog.new Product();
						/*
						 * Get attributes
						 */
						product.description = startElement.getAttributeByName(new QName("description")).getValue();
						product.productImage = startElement.getAttributeByName(new QName("product_image")).getValue();
					} else if (startElement.getName().getLocalPart().equals("catalog_item")) {
						if (product.catalogItemList == null)
							product.catalogItemList = new ArrayList<>();
						catalogItem = catalog.new CatalogItem();
						catalogItem.gender = startElement.getAttributeByName(new QName("gender")).getValue();
					} else if (startElement.getName().getLocalPart().equals("item_number")) {
						itemNo = true;
					} else if (startElement.getName().getLocalPart().equals("price")) {
						price = true;
					} else if (startElement.getName().getLocalPart().equals("size")) {
						if (catalogItem.sizeList == null)
							catalogItem.sizeList = new ArrayList<>();
						if (size == null)
							size = catalog.new Size();
						size.description = startElement.getAttributeByName(new QName("description")).getValue();
					} else if (startElement.getName().getLocalPart().equals("color_swatch")) {
						if (size.colorSwatchList == null)
							size.colorSwatchList = new ArrayList<>();
						if (colorSwatch == null) {
							colorSwatch = catalog.new ColorSwatch();
						}
						colorSwatch.image = startElement.getAttributeByName(new QName("image")).getValue();
						color = true;
					}
					/*
					 * End event add the object to list and dereference the variable
					 */
				} else if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("color_swatch")) {
						size.colorSwatchList.add(colorSwatch);
						colorSwatch = null;
					} else if (endElement.getName().getLocalPart().equals("size")) {
						catalogItem.sizeList.add(size);
						size = null;
					} else if (endElement.getName().getLocalPart().equals("catalog_item")) {
						product.catalogItemList.add(catalogItem);
						catalogItem = null;
					} else if (endElement.getName().getLocalPart().equals("product")) {
						catalog.productList.add(product);
						product = null;
					}
				} else if(xmlEvent.isCharacters()){
					/*
					 * Get text value
					 */
					Characters characters = xmlEvent.asCharacters();
					if (itemNo) {
						catalogItem.itemNumber = characters.getData();
						itemNo = false;
					} else if (price) {
						catalogItem.price = Double.valueOf(characters.getData());
						price = false;
					} else if (color) {
						colorSwatch.color = characters.getData();
						color = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return catalog;
	}
}