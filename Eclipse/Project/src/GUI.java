import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Position;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Juego juego;

	/**
	 * Create the frame.
	 */
	public GUI(Juego j) {
		
		juego = j;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				int columna = e.getX()/100,
				    fila = e.getY()/100;
				if (juego.getMercado().isPlaceHolderFull()) {
					Ente ente = juego.getMercado().getPlaceHolderContent();
					ente.getPos().setLocation((new Point(columna*100, fila*100)));
					add(ente.getGrafico());
					JOptionPane.showMessageDialog(null, "Celda (" + fila + ", " + columna + ")");
				}
				//JOptionPane.showMessageDialog(null, "Celda (" + e.getX()/100 + ", " + e.getY()/100 + ")");
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {
            }
		});
		
	}

}
