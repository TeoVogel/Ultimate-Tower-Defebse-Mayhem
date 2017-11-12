package juego;

import juego.acciones.Accion;

public class Mercado {

	private Accion accionPlaceHolder;
	private int monedas;
	
	public Mercado () {
		monedas = 200;
	}
	
	public int getMonedas () {
		return monedas;
	}
	
	public void agregarMonedas (int m) {
		monedas += m;
		Juego.getJuego().getInterfaz().getPanelTienda().setMonedas(monedas);
	}

	public void addToPlaceHolder(Accion a) {
		accionPlaceHolder = a;
	}
	
	public boolean isPlaceHolderFull () {
		return accionPlaceHolder != null;
	}
	
	public Accion getPlaceHolderContent () {
		Accion a = accionPlaceHolder;
		accionPlaceHolder = null;
		agregarMonedas(a.getPrecio());
		return a;
	}
	
}
