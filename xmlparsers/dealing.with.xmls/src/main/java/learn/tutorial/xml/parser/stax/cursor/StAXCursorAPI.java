package learn.tutorial.xml.parser.stax.cursor;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import learn.tutorial.xml.Catalog;

/**
 * The cursor-based API allows the application to process XML as a stream of
 * tokens aka events; the application can check the parser’s state and get
 * information about the last parsed event, then advance to the next event, and
 * so on. This is a low-level API; while considerably efficient, it does not
 * provide an abstraction of the underlying XML structure.
 * 
 * @author KD
 *
 */
public class StAXCursorAPI {

	public static Catalog parseXML(InputStream inputStream) throws XMLStreamException {
		Catalog catalog = null;
		Catalog.Product product = null;
		Catalog.CatalogItem catalogItem = null;
		Catalog.Size size = null;
		Catalog.ColorSwatch colorSwatch = null;

		boolean itemNo = false;
		boolean price = false;
		boolean color = false;
		/*
		 * Get the XML Input Factory
		 */
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		/*
		 * Create XML Stream Reader from it.
		 */
		XMLStreamReader xmlStreamReader = xmlInputFactory
				.createXMLStreamReader(inputStream);
		/*
		 * Check event type
		 */
		int event = xmlStreamReader.getEventType();
		/*
		 * set the value to respective parameter of Catalog object based on th
		 * event type in the infinite while loop.
		 */
		while (true) {
			switch (event) {
			/*
			 * Do the steps provided if event is start element.
			 */
			case XMLStreamConstants.START_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("catalog")) {
					if (catalog == null)
						catalog = new Catalog();
				} else if (xmlStreamReader.getLocalName().equals("product")) {
					if (catalog.productList == null)
						catalog.productList = new ArrayList<>();
					if (product == null)
						product = catalog.new Product();
					/*
					 * Get attributes
					 */
					product.description = xmlStreamReader.getAttributeValue(0);
					product.productImage = xmlStreamReader.getAttributeValue(1);
				} else if (xmlStreamReader.getLocalName().equals("catalog_item")) {
					if (product.catalogItemList == null)
						product.catalogItemList = new ArrayList<>();
					catalogItem = catalog.new CatalogItem();
					catalogItem.gender = xmlStreamReader.getAttributeValue(0);
				} else if (xmlStreamReader.getLocalName().equals("item_number")) {
					itemNo = true;
				} else if (xmlStreamReader.getLocalName().equals("price")) {
					price = true;
				} else if (xmlStreamReader.getLocalName().equals("size")) {
					if (catalogItem.sizeList == null)
						catalogItem.sizeList = new ArrayList<>();
					if (size == null)
						size = catalog.new Size();
					size.description = xmlStreamReader.getAttributeValue(0);
				} else if (xmlStreamReader.getLocalName().equals("color_swatch")) {
					if (size.colorSwatchList == null)
						size.colorSwatchList = new ArrayList<>();
					if (colorSwatch == null) {
						colorSwatch = catalog.new ColorSwatch();
					}
					colorSwatch.image = xmlStreamReader.getAttributeValue(0);
					color = true;
				}
				break;
			/*
			 * DO the steps provided if event is end element.
			 */
			case XMLStreamConstants.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("color_swatch")) {
					size.colorSwatchList.add(colorSwatch);
					colorSwatch = null;
				} else if (xmlStreamReader.getLocalName().equals("size")) {
					catalogItem.sizeList.add(size);
					size = null;
				} else if (xmlStreamReader.getLocalName().equals("catalog_item")) {
					product.catalogItemList.add(catalogItem);
					catalogItem = null;
				} else if (xmlStreamReader.getLocalName().equals("product")) {
					catalog.productList.add(product);
					product = null;
				}
				break;
			/*
			 * Do the steps provided if the event is character element.
			 */
			case XMLStreamConstants.CHARACTERS:
				if (itemNo) {
					catalogItem.itemNumber = xmlStreamReader.getText();
					itemNo = false;
				} else if (price) {
					catalogItem.price = Double.valueOf(xmlStreamReader.getText());
					price = false;
				} else if (color) {
					colorSwatch.color = xmlStreamReader.getText();
					color = false;
				}

				break;
			}
			/*
			 * if xml stream reader is not having next stream break the loop.
			 */
			if (!xmlStreamReader.hasNext())
				break;
			/*
			 * assign next event to xml stream reader.
			 */
			event = xmlStreamReader.next();
		}

		return catalog;
	}
}
