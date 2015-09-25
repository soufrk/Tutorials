package learn.tutorials.abstractfactorypattern;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factory){
		if(factory.equalsIgnoreCase("SHAPE"))
			return new ShapeFactory();
		else if(factory.equalsIgnoreCase("COLOR"))
			return new ColorFactory();
		else
			return null;
	}
}
