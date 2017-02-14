import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Triangle extends JPanel {
	
	private Color color;
	private Color borderColor;
	
	// Default constructor
	public Triangle() {
		color = Color.GRAY;
		borderColor = Color.BLACK;
	}
	
	// Constructor for just fill color
	public Triangle(Color c) {
		color = c;
	}
	
	// Constructor for fill and border colors
	public Triangle(Color c, Color b) {
		color = c;
		borderColor = b;
	}
	
	private void draw(Graphics g) {
		Graphics2D shape = (Graphics2D)g;
		Graphics2D border = (Graphics2D)g;
		
		RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        
        shape.setRenderingHints(rh);
        border.setRenderingHints(rh);
		
        border.setPaint(borderColor);
        Polygon triangleBorder = new Polygon();
        int xCoord = g.getClipBounds().x;
        int yCoord = g.getClipBounds().y;
        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;
        triangleBorder.addPoint(xCoord + width / 2, yCoord);
        triangleBorder.addPoint(xCoord, yCoord +  height);
        triangleBorder.addPoint(xCoord + width, yCoord + height);
        border.fillPolygon(triangleBorder);
        
		shape.setPaint(color);
		Polygon triangleFill = new Polygon();
		width -= 6;
		height -= 6;
		triangleFill.addPoint(xCoord + 3 + width / 2, yCoord + 6);
		triangleFill.addPoint(xCoord + 6, yCoord + 3 +  height);
		triangleFill.addPoint(xCoord + width, yCoord + 3 + height);
		shape.fillPolygon(triangleFill);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}
