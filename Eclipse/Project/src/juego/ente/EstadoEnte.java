package juego.ente;

import grafica.GraficoEnte;

public abstract class EstadoEnte {
	
	protected int index;
	
	public boolean enMovimiento () {
		return false;
	}
	
	public boolean esMorir() {
		return false;
	}
	
	public int getIndex () {
		return index;
	}
	
	public abstract void doAction(GraficoEnte e);
	
}
