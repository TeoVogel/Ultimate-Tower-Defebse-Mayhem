package juego;

import juego.acciones.AccionInsertar;
import juego.acciones.AccionMonetaria;
import juego.acciones.AccionSobreAliado;

public class Mercado {

	private AccionSobreAliado accionSobreAliado;
	private AccionInsertar accionInsertar;
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

	public void addAccionSobreAliado(AccionSobreAliado a) {
		accionSobreAliado = a;
	}
	
	public boolean isAccionSobreAliado () {
		return accionSobreAliado != null;
	}
	
	public AccionSobreAliado getAccionSobreAliado () {
		AccionSobreAliado a = accionSobreAliado;
		accionSobreAliado = null;
		return a;
	}

	public void addAccionInsertar(AccionInsertar a) {
		accionInsertar = a;
	}
	
	public boolean isAccionInsertar () {
		return accionInsertar != null;
	}
	
	public AccionInsertar getAccionInsertar () {
		AccionInsertar a = accionInsertar;
		accionInsertar = null;
		return a;
	}
	
}
