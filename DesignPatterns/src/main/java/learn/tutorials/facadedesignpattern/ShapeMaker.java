package learn.tutorials.facadedesignpattern;

public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape triangle;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		triangle = new Triangle();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		triangle.draw();
	}
}
