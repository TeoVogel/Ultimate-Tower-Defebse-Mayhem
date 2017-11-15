package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionComprarAliado implements AccionSobreMapa {

	private Aliado aliado;
	
	public AccionComprarAliado (String tipo) {
		aliado = FactoryAliado.crearAliado(tipo);
	}
	
	public void ejecutar (int fila, int columna){
		Juego.getJuego().getMapa().addAliado(aliado, fila, columna);
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return aliado.getPrecio();
	}
	
}
