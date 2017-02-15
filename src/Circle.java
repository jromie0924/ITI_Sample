import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Circle extends JPanel {
	
	private Color color;
	private Color borderColor;
	
	// Default constructor
	public Circle() {
		color = Color.GRAY;
		borderColor = Color.BLACK;
	}
	
	// Constructor for just fill color
	public Circle(Color c) {
		color = c;
	}
	
	// Constructor for fill and border colors
	public Circle(Color c, Color b) {
		color = c;
		borderColor = b;
	}
	
	private void draw(Graphics g) {
		Graphics2D shape = (Graphics2D)g;
		Graphics2D border = (Graphics2D)g;
		
		// Got this from
		// http://zetcode.com/gfx/java2d/shapesandfills/
		RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        
        shape.setRenderingHints(rh);
        border.setRenderingHints(rh);
		
        border.setPaint(borderColor);
        border.fillOval(g.getClipBounds().x,  g.getClipBounds().y,  g.getClipBounds().width,  g.getClipBounds().height);
        
		shape.setPaint(color);
		shape.fillOval(g.getClipBounds().x + 3,  g.getClipBounds().y + 3,  g.getClipBounds().width - 6,  g.getClipBounds().height - 6);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}