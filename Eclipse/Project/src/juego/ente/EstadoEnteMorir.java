package juego.ente;

import grafica.GraficoEnte;

public class EstadoEnteMorir extends EstadoEnte {

	public void doAction(GraficoEnte g) {
		g.setVisible(false);
		g.repaint();
		g.getParent().remove(g);
	}
}
