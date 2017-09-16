

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class _GUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public _GUI() {		
		getContentPane().setLayout(null);
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Celda (" + e.getX()/100 + ", " + e.getY()/100 + ")");
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {
            }
		});
	}
	
	
	
}