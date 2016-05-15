package learn.tutorial.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import learn.tutorial.xml.CatalogClassJaxb;

public class JaxbDemo {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CatalogClassJaxb.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		CatalogClassJaxb catalog = (CatalogClassJaxb) unmarshaller
				.unmarshal(JaxbDemo.class.getClassLoader().getResourceAsStream("catalog.xml"));
		System.out.println(catalog);
	}

}
