package learn.tutorial.xml.parser.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <ul>
 * <li>DOM Parser is the easiest parser to learn, it loads the XML file into
 * memory and we can traverse it node by node to parse the XML. DOM Parser is
 * good for small files but when file size increases it performs slow and
 * consumes more memory</li>
 * <li>We will be using dom parser for three usage</li>
 * <ol>
 * <li>Read a XML File</li>
 * <li>Write a XML File</li>
 * <li>Edit a XML File</li>
 * </ol>
 * <li>New points learned</li>
 * <ol>
 * <li>Between each parent and child node there exists an invisible text node
 * which no node name or attribute, thus checking the node with
 * node.getNodeType() == Node.ELEMENT_NODE is recommended</li>
 * <li>Not able to get the text value of only the current node</li>
 * </ol>
 * </ul>
 * 
 * @author KD
 *
 */
public class DOMdemo {
	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// 1. Get a new instance of document builder factory
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		// 2. Create a new document builder from the document builder factory
		DocumentBuilder documentBuilder = domFactory.newDocumentBuilder();
		// 3. Read a xml from resources folder
		readXML(documentBuilder);
		System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		// 4. Write a xml to console
		writeXML(documentBuilder);
		System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		// 5. Edit an existing xml and save it
		editXML(documentBuilder);
	}

	/**
	 * <ul>
	 * <li>Edits an existing xml using dom parser</li>
	 * <li>Following edits are being performed:</li>
	 * <ol>
	 * <li>Update the “id” attribute value for all the Employee based on Gender.
	 * For Male, id will be prefixed with “M” else prefix with “F”.</li>
	 * <li>Update the value of “name” element by making it to upper case.</li>
	 * <li>Delete “gender” element as it’s not used now.</li>
	 * <li>Add a new element “salary” to all the employee node in the xml.</li>
	 * </ol>
	 * </ul>
	 * 
	 * @param documentBuilder
	 * @throws IOExceptiony
	 * @throws SAXException
	 * @throws TransformerException
	 */
	private static void editXML(DocumentBuilder documentBuilder)
			throws SAXException, IOException, TransformerException {
		// 1. Get the xml document as input stream
		Document document = documentBuilder.parse(DOMdemo.class.getClassLoader().getResourceAsStream("employee.xml"));
		// 2. Get all the employee node list
		NodeList nodeList = document.getElementsByTagName("Employee");
		// 3. For each employee do the following
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				// 4. Get id
				String attrValue = element.getAttribute("id");
				Node genderNode = null;
				if (node.hasChildNodes()) {
					NodeList childNodeList = element.getChildNodes();
					for (int j = 0; j < childNodeList.getLength(); j++) {
						Node childNode = childNodeList.item(j);
						// 5. Get name and set it again in upper case
						if (childNode.getNodeName().equals("name"))
							childNode.setTextContent(childNode.getTextContent().toUpperCase());
						// 6. Get the gender node
						else if (childNode.getNodeName().equals("gender"))
							genderNode = childNode;
					}
				}
				// 7. Identify the gender and append proper prefix to id value
				element.setAttribute("id",
						(genderNode.getTextContent().equalsIgnoreCase("male") ? "M" : "F") + attrValue);
				// 8. Remove gender node
				element.removeChild(genderNode);
				// 9. Create a new node salary and append it to the current
				// employee
				Node salaryNode = document.createElement("salary");
				salaryNode.setTextContent("200000");
				element.appendChild(salaryNode);
			}
		}
		// 10. Normalize the xml
		document.getDocumentElement().normalize();
		// 11. Output the edited xml to console
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult console = new StreamResult(System.out);
		transformer.transform(source, console);

	}

	/**
	 * Writes a new XML using dom parser
	 * 
	 * @param documentBuilder
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	private static void writeXML(DocumentBuilder documentBuilder)
			throws ParserConfigurationException, TransformerException {
		// 1. Create new document to get empty document to write into
		Document document = documentBuilder.newDocument();
		// 2. Create root element with specified namespace and add it to current
		// document
		Element rootElement = document.createElementNS("http://www.github.com/kdsalvy", "Company");
		document.appendChild(rootElement);
		// 3. Create new child nodes and append to the document
		rootElement.appendChild(getNewNode(document, "Employee", "Saurabh Kedia", "Java Developer"));
		rootElement.appendChild(getNewNode(document, "Employee", "Lee Chan", "Database Administrator"));
		// 4. Output the formed xml to file/console. Get the new instance of
		// transformer factory
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// 5. Get the transformer object from transformer factory
		Transformer transformer = transformerFactory.newTransformer();
		// 6. Set the below property for indented xml
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		// 7. write to console or file
		DOMSource source = new DOMSource(document);
		StreamResult console = new StreamResult(System.out);
		transformer.transform(source, console);
	}

	/**
	 * Creates a new node with two child nodes with text passed as arguments
	 * 
	 * @param document
	 * @param nodeName
	 * @param child
	 * @param childSibling
	 * @return
	 */
	private static Node getNewNode(Document document, String nodeName, String child, String childSibling) {
		Element element = document.createElement(nodeName);
		element.setAttribute("Designation", "Software Engineer");
		Element childNode = document.createElement("Name");
		childNode.setTextContent(child);
		element.appendChild(childNode);
		Element childSiblingNode = document.createElement("Role");
		childSiblingNode.setTextContent(childSibling);
		element.appendChild(childSiblingNode);
		return element;
	}

	/**
	 * Reads a xml using dom parser
	 * 
	 * @param documentBuilder2
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static void readXML(DocumentBuilder documentBuilder)
			throws ParserConfigurationException, SAXException, IOException {
		// 1. Give the input stream of the xml file to the document builder to
		// get an instance of document
		Document document = documentBuilder.parse(DOMdemo.class.getClassLoader().getResourceAsStream("catalog.xml"));
		// 2. Normalise the document to get it well structured from this node to
		// complete depth.
		document.getDocumentElement().normalize();
		// 5. Get the node list of the child nodes of document element node
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		// 6. Iterate the node list to print all the nodes and attributes
		printNodeNameAndAttributes(nodeList);
	}

	/**
	 * Prints all the Nodes, its attributes and text recursively to n level
	 * depth
	 * 
	 * @param nodeList
	 */
	private static void printNodeNameAndAttributes(NodeList nodeList) {
		// 1. Iterate the passed node list
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			// 2. Skips the empty text nodes between parent and child nodes,
			// print node name, attributes and text
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				System.out.print("[Node: \"" + element.getNodeName());
				if (element.hasAttributes()) {
					System.out.print("\" Attribute: ");
					NamedNodeMap attributeMap = element.getAttributes();
					for (int j = 0; attributeMap != null && j < attributeMap.getLength(); j++) {
						System.out.print(attributeMap.item(j) + " ");
					}
				}
				// {Text content gives the text of current node and its
				// children. Need to get only current node text }
				System.out.println(" element Value : " + element.getTextContent() + " ]");
				// 3. If current node has child nodes call the method
				// recursively for its child node
				if (element.hasChildNodes()) {
					printNodeNameAndAttributes(element.getChildNodes());
				}
			}
		}
	}
}
