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
	
	public void ejecutar (Celda c){
		Juego.getJuego().getMapa().addAliado(aliado, c.fila, c.columna);
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return aliado.getPrecio();
	}
	
}
