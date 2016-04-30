package learn.tutorial.xml.parser.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <ul>
 * <li>The actual parsing is done by the Handler class and we need to create our
 * own handler class to parse the XML document. We need to implement
 * org.xml.sax.ContentHandler interface to create our own handler classes.</li>
 * <li>This interface contains callback methods that receive notification when
 * any event occurs, for example StartDocument, EndDocument, StartElement,
 * EndElement, CharacterData etc.</li>
 * <li>org.xml.sax.helpers.DefaultHandler provides the default implementation of
 * the interface ContentHandler. Extending this class is advisable than
 * implementing ContentHandler as we will need to override only a few methods as
 * per our need</li>
 * <ul>
 * 
 * @author KD
 *
 */
public class SAXEventHandler extends DefaultHandler {

	Catalog catalog = null;
	Catalog.Product product = null;
	Catalog.CatalogItem catalogItem = null;
	Catalog.Size size = null;
	Catalog.ColorSwatch colorSwatch = null;

	boolean itemNo = false;
	boolean price = false;
	boolean color = false;

	@Override
	/**
	 * Checks the start element name and set the attribute in appropriate
	 * object. If object is null, initialises the object first and then set the
	 * attribute value
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if (qName.equals("catalog")) {
			if (catalog == null)
				catalog = new Catalog();
		} else if (qName.equals("product")) {
			if (catalog.productList == null)
				catalog.productList = new ArrayList<>();
			if (product == null)
				product = catalog.new Product();
			product.description = attributes.getValue("description");
			product.productImage = attributes.getValue("product_image");
		} else if (qName.equals("catalog_item")) {
			if (product.catalogItemList == null)
				product.catalogItemList = new ArrayList<>();
			catalogItem = catalog.new CatalogItem();
			catalogItem.gender = attributes.getValue("gender");
		} else if (qName.equals("item_number")) {
			itemNo = true;
		} else if (qName.equals("price")) {
			price = true;
		} else if (qName.equals("size")) {
			if (catalogItem.sizeList == null)
				catalogItem.sizeList = new ArrayList<>();
			if (size == null)
				size = catalog.new Size();
			size.description = attributes.getValue("description");
		} else if (qName.equals("color_swatch")) {
			if (size.colorSwatchList == null)
				size.colorSwatchList = new ArrayList<>();
			if (colorSwatch == null) {
				colorSwatch = catalog.new ColorSwatch();
			}
			colorSwatch.image = attributes.getValue("image");
			color = true;
		}
	}

	@Override
	/**
	 * Checks the end element and add it to the parent tag's list of end
	 * element. Once it is done, dereference the variable.
	 */
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("color_swatch")) {
			size.colorSwatchList.add(colorSwatch);
			colorSwatch = null;
		} else if (qName.equals("size")) {
			catalogItem.sizeList.add(size);
			size = null;
		} else if (qName.equals("catalog_item")) {
			product.catalogItemList.add(catalogItem);
			catalogItem = null;
		} else if (qName.equals("product")) {
			catalog.productList.add(product);
			product = null;
		}
	}

	@Override
	/**
	 * Gets the text value of a node based on the boolean value set on
	 * encountering the element in start element method.
	 */
	public void characters(char ch[], int start, int length) throws SAXException {
		if (itemNo) {
			catalogItem.itemNumber = new String(ch, start, length);
			itemNo = false;
		} else if (price) {
			catalogItem.price = Double.valueOf(new String(ch, start, length));
			price = false;
		} else if (color) {
			colorSwatch.color = new String(ch, start, length);
			color = false;
		}
	}
}
