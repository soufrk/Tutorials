package learn.tutorials.decoratordesignpattern;

/**
 * Create a Dark roast Double whip With Soy
 * @author KD
 *
 */
public class CoffeeServer {

	public static void main(String[] args) {
		// Prepare espresso without any condiments
		Beverage espresso = new Espresso();
		System.out.println(espresso.getDescription() + "\t" + espresso.getCost());
		
		//Prepare one Dark Roast Double Whip with Soy Latte
		Beverage darkRoastDoubleWhipWithSoy = new DarkRoast();
		darkRoastDoubleWhipWithSoy = new Mocha(darkRoastDoubleWhipWithSoy);
		darkRoastDoubleWhipWithSoy = new Mocha(darkRoastDoubleWhipWithSoy);
		darkRoastDoubleWhipWithSoy = new Soy(darkRoastDoubleWhipWithSoy);
		System.out.println(darkRoastDoubleWhipWithSoy.getDescription() + "\t" + darkRoastDoubleWhipWithSoy.getCost());
		
	}

}
