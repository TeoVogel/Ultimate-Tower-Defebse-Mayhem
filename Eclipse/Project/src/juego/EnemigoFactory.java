package juego;

import juego.ente.Enemigo;

public class EnemigoFactory {

	public static Enemigo crearEnemigo () {
		return new Enemigo(1,1,1,1,20);
	}
	
}
