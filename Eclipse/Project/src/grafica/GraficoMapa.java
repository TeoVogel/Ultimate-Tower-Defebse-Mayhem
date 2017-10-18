package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import juego.Mapa;
public class GraficoMapa extends JFrame {
	private JPanel contentPane;
	private Mapa miMapa;
	
	public GraficoMapa(Mapa m){
		miMapa = m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		addMouseListener(new MouseAdapter() {
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
		
	public void addGrafico(Grafico g){
		add(g.getLabel());
		g.getLabel().setVisible(true);
		g.getLabel().repaint();
	
	}
		
}
