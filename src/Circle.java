import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Circle extends JPanel {
	
	private Color color;
	
	// Default constructor
	public Circle() {
		color = Color.GRAY;
	}
	
	public Circle(Color c) {
		color = c;
	}
	
	private void draw(Graphics g) {
		Graphics2D shape = (Graphics2D)g;
		
		RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        
        shape.setRenderingHints(rh);
		
		shape.setPaint(color);
		shape.fillOval(g.getClipBounds().x,  g.getClipBounds().y,  g.getClipBounds().width,  g.getClipBounds().height);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}