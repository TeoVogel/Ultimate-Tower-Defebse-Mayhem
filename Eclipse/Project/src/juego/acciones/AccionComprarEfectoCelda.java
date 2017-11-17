package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.EfectoCelda.EfectoCelda;
import juego.ente.EfectoCelda.FactoryEfectoCelda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionComprarEfectoCelda implements AccionSobreMapa {

	private EfectoCelda efecto;
	
	public AccionComprarEfectoCelda (int tipo) {
		efecto = FactoryEfectoCelda.crearEfectoCelda(tipo);
	}
	
	public void ejecutar (int fila, int columna){
		Juego.getJuego().getMapa().addEfectoCelda(efecto, fila, columna);
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return efecto.getPrecio();
	}
	
}
