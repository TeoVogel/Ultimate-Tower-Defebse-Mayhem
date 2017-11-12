package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionComprarAliado implements AccionMonetaria, AccionInsertar {

	private Aliado aliado;
	
	public AccionComprarAliado (String tipo) {
		aliado = FactoryAliado.crearAliado(tipo);
	}
	
	public void ejecutar (Celda c){
		Juego.getJuego().getMapa().addAliado(aliado, c);
		Juego.getJuego().getMercado().agregarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return - aliado.getPrecio();
	}
	
}
