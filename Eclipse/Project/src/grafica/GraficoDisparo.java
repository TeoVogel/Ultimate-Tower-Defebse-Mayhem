package grafica;

import juego.Juego;

public abstract class GraficoDisparo {
	protected int altoDisparo = 5;
	
	protected PanelMapa panelMapa;// = Juego.getJuego().getInterfaz().getPanelMapa();
	
	public GraficoDisparo() {
//		panelMapa = Juego.getJuego().getInterfaz().getPanelMapa();
	}
	
	public abstract void graficar(GraficoEnte ataca, GraficoEnte recibe);
}
