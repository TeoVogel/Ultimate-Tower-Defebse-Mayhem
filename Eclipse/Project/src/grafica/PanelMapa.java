package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.List;
import java.util.ArrayList;

import juego.Constantes;
import juego.Juego;
import juego.ente.Celda;
import juego.ente.Ente;
import juego.Pair;

public class PanelMapa extends JLabel {
	private List<Pair<JLabel, Integer>> graficosTemporales;
	public final static int TILE_WIDTH = 100;
	public final static int TILE_HIGHT = 100;
	
	public PanelMapa() {
		super();
		graficosTemporales = new ArrayList<Pair<JLabel, Integer>>();
		setBounds(0, 88, 1000, 638);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fondo.png"));
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (Juego.getJuego().getMercado().isAccionSobreMapa()) {
					int columna = e.getX()/100,
					    fila    = e.getY()/100;
					Celda c = Juego.getJuego().getMapa().getCelda(fila, columna);
					Juego.getJuego().getMercado().getAccionSobreMapa().ejecutar(c);
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {}
		});	
	}
	
	public void addEnte(Ente e) {
		JLabel grafico = e.getGrafico();
		add(grafico);
		grafico.repaint();
	}
	
	// Agrega graficos a una lista para que sean
	// eliminados despues de un tiempo, no los agrega al panel
	public void graficoTemporal(JLabel grafico, int tiempo) {
		graficosTemporales.add(new Pair<JLabel, Integer>(grafico, tiempo));
	}
	
	public void actualizarGraficosTemporales() {
		List<Pair<JLabel, Integer>> eliminar = new ArrayList<Pair<JLabel, Integer>>();
		
		for (Pair<JLabel, Integer> par : graficosTemporales) {
			JLabel grafico = par.getLeft();
			int tiempo = par.getRight() - 1;
			par.setRight(tiempo);
			if (tiempo == 0) {
				grafico.setVisible(false);
				remove(grafico);
				eliminar.add(par);
			}
		}
		
		for (Pair<JLabel, Integer> par : eliminar)
			graficosTemporales.remove(par);
	}
}
