package juego.acciones;

import juego.FactoryAliado;
import juego.Juego;
import juego.ente.AliadoDosCeldas;

public class ComprarBomba implements AccionSobreMapa {

	
	public ComprarBomba(){
	}
	
	public void ejecutar (int fila, int columna){
		Juego.getJuego().detonarBomba(fila, columna);
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}

	public int getPrecio() {
		return 50;
	}
	
}
