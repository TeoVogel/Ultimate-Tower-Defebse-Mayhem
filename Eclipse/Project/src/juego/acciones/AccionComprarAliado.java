package juego.acciones;

import juego.ente.Aliado;
import juego.Juego;

public abstract class AccionComprarAliado implements AccionSobreMapa {

	protected Aliado aliado;
	
	public AccionComprarAliado (){}
	
	public void ejecutar (int fila, int columna){
		if(	Juego.getJuego().getMapa().addAliado(aliado, fila, columna) )
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return aliado.getPrecio();
	}
	
}
