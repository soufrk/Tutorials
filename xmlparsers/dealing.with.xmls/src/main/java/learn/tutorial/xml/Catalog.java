package learn.tutorial.xml;

import java.util.List;

/**
 * Bean class to hold the data of Catalog xml
 * 
 * @author KD
 *
 */
public class Catalog {
	public List<Product> productList;

	public class Product {
		public String description;
		public String productImage;
		public List<CatalogItem> catalogItemList;

		@Override
		public String toString() {
			return "Product [description=" + description + ", productImage=" + productImage + ", catalogItemList="
					+ catalogItemList + "]";
		}
	}

	public class CatalogItem {
		public String gender;
		public String itemNumber;
		public Double price;
		public List<Size> sizeList;

		@Override
		public String toString() {
			return "CatalogItem [gender=" + gender + ", itemNumber=" + itemNumber + ", price=" + price + ", sizeList="
					+ sizeList + "]";
		}
	}

	public class Size {
		public String description;
		public List<ColorSwatch> colorSwatchList;

		@Override
		public String toString() {
			return "Size [description=" + description + ", colorSwatchList=" + colorSwatchList + "]";
		}
	}

	public class ColorSwatch {
		public String image;
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