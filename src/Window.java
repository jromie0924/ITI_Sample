import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Window extends JFrame {
	
	private final int XDIM = 200;
	private final int YDIM = 200;
	private JButton addCircleButton;
    private JButton addSquareButton;
    private JButton addTriangleButton;
    private JButton clearCanvasButton;
    private ArrayList<JPanel> panels;
    
    public Window() {
    	
    	panels = new ArrayList<JPanel>();
    	
    	// Button for adding a circle to the window
        addCircleButton = new JButton("Draw Circle");
        addCircleButton.setBounds(10, 10, 120, 50);
        
        // Button for add a square to the window
        addSquareButton = new JButton("Draw Square");
        addSquareButton.setBounds(140, 10, 120, 50);
        
        // Button for adding a triangle to the window
        addTriangleButton = new JButton("Draw Triangle");
        addTriangleButton.setBounds(270, 10, 120, 50);
        
        clearCanvasButton = new JButton("Clear Canvas");
        clearCanvasButton.setBounds(400, 10, 120, 50);
        
        setSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        add(addCircleButton);
        add(addSquareButton);
        add(addTriangleButton);
        add(clearCanvasButton);
        setVisible(true);
        initialize(this);
    }

    private Color randomColor() {
    	int r = ThreadLocalRandom.current().nextInt(0, 256);
    	int g = ThreadLocalRandom.current().nextInt(0, 256);
    	int b = ThreadLocalRandom.current().nextInt(0, 256);
    	
    	return new Color(r, g, b);
    }

    public void initialize(Window w) {

        addCircleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JPanel circle = new Circle(randomColor(), randomColor());
                circle.setBounds(150,150,XDIM,YDIM);
                circle.setOpaque(false);
                add(circle);
                repaint();
                handleDrag(circle);
                handleClick(circle);
                panels.add(circle);
            }
        });
        
        addSquareButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Square square = new Square(randomColor(), randomColor());
                square.setBounds(150,150,XDIM,YDIM);
                square.setOpaque(false);
                add(square);
                repaint();
                handleDrag(square);
                handleClick(square);
                panels.add(square);
            }
        });
        
        addTriangleButton.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		// TODO Auto-generated method stub
                Triangle triangle = new Triangle(randomColor(), randomColor());
                triangle.setBounds(150,150,XDIM,YDIM);
                triangle.setOpaque(false);
                add(triangle);
                repaint();
                handleDrag(triangle);
                handleClick(triangle);
                panels.add(triangle);
        	}
        });
        
        clearCanvasButton.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		// TODO Auto-generated method stub
        		for(JPanel panel : panels) {
        			remove(panel);
        		}
        		repaint();
        	}
        });

    }
    
    public void handleDrag(final JPanel panel) {
        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
           
        	@Override
            public void mouseDragged(MouseEvent me) {
                me.translatePoint(me.getComponent().getLocation().x, me.getComponent().getLocation().y);
                panel.setLocation(me.getX(), me.getY());
                repaint();
            }
        });
    }
    
    public void handleClick(final JPanel panel) {
    	panel.addMouseListener(new MouseAdapter() {
    		
    		@Override
    		public void mouseClicked(MouseEvent me) {
    			if(me.getButton() == MouseEvent.BUTTON3) {
    				int x = me.getComponent().getLocation().x;
    				int y = me.getComponent().getLocation().y;
    				me.translatePoint(x, y);
    				String panelClass = panel.getClass().toString();
    				switch (panelClass) {
    					case "class Circle":
    						JPanel circle = new Circle(randomColor(), randomColor());
    						circle.setBounds(x, y, XDIM, YDIM);
    						remove(panel);
    						add(circle);
    						repaint();
    						handleDrag(circle);
    						handleClick(circle);
    						break;
    						
    					case "class Square":
    						JPanel square = new Square(randomColor(), randomColor());
    						square.setBounds(x, y, XDIM, YDIM);
    						remove(panel);
    						add(square);
    						repaint();
    						handleDrag(square);
    						handleClick(square);
    						break;
    						
    					case "class Triangle":
    						JPanel triangle = new Triangle(randomColor(), randomColor());
    						triangle.setBounds(x, y, XDIM, YDIM);
    						remove(panel);
    						add(triangle);
    						repaint();
    						handleDrag(triangle);
    						handleClick(triangle);
    						break;
    				}
    			} else if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1) {
    				remove(panel);
    				repaint();
    			}
    		}
    	});
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
            	new Window();
            }
        });

    }


}
