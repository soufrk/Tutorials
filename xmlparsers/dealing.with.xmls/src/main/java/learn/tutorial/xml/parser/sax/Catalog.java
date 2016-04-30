package learn.tutorial.xml.parser.sax;

import java.util.List;

/**
 * Bean class to hold the data of Catalog xml
 * 
 * @author KD
 *
 */
public class Catalog {
	List<Product> productList;

	public class Product {
		String description;
		String productImage;
		List<CatalogItem> catalogItemList;

		@Override
		public String toString() {
			return "Product [description=" + description + ", productImage=" + productImage + ", catalogItemList="
					+ catalogItemList + "]";
		}
	}

	public class CatalogItem {
		String gender;
		String itemNumber;
		Double price;
		List<Size> sizeList;

		@Override
		public String toString() {
			return "CatalogItem [gender=" + gender + ", itemNumber=" + itemNumber + ", price=" + price + ", sizeList="
					+ sizeList + "]";
		}
	}

	public class Size {
		String description;
		List<ColorSwatch> colorSwatchList;

		@Override
		public String toString() {
			return "Size [description=" + description + ", colorSwatchList=" + colorSwatchList + "]";
		}
	}

	public class ColorSwatch {
		String image;
		String color;

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