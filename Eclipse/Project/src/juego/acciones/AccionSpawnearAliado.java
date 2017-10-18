package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.EnemigoFactory;
import juego.Juego;

public class AccionSpawnearAliado implements Accion {

	private Aliado aliado;
	private Juego juego;	
	
	public AccionSpawnearAliado ( Juego j) {
		juego = j;
	}
	
	public void ejecutar (Celda celda){
		juego.getMapa().addAliado(AliadoFactory.crearAliado1(celda));
	}
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addAliado(AliadoFactory.crearAliado1(juego.getMapa().getCelda(fila, columna)));
	}
	
}
