package learn.tutorials.abstractfactorypattern;

public class AbstractFactoryPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// get shape factory
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

		// get an object of Shape Circle
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Shape Circle
		shape1.draw();

		// get an object of Shape TRIANGLE
		Shape shape2 = shapeFactory.getShape("TRIANGLE");

		// call draw method of Shape TRIANGLE
		shape2.draw();

		// get an object of Shape RECTANGLE
		Shape shape3 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Shape RECTANGLE
		shape3.draw();

		// get color factory
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

		// get an object of Color Red
		Color color1 = colorFactory.getColor("RED");

		// call fill method of Red
		color1.fill();

		// get an object of Color Green
		Color color2 = colorFactory.getColor("Green");

		// call fill method of Green
		color2.fill();

		// get an object of Color Blue
		Color color3 = colorFactory.getColor("BLUE");

		// call fill method of Color Blue
		color3.fill();
	}

}
