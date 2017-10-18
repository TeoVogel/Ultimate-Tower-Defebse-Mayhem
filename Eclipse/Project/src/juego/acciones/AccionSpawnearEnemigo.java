package juego.acciones;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.EnemigoFactory;
import juego.Juego;

public class AccionSpawnearEnemigo implements Accion {

	private Juego juego;	
	
	public AccionSpawnearEnemigo (Juego j) {
		juego = j;
	}
	
	public void ejecutar (Celda celda) {
		juego.getMapa().addEnemigo(
				EnemigoFactory.crearEnemigo1(celda));
	}
	
}
