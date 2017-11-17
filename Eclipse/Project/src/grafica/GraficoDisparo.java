package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;

public abstract class GraficoDisparo implements Grafico {
	protected int altoDisparo = 10;
	protected int corrimiento;
	
	protected ImageIcon disparo;
	protected JLabel grafico;
	
	public GraficoDisparo() {}
	
	public void action() {
		grafico.setVisible(false);
		grafico.repaint();
		Juego.getJuego().getInterfaz().getPanelMapa().remove(grafico);
	}
	
	public void graficar(GraficoEnte ataca, GraficoEnte recibe){}
	
}
