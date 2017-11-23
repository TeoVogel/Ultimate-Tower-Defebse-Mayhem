package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Juego;
import juego.Pair;
import juego.ente.Ente;

public class PanelMapa extends JLabel {
	private List<Pair<Grafico, Integer>> graficosTemporales;
	public final static int TILE_WIDTH = 100;
	public final static int TILE_HIGHT = 100;
	
	public PanelMapa() {
		super();
		graficosTemporales = new ArrayList<Pair<Grafico, Integer>>();
		setBounds(0, 88, 1000, 638);
		setLayout(null);
		setIcon(new ImageIcon(Interfaz.path + "fondo.png"));
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (Juego.getJuego().getMercado().isAccionSobreMapa()) {
					int columna = e.getX()/100,
					    fila    = e.getY()/100;
					Juego.getJuego().getMercado().getAccionSobreMapa().ejecutar(fila, columna);
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {}
		});	
	}
	
	public void addEnte(Ente e) {
		// TODO: por que no add(e) ?
		JLabel grafico = e.getGrafico();
		add(grafico);
		this.setComponentZOrder(grafico, 0);
		grafico.repaint();
	}
	
	// Agrega graficos a una lista para que sean
	// eliminados despues de un tiempo, no los agrega al panel
	public void graficoTemporal(Grafico grafico, int tiempo) {
		graficosTemporales.add(new Pair<Grafico, Integer>(grafico, tiempo));
	}
	
	public void actualizarGraficosTemporales() {
		List<Pair<Grafico, Integer>> eliminar = new ArrayList<Pair<Grafico, Integer>>();
		
		for (Pair<Grafico, Integer> par : graficosTemporales) {
			Grafico grafico = par.getLeft();
			int tiempo = par.getRight() - 1;
			par.setRight(tiempo);
			if (tiempo == 0) {
				grafico.action();
				eliminar.add(par);
			}
		}
		
		for (Pair<Grafico, Integer> par : eliminar)
			graficosTemporales.remove(par);
	}
	
	public void graficarBomba(int fila, int columna) {
		graficoTemporal(new GraficoBomba(fila, columna), 25);
	}
}
