package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionComprarAliado implements Accion {

	private Aliado aliado;
	
	public AccionComprarAliado (String tipo) {
		aliado = FactoryAliado.crearAliado(tipo);
	}
	
	public void ejecutar (int fila, int columna){
		Juego.getJuego().getMapa().addAliado(aliado, fila, columna);
	}
	
	public int getPrecio () {
		return - aliado.getPrecio();
	}
	
}
