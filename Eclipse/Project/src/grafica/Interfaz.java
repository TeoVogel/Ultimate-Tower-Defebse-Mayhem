package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import juego.Juego;

public class Interfaz{
	private static JFrame frame;
	private static JPanel contentPane;
	private static Juego juego;
	
	public static void Iniciar(Juego j){
		juego = j;
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		frame.addMouseListener(new MouseAdapter() {
				@Override
	            public void mousePressed(MouseEvent e) {
					if (juego.getMercado().isPlaceHolderFull()) {
						int columna = e.getX()/100,
						    fila    = e.getY()/100;
						juego.getMercado().getPlaceHolderContent().ejecutar(grilla[fila][columna]);
					}
	            }
				
	            @Override
	            public void mouseReleased(MouseEvent e) {}
			}
		);
	}
		
	public static JFrame getFrame(){
		return frame;
	}
	
	public static void addGrafico(Grafico g){
		frame.add(g.getLabel());
		g.getLabel().setVisible(true);
		g.getLabel().repaint();
	
	}
}
