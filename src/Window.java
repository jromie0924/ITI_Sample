import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Window extends JFrame {

    private JButton addCircleButton;
    private JButton addSquareButton;
    private JButton addTriangleButton;
    private List<JPanel> panels = new ArrayList<JPanel>();
    
    public Window() {
    	
    	// Button for adding a circle to the window
        addCircleButton = new JButton("Add Circle");
        addCircleButton.setBounds(10, 10, 120, 50);
        
        // Button for add a square to the window
        addSquareButton = new JButton("Add Square");
        addSquareButton.setBounds(140, 10, 120, 50);
        
        // Button for adding a triangle to the window
        addTriangleButton = new JButton("Add Triangle");
        addTriangleButton.setBounds(270, 10, 120, 50);
        
        setSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        add(addCircleButton);
        add(addSquareButton);
        add(addTriangleButton);
        setVisible(true);
        initialize();
    }


    public void initialize() {

        addCircleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JPanel circle = new Circle(Color.GREEN);
                circle.setBounds(150,150,200,200);
                circle.setOpaque(false);
                panels.add(circle);
                add(circle);
                repaint();
                handleDrag(circle);
            }
        });
        
        addSquareButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Square square = new Square();
                square.setBounds(150,150,200,200);
                square.setBackground(Color.black);
                panels.add(square);
                add(square);
                repaint();
                handleDrag(square);
            }
        });

    }

    public void handleDrag(JPanel panel){
        final JPanel p = panel;
        panel.addMouseMotionListener(new MouseMotionAdapter() {

        	@Override
            public void mouseDragged(MouseEvent me) {
                me.translatePoint(me.getComponent().getLocation().x, me.getComponent().getLocation().y);
                p.setLocation(me.getX(), me.getY());
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
