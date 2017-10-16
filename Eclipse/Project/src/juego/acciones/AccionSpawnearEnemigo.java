package juego.acciones;

import juego.ente.Enemigo;
import juego.EnemigoFactory;
import juego.Juego;

public class AccionSpawnearEnemigo implements Accion {

	private Juego juego;	
	
	public AccionSpawnearEnemigo (Juego j) {
		juego = j;
	}
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addEnemigo(
				EnemigoFactory.crearEnemigo(juego.getMapa(), fila, columna));
	}
	
}
