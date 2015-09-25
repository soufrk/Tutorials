package learn.tutorials.factorydesignpattern;

public class FactoryPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the instance of Factory Method
		ShapeFactory shapeFactory = new ShapeFactory();
		// Create the instance of the concrete shape class and assign it to the reference of interface Shape they implement
		Shape shape = shapeFactory.getShape("CIRCLE");
		// Call the draw() method overridden in all the implemented classes
		shape.draw();
		shape = shapeFactory.getShape("TRIANGLE");
		shape.draw();
		shape = shapeFactory.getShape("RECTANGLE");
		shape.draw();
	}

}
