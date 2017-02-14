import java.awt.Color;

public abstract class Base_Shape {
	protected Color color;
	protected Color borderColor;
	
	// Default constructor
	public Base_Shape() {
		color = Color.WHITE;
		borderColor = Color.BLACK;
	}
	
	public Base_Shape(Color c) {
		color = c;
		borderColor = Color.BLACK;
	}
	
	public Base_Shape(Color c, Color b) {
		color = c;
		borderColor = b;
	}
	
	public abstract Position getPos();
	public abstract void changeColor(Color newColor);
	public abstract void changeBorderColor(Color newBorderColor);
}
