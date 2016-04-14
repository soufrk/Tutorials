package learn.tutorials.decoratordesignpattern;

/**
 * Abstract class beverage that contains two methods :- Concrete method
 * getDescription Abstract method getCost
 * 
 * @author KD
 *
 */
public abstract class Beverage {

	public String description = "Unknown Beverage";

	public String getDescription() {
		return this.description;
	}

	public abstract double getCost();
}

/**
 * DarkRoast concrete implementation of Beverage
 * @author KD
 *
 */
class DarkRoast extends Beverage {

	@Override
	public String getDescription() {
		return "Dark Roast";
	}

	@Override
	public double getCost() {
		return 0.99;
	}
}

/**
 * Decaf concrete implementation of Beverage
 * @author KD
 *
 */
class Decaf extends Beverage {

	@Override
	public String getDescription() {
		return "Decaf";
	}

	@Override
	public double getCost() {
		return 1.05;
	}

}

/**
 * Espresso - concrete implementation of Beverage
 * @author KD
 *
 */
class Espresso extends Beverage {

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double getCost() {
		return 1.99;
	}

}

/**
 * HouseBlend - concrete implementation of Beverage 
 * @author KD
 *
 */
class HouseBlend extends Beverage {

	@Override
	public String getDescription() {
		return "House Blend";
	}

	@Override
	public double getCost() {
		return 0.89;
	}

}