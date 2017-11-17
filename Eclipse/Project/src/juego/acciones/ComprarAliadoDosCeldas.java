package juego.acciones;

import juego.FactoryAliado;
import juego.Juego;
import juego.ente.AliadoDosCeldas;

public class ComprarAliadoDosCeldas extends AccionComprarAliado{
	AliadoDosCeldas dosCeldas;
	
	public ComprarAliadoDosCeldas(){
			dosCeldas= FactoryAliado.crearTanque();	
			aliado= dosCeldas;
	}
	
	public void ejecutar (int fila, int columna){
		if(	Juego.getJuego().getMapa().addAliadoDosCeldas(dosCeldas, fila, columna) )
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
}
