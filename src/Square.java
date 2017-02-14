import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Square extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		g.fillRect(0,  0,  g.getClipBounds().width,  g.getClipBounds().height);
	}
}
