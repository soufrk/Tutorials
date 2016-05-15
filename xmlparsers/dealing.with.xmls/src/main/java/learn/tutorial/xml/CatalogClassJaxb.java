package learn.tutorial.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Bean class to hold the data of Catalog xml
 * 
 * @author KD
 *
 */
@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.NONE)
public class CatalogClassJaxb {
	@XmlElement(name = "product")
	public List<Product> productList;

	@XmlRootElement(name = "product")
	@XmlAccessorType(XmlAccessType.NONE)
	public static class Product {
		@XmlAttribute(name = "description")
		public String description;
		@XmlAttribute(name = "product_image")
		public String productImage;
		@XmlElement(name = "catalog_item")
		public List<CatalogItem> catalogItemList;

		@Override
		public String toString() {
			return "Product [description=" + description + ", productImage=" + productImage + ", catalogItemList="
					+ catalogItemList + "]";
		}
	}

	@XmlRootElement(name = "catalog_item")
	@XmlAccessorType(XmlAccessType.NONE)
	public static class CatalogItem {
		@XmlAttribute(name = "gender")
		public String gender;
		@XmlElement(name = "item_number")
		public String itemNumber;
		@XmlElement(name = "price")
		public Double price;
		@XmlElement(name = "size")
		public List<Size> sizeList;

		@Override
		public String toString() {
			return "CatalogItem [gender=" + gender + ", itemNumber=" + itemNumber + ", price=" + price + ", sizeList="
					+ sizeList + "]";
		}
	}

	@XmlRootElement(name = "size")
	@XmlAccessorType(XmlAccessType.NONE)
	public static class Size {
		@XmlAttribute(name = "description")
		public String description;
		@XmlElement(name = "color_swatch")
		public List<ColorSwatch> colorSwatchList;

		@Override
		public String toString() {
			return "Size [description=" + description + ", colorSwatchList=" + colorSwatchList + "]";
		}
	}

	@XmlRootElement(name = "color_swatch")
	@XmlAccessorType(XmlAccessType.NONE)
	public static class ColorSwatch {
		@XmlAttribute(name = "image")
		public String image;
		@XmlValue
		public String color;

		@Override
		public String toString() {
			return "ColorSwatch [image=" + image + ", color=" + color + "]";
		}
	}

	@Override
	public String toString() {
		return "Catalog [productList=" + productList + "]";
	}

}