package juego;

import java.util.Random;

import juego.ente.Celda;
import juego.ente.Enemigo;

public class EnemigoFactory {

	public static Enemigo crearEnemigo (Celda celda) {
		return new Enemigo(1,1,1,1,20);
	}
	
}
