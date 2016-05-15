package learn.tutorial.xml.xPath;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathDemo {
	public static void main(String[] args)
			throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		XPath xPath = XPathFactory.newInstance().newXPath();
		String[] expressions = { "/catalog/product/@description", "/catalog/product/@product_image",
				"/catalog/product/catalog_item/@gender" };
		for (String expression : expressions) {
			System.out.println(expression + "\t\t:\t" + getValueOfExpression(xPath, expression));
		}

	}

	/**
	 * Pass expression to get it's value from given xPath object.
	 * 
	 * @param xPath
	 * @param expression
	 * @return
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private static String getValueOfExpression(XPath xPath, String expression)
			throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(XPathDemo.class.getClassLoader().getResourceAsStream("catalog.xml"));
		return xPath.compile(expression).evaluate(xmlDoc);
	}
}
