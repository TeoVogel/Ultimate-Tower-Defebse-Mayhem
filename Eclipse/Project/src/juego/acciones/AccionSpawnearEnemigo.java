package juego.acciones;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.EnemigoFactory;
import juego.Juego;

public class AccionSpawnearEnemigo implements Accion {

	private Juego juego;
	private Enemigo enemigo;
	
	public AccionSpawnearEnemigo (Juego j) {
		juego = j;
		enemigo = EnemigoFactory.crearEnemigo1();
	}
	
	public void ejecutar (Celda celda) {
		enemigo.init(celda);
		juego.getMapa().addEnemigo(enemigo);
	}
	
}
