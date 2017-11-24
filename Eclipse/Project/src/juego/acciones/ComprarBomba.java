package juego.acciones;

import juego.Juego;

public class ComprarBomba implements AccionSobreMapa {

	
	public ComprarBomba(){
	}
	
	public void ejecutar (int fila, int columna){
		Juego.getJuego().getInterfaz().getPanelMapa().graficarBomba(fila, columna);
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}

	public int getPrecio() {
		return 25;
	}
	
}
