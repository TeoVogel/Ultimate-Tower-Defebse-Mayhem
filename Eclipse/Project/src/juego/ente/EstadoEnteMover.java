package juego.ente;

import grafica.GraficoEnte;

public class EstadoEnteMover extends EstadoEnte {
	
	public EstadoEnteMover () {
		index = 3;
	}
	
	public boolean enMovimiento () {
		return true;
	}
	
	public void doAction(GraficoEnte e) {}
	
}
